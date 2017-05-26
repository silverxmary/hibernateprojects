/*
 * Concesionario.java
 *
 */
package ar.com.educacionit.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */
@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fac_id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="factura", orphanRemoval=true)
    private Set<Item> items;

    // Constructor vacio
    public Factura() {
        this.items = new HashSet<Item>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set getItems() {
        return items;
    }

    public void setItems(Set items) {
        this.items = items;
    }
}
