package com.pe.soaint.hha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detalleventa")
public class DetalleVenta{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddetalleventa")
	private Integer iddetalleventa;
	
	@ManyToOne
	@JoinColumn(name = "idventa", referencedColumnName = "idventa")
	@JsonBackReference
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	private Producto producto;

	public Integer getIddetalleventa() {
		return iddetalleventa;
	}

	public void setIddetalleventa(Integer iddetalleventa) {
		this.iddetalleventa = iddetalleventa;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}