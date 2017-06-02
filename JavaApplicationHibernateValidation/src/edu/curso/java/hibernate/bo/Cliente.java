package edu.curso.java.hibernate.bo;

import java.util.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import edu.curso.java.hibernate.validation.ValidaUsuario;



@Entity
public class Cliente {
	
	private Long id;
	
	@NotEmpty
	@Length(min= 3, max = 40)
	private String nombre;
	
	@NotEmpty
	@Length(min= 3, max = 40)
	private String apellido;
	
	@NotNull
	private Date fechaAlta;
	
	private Double saldo;
	
	@AssertTrue
	private boolean esClienteVip;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp="^[0-9]{2}-[0-9]{8}-[0-9]$",  message = "{cuit.msg}")
	private String cuit;

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	@Valid
	@NotNull
	private Direccion direccion;
	
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
	@NotNull
	@ValidaUsuario
	private String nombreUsuario;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@ManyToOne
	@JoinColumn(name="idDireccion")
	public Direccion getDireccion() {
		return direccion;
	}
	
	@OneToMany
	@JoinColumn(name="idCliente")
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public boolean isEsClienteVip() {
		return esClienteVip;
	}
	public void setEsClienteVip(boolean esClienteVip) {
		this.esClienteVip = esClienteVip;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
