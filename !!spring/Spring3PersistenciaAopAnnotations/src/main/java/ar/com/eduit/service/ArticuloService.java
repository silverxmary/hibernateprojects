package ar.com.eduit.service;

import java.util.List;

import ar.com.eduit.entities.Articulo;

public interface ArticuloService {
	
	public Articulo salvarArticulo(Articulo articulo);
	
	public void borrarArticulo(Articulo articulo);
	
	public List<Articulo> listarArticulos();
	
	public Articulo obtenerPorId(Long id);
	
	public void modificarArticulo(Articulo articulo);
	
	

}
