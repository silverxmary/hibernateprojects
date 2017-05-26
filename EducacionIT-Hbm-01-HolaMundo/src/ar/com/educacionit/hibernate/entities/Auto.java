/*
 * Auto.java
 *
 */

package ar.com.educacionit.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */

@Entity
@Table(name="autos")
public class Auto implements Serializable{
    
    // Atributos
    @Id    
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="au_id")
    private Long id;
    
    @Column(name="au_marca")
    private String marca;
    
    @Column(name="au_modelo")
    private String modelo;

    /* Siempre conservar el constructor de Auto vacio: Auto(){} */
    
    /** Creates a new instance of Auto */
    public Auto() {
    }
    
    public Auto(String unaMarca, String unModelo)
    {
        marca = unaMarca;
        modelo = unModelo;
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String toString()
    {
        return id + " - " + marca + " - " + modelo;
    }
    
}
