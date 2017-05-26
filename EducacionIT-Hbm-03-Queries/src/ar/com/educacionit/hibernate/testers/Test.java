/*
 * Test.java
 *
 */

package ar.com.educacionit.hibernate.testers;

import ar.com.educacionit.hibernate.entities.Auto;
import java.util.Iterator;
import java.util.List;
import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import org.hibernate.Session;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@gmail.com>
 */
public class Test {
    
    /**
     * Creates a new instance of TestAutosOld
     */
    public Test() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();

        // Informa todos los autos
        System.out.println("[Todos los autos ordenados en forma descendente por fecha de venta]");
        mostrarAutos( getTodosLosAutos(session).iterator() );
        System.out.println("---------------------");
        
        // Informa autos modelo 2000
        System.out.println("[Autos modelo 2000]");
        mostrarAutos( getAutosModelo2000(session).iterator() );
        System.out.println("---------------------");
        
        // Informa autos donde la marca comienza con la letra C
        System.out.println("[Autos donde su marca comienza con la letra C]");
        mostrarAutos( getAutosTalQueMarcaComienzaConC(session).iterator() );
        System.out.println("---------------------");

        // Informa autos con precio > 15000
        System.out.println("[Autos con precio mayor a $15.000]");
        mostrarAutos( getAutosTalQuePrecioMayorA15K(session).iterator() );
        System.out.println("---------------------");
        
        // Informa autos con fecha de venta entre 2002-01-01 y 2003-01-01
        System.out.println("[Autos con fecha de venta entre 2002-01-01 y 2003-01-01]");
        mostrarAutos( getAutosEntreFechas(session).iterator() );
        System.out.println("---------------------");        

        // Informa la cantidad de autos
        System.out.println("Cantidad de autos: " + getCantidadDeAutos( session ));
        System.out.println("---------------------");        

        // Informa el promedio de los precios
        System.out.println("Promedio de precios: $" + getPromedioDePrecios( session ));
        System.out.println("---------------------");
        
        // Informa el precio del auto mas caro
        System.out.println("Precio del auto mas caro: $" + getPrecioMasCaro( session ));
        System.out.println("---------------------");
        
        // Informa la cantidad de marcas distintas
        System.out.println("Cantidad de marcas distintas: " + getCantidadDeMarcas( session ));
        System.out.println("---------------------");
        
        // Informa el monto total de venta agrupado por marca
        System.out.println("[Monto total de venta agrupado por marca]");
        mostrarMontoTotalSegunMarca( session );
        System.out.println("---------------------");        
        
        // Realiza el producto cartesiano entre autos y concesionarios
      /*  System.out.println("[Porducto cartesiano entre autos y concesionarios]");
        mostrarProductoCartesiano( session );
        System.out.println("---------------------");        
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
    
    private static List<Auto> getTodosLosAutos(Session s)
    {
        // Consulta
        String qry = "FROM ar.com.educacionit.hibernate.entities.Auto ORDER BY fechaVenta DESC";

        // Realiza la consulta
        List<Auto> autos = s.createQuery(qry).list();
                
        // Retorna los autos
        return autos;
    }
    
    private static List<Auto> getAutosModelo2000(Session s)
    {
        // Consulta
        String qry = "FROM ar.com.educacionit.hibernate.entities.Auto WHERE modelo = '2000'";
        
        // Realiza la consulta
        List<Auto> autos = s.createQuery(qry).list();
                
        // Retorna los autos
        return autos;
    }    

    private static List<Auto> getAutosTalQueMarcaComienzaConC(Session s)
    {
        // Consulta
        String qry = "FROM ar.com.educacionit.hibernate.entities.Auto WHERE marca LIKE 'C%'";
        
        // Realiza la consulta
        List<Auto> autos = s.createQuery(qry).list();
                
        // Retorna los autos
        return autos;
    }        
    
    private static List<Auto> getAutosTalQuePrecioMayorA15K(Session s)
    {
        // Consulta
        String qry = "FROM ar.com.educacionit.hibernate.entities.Auto WHERE precio > 15000";
        
        // Realiza la consulta
        List<Auto> autos = s.createQuery(qry).list();
                
        // Retorna los autos
        return autos;
    }            
    
    private static List<Auto> getAutosEntreFechas(Session s)
    {
        // Consulta
            String qry = "FROM ar.com.educacionit.hibernate.entities.Auto WHERE fechaVenta BETWEEN '2002-01-01' AND '2003-01-01'";
        
        // Realiza la consulta
        List<Auto> autos = s.createQuery(qry).list();
                
        // Retorna los autos
        return autos;
    }

    private static int getCantidadDeAutos(Session s)
    {
        // Consulta
        String qry = "SELECT count(*) FROM ar.com.educacionit.hibernate.entities.Auto";
        
        // Realiza la consulta
        Long cantidad = (Long) s.createQuery(qry).uniqueResult();
        
        // Retorna la cantidad
        return cantidad.intValue();
    }    
    
    private static double getPromedioDePrecios(Session s)
    {
        // Consulta
        String qry = "SELECT avg(precio) FROM ar.com.educacionit.hibernate.entities.Auto";
        
        // Realiza la consulta
        Double cantidad = (Double) s.createQuery(qry).uniqueResult();
        
        // Retorna la cantidad
        return cantidad.floatValue();
    }        

    private static float getPrecioMasCaro(Session s)
    {
        // Consulta
        String qry = "SELECT max(precio) FROM ar.com.educacionit.hibernate.entities.Auto";
        
        // Realiza la consulta
        Float precio = (Float) s.createQuery(qry).uniqueResult();
        
        // Retorna el precio
        return precio.floatValue();
    }        
    
    private static int getCantidadDeMarcas(Session s)
    {
        // Consulta
        String qry = "SELECT count(distinct marca) FROM ar.com.educacionit.hibernate.entities.Auto";
        
        // Realiza la consulta
        Long precio = (Long) s.createQuery(qry).uniqueResult();
        
        // Retorna la cantidad
        return precio.intValue();
    }      
    
    private static void mostrarMontoTotalSegunMarca(Session s)
    {
        // Consulta
        String qry = "SELECT marca, sum(precio) FROM ar.com.educacionit.hibernate.entities.Auto GROUP BY marca";
        
        // Realiza la consulta
        List datos = s.createQuery(qry).list();
        
        // Recorre los datos obtenidos
        Iterator it = datos.iterator();
        while( it.hasNext() )
        {
            Object[] dato = (Object[]) it.next();
            System.out.print("Marca: " + dato[0]);
            System.out.println(" -- Monto vendido: $" + dato[1]);
        }
    }
    
    private static void mostrarProductoCartesiano(Session s)
    {
        // Consulta
        String qry = "FROM ar.com.educacionit.hibernate.entities.Auto, ar.com.educacionit.hibernate.entities.Concesionario";
        
        // Realiza la consulta
        List datos = s.createQuery(qry).list();
        
        // Recorre los datos obtenidos
        Iterator it = datos.iterator();
        while( it.hasNext() )
        {
            Object[] dato = (Object[]) it.next();
            System.out.println("Auto: " + dato[0]);
            System.out.println("Concesionario: " + dato[1]);
            System.out.println("--------");
            
        }
    }        
    
}
