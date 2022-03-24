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

import com.market.model.UnidadMedida;
import com.market.service.UnidadMedidaService;

@RestController
@RequestMapping("/api/um")
public class UnidadMedidaController {
	
	@Autowired
	UnidadMedidaService unidadMedidaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<UnidadMedida>> listar(){
		List<UnidadMedida> lista = unidadMedidaService.listar();
		return new ResponseEntity<List<UnidadMedida>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Optional<UnidadMedida>> buscar(@PathVariable("id") Integer id){
		Optional<UnidadMedida> um = unidadMedidaService.buscar(id);
		return new ResponseEntity<Optional<UnidadMedida>>(um,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody UnidadMedida unidadMedida){
		unidadMedidaService.agregar(unidadMedida);
		return new ResponseEntity("Unidad de medida agregada correctamente.",HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/actualizar")
	public ResponseEntity<?> acttualizar(@RequestBody UnidadMedida unidadMedida){
		unidadMedidaService.actualizar(unidadMedida);
		return new ResponseEntity("Unidad de medida actualizada correctamente.",HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody UnidadMedida unidadMedida){
		unidadMedidaService.eliminar(unidadMedida);
		return new ResponseEntity("Unidad de medida eliminada de forma exitosa.", HttpStatus.OK);
	}
}
