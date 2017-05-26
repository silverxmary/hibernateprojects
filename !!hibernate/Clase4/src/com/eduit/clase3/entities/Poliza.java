package com.eduit.clase3.entities;
import javax.persistence.*;

@Entity
@Table(name="polizas")
public class Poliza 
{
    @Id
    @GeneratedValue
    @Column(name="p_id")
    private long id;
    @Column(name="p_texto")
    private String texto;
    @OneToOne(mappedBy="poliza") //ES EL NOMBRE DE LA PROPERTY DENTRO DE LA CLASE SEGURO
    private Seguro seguro;

    public Poliza() {
    }

    public Poliza(String texto) {
        this.texto = texto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    @Override
    public String toString() {
        return "Poliza{" + "id=" + id + ", texto=" + texto + ", seguro=" + seguro + '}';
    }
    
    
}
