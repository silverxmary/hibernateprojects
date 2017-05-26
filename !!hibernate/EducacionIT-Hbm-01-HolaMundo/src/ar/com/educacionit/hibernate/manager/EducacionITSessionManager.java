/*
 * EducacionITSessionManager.java
 *
 */
package ar.com.educacionit.hibernate.manager;

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

    /**
     * Creates a new instance of EducacionITSessionManager
     */
    public EducacionITSessionManager() {
    }

    public static Session getSession() throws HibernateException {

        // Instancia un objeto del tipo Configuration
        Configuration config = new Configuration();

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

        // Establece las propiedades de configuracion
        config.setProperties(props);
        
       // config.addAnnotatedClass(ar.com.educacionit.hibernate.entities.Auto.class);

        // Guarda la fabrica de sesiones
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        SessionFactory factory = config.buildSessionFactory(builder.build());

        // Retorna una sesion de trabajo
        return factory.openSession();



    }

 

}
