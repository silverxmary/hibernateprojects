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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    // Atributos
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id")
    private Long id = null;
        
    @Column(name = "cat_descripcion")
    private String descripcion;
    
    @ManyToMany
    @JoinTable(name = "categorias_items",
               joinColumns = {@JoinColumn(name = "cat_id")},
               inverseJoinColumns = {@JoinColumn(name = "it_id")})    
    private Set<Item> items = new HashSet<Item>();

    
    /**
     * Creates a new instance of Categoria
     */

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
}
