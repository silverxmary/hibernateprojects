package com.eduit.clase3.repository;

import com.eduit.clase3.entities.Cliente;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClienteRepository extends GenericRepository<Cliente, Long>{
    
    public ClienteRepository(SessionFactory factory) {
        super(factory);
    }
    
    public List<Cliente> allClient()
    {
        Session s = getFactory().openSession();
        List<Cliente> clientes = s.getNamedQuery("ALL_CLIENT").list();
        s.close();
        return clientes;
    }
    
    public List<Cliente> allByCredito(float credito)
    {
        Session s = getFactory().openSession();
        List<Cliente> clientes = s.getNamedQuery("ALL_BY_CREDITO").
                                    setParameter("cr", credito).
                                    list();
        s.close();
        return clientes;
    }
}
