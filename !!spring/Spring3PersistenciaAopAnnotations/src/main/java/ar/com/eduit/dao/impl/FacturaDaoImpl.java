package ar.com.eduit.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.com.eduit.dao.FacturaDao;
import ar.com.eduit.entities.Factura;


@Service("facturaDao")
@Scope("singleton")
public class FacturaDaoImpl extends GenericDaoImpl<Factura, Long> implements FacturaDao {
	
	

}
