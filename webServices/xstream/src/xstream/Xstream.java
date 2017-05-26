/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xstream;

import com.thoughtworks.xstream.XStream;
import domain.Usuario;

/**
 *
 * @author Diego
 */
public class Xstream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       XStream xstream = new XStream();
        Usuario u =new Usuario();
        u.setNombre("nombre");
        u.setApellido("apellido");
        System.out.println(xstream.toXML(u));
    }
}
