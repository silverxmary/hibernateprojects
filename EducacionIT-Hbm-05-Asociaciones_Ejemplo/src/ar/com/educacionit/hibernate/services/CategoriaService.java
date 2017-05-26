/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.hibernate.services;

import ar.com.educacionit.hibernate.entities.Categoria;
import ar.com.educacionit.hibernate.entities.Factura;
import ar.com.educacionit.hibernate.entities.Item;
import ar.com.educacionit.hibernate.manager.EducacionITSessionManager;
import org.hibernate.Session;

/**
 *
 * @author rdurante
 */
public class CategoriaService {

    public static void crearCategorias() {
        // Obtiene la sesion de trabajo e inicia una transaccion
        Session session = EducacionITSessionManager.getSession();
        session.beginTransaction();

        // Instanciamos una factura
        Categoria cat = new Categoria();
        cat.setDescripcion("BEBIDAS");

        Categoria cat2 = new Categoria();
        cat2.setDescripcion("COMIDAS");

        Categoria cat3 = new Categoria();
        cat3.setDescripcion("POSTRES");


        session.save(cat);
        session.save(cat2);
        session.save(cat3);


        // Confirma los cambios
        session.getTransaction().commit();

        // Cierra la sesion
        session.close();
    }

    public static void asignarItemsACategorias(Long categoriaid, Long itemid) {
        // Obtiene la sesion de trabajo e inicia una transaccion
        Session session = EducacionITSessionManager.getSession();
        session.beginTransaction();

        // Obtiene la Categoria
        Categoria categoria = (Categoria) session.load(Categoria.class, new Long(categoriaid));
        Item item = (Item) session.load(Item.class, new Long(itemid));

        categoria.getItems().add(item);

        session.save(categoria);
        // Confirma los cambios
        session.getTransaction().commit();

        // Cierra la sesion
        session.close();
    }

    public static void informar(Long categoriaid, Long itemid) {
        // Obtiene la sesion de trabajo e inicia una transaccion
        Session session = EducacionITSessionManager.getSession();


        // Obtiene la Categoria
        Categoria categoria = (Categoria) session.load(Categoria.class, new Long(categoriaid));
        Item item = (Item) session.load(Item.class, new Long(itemid));

        System.out.println("La categoria tiene:");
        System.out.println(categoria.getItems().size() + " items");

        System.out.println("El item tiene:");
        System.out.println(item.getCategorias().size() + " categorias");


        // Cierra la sesion
        session.close();
    }
}
