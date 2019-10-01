package com.starbucks.sistema.venta.logica.Jasper;

import java.sql.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public abstract class AbstractJasperReports {

	private static JasperReport report;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;

	public static void CreateReport(Connection con, String path) {
		try {
			report = (JasperReport) JRLoader.loadObjectFromFile(path);
			reportFilled = JasperFillManager.fillReport(report, null, con);
		} catch (JRException e) {
			// TODO: handle exception
		}

	}

	public static void ShowViewer() {

		viewer = new JasperViewer(reportFilled);
		viewer.setVisible(true);

	}

	public static void ExportToPDF(String destino) {
		try {
			JasperExportManager.exportReportToPdfFile(reportFilled, destino);
		} catch (JRException e) {
			// TODO: handle exception
		}
	}

}
