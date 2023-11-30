package com.luren.sistemaluren.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.luren.sistemaluren.model.Servicio;

public interface IServicioRepository
	extends JpaRepository<Servicio, String> {
}