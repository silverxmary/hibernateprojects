/*
 * Concesionario.java
 *
 */

package ar.com.educacionit.hibernate.entities;

import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */

@Entity
@Table(name="concesionarios")
public class Concesionario implements Serializable {
    
    // Atributos
    @Id    
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="co_id")
    private Long id;
    @Column(name="co_nombre")
    private String nombre;
    @Column(name="co_direccion")
    private String direccion;
    
    // Constructor vacio
    public Concesionario(){}
    
    // Constructores
    public Concesionario(String unNombre, String unaDireccion)
    {
        setNombre(unNombre);
        setDireccion(unaDireccion);
    }
    
    public static Concesionario obtenerPorPK(long unId) throws HibernateException
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Construye la consulta
        String query = "FROM ar.com.educacionit.hibernate.entities.Concesionario where id = " + unId;
        
        // Realiza la consulta
        List<Concesionario> elConcesionario = session.createQuery(query).list();
        
        // Cierra la sesion de trabajo
        session.close();
        
        // Retorna el concesionario
        if( elConcesionario != null && elConcesionario.size() > 0)
            return elConcesionario.get(0);
        else
            return null;

    }
    
    public static List consultar() throws HibernateException
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Realiza la consulta
        List losConcesionarios = session.createQuery("FROM ar.com.educacionit.hibernate.entities.Concesionario").list();

        // Cierra la sesion de trabajo
        session.close();
        
        // Retorna los concesionarios
        return losConcesionarios;
    }
    
    public static List consultar3s() throws HibernateException
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Realiza la consulta
        List losConcesionarios = 
                session.createQuery("SELECT c1, c2 FROM ar.com.educacionit.hibernate.entities.Concesionario c1, ar.com.educacionit.hibernate.entities.Auto c2").list();

        // Cierra la sesion de trabajo
        session.close();
        
        // Retorna los concesionarios
        return losConcesionarios;
    }    
    
    public void insertar() throws HibernateException
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Genera una transaccion
        Transaction tx = session.beginTransaction();
        
        // Inserta el concesionario
        session.save(this);
        
        // Compromete los cambios
        tx.commit();
        
        // Cierra la sesion de trabajo
        session.close();
    }
    
    public void actualizar() throws HibernateException
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Genera una transaccion
        Transaction tx = session.beginTransaction();
        
        // Actualiza el concesionario
        session.update(this);
        
        // Compromete los cambios
        tx.commit();
        
        // Cierra la sesion de trabajo
        session.close();      
    }
    
    public void eliminar() throws HibernateException
    {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();
        
        // Genera una transaccion
        Transaction tx = session.beginTransaction();
        
        // Elimina el concesionario
        session.delete(this);
        
        // Compromete los cambios
        tx.commit();
        
        // Cierra la sesion de trabajo
        session.close();        
    }
    
    public String toString()
    {
        return id + " - " + nombre + " - " + direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
