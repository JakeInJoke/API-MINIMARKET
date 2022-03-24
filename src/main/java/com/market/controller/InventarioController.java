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

import com.market.model.Inventario;
import com.market.service.InventarioService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
	
	@Autowired
	InventarioService inventarioService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Inventario>> listar(){
		List<Inventario> lista = inventarioService.listar();
		return new ResponseEntity<List<Inventario>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Optional<Inventario>> buscar(@PathVariable("id") Integer id){
		Optional<Inventario> objInv = inventarioService.buscar(id);
		return new ResponseEntity<Optional<Inventario>>(objInv,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Inventario inventario){
		inventarioService.agregar(inventario);
		return new ResponseEntity("Objeto agregado exitosamente",HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Inventario inventario){
		inventarioService.actualizar(inventario);
		return new ResponseEntity("Inventario actualizado exitosamente.",HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/reducir")
	public ResponseEntity<?> reducir(@RequestBody Inventario inventario){
		inventarioService.reducir(inventario);
		return new ResponseEntity("Inventario reducido.",HttpStatus.OK);
	}
	
}
