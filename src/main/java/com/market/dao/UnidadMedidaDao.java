package com.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.UnidadMedida;

@Repository
public interface UnidadMedidaDao extends JpaRepository<UnidadMedida, Integer>{
	
	@Procedure
	void sp_agregar_unidad_medida(String v_nombre, String v_abreviatura);
	
	@Procedure
	void sp_update_unidad_medida(Integer v_id_unidad_medida,String v_nombre, String v_abreviatura);
	
	@Procedure
	void sp_delete_unidad_medida(Integer v_id_unidad_medida);
}
