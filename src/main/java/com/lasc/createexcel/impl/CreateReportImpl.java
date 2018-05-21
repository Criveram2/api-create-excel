package com.lasc.createexcel.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lasc.createexcel.api.CreateReport;
import com.lasc.createexcel.controller.ReportController;
import com.lasc.createexcel.exceptions.ExcelException;
import com.lasc.createexcel.model.ExtAhorros;
import com.lasc.createexcel.model.Movimientos;
import com.lasc.createexcel.model.Reporte;
import com.lasc.createexcel.model.Resultado;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Service
public class CreateReportImpl implements CreateReport {

	private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	private static final String TEMPLATE_NAME = "/ExtAhoTemplate.jrxml";

	public ExtAhorros convertXmlToObjectJava(String xml) throws ExcelException {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ExtAhorros.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (ExtAhorros) unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			Log.error("Error to change xml to object" + e.getMessage());
			throw new ExcelException("Error to change xml to object");
		}
	}

	public String convertXmlToObjectRespose(Resultado ext) {
		String strXml = "";
		try {
			StringWriter writer = new StringWriter();
			JAXBContext jc = JAXBContext.newInstance(Resultado.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(ext, writer);
			strXml = writer.toString();
		} catch (JAXBException ex) {
			Log.error("Error to change xml to objectResponse" + ex.getMessage());
		}
		return strXml;
	}

	@Override
	public Resultado CreateReportExcel(String reportTemplateUrl, ExtAhorros extAhorros, String DestinoUrl) {

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL url = classLoader.getResource(TEMPLATE_NAME);
			String fileString = url.getFile();
			fileString = URLDecoder.decode(fileString, "UTF-8");
			File file = new File(fileString);
			JasperDesign jasperDesign = JRXmlLoader.load(file);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JRBeanCollectionDataSource CollectionExtracto = new JRBeanCollectionDataSource(
					findReportExtacto(extAhorros));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, getParameters(), CollectionExtracto);
			exportXLS(jasperPrint, DestinoUrl);
			return new Resultado(0, "Archivo Creado", DestinoUrl + ".xls");
		} catch ( UnsupportedEncodingException e) {
			log.error("CreateReportExcel genera" + e.getMessage());
			return new Resultado(1, "No fue posible crear el archivo", DestinoUrl + ".xls");
		} catch (ExcelException e) {
			return new Resultado(1, e.getMessage(), DestinoUrl + ".xls");
		} catch (JRException e){
			log.error("CreateReportExcel genera" + e.getMessage());
			return new Resultado(1, e.getMessage(), DestinoUrl + ".xls");
		}
	}

	public int valideNull(ExtAhorros ext) {
		if ((ext.getTotalesAhorros() != null) && (ext.getCliente() != null) && (ext.getNombreArchivo() != null)
				&& (ext.getRutaDestino() != null)) {
			return 1;
		}
		return 0;
	}

	private static Map<String, Object> getParameters() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("footerText", "Just to demonstrate how to pass parameters to report");
		return params;
	}

	private static void exportXLS(JasperPrint jasperPrint, String fileName) throws ExcelException {

		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.setOnePagePerSheet(true);
		configuration.setDetectCellType(true);
		configuration.setCollapseRowSpan(false);
		configuration.setRemoveEmptySpaceBetweenRows(true);
		configuration.setWhitePageBackground(false);	
		log.info(fileName + ".xls");
		File file = new File(fileName + ".xls");
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(fos));
			exporterXLS.setConfiguration(configuration);
			exporterXLS.exportReport();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			log.error("File not found " + e.getMessage());
			throw new ExcelException("File not found");
		} catch (IOException e) {
			log.error("IOException " + e.getMessage());
			throw new ExcelException("File not found");
		} catch (JRException e) {
			log.error("JRException " + e.getMessage());
			throw new ExcelException("File not found");
		}
	}

	private static Collection<Reporte> findReportExtacto(ExtAhorros extAhorros) {

		List<Reporte> reporte;
		reporte = new ArrayList<Reporte>();

		if (extAhorros.getMovimientos() != null) {
			for (Movimientos mov : extAhorros.getMovimientos()) {
				Reporte rep = new Reporte(extAhorros.getCliente().getFecInicial(),
						extAhorros.getCliente().getFecFinal(), extAhorros.getCliente().getFechaGeneracion(),
						extAhorros.getCliente().getHora(), extAhorros.getCliente().getNombre(),
						extAhorros.getCliente().getNit(), extAhorros.getCliente().getCuenta(),
						extAhorros.getCliente().getProducto(), extAhorros.getTotalesAhorros().getTotConsig(),
						extAhorros.getTotalesAhorros().getTotIntereses(),
						extAhorros.getTotalesAhorros().getTotRetiros(), extAhorros.getTotalesAhorros().getTotRetFte(),
						extAhorros.getTotalesAhorros().getSdoDisponible(), extAhorros.getTotalesAhorros().getSdoCanje(),
						extAhorros.getTotalesAhorros().getSdoTotal());
				rep.setFecha(mov.getFecha());
				rep.setConcepto(mov.getConcepto());
				rep.setDocumento(mov.getDocumento());
				rep.setOficina(mov.getOficina());
				rep.setConsignacion(mov.getConsignacion());
				rep.setRetiro(mov.getRetiro());
				rep.setSaldo(mov.getSaldo());
				rep.setCodOperacion(mov.getCodOperacion());
				rep.setRefPago(mov.getRefPago());
				reporte.add(rep);
			}
		} else {
			Reporte rep = new Reporte(extAhorros.getCliente().getFecInicial(), extAhorros.getCliente().getFecFinal(),
					extAhorros.getCliente().getFechaGeneracion(), extAhorros.getCliente().getHora(),
					extAhorros.getCliente().getNombre(), extAhorros.getCliente().getNit(),
					extAhorros.getCliente().getCuenta(), extAhorros.getCliente().getProducto(),
					extAhorros.getTotalesAhorros().getTotConsig(), extAhorros.getTotalesAhorros().getTotIntereses(),
					extAhorros.getTotalesAhorros().getTotRetiros(), extAhorros.getTotalesAhorros().getTotRetFte(),
					extAhorros.getTotalesAhorros().getSdoDisponible(), extAhorros.getTotalesAhorros().getSdoCanje(),
					extAhorros.getTotalesAhorros().getSdoTotal());
			rep.setFecha(" ");
			rep.setConcepto(" ");
			rep.setDocumento(" ");
			rep.setOficina(" ");
			rep.setConsignacion(" ");
			rep.setRetiro(" ");
			rep.setSaldo(" ");
			rep.setCodOperacion(" ");
			rep.setRefPago(" ");
			reporte.add(rep);
		}

		return reporte;

	}

}
