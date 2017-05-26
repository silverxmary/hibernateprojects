/*
 * Cuenta.java
 *
 * Created on 17 de noviembre de 2008, 14:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;


public class Cuenta implements Serializable{
    
   
    private Long id;
    private List<Cliente> clientes;
    private Double saldo;
    
    public Cuenta() {
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
   
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
}
