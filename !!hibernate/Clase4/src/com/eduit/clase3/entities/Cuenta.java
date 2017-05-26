
package com.eduit.clase3.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="cuentas")

public class Cuenta 
{
    @Id
    @GeneratedValue
    @Column(name="cu_id")
    private long id;
    private float saldo;
    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="clientes_cuentas",
            joinColumns = {@JoinColumn(name="fk_cu")},
            inverseJoinColumns = @JoinColumn(name="fk_cl"))
    
    private List<Cliente> clientes;

    public Cuenta() {
    }

    public Cuenta(float saldo) {
        this.saldo = saldo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", saldo=" + saldo + "}";
    }
    
    
}
