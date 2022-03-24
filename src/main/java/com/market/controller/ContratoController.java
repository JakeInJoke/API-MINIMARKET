package com.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Contrato;
import com.market.service.ContratoService;

@RestController
@RequestMapping("/api/contrato")
public class ContratoController {
	
	@Autowired
	ContratoService contratoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Contrato>> listar(){
	List<Contrato> lista = contratoService.lista();
	return new ResponseEntity<List<Contrato>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Optional<Contrato>> obtener(@PathVariable("id") String contrato){
		Optional<Contrato> cont = contratoService.getById(contrato);
		return new ResponseEntity<Optional<Contrato>>(cont,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Contrato contrato) {
		contratoService.agregar(contrato);
		return new ResponseEntity("Contrato almacenado correctamente.",HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody Contrato contrato){
		contratoService.actualizar(contrato);
		return new ResponseEntity("Contrato actualizado de manera exitosa.",HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@RequestBody Contrato contrato){
		contratoService.eliminar(contrato);
		return new ResponseEntity("Contrato eliminado conrrectamente.",HttpStatus.OK);
	}
	
}
