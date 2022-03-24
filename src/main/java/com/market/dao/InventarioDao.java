package com.market.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.Inventario;

@Repository
public interface InventarioDao extends JpaRepository<Inventario, Integer>{
	
	@Procedure
	void sp_agregar_inventario(String v_id_contrato, Integer v_cantidad, Double v_precio );
	
	@Procedure
	void sp_reducir_inventario(String v_id_contrato, Integer v_cantidad);
	
	@Procedure
	void sp_update_inventario(Integer v_id_inventario, String v_id_contrato, Integer v_cantidad, Double v_precio);
}
