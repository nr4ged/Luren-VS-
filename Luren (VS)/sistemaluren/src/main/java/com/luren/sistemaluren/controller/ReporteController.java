package com.luren.sistemaluren.controller;


import org.springframework.stereotype.Controller;

/* 
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
*/
@Controller

public class ReporteController {
/*
	@Autowired
	private DataSource dataSource; // javax
	@Autowired
	private ResourceLoader resourceLoader; // core.io
 
	@GetMapping("/reportePro")
	public void reportes(HttpServletResponse response) {

		// response.setHeader("Content-Disposition", "attachment;
		// filename='reporte.pdf';");
		response.setHeader("Content-Disposition", "inline;"); // Para mostrar
		response.setContentType("application/pdf");
		try {
			// Recuperar el recurso (jasper)
			String ru = resourceLoader.getResource("classpath:/reportes/Producto.jasper").getURI().getPath();
			// Combinanr jasper y data
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			// java.io --> genera el archivo resultante
			OutputStream outStream = response.getOutputStream();
			// carga el archivo
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/reporteUsu")
	public void reporte(HttpServletResponse response) {

		// response.setHeader("Content-Disposition", "attachment;
		// filename='reporte.pdf';");
		response.setHeader("Content-Disposition", "inline;"); // Para mostrar
		response.setContentType("application/pdf");
		try {
			// Recuperar el recurso (jasper)
			String ru = resourceLoader.getResource("classpath:/reportes/Usuario.jasper").getURI().getPath();
			// Combinanr jasper y data
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			// java.io --> genera el archivo resultante
			OutputStream outStream = response.getOutputStream();
			// carga el archivo
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	/*
	 @PostMapping("/filtro")
	public void reporteFiltro(@RequestParam(name="usuario") String Usuario, HttpServletResponse response) {
		
	response.setHeader("Content-Disposition", "inline");
	response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:/reportes/filtro.jasper").getURI().getPath();
			HashMap parametros = new HashMap();
			parametros.put("usuario", Usuario);
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */

}