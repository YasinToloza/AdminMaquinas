package com.proyecto.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ReporteController {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/Reporte/Clientes")
	public void Clientes(HttpServletResponse response) {
		//Asigna un nombre al archivo pdf generado
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		//Visualiza en pantalla el pdf
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/Cliente.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GetMapping("/Reporte/Maquinas")
	public void Maquinas(HttpServletResponse response) {
		//Asigna un nombre al archivo pdf generado
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		//Visualiza en pantalla el pdf
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/Maquinas.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GetMapping("/Reporte/Usuarios")
	public void Usuarios(HttpServletResponse response) {
		//Asigna un nombre al archivo pdf generado
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		//Visualiza en pantalla el pdf
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/Usuarios.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GetMapping("/Reporte/MayorPrecio")
	public void MayorPrecio(HttpServletResponse response) {
		//Asigna un nombre al archivo pdf generado
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		//Visualiza en pantalla el pdf
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/MayorPrecio.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GetMapping("/Reporte/MayorStock")
	public void MayorStock(HttpServletResponse response) {
		//Asigna un nombre al archivo pdf generado
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		//Visualiza en pantalla el pdf
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/MayorStock.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GetMapping("/Reporte/ProveedoresMaquinas")
	public void ContactoProveedor(HttpServletResponse response) {
		//Asigna un nombre al archivo pdf generado
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		//Visualiza en pantalla el pdf
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/ContactoProveedor.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

}
