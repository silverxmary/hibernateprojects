/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhibernate;

import java.util.Date;
import java.util.List;
import javaapplicationhibernate.bo.Cliente;
import javaapplicationhibernate.bo.Pedido;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author educacionit
 */
public class JavaApplicationHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Session session = MiHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Long id = null;
        Cliente cliente = new Cliente();

        double saldo = 5000;

        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setEsClienteVip(true);
        cliente.setSaldo(saldo);
        cliente.setFechaAlta(new Date());

        id = (Long) session.save(cliente);
        System.out.println("Id generado " + id);

        Pedido pedido1 = new Pedido();
        pedido1.setSaldo(5000);
        pedido1.setCliente(cliente);

        session.save(pedido1);

        cliente.getPedidos().add(pedido1);
        session.update(cliente);

        transaction.commit();
        session.close();

        System.out.println("Recuperando cliente -------------------------------------------");

        session = MiHibernateUtil.getSessionFactory().openSession();
        cliente = (Cliente) session.load(Cliente.class, id);

        System.out.println(cliente.getNombre() + " " + cliente.getApellido());

        session.close();

        System.out.println("Recuperando pedidos -------------------------------------------");

        session = MiHibernateUtil.getSessionFactory().openSession();
        cliente = (Cliente) session.load(Cliente.class, id);

        System.out.println(cliente.getNombre() + " " + cliente.getApellido());
        for (Pedido p : cliente.getPedidos()) {
            System.out.println(p.getSaldo());
        }

        session.close();

        System.out.println("Recuperando pedidos -------------------------------------------");

        session = MiHibernateUtil.getSessionFactory().openSession();
        cliente = (Cliente) session.load(Cliente.class, id);

        System.out.println(cliente.getNombre() + " " + cliente.getApellido());

        for (Pedido p : cliente.getPedidos()) {
            System.out.println(p.getSaldo());
        }

        session.close();

        System.out.println("-------------------------------------------");

        session = MiHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Cliente as c");
        query.setCacheable(true);

        List<Cliente> clientes = query.list();

        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " " + c.getApellido());
        }

        session.close();

        System.out.println("-------------------------------------------");

        session = MiHibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Cliente as c");
        query.setCacheable(true);

        clientes = query.list();

        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " " + c.getApellido());
        }

        session.close();

        MiHibernateUtil.getSessionFactory().close();
    }

}
