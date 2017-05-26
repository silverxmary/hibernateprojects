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
    
    private static SessionFactory factory;

    public EducacionITSessionManager() {}

    public static SessionFactory getSession() throws HibernateException {

       if( factory == null) {
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
        
        //Mediante esta linea se setea la clase que determina el tipo de objetos que leerá
//
        config.addAnnotatedClass(com.eduit.clase3.entities.Cliente.class);
        config.addAnnotatedClass(com.eduit.clase3.entities.Cuenta.class);
        config.addAnnotatedClass(com.eduit.clase3.entities.Poliza.class);
        config.addAnnotatedClass(com.eduit.clase3.entities.Seguro.class);
        
        props.put("hibernate.hbm2ddl.auto", "create");
        //"UPDATE", "VALIDATE", "CREATE-DROP"
        
        // Establece las propiedades de configuracion
        config.setProperties(props);

        
        // Guarda la fabrica de sesiones
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        factory = config.buildSessionFactory(builder.build());
       }

        // Retorna una sesion de trabajo
        return factory;



    }

 

}
