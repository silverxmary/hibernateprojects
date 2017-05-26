package com.eduit.clase3.entities;

import javax.persistence.*;

@Entity
@Table(name="seguros")

public class Seguro 
{
    @Id
    @GeneratedValue
    @Column(name="s_id")
    private long id;
    @Column(name="s_monto")
    private float monto;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_cc")
    private Cliente cliente;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_po")
    private Poliza poliza;

    public Seguro() {
    }

    public Seguro(float monto) {
        this.monto = monto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    @Override
    public String toString() {
        return "Seguro{" + "id=" + id + ", monto=" + monto + ", cliente=" + cliente + ", poliza=" + poliza + '}';
    }
    
    
    
}
