package com.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer> {
	
	@Procedure
	void sp_agregar_categoria(String v_nombre);
	
	@Procedure
	void sp_delete_categoria(Integer v_id_categoria);
	
	@Procedure
	void sp_update_categoria(Integer v_id_categoria, String v_nombre);
}
