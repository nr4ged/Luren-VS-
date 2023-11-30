package com.luren.sistemaluren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.luren.sistemaluren.model.Usuario;
import com.luren.sistemaluren.repository.ITipoUsuarioRepository;
import com.luren.sistemaluren.repository.IUsuarioRepository;

@Controller
public class UsuarioController {

	 @Autowired
	    private IUsuarioRepository repoUsu;
	 @Autowired
	    private ITipoUsuarioRepository repoTipoUsu;
	 
	
	// CARGARPAGINA!!
	 @GetMapping("/PgUsuario")
	 public String cargarPgServicio(Model model) {
	     model.addAttribute("usuario", new Usuario());
	     model.addAttribute("lstUsuario", repoUsu.findAll());
	     model.addAttribute("lstTipoUsuario", repoTipoUsu.findAll());
	     
	     
	     return "PgUsuario";
	 }


	   @PostMapping("/PgUsuario")
	     public String registrarUsuario(@ModelAttribute Usuario usuario, @RequestParam(value = "action", required = false) String action, Model model) {
	         if ("registrar".equals(action)) {
	        // Verificar si ya existe un usuario con el mismo código
	          if (repoUsu.existsById(usuario.getCodigo())) {
	               model.addAttribute("mensaje", "El código de USUARIO ya existe");
	            	   } else {
	            	        try {
	            	        	repoUsu.save(usuario);
	            	            model.addAttribute("mensaje", "Usuario registrado correctamente");
	            	       } catch (Exception e) {
	            	            model.addAttribute("mensaje", "Error al registrar al Usuario");
	            	            }
	            	        }
	    
	   }else if ("actualizar".equals(action)) {
	        try {
	        	repoUsu.save(usuario);
	            model.addAttribute("mensaje", "Usuario actualizado correctamente");
	        
	        } catch (Exception e) {
	            model.addAttribute("mensaje", "Error al actualizar el Usuario");
	        
	    }
	   }else if ("eliminar".equals(action)) {
   	    if (usuario.getCodigo().isBlank()) {
	        model.addAttribute("mensaje", "El campo Código de Usuario debe estar lleno");
	    } else {
	        if (repoUsu.existsById(usuario.getCodigo())) {
	            try {
	            	repoUsu.deleteById(usuario.getCodigo());
	                model.addAttribute("mensaje", "Usuario eliminado correctamente");
	            } catch (Exception e) {
	                model.addAttribute("mensaje", "Error al eliminar el Usuario");
	            }
	        } else {
	            model.addAttribute("mensaje", "El código de usuario no existe");
	        }
	    }
	}
	   model.addAttribute("lstUsuario", repoUsu.findAll());
	   model.addAttribute("lstTipoUsuario", repoTipoUsu.findAll());
       return "PgUsuario";
   }
	   @GetMapping("/PgUsuario/editar/{codUsuario}")
	    public String editarUsuario(@PathVariable("codUsuario") String codUsuario, Model model) {
	        Usuario usuario = repoUsu.findById(codUsuario).orElse(null);
	        model.addAttribute("usuario", usuario);
	        model.addAttribute("lstUsuario", repoUsu.findAll());
	        model.addAttribute("lstTipoUsuario", repoTipoUsu.findAll());
	        return "PgUsuario";
	    }
	 //CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
		@GetMapping("/PgUsuario/listado")
		public String generarLista(Model model) {
			model.addAttribute("lstUsuario", repoUsu.findAll());
			model.addAttribute("lstTipoUsuario", repoTipoUsu.findAll());
			model.addAttribute("usuario", new Usuario());
			return ("PgUsuario");
		}
}
