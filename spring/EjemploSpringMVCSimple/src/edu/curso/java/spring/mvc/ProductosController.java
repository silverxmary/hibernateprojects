package edu.curso.java.spring.mvc;


import java.beans.PropertyEditorSupport;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.apache.cxf.jaxrs.provider.JSONUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.sun.corba.se.impl.copyobject.JavaStreamObjectCopierImpl;

import edu.curso.java.spring.bo.*;
import edu.curso.java.spring.mvc.form.ProductoForm;
import edu.curso.java.spring.service.ProductoService;

@Controller
public class ProductosController {

	@Autowired
	private ProductoService productoService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model)  {
		
		List<Producto> productos = productoService.buscarProductos();
	 	model.addAttribute("productos", productos);
	 	return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String ver(@RequestParam("id") long id, Model model)  {
		Producto producto = productoService.buscarProducto(id);
		
	 	model.addAttribute("producto", producto);
	 	return null;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String editar(@RequestParam("id") long id, Model model)  {
		Producto producto = productoService.buscarProducto(id);
		ProductoForm productoForm = new ProductoForm();
		BeanUtils.copyProperties(producto, productoForm);
		model.addAttribute("productoForm", productoForm);	
		return "/productos/form";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String borrar(@RequestParam("id") long id, Model model)  {
		productoService.borrarProducto(id);
		return "redirect:/productos/listar.html";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String nuevo(Model model) throws Exception{
		
		ProductoForm productoForm = new ProductoForm();
		model.addAttribute("productoForm", productoForm);
		return "/productos/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("productoForm") @Valid ProductoForm productoForm, BindingResult result, Model model) {
		
		System.out.println(result.hasErrors());
		
		if (result.hasErrors()) {
			return "/productos/form";
		}
		
		Long id = productoForm.getId();
		
		Producto producto = null;
		
		if(id == null) {
			producto = new Producto();
			BeanUtils.copyProperties(productoForm, producto);	
			id = productoService.guardarProducto(producto);	
		} else {
			producto = productoService.buscarProducto(id);
			BeanUtils.copyProperties(productoForm, producto);	
			productoService.actualizarProducto(producto);
		}
		
		return "redirect:/productos/ver.html?id=" + id;
	}

	
	
	/*@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
		Long id = producto.getId();
		if(id == null) {
			id = productoService.guardarProducto(producto);	
		} else {
			productoService.actualizarProducto(producto);
		}
		
		return "redirect:/productos/ver.html?id=" + id;
	}*/

	
	
}



