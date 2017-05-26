/*
 * Poliza.java
 *
 * Created on 17 de noviembre de 2008, 15:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;


public class Poliza implements Serializable {
    
    private Long id;
    private String textoPoliza;
    private Seguro seguro;
    
    
    public Poliza() {
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
  
    public String getTextoPoliza() {
        return textoPoliza;
    }

    public void setTextoPoliza(String textoPoliza) {
        this.textoPoliza = textoPoliza;
    }
    
    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
  
    
    
    
}
