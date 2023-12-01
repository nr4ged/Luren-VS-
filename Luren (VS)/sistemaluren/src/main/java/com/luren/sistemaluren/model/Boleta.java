package com.luren.sistemaluren.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_boleta")
@Data
public class Boleta {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cod_servicio", referencedColumnName = "cod_servicio")
    private Servicio servicio;

    @Column(name = "fecha_generacion")
    private String fechaGeneracion;

    
    
    @Override
	public String toString() {
		return "Boleta [id=" + id + ", cliente=" + cliente + ", servicio=" + servicio + ", fechaGeneracion="
				+ fechaGeneracion + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
	public String getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

    
    
}