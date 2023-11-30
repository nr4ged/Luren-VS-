package com.luren.sistemaluren.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_tipousuario")
@Data
public class TipoUsuario {

	@Id
	@Column(name = "id_tipo_usuario")
	private int id_tipo_usuario;

	@Column(name = "des_tipo_usuario")
	private String des_tipo_usuario;

	@Override
	public String toString() {
		return "TipoUsuario [id_tipo_usuario=" + id_tipo_usuario + ", des_tipo_usuario=" + des_tipo_usuario + "]";
	}

	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public String getDes_tipo_usuario() {
		return des_tipo_usuario;
	}

	public void setDes_tipo_usuario(String des_tipo_usuario) {
		this.des_tipo_usuario = des_tipo_usuario;
	}

}
