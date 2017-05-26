
package com.eduit.clase3;

import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import com.eduit.clase3.entities.*;
import com.eduit.clase3.repository.ClienteRepository;
import java.util.*;
import org.hibernate.SessionFactory;

public class Main 
{
    public static void main(String[] args) 
    {
        SessionFactory factory = EducacionITSessionManager.getSession();
        try 
            {
                ClienteRepository clientRepo = new ClienteRepository(factory);
                
                Cliente martin = new Cliente("Martin", "Lopez");
                Cuenta c1 = new Cuenta(5000F);
                Cuenta c2 = new Cuenta(4000F);
                
                List<Cuenta> cuentas = new ArrayList<>();
                cuentas.add(c1);
                cuentas.add(c2);
                martin.setCuentas(cuentas);
                Seguro s = new Seguro(300F);
                Poliza p = new Poliza("Texto Poliza");
                s.setPoliza(p);
                
                List<Seguro> seguros = new ArrayList<>();
                seguros.add(s);
                martin.setSeguros(seguros);
                
                long id = clientRepo.save(martin);
                
                System.out.println("Obteniendo cliente " + id);
                
                Cliente c = clientRepo.GetByID(id);
                System.out.println("Listando cuentas");
                
                /*
                El fetchType Lazy indica que al traer al objeto no traerá todo
                sino que solo traerá lo que yo le pido. Por esa razòn en este caso
                lanza una Exception, en el atributo list<cuentas> se debe cambiar
                el fetchType a EAGER
                */
                
                List<Cuenta> accounts = c.getCuentas();
                for(Cuenta acc : accounts)
                {
                    System.out.println(acc);
                }
                
                /*
                HIBERNATE CREA UNA CLASE EN TIEMPO DE EJECUCION MEDIANTE JAVASYST
                class $Cliente_1 extends Cliente
                Esta clase (proxy) extiende de nuestra clase y el objeto que trae de la
                base de datos entra como un objeto cliente aunque no lo sea.
                Dentro del método de esta clase nueva, genera LA QUERY.
                De forma "burda" podemos solucionar este problema evitando que se cierre
                la sesion al comentar el s.close() en el método del repositorio genérico.
                */
            } 
        finally{
            factory.close();
        }
    }
}
