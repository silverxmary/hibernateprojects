package ar.com.eduit.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.com.eduit.dao.ArticuloDao;
import ar.com.eduit.entities.Articulo;

@Service("articuloDao")
@Scope("singleton")
public class ArticuloDaoImpl extends GenericDaoImpl<Articulo, Long> implements ArticuloDao{

}
