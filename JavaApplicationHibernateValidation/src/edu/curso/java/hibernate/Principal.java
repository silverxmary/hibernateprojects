package edu.curso.java.hibernate;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.curso.java.hibernate.bo.Cliente;
import edu.curso.java.hibernate.bo.Direccion;
import edu.curso.java.hibernate.bo.Pedido;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Cliente clienteTest = new Cliente();
		clienteTest.setCuit("dadasdasdas");
		clienteTest.setNombreUsuario("pepe");
		Direccion direccionTest = new Direccion();
		
		clienteTest.setDireccion(direccionTest);
		
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(clienteTest);
		
		for(ConstraintViolation<?> cViolation : constraintViolations) {
			System.out.println(cViolation.getMessageTemplate() + " "+ cViolation.getInvalidValue() + " " + cViolation.getPropertyPath() + " " + cViolation.getMessage());
		}
		
		
		
		System.out.println("--------------------------------------------------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
		
			transaction = session.beginTransaction();
			
			Cliente cliente = new Cliente();
			
			double saldo = 5000;
		
			
			cliente.setNombre("Juan");
			cliente.setCuit("xxxxxxxxx");
			cliente.setFechaAlta(new Date());
			
			Long id = (Long) session.save(cliente);
			System.out.println("Id generado " + id);
			
			transaction.commit();
		
		} catch (ConstraintViolationException e) {
			
			for(ConstraintViolation<?> c : e.getConstraintViolations()) {
				System.out.println(c.getPropertyPath() + " " + c.getMessage());
				
			}
			transaction.rollback();
		}
		
		session.close();	
		
		HibernateUtil.getSessionFactory().close();
		

	}

}
