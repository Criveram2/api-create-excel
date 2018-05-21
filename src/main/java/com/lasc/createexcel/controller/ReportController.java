package com.lasc.createexcel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lasc.createexcel.api.CreateReport;
import com.lasc.createexcel.exceptions.ExcelException;

import com.lasc.createexcel.model.ExtAhorros;
import com.lasc.createexcel.model.Resultado;

@RestController
public class ReportController {

	private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	private static String reportTemplateUrl = "classpath:ExtAhoTemplate.jrxml";

	@Autowired
	private CreateReport crearReporte;

	private static String destinoUrl;

	@RequestMapping(value = "/geoLocation", produces = { "application/json" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getGeoLocation(@RequestParam("ipAddress") String ipAddress) {
		System.out.println("ingreso here" + ipAddress);
		log.info("ingreso a getGeoLocation");
		return new ResponseEntity<String>(ipAddress, HttpStatus.OK);
	}

	@RequestMapping(value = "/createExcel", consumes = { "application/xml" }, produces = {
			"application/xml" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createExcel(@RequestBody String body) {

		try {
			ExtAhorros extracto;
			extracto = crearReporte.convertXmlToObjectJava(body);
			if (crearReporte.valideNull(extracto) == 0) {
				Resultado output = new Resultado(1, "los datos estan incompletos ", "destinoUrl");
				return new ResponseEntity<String>(crearReporte.convertXmlToObjectRespose(output), HttpStatus.OK);
			}
			destinoUrl = extracto.getRutaDestino() + extracto.getNombreArchivo();
			Resultado output = crearReporte.CreateReportExcel(reportTemplateUrl, extracto, destinoUrl);
			log.info("Archivo creado en  " + destinoUrl);
			return new ResponseEntity<String>(crearReporte.convertXmlToObjectRespose(output), HttpStatus.OK);
		} catch (ExcelException e) {
			Resultado output = new Resultado(1, "Error al general Archivo Excel", destinoUrl);
			return new ResponseEntity<String>(crearReporte.convertXmlToObjectRespose(output), HttpStatus.OK);
		}
	}
}
