/*
 * Auto.java
 *
 */
package ar.com.educacionit.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */
@Entity
@Table(name = "items")
public class Item implements Serializable {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "it_id")
    private Long id = null;
    @ManyToOne
    @JoinColumn(name = "fac_id")
    private Factura factura;
    @Column(name = "it_cantidad")
    private Long cantidad;
    @Column(name = "it_descripcion")
    private String nombreProducto;
    
    @ManyToMany(mappedBy = "items")
    private Set<Categoria> categorias = new HashSet<Categoria>();

    /**
     * Creates a new instance of Item
     */
    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
}
