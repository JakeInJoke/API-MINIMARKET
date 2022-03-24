package com.market.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.market.model.Contrato;

@Repository
public interface ContratoDao extends JpaRepository<Contrato, String> {
	
	/*@Query(value = "SELECT * FROM CONTRATO WHERE ID_CONTRATO = :id",nativeQuery = true)
	Optional<Contrato> get(@Param("id") String v_id_contrato);*/
	
	@Procedure
	void sp_agregar_contrato(Integer v_id_proveedor,String v_id_producto);
	
	@Procedure
	void sp_delete_contrato(String v_id_contrato);
	
	@Procedure
	void sp_update_contrato(String v_id_contrato, Integer v_id_proveedor, String v_id_producto);
}
