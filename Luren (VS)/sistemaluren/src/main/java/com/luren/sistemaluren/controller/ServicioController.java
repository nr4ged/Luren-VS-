package com.luren.sistemaluren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luren.sistemaluren.model.Servicio;
import com.luren.sistemaluren.repository.IServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private IServicioRepository repoServ;

    // CARGARPAGINA!!
    @GetMapping("/PgServicio")
    public String cargarPgServicio(Model model) {
 
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("lstServicio", repoServ.findAll());
            return "PgServicio";  
    }

    
    @PostMapping("/PgServicio")
    public String registrarServicio(@ModelAttribute Servicio servicio, @RequestParam(value = "action", required = false) String action, Model model) {
    	
    	if ("registrar".equals(action)) {    
    		
    	        if (repoServ.existsById(servicio.getCod_servicio())) {
    	            model.addAttribute("mensaje", "El código de servicio ya existe");
    	        } else {
    	        	
    	            try {
    	                repoServ.save(servicio);
    	                model.addAttribute("mensaje", "Servicio registrado correctamente");
    	            } catch (Exception e) {
    	                model.addAttribute("mensaje", "Error al registrar el servicio");
    	            }
    	        }
    	    
    	}else if ("actualizar".equals(action)) {
    	        try {
    	            repoServ.save(servicio);
    	            model.addAttribute("mensaje", "Servicio actualizado correctamente");
    	        
    	        } catch (Exception e) {
    	            model.addAttribute("mensaje", "Error al actualizar el servicio");
    	    }
    	        
    	} else if ("eliminar".equals(action)) {
    	    	
    	        if (repoServ.existsById(servicio.getCod_servicio())) {
    	        	
    	            try {
    	                repoServ.deleteById(servicio.getCod_servicio());
    	                model.addAttribute("mensaje", "Servicio eliminado correctamente");
    	            } catch (Exception e) {
    	                model.addAttribute("mensaje", "Error al eliminar el servicio");
    	            }
    	        } else {
    	            model.addAttribute("mensaje", "El código de servicio no existe");
    	        }
    	    }
    	

        model.addAttribute("lstServicio", repoServ.findAll());
        return "PgServicio";
    }
   
    @GetMapping("/PgServicio/editar/{codServicio}")
    public String editarServicio(@PathVariable("codServicio") String codServicio, Model model) {
        Servicio servicio = repoServ.findById(codServicio).orElse(null);
        model.addAttribute("servicio", servicio);
        model.addAttribute("lstServicio", repoServ.findAll());
        return "PgServicio";
    }

  
   
    

   
}
