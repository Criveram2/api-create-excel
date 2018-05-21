package com.lasc.createexcel.api;

import com.lasc.createexcel.exceptions.ExcelException;
import com.lasc.createexcel.model.ExtAhorros;
import com.lasc.createexcel.model.Resultado;

public interface CreateReport {

	String convertXmlToObjectRespose(Resultado ext);
	
	ExtAhorros convertXmlToObjectJava(String xml) throws ExcelException;
	
	Resultado CreateReportExcel(String reportTemplateUrl, ExtAhorros extAhorros, String DestinoUrl);
	
	int valideNull(ExtAhorros ext);
}
