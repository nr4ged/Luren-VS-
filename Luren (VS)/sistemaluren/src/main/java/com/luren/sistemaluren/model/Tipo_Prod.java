package com.luren.sistemaluren.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_tipprod")
@Data
public class Tipo_Prod {
	@Id
	@Column(name="tipo_prod")
	private int tipo;
	private String des_tipo;

	@Override
	public String toString() {
		return "Tipo_Prod [tipo=" + tipo + ", des_tipo=" + des_tipo + "]";
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDes_tipo() {
		return des_tipo;
	}

	public void setDes_tipo(String des_tipo) {
		this.des_tipo = des_tipo;
	}

}
