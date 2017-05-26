/*
 * Seguro.java
 *
 * Created on 17 de noviembre de 2008, 15:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;

public class Seguro implements Serializable{
    
   private Long id;
   private Double SumaAsegurada;
   private Poliza poliza;
   private Cliente cliente;
   
    public Seguro() {
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
    public Double getSumaAsegurada() {
        return SumaAsegurada;
    }

    public void setSumaAsegurada(Double SumaAsegurada) {
        this.SumaAsegurada = SumaAsegurada;
    }
   
  
    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    @Override
    public String toString(){
        return "Seguro N° :"+getId()+" suma asegurada :"+getSumaAsegurada()+" poliza n° "+getPoliza().getId()+" texto poliza :"+getPoliza().getTextoPoliza();     
                
    }
    
}
