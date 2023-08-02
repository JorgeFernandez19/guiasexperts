package com.guiasexperts.uth.data.service;

import java.io.File;
import java.sql.Connection;
import java.util.Map;

import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportGenerator {
	private String ubicacion;
	
	public boolean generarReportePDF(String reportName, Map<String, Object> parameters, JRDataSource datasource) {
		
		boolean generado = false;
		try {
		JasperReport reporte =	(JasperReport)JRLoader.loadObjectFromFile((String) fetchReportPath(reportName+".jasper"));
		JasperPrint impresora = JasperFillManager.fillReport(reporte, parameters, datasource);
	   String rutaPDF = generateReportSavePath() + reportName + ".pdf";	
			   this.ubicacion = rutaPDF;
			   JasperExportManager.exportReportToPdfFile(impresora, rutaPDF);
			   generado = true;
	
		
		}catch (Exception error) {
			error.printStackTrace();
			generado = false;
			
		}
		return generado;
	}

	private String generateReportSavePath() {
		String path =null;
		try {
	
	path =File.createTempFile("temp", "pdf").getAbsolutePath();
			
		}catch(Exception error) {
			error.printStackTrace();
		}
		return path;
	}

	private Object fetchReportPath(String reportName) {
		String path =null;
		try {
			path = ResourceUtils.getFile("classpath:"+reportName).getAbsolutePath();
		}catch(Exception error) {
			error.printStackTrace();
	}
		return null;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	

}
