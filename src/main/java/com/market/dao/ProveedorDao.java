package com.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.Proveedor;

@Repository
public interface ProveedorDao extends JpaRepository<Proveedor, Integer>{
	
	@Procedure
	void sp_agregar_proveedor(String v_nombre, Integer v_ruc, String v_email, Integer v_telefono, String v_direccion);
	
	@Procedure
	void sp_update_proveedor(Integer v_id_proveedor,String v_nombre, Integer v_ruc, String v_email, Integer v_telefono, String v_direccion);
	
	@Procedure
	void sp_delete_proveedor(Integer v_id_proveedor);
}
