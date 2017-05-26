/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.java.advanced.thread;

/**
 *
 * @author instructor
 */
public class Hipodromo {

    public static void main(String... args) throws InterruptedException {
        Meta meta = new Meta(200);
        Caballo caballo1 = new Caballo("El loco", meta);
        Caballo caballo2 = new Caballo("El negrito", meta);
        Caballo caballo3 = new Caballo("El Tercero", meta);
        
        caballo1.start();
        caballo2.start();
        caballo3.start();
        
    }

}
