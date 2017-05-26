/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unmarshallerconclasesgeneradas;

import generated.Usuario;
import java.io.File;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Diego
 */
public class UnMarshallerConClasesGeneradas {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            URL url = UnMarshallerConClasesGeneradas.class.getResource("usuario.xml");
            File file = new File(url.getPath());
            JAXBContext jaxbContext = JAXBContext.newInstance(Usuario.class);
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Usuario usuario = (Usuario) jaxbUnmarshaller.unmarshal(file);
            System.out.println(usuario.getNombre());
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}
