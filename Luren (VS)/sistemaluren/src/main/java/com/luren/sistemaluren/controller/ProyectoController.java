package com.luren.sistemaluren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoController {

		
	
		@GetMapping("/")
		public String cargarPagPrincipal() {
			return "Inicio";
		}

		@GetMapping("/Login")
		public String cargarLogin() {
			return "Login";
		}
		
		
		@GetMapping("/PgFiltroProducto.html")
		public String cargPgFiltro() {
			return "Filtro";
		}
		
	
}
