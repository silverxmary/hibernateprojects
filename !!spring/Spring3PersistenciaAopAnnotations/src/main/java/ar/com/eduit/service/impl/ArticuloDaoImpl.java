package ar.com.eduit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.com.eduit.dao.ArticuloDao;
import ar.com.eduit.entities.Articulo;
import ar.com.eduit.service.ArticuloService;

@Service(value="articuloDaoImpl")
@Scope(value="prototype")
public class ArticuloDaoImpl implements ArticuloService {

	@Autowired
	private ArticuloDao articuloDao;
	
	
	@Override
	public Articulo salvarArticulo(Articulo articulo) {
	    Long id = articuloDao.save(articulo);
	    articulo.setId(id);
		return articulo;
	}

	@Override
	public void borrarArticulo(Articulo articulo) {
		articuloDao.delete(articulo);
	}

	@Override
	public List<Articulo> listarArticulos() {
		
		return articuloDao.findAll();
	}

	@Override
	public Articulo obtenerPorId(Long id) {
		
		return articuloDao.getById(id);
	}

	@Override
	public void modificarArticulo(Articulo articulo) {
		articuloDao.saveOrUpdate(articulo);
		
	}

}
