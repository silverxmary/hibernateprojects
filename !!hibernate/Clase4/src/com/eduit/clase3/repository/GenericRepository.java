package com.eduit.clase3.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class GenericRepository<E,pk extends Serializable> 
{
    //Atributo
    private SessionFactory factory;
    
    //Getter
    public SessionFactory getFactory() {
        return factory;
    }
    
    //Constructor
    public GenericRepository(SessionFactory factory){
        if (factory == null) {
            throw new IllegalArgumentException("Session factory is mandatory.");
        } 
        this.factory = factory;
    }
    
    //Metodos
    public pk save(E e)
    {
        Session s = factory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            pk id = (pk) s.save(e);
            tx.commit();
            return id;
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            throw ex;
            
        }
        finally{
            s.close();
        }
    }
    
    public void update(E e)
    {
        Session s = factory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            s.update(e);
            tx.commit();
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            throw ex;
            
        }
        finally{
            s.close();
        }
    }
    
    public void delete(E e)
    {
        Session s = factory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            s.delete(e);
            tx.commit();
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            throw ex;
            
        }
        finally{
            s.close();
        }
    }
    
    public void saveOrUpdate(E e)
    {
        Session s = factory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            s.saveOrUpdate(e);
            tx.commit();
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            throw ex;
            
        }
        finally{
            s.close();
        }
    }
    
    public Class getType(){
        Class clazz = this.getClass(); //En nuestro caso: PersonaRepository
        ParameterizedType superClazz = (ParameterizedType) clazz.getGenericSuperclass(); 
        //Aca da los Generics, si pongo solo super, no los devuelve
        //GenericRepository<Persona, Long>
        Type[] generics = superClazz.getActualTypeArguments();
        /*
        Class clazz = this.getClass();
        return (Class) ((ParameterizedType) clazz.getGenericSuperclass().
                                                    getactualTypeArguments)[0];
        
        */
        return (Class) generics[0];
    }
    
    
    public E GetByID(pk id)
    {
        Session s = factory.openSession();
        E e = (E) s.get(getType(), id);
        s.close();
        return e;
    }
    
    public List<E> getAll()
    {
        Session s = factory.openSession();
        List<E> entities = s.createQuery(
                "from " + getType().getName()).list();
        s.close();
        return entities;
    }
}
