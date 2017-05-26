/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import com.thoughtworks.xstream.XStream;
import domain.Usuario;

/**
 *
 * @author Diego
 */
public class Reader {
    
    public static void main(String[] args) {
        XStream x=new XStream();
                
        String xml="<domain.Usuario>\n" +
                "  <nombre>nombre</nombre>\n" +
                "  <apellido>apellido</apellido>\n" +
                "</domain.Usuario>";
        
        
        Usuario u=(Usuario)x.fromXML(xml);
        System.out.println(u.getNombre());
    }
    
}
