package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.UnidadMedidaDao;
import com.market.model.UnidadMedida;

@Service
public class UnidadMedidaService {
	
	@Autowired
	UnidadMedidaDao unidadMedidaDao;
	
	public List<UnidadMedida> listar(){
		return unidadMedidaDao.findAll();
	}
	
	public Optional<UnidadMedida> buscar(Integer id){
		return unidadMedidaDao.findById(id);
	}
	
	public void agregar(UnidadMedida unidadMedida) {
		unidadMedidaDao.sp_agregar_unidad_medida(unidadMedida.getNombre(), unidadMedida.getAbreviatura());
	}
	
	public void actualizar(UnidadMedida unidadMedida) {
		unidadMedidaDao.sp_update_unidad_medida(unidadMedida.getId_unidad_medida() ,unidadMedida.getNombre(), unidadMedida.getAbreviatura());
	}
	public void eliminar(UnidadMedida unidadMedida) {
		unidadMedidaDao.sp_delete_unidad_medida(unidadMedida.getId_unidad_medida());
	}
}
