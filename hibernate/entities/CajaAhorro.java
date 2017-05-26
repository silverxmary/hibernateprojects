/*
 * CajaAhorro.java
 *
 * Created on 17 de noviembre de 2008, 14:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package entities;


public class CajaAhorro extends Cuenta{
    
    private Float intereses;
    
    public CajaAhorro() {
    }
    
   
    public Float getIntereses() {
        return intereses;
    }

    public void setIntereses(Float intereses) {
        this.intereses = intereses;
    }
    
    @Override
    public String toString(){
        return "Tipo Cuenta : Caja de Ahorro "+" saldo : "+getSaldo()+" intereses :" + getIntereses();
    }
    
}
