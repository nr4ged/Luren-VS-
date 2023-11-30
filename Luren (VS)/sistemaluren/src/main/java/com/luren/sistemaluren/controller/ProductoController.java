package com.luren.sistemaluren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luren.sistemaluren.model.Producto;
import com.luren.sistemaluren.repository.IProductoRepository;
import com.luren.sistemaluren.repository.ITipo_ProdRepository;


@Controller
public class ProductoController {
	
	@Autowired
	private IProductoRepository repoProd;
	@Autowired
	private ITipo_ProdRepository repoTipo;
	
	//CARGARPAGINA!!
	
	@GetMapping("/PgProducto")
	public String abrirPagProd(Model model) {
	model.addAttribute("producto", new Producto());
    model.addAttribute("lstTipo", repoTipo.findAll());
    model.addAttribute("lstProductos", repoProd.findAll());
		return "PgProducto";
	}
	
	//REGISTAR Y ACTUALIZAR!!
	@PostMapping("/PgProducto")
    public String registrarServicio(@ModelAttribute Producto producto, @RequestParam(value = "action", required = false) String action, Model model) {
		if ("registrar".equals(action)) {
    	        if (repoProd.existsById(producto.getCodigo())) {
    	            model.addAttribute("mensaje", "El código del Producto ya existe");
    	        } else {
    	            try {
    	            	repoProd.save(producto);
    	                model.addAttribute("mensaje", "Producto registrado correctamente");
    	            } catch (Exception e) {
    	                model.addAttribute("mensaje", "Error al registrar el servicio");
    	            }
    	        }
    	    
    	}else if ("actualizar".equals(action)) {
    	        try {
    	        	repoProd.save(producto);
    	            model.addAttribute("mensaje", "Producto actualizado correctamente");
    	        
    	        } catch (Exception e) {
    	            model.addAttribute("mensaje", "Error al actualizar el Producto");
    	    }
    	}else if ("eliminar".equals(action)) {
    	    if (producto.getCodigo().isBlank()) {
    	        model.addAttribute("mensaje", "El campo Código del Producto debe estar lleno");
    	    } else {
    	        if (repoProd.existsById(producto.getCodigo())) {
    	            try {
    	            	repoProd.deleteById(producto.getCodigo());
    	                model.addAttribute("mensaje", "Producto eliminado correctamente");
    	            } catch (Exception e) {
    	                model.addAttribute("mensaje", "Error al eliminar el Producto");
    	            }
    	        } else {
    	            model.addAttribute("mensaje", "El código del Producto no existe");
    	        }
    	    }
    	}
	    model.addAttribute("lstProductos", repoProd.findAll());
	    model.addAttribute("lstTipo", repoTipo.findAll());
        return "PgProducto";
    }
	
	//BUSCAR
		
    @GetMapping("/PgProducto/editar/{codigo}")
    public String editarServicio(@PathVariable("codigo") String codigo, Model model) {
    	Producto producto = repoProd.findById(codigo).orElse(null);
        model.addAttribute("producto", producto);
        model.addAttribute("lstProductos", repoProd.findAll());
        model.addAttribute("lstTipo", repoTipo.findAll());
        return "PgProducto";
    }
}
