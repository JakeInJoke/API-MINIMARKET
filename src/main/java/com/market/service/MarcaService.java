package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.MarcaDao;
import com.market.model.Marca;

@Service
public class MarcaService {
	
	@Autowired
	MarcaDao marcaDao;
	
	public List<Marca> listar(){
		return marcaDao.findAll();
	}
	
	public Optional<Marca> buscar(Integer id){
		return marcaDao.findById(id);
	}
	
	public void agregar(Marca marca){
		marcaDao.sp_agregar_marca(marca.getNombre());
	}
	
	public void actualizar(Marca marca) {
		marcaDao.sp_update_marca(marca.getId_marca(), marca.getNombre());
	}
	
	public void eliminar(Marca marca) {
		marcaDao.sp_delete_marca(marca.getId_marca());
	}
}
