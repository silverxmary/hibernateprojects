/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbmarshaller;

import domain.Usuario;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Diego
 */
public class JaxbMarshaller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       	Usuario u=new Usuario();
        u.setId(1);
        u.setNombre("nombre");
        u.setApellido("apellido");
        try {
 
		JAXBContext jaxbContext = JAXBContext.newInstance(Usuario.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(u, System.out);
 
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
 
	}
    
}
