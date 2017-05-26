package ar.com.eduit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.com.eduit.beans.EstacionMetereologica;


public class App {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EstacionMetereologica norte = context.getBean("estacionMetereologicaNorte",EstacionMetereologica.class);
		norte.tomarMedicion();
		
		EstacionMetereologica sur = context.getBean("estacionMetereologicaSur",EstacionMetereologica.class);
		sur.tomarMedicion();
	   
	}
}
