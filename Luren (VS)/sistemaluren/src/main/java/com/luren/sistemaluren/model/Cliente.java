package com.luren.sistemaluren.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {
	@Id
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "empresa")
	private String empresa;
	@Column(name = "nru_documento")
	private String nru_documento;

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", empresa=" + empresa
				+ ", nru_documento=" + nru_documento + ", ObjTipoCliente=" + ObjTipoCliente + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNru_documento() {
		return nru_documento;
	}

	public void setNru_documento(String nru_documento) {
		this.nru_documento = nru_documento;
	}

	public TipoCliente getObjTipoCliente() {
		return ObjTipoCliente;
	}

	public void setObjTipoCliente(TipoCliente objTipoCliente) {
		ObjTipoCliente = objTipoCliente;
	}

	@ManyToOne
	@JoinColumn(name = "tipo", insertable = false, updatable = false)
	private TipoCliente ObjTipoCliente;
}
