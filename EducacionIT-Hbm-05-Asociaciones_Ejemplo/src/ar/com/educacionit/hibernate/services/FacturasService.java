/*
 * ConcesionarioService.java
 *
 */
package ar.com.educacionit.hibernate.services;

import ar.com.educacionit.hibernate.entities.Item;
import ar.com.educacionit.hibernate.entities.Factura;
import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import org.hibernate.Session;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */
public class FacturasService {

    /**
     * Creates a new instance of ConcesionarioService
     */
    public FacturasService() {
    }

    public static void crearFactura() {
        // Obtiene la sesion de trabajo e inicia una transaccion
        Session session = EducacionITSessionManager.getSession();
        session.beginTransaction();

        // Instanciamos una factura
        Factura factura = new Factura();

        // Instanciamos el primer Item y seteamos valores
        Item item = new Item();
        item.setCantidad(10L);
        item.setNombreProducto("1er Item");
        item.setFactura(factura);
        factura.getItems().add(item);

        // Instanciamos el primer Item y seteamos valores
        Item item2 = new Item();
        item2.setCantidad(15L);
        item2.setNombreProducto("2do item");
        item2.setFactura(factura);
        factura.getItems().add(item2);


        session.save(factura);
        // session.save(item);

        // Confirma los cambios
        session.getTransaction().commit();

        // Cierra la sesion
        session.close();
    }

    public static void removerItem(Long id) {
        // Obtiene la sesion de trabajo e inicia una transaccion
        Session session = EducacionITSessionManager.getSession();
        session.beginTransaction();

        // Obtiene la factura
        Factura factura = (Factura) session.load(Factura.class, new Long(id));

        // Informa la factura
        System.out.println("Factura: " + factura.getId().toString() + "------------------------");

        // Removemos un item
        Item item = (Item) factura.getItems().iterator().next();
        factura.getItems().remove(item);

        // Guardamos los cambios
        session.save(factura);
        // Confirma los cambios
        session.getTransaction().commit();
        // Cierra la sesion
        session.close();
    }

    // Elimina la factura con todos sus items
    public static void eliminar(Long id) {
        // Obtiene la sesion de trabajo
        Session session = EducacionITSessionManager.getSession();

        // Inicia la transaccion
        session.beginTransaction();

        // Construye un concesionario a partir de idConcesionario
        Factura c1 = (Factura) session.load(Factura.class, id);

        // Elimina el concesionario y todos sus autos
        session.delete(c1);

        // Compromete los cambios
        session.getTransaction().commit();

        // Cierra la sesion de trabajo
        session.close();
    }
}
