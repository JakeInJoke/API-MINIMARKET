package com.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.Marca;

@Repository
public interface MarcaDao extends JpaRepository<Marca, Integer>{

	@Procedure
	void sp_agregar_marca(String v_nombre);
	
	@Procedure
	void sp_update_marca(Integer v_id_marca, String v_nombre);
	
	@Procedure
	void sp_delete_marca(Integer v_id_marca);
	
}
