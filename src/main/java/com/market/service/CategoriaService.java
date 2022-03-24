package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CategoriaDao;
import com.market.model.Categoria;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaDao categoriaDao;
	
	public List<Categoria> lista(){
		return categoriaDao.findAll();
	}
	
	public Optional<Categoria> getById(Integer id){
		return categoriaDao.findById(id);
	}
	
	public void agregar(Categoria categoria) {
		categoriaDao.sp_agregar_categoria(categoria.getNombre());
	}
	
	public void eliminar(Categoria categoria) {
		categoriaDao.sp_delete_categoria(categoria.getId());
	}
	
	public void actualizar(Categoria categoria) {
		categoriaDao.sp_update_categoria(categoria.getId(),categoria.getNombre());
	}
}
