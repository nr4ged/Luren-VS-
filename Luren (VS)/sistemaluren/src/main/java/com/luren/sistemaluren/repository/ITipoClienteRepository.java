package com.luren.sistemaluren.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luren.sistemaluren.model.TipoCliente;


public interface ITipoClienteRepository extends JpaRepository<TipoCliente, Integer> {

}
