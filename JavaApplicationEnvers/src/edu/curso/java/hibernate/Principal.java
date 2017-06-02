package edu.curso.java.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.query.AuditQueryCreator;

import edu.curso.java.hibernate.bo.Cliente;
import edu.curso.java.hibernate.bo.Direccion;

public class Principal {

	private SessionFactory sessionFactory = null;
	private Long idClienteActual = null;
			
	public Principal() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public static void main(String[] args) {

		Principal p = new Principal();
		//p.guardar();
		p.recuperar();
		
	}
	
	
	
	public void guardar() {
		System.out.println("Ejecutando guardar");
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Cliente cliente = new Cliente();

		double saldo = 5000;
		
		cliente.setNombre("Juanx");
		cliente.setApellido("Perezx");
		cliente.setEsClienteVip(true);
		cliente.setSaldo(saldo);
		cliente.setFechaAlta(new Date());
		
		Direccion direccion = new Direccion();
		direccion.setCalle("Callao 123x");
		
	
		idClienteActual = (Long) session.save(cliente);
		System.out.println("Id generado " + idClienteActual);
		
		transaction.commit();
		
		session.close();
		System.out.println("fin guardar");
		
	}
	
	
	
	public void recuperar() {
		System.out.println("Ejecutando recuperar");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		long id = 1;
		 Cliente cliente = null;
/*               
                cliente = new Cliente();
                cliente.setNombre("Carlos");
		session.save(cliente);
                id = cliente.getId();
		transaction.commit();
                

		transaction = session.beginTransaction();                
		cliente = (Cliente) session.load(Cliente.class, id);		
		cliente.setNombre("Carlos xyz");
		session.update(cliente);
		transaction.commit();*/
		
		
		AuditReader reader = AuditReaderFactory.get(session);
		cliente = (Cliente) reader.find(Cliente.class, id, 1);
		System.out.println(cliente.getNombre());
		
		List<Number> versions = reader.getRevisions(Cliente.class, id);
		for (Number number : versions) {
		  System.out.println(number + " " +  reader.getRevisionDate(number)); 
		}
	
		
	System.out.println("-------------------------------------------------------");
		
		AuditQuery auditQuery = reader.createQuery().forRevisionsOfEntity(Cliente.class, false, true);
		auditQuery.add(AuditEntity.property("nombre").eq("Juan"));
		List<Number> versions2 = auditQuery.getResultList();
		for (Number number : versions) {
			  System.out.println(number + " " +  reader.getRevisionDate(number)); 
		}
	


		
		session.close();
		
		System.out.println("fin recuperar");
	}
	

}
