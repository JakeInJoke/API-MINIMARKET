package com.market.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id_producto;
	private String nombre;
	private String descripcion;
	private Integer id_marca , id_catergoria,id_unidad_medida,estado;
	private Date creacion, modificacion;
	
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getId_marca() {
		return id_marca;
	}
	public void setId_marca(Integer id_marca) {
		this.id_marca = id_marca;
	}
	public Integer getId_catergoria() {
		return id_catergoria;
	}
	public void setId_catergoria(Integer id_catergoria) {
		this.id_catergoria = id_catergoria;
	}
	public Integer getId_unidad_medida() {
		return id_unidad_medida;
	}
	public void setId_unidad_medida(Integer id_unidad_medida) {
		this.id_unidad_medida = id_unidad_medida;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}
	public Date getModificacion() {
		return modificacion;
	}
	public void setModificacion(Date modificacion) {
		this.modificacion = modificacion;
	}
	
	
}
