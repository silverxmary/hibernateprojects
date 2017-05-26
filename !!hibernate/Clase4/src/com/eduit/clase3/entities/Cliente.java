package com.eduit.clase3.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="clientes")

public class Cliente 
{
    @Id
    @GeneratedValue
    @Column(name="cl_id")
    private long id;
    @Column(name="cl_nombre")
    private String nombre;
    @Column(name="cl_apellido")
    private String apellido;
    
    //Para cada relacion de tablas hay una annotation distinta
    
    @ManyToMany(fetch = FetchType.LAZY /*, cascade = CascadeType.ALL*/)
    @JoinTable(name="clientes_cuentas",
                joinColumns ={ @JoinColumn(name="fk_cl")},
                inverseJoinColumns = @JoinColumn(name="fk_cu"))
    private List<Cuenta> cuentas;
    
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL) //orphanRemoval = true
    @JoinColumn(name="fk_cc")
    private List<Seguro> seguros;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cuentas=" + cuentas + ", seguros=" + seguros + '}';
    }
    
    
    
}
