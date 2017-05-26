package javaapplicationhibernate.bo;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Cliente {
	
    	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String apellido;
	private Date fechaAlta;
	private Double saldo;
	private boolean esClienteVip;
        
        @OneToMany
	@JoinColumn(name="idCliente")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
	

	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	

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

}
