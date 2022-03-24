package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.ContratoDao;
import com.market.model.Contrato;

@Service
public class ContratoService {
	
	@Autowired
	ContratoDao contratoDao;
	
	public List<Contrato> lista(){
		return contratoDao.findAll();
	}
	
	public Optional<Contrato> getById(String id){
		return contratoDao.findById(id);
	}
	
	public void agregar(Contrato contrato) {
		contratoDao.sp_agregar_contrato(contrato.getId_proveedor(),contrato.getId_producto());
	}
	
	public void eliminar(Contrato contrato) {
		contratoDao.sp_delete_contrato(contrato.getId_contrato());
	}
	
	public void actualizar(Contrato contrato) {
		contratoDao.sp_update_contrato(contrato.getId_contrato(),contrato.getId_proveedor(),contrato.getId_producto());
	}
}
