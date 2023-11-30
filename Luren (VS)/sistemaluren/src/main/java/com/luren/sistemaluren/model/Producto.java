package com.luren.sistemaluren.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Producto {
	@Id
	private String codigo;
	private String producto;
	private String proveedor;
	private int cantidad;
	private double precio;
	private int tipo;

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", producto=" + producto + ", proveedor=" + proveedor + ", cantidad="
				+ cantidad + ", precio=" + precio + ", tipo=" + tipo + ", objTipo=" + objTipo + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Tipo_Prod getObjTipo() {
		return objTipo;
	}

	public void setObjTipo(Tipo_Prod objTipo) {
		this.objTipo = objTipo;
	}

	@ManyToOne
	@JoinColumn(name = "tipo", insertable = false, updatable = false)
	private Tipo_Prod objTipo;
}
