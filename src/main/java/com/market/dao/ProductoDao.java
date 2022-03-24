package com.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, String> {
	
	@Procedure
	void sp_agregar_producto(String v_nombre, String v_descripcion,Integer v_id_marca,Integer v_id_categoria,Integer v_id_unidad_medida);
	
	@Procedure
	void sp_update_producto(String v_id_producto,String v_nombre,String v_descripcion,Integer v_id_marca,Integer v_id_categoria,Integer v_id_unidad_medida);
	
	@Procedure
	void sp_delete_producto(String v_id_producto);
}
