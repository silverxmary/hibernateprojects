package ar.com.eduit.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.com.eduit.entities.Articulo;
import ar.com.eduit.entities.Factura;
import ar.com.eduit.service.FacturaService;

public class AppTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        FacturaService facturaService = context.getBean("facturaService", FacturaService.class);

        Factura factura = new Factura();
        Articulo tel = new Articulo("telefono", "caja", 1000.00f, 10);
        Articulo tv = new Articulo("tv", "caja", 3000.00f, 50);
        factura.getArticulos().add(tel);
        factura.getArticulos().add(tv);

        System.out.println(facturaService.crearFactura(factura));
    }
}
