package com.luren.sistemaluren.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_tipocliente")
@Data
public class TipoCliente {

	@Id
	@Column(name = "id_tipocliente")
	private int id_tipocliente;
	@Column(name = "documento_cliente")
	private String documento_cliente;

	@Override
	public String toString() {
		return "TipoCliente [id_tipocliente=" + id_tipocliente + ", documento_cliente=" + documento_cliente + "]";
	}

	public int getId_tipocliente() {
		return id_tipocliente;
	}

	public void setId_tipocliente(int id_tipocliente) {
		this.id_tipocliente = id_tipocliente;
	}

	public String getDocumento_cliente() {
		return documento_cliente;
	}

	public void setDocumento_cliente(String documento_cliente) {
		this.documento_cliente = documento_cliente;
	}

}
