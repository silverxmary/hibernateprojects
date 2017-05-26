/*
 * TestService.java
 *
 */
package ar.com.educacionit.hibernate.testers;

import ar.com.educacionit.hibernate.services.CategoriaService;
import ar.com.educacionit.hibernate.services.FacturasService;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */
public class TestService {

    /**
     * Creates a new instance of TestService
     */
    public TestService() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // CASO DE PRUEBA #1 - Crear una factura con un item.
        // FacturasService.crearFactura();

        // CASO DE PRUEBA #2 - Remover un item
        //FacturasService.removerItem(15L);

        // CASO DE PRUEBA #3 - Elimina una factura junto con todos sus items        
         FacturasService.eliminar(16L);
        
        // CASO DE PRUEBA #4 - Crear categorias        
        // CategoriaService.crearCategorias();
        
        // CASO DE PRUEBA #5 - Asignar items a categorias        
        // CategoriaService.asignarItemsACategorias(2L, 15L);
        
        // CASO DE PRUEBA #6 - Informar
        CategoriaService.informar(1L, 15L);
        


    }
}
