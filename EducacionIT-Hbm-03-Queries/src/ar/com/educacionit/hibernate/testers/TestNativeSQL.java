/*
 * TestNativeSQL.java
 *
 */

package ar.com.educacionit.hibernate.testers;

import ar.com.educacionit.hibernate.entities.Auto;
import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@gmail.com>
 */
public class TestNativeSQL {
    
    /** Creates a new instance of TestNativeSQL */
    public TestNativeSQL() {
    }
    
    public static void main(String[] args)
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Construye y ejecuta una queries en SQL nativo
        
            List losAutos = null;
            
            // CASO #1 -- Seleccionar todos los autos

            System.out.println("CASO #1 ---------------------------------------------------");
            losAutos = session.createSQLQuery("SELECT * FROM autos")
                                        .addEntity(Auto.class)
                                        .list();

            mostrarAutos((Iterator<Auto>) losAutos.iterator());
            System.out.println("---------------------------------------------------");


            // CASO #2 -- Seleccionar autos segun criterio
            /*
            System.out.println("CASO #2 ---------------------------------------------------");
            losAutos = session.createSQLQuery("SELECT * FROM autos WHERE au_marca = 'Fiat'")
                                        .addEntity(Auto.class)
                                        .list();

            mostrarAutos((Iterator<Auto>) losAutos.iterator());
            System.out.println("---------------------------------------------------");
            */
            
            // CASO #3 -- Seleccionar el monto total del valor de los autos Chevrolet
            
            /*
            System.out.println("CASO #3 ---------------------------------------------------");
            Double total = (Double) session.createSQLQuery("SELECT SUM(au_precio) as total FROM autos WHERE au_marca = 'Chevrolet'")
                                            .addScalar("total", DoubleType.INSTANCE)
                                            .uniqueResult();

            System.out.println("Total: $" + total);
            System.out.println("---------------------------------------------------");            
            */
            
            // CASO #4 -- Seleccionar algunos campos de la tabla autos
            /*
            System.out.println("CASO #4 ---------------------------------------------------");
            losAutos = session.createSQLQuery("SELECT au_marca, au_modelo FROM autos")
                                            .addScalar("au_marca", StringType.INSTANCE)
                                            .addScalar("au_modelo", IntegerType.INSTANCE)
                                            .list();
                    
            // >>> Colocar un breakpoint en la linea de abajo, y monitorear la variable 'losAutos'
            System.out.println("---------------------------------------------------");            
            */          

        // Cierra la sesion de trabajo
        session.close();
        
    }
    
    public static void mostrarAutos( Iterator<Auto> it)
    {
        // Informa los datos
        while( it.hasNext() )
        {
            Auto a = it.next();
            System.out.println( a.toString() );
        }
    }    
    
}
