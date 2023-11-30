package com.luren.sistemaluren.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luren.sistemaluren.model.Producto;

public interface IProductoRepository 
extends JpaRepository<Producto, String> {
	
}