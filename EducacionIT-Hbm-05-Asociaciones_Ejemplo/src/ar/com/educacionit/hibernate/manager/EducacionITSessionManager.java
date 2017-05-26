/*
 * EducacionITSessionManager.java
 *
 */
package ar.com.educacionit.hibernate.manager;

import ar.com.educacionit.hibernate.entities.Categoria;
import ar.com.educacionit.hibernate.entities.Item;
import ar.com.educacionit.hibernate.entities.Factura;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Sebastián S. Sanga <SebastianSanga@gmail.com>
 */
public abstract class EducacionITSessionManager {

    // Atributo que guarda una fabrica de sesiones
    private static SessionFactory factory;

    /**
     * Creates a new instance of EducacionITSessionManager
     */
    public EducacionITSessionManager() {
    }

    public static Session getSession() throws HibernateException {
        // Si la fabrica de sesiones ya esta creada, entonces retorna una sesion 
        if (factory != null) {
            return factory.openSession();
        } // Si la fabrica de sesiones no esta creada, entonces crea una y retorna una sesion
        else {
            // Instancia un objeto del tipo Configuration
            Configuration config = new Configuration();

            // Registra los mappers en la configuracion
            registerMappers(config);

            // Establece las propiedades de configuracion
            config.setProperties(getHibernateProperties());

            // Guarda la fabrica de sesiones
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            factory = config.buildSessionFactory(builder.build());

            // Retorna una sesion de trabajo
            return factory.openSession();
        }
    }

    private static Properties getHibernateProperties() {
        // Instancia un objeto del tipo Properties
        Properties props = new Properties();

        // Establece el driver de conexion dependiente del RDBMS
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        // Establece la url de conexion dependiente del RDBMS
        props.put("hibernate.connection.url", "jdbc:mysql://localhost/hibernate");

        // Establece el usuario
        props.put("hibernate.connection.username", "root");

        // Establece la clave
        props.put("hibernate.connection.password", "");

        // Establece el dialecto a utilizar
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        // Establece el uso de logging, deberá existir el archivo log4j.properties
        props.put("hibernate.show_sql", "true");

        // Retorna las propiedades
        return props;

    }

    private static void registerMappers(Configuration config) throws MappingException {
        config.addAnnotatedClass(Factura.class);
        config.addAnnotatedClass(Item.class);
        config.addAnnotatedClass(Categoria.class);
        
    }
}
