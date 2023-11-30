package com.luren.sistemaluren.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.luren.sistemaluren.model.Usuario;

public interface IUsuarioRepository 
	extends JpaRepository<Usuario, String> {

		@Procedure(name = "validarIngresoUsuario")
	List<Usuario> validarIngresoUsuario(@Param("Usuario") String usuario, @Param("pass") String clave);

}
