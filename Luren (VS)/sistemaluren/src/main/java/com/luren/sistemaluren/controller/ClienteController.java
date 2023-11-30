package com.luren.sistemaluren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luren.sistemaluren.model.Cliente;
import com.luren.sistemaluren.repository.IClienteRepository;
import com.luren.sistemaluren.repository.ITipoClienteRepository;



@Controller
public class ClienteController {
	
	@Autowired
    private IClienteRepository repoCli;
 	@Autowired
    private ITipoClienteRepository repoTipoCli;

 
//CARGARPAGINA!!
	 @GetMapping("/PgCliente")
	 public String cargarPgCliente(Model model) {
	     model.addAttribute("cliente", new Cliente());
	     model.addAttribute("lstCliente", repoCli.findAll());
	     model.addAttribute("lstTipoCliente", repoTipoCli.findAll());
	     
	     
	     return "PgCliente";
	 }
	 
	 @PostMapping("/PgCliente")
     public String registrarCliente(@ModelAttribute Cliente cliente, @RequestParam(value = "action", required = false) String action, Model model) {
         if ("registrar".equals(action)) {
        // Verificar si ya existe un cliente con el mismo código
          if (repoCli.existsById(cliente.getCodigo())) {
               model.addAttribute("mensaje", "El código de Cliente ya existe");
            	   } else {
            	        try {
            	        	repoCli.save(cliente);
            	            model.addAttribute("mensaje", "Cliente registrado correctamente");
            	       } catch (Exception e) {
            	            model.addAttribute("mensaje", "Error al registrar al Cliente");
            	            }
            	        }
         }else if ("actualizar".equals(action)) {
 	        try {
 	        	repoCli.save(cliente);
 	            model.addAttribute("mensaje", "Cliente actualizado correctamente");
 	        
 	        } catch (Exception e) {
 	            model.addAttribute("mensaje", "Error al actualizar el Cliente");
 	        
 	    }
         }else if ("eliminar".equals(action)) {
        	    if (cliente.getCodigo().isBlank()) {
     	        model.addAttribute("mensaje", "El campo Código de Usuario debe estar lleno");
     	    } else {
     	        if (repoCli.existsById(cliente.getCodigo())) {
     	            try {
     	            	repoCli.deleteById(cliente.getCodigo());
     	                model.addAttribute("mensaje", "Cliente eliminado correctamente");
     	            } catch (Exception e) {
     	                model.addAttribute("mensaje", "Error al eliminar el Cliente");
     	            }
     	        } else {
     	            model.addAttribute("mensaje", "El código de cliente no existe");
     	        }
     	    }
     	}
     	   model.addAttribute("lstCliente", repoCli.findAll());
     	   model.addAttribute("lstTipoCliente", repoTipoCli.findAll());
            return "PgCliente";
        }
	 @GetMapping("/PgCliente/editar/{codCliente}")
	    public String editarCliente(@PathVariable("codCliente") String codCliente, Model model) {
	        Cliente cliente = repoCli.findById(codCliente).orElse(null);
	        model.addAttribute("cliente", cliente);
	        model.addAttribute("lstCliente", repoCli.findAll());
	        model.addAttribute("lstTipoCliente", repoTipoCli.findAll());
	        return "PgCliente";
	    }
	//CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
			@GetMapping("/PgCliente/listado")
			public String generarLista(Model model) {
				model.addAttribute("lstCliente", repoCli.findAll());
				model.addAttribute("lstTipoCliente", repoTipoCli.findAll());
				model.addAttribute("cliente", new Cliente());
				return ("PgCliente");
			} 
}

