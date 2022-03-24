package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.InventarioDao;
import com.market.model.Inventario;

@Service
public class InventarioService {
	
	@Autowired
	InventarioDao inventarioDao;
	
	public List<Inventario> listar(){
		return inventarioDao.findAll();
	}
	
	public Optional<Inventario> buscar(Integer id){
		return inventarioDao.findById(id);
	}
	
	public void agregar(Inventario inventario) {
		inventarioDao.sp_agregar_inventario(inventario.getId_contrato(), inventario.getCantidad(), inventario.getPrecio());
	}
	
	public void actualizar(Inventario inventario) {
		inventarioDao.sp_update_inventario(inventario.getId_inventario(), inventario.getId_contrato(), inventario.getCantidad(), inventario.getPrecio());
	}
	
	public void reducir(Inventario inventario) {
		inventarioDao.sp_reducir_inventario(inventario.getId_contrato(), inventario.getCantidad());
	}
}
