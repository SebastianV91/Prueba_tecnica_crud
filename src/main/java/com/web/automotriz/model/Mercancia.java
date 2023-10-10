package com.web.automotriz.model;

import java.util.Date;

public class Mercancia {

	private Long idmercancia;

	private String nombre_producto;
	
	private Integer cantidad;
	
	private Date fecha_ingreso;
	
	private Integer usuarioid;

	private Integer usuarioidmodificacion;
	
	private Date fecha_modificacion;
	
	public Long getIdmercancia() {
		return idmercancia;
	}

	public void setIdmercancia(Long idmercancia) {
		this.idmercancia = idmercancia;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Integer getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}

	public Integer getUsuarioidmodificacion() {
		return usuarioidmodificacion;
	}

	public void setUsuarioidmodificacion(Integer usuarioidmodificacion) {
		this.usuarioidmodificacion = usuarioidmodificacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

}
