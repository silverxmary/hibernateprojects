/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbcomplexmarshaller;

import domain.Direccion;
import domain.Telefono;
import domain.TipoUsuario;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Diego
 */
public class JaxbComplexMarshaller {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario u=new Usuario();
        u.setId(1);
        u.setNombre("nombre");
        u.setApellido("apellido");
        
        u.setTipoUsuario(TipoUsuario.REGULAR);
        
        Direccion d=new Direccion();
        d.setCalle("Lavalle");
        d.setAltura(1000);
        u.setDireccion(d);
        Telefono t=new Telefono();
        t.setNumero("1321");
        
        
        Telefono t1=new Telefono();
        t1.setNumero("13212");
        
        List<Telefono>tels=new ArrayList<Telefono>();
        tels.add(t);
        tels.add(t1);
        u.setTelefonos(tels);
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

