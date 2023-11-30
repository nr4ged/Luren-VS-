package com.luren.sistemaluren.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.luren.sistemaluren.model.Cliente;

public interface IClienteRepository
	extends JpaRepository<Cliente, String> {

		@Procedure(name = "validarIngresoCliente")
	List<Cliente> validarIngresoCliente(@Param("Cliente") String codigo, @Param("pass") String nru_documento);


}

