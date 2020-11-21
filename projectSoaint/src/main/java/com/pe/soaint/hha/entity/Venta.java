package com.pe.soaint.hha.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "venta")
public class Venta{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idventa")
	private Integer idventa;
	
	@ManyToOne
	@JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
	private Cliente cliente;
	
	@NotNull
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "venta")
	@JsonManagedReference
	private List<DetalleVenta> detalles;

	public Integer getIdventa() {
		return idventa;
	}

	public void setIdVenta(Integer idventa) {
		this.idventa = idventa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
}