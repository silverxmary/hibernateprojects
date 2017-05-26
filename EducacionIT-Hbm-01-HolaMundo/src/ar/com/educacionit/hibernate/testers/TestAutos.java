/*
 * TestAutos.java
 *
 */

package ar.com.educacionit.hibernate.testers;

import ar.com.educacionit.hibernate.entities.Auto;
import java.util.Iterator;
import java.util.List;
import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@gmail.com>
 */
public class TestAutos {
    
    /** Creates a new instance of TestAutos */
    public TestAutos() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // CASO #1 -- Inserta un Auto
        // insertarAutos();
        
        // CASO #2 -- Consulta los autos e imprime en pantalla
        // consultarAutos();
        
        // CASO #3 -- Consulta los autos, modifica un auto, y luego vuelve a consultar
        
        /*
        consultarAutos();
        System.out.println("------------------------------------------------");
        modificarAuto();
        System.out.println("------------------------------------------------");
        consultarAutos();
        */
        
        // CASO #4 -- Consulta los autos, elimina un auto, y luego vuelve a consultar
        
        consultarAutos();
        System.out.println("------------------------------------------------");
        eliminarAuto();
        System.out.println("------------------------------------------------");
        consultarAutos();
        
    }
    
    public static void consultarAutos()
    {
        // Obtiene los autos
        Iterator<Auto> it = getAutos().iterator();
        
        // Muestra los datos
        while( it.hasNext() )
        {
            Auto a = it.next();
            System.out.println( a.toString() );
        }
            
    }
    
    public static void insertarAutos()
    {
        // Instancia los autos
        Auto a1 = new Auto("Chevrolet Corsa", "2002");
        Auto a2 = new Auto("Fiat Uno", "2001");
        Auto a3 = new Auto("Peugeot 505", "2003");
        
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Genera una transaccion
        Transaction tx = session.beginTransaction();
        
        // Inserta los autos
        session.save(a1);
        session.save(a2);
        session.save(a3);
        
        
        // Compromete los cambios
        tx.commit();
        
        // Cierra la sesion de trabajo
        session.close();
        
        // Informa
        System.out.println("Los autos han sido insertados...");
    }
    
    private static List getAutos()
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Realiza la consulta
        List losAutos = session.createQuery("FROM ar.com.educacionit.hibernate.entities.Auto").list();
                
        // Cierra la sesion de trabajo
        session.close();
        
        // Retorna los autos
        return losAutos;
    }
    
    public static void modificarAuto()
    {
        // Instancia un auto
        Auto a1 = new Auto("Mercedes", "2002");
        a1.setId(1L);
        
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Genera una transaccion
        Transaction tx = session.beginTransaction();
        
        // Modifica el auto
        session.update(a1);
        
        // Compromete los cambios
        tx.commit();
        
        // Cierra la sesion de trabajo
        session.close();
        
        // Informa
        System.out.println("El auto ha sido modificado...");        
    }    
    
    public static void eliminarAuto()
    {
        // Establece el id del auto a eliminar
        Long elId = 1L;

        // Instancia un auto
        Auto a1 = new Auto();
        a1.setId(elId);
        
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Genera una transaccion
        Transaction tx = session.beginTransaction();
        
        // Elimina el auto
        session.delete(a1);
        
        // Compromete los cambios
        tx.commit();
        
        // Cierra la sesion de trabajo
        session.close();
        
        // Informa
        System.out.println("El auto ha sido eliminado...");        
    }        
}
