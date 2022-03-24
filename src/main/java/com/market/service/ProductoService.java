package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.ProductoDao;
import com.market.model.Producto;

@Service
public class ProductoService {
	
	@Autowired
	ProductoDao productoDao;
	
	public List<Producto> lista(){
		return productoDao.findAll();
	}
	public Optional<Producto> buscar(String id){
		return productoDao.findById(id);
	}
	
	public void agregar(Producto producto) {
		productoDao.sp_agregar_producto(producto.getNombre(), producto.getDescripcion(), producto.getId_marca(), producto.getId_catergoria(), producto.getId_unidad_medida());
	}
	
	public void actualizar(Producto producto) {
		productoDao.sp_update_producto(producto.getId_producto(),producto.getNombre(), producto.getDescripcion(), producto.getId_marca(), producto.getId_catergoria(), producto.getId_unidad_medida());
	}
	public void eliminar (Producto producto) {
		productoDao.sp_delete_producto(producto.getId_producto());
	}
	
}
