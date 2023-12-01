package com.luren.sistemaluren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luren.sistemaluren.model.Boleta;
import com.luren.sistemaluren.repository.IBoletaRepository;
import com.luren.sistemaluren.repository.IClienteRepository;
import com.luren.sistemaluren.repository.IServicioRepository;

@Controller
public class BoletaController {
	
	@Autowired
    private IBoletaRepository boletaService;

    @Autowired
    private IClienteRepository clienteService; // Asegúrate de tener un servicio para Cliente

    @Autowired
    private IServicioRepository servicioService; // Asegúrate de tener un servicio para Servicio

    // CARGARPAGINA!!
    @GetMapping("/PgBoleta")
    public String cargarPgBoleta(Model model) {
        model.addAttribute("boleta", new Boleta());
        model.addAttribute("lstBoleta", boletaService.findAll());
        model.addAttribute("lstCliente", clienteService.findAll()); // Asegúrate de tener un método para listar clientes
        model.addAttribute("lstServicio", servicioService.findAll()); // Asegúrate de tener un método para listar servicios

        return "PgBoleta";
    }
    
    @PostMapping("/PgBoleta")
    public String registrarBoleta(@ModelAttribute Boleta boleta, @RequestParam(value = "action", required = false) String action, Model model) {
        if ("registrar".equals(action)) {
       // Verificar si ya existe un cliente con el mismo código
         if (boletaService.existsById(boleta.getId())) {
              model.addAttribute("mensaje", "El código de Cliente ya existe");
           	   } else {
           	        try {
           	        	boletaService.save(boleta);
           	            model.addAttribute("mensaje", "Boleta registrado correctamente");
           	       } catch (Exception e) {
           	            model.addAttribute("mensaje", "Error al registrar Boleta");
           	            }
           	        }
        }else if ("actualizar".equals(action)) {
	        try {
	        	boletaService.save(boleta);
	            model.addAttribute("mensaje", "Boleta actualizado correctamente");
	        
	        } catch (Exception e) {
	            model.addAttribute("mensaje", "Error al actualizar el Boleta");
	        
	    }
        }else if ("eliminar".equals(action)) {
       	    if (boleta.getId().isBlank()) {
    	        model.addAttribute("mensaje", "El campo Código de boleta debe estar lleno");
    	    } else {
    	        if (boletaService.existsById(boleta.getId())) {
    	            try {
    	            	boletaService.deleteById(boleta.getId());
    	                model.addAttribute("mensaje", "boleta eliminado correctamente");
    	            } catch (Exception e) {
    	                model.addAttribute("mensaje", "Error al eliminar el boleta");
    	            }
    	        } else {
    	            model.addAttribute("mensaje", "El código de boleta no existe");
    	        }
    	    }
    	}
        model.addAttribute("boleta", new Boleta());
        model.addAttribute("lstBoleta", boletaService.findAll());
        model.addAttribute("lstCliente", clienteService.findAll()); // Asegúrate de tener un método para listar clientes
        model.addAttribute("lstServicio", servicioService.findAll());
           return "PgBoleta";
       }
    
}
