/*
 * Cliente.java
 *
 */

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Cliente implements Serializable {
   
    private Long id;
    private String nombres;
    private String dirrecion;
    private List<Cuenta> cuentas;
    private List<Seguro> seguros;
    
    public Cliente(){
      cuentas = new ArrayList<Cuenta>();  
      seguros = new ArrayList<Seguro>();    
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }
    
   
    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
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
    
}
