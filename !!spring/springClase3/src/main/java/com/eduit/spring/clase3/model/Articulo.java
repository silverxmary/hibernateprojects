package com.eduit.spring.clase3.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;


@Entity
@Table(name="articulos")
public class Articulo implements Serializable {
	
   
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String presentacion;
	

	@NumberFormat(style = Style.NUMBER)
	private Float precio;
	

	@NumberFormat(style = Style.NUMBER)
	@Min(1)
	@Max(9999)
	private Integer cantidad;
	
	

	public Articulo(String nombre, String presentacion, Float precio, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.presentacion = presentacion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Articulo() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="presentacion")
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
	@Column(name="cantidad")
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name="precio")
	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
}
