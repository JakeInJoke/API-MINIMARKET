package com.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.ProveedorDao;
import com.market.model.Proveedor;

@Service
public class ProveedorService {
	@Autowired
	ProveedorDao proveedorDao;
	
	public List<Proveedor> listar(){
		return proveedorDao.findAll();
	}
	
	public Optional<Proveedor> buscar(Integer id){
		return proveedorDao.findById(id);
	}
	
	public void agregar(Proveedor proveedor) {
		proveedorDao.sp_agregar_proveedor(proveedor.getNombre(), proveedor.getRuc(), proveedor.getEmail(), proveedor.getTelefono(), proveedor.getDireccion());
	}
	
	public void actualizar(Proveedor proveedor) {
		proveedorDao.sp_update_proveedor(proveedor.getId_proveedor(),proveedor.getNombre(), proveedor.getRuc(), proveedor.getEmail(), proveedor.getTelefono(), proveedor.getDireccion());
	}
	
	public void eliminar(Proveedor proveedor) {
		proveedorDao.sp_delete_proveedor(proveedor.getId_proveedor());
	}
}
