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

import com.market.model.Proveedor;
import com.market.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {
	
	@Autowired
	ProveedorService proveedorService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Proveedor>> listar(){
		List<Proveedor> lista = proveedorService.listar();
		return new ResponseEntity<List<Proveedor>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Optional<Proveedor>> buscar(@PathVariable("id") Integer id){
		Optional<Proveedor> proveOptional = proveedorService.buscar(id);
		return new ResponseEntity<Optional<Proveedor>>(proveOptional,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Proveedor proveedor){
		proveedorService.agregar(proveedor);
		return new ResponseEntity("Proveedor agregado exitosamente.",HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Proveedor proveedor){
		proveedorService.actualizar(proveedor);
		return new ResponseEntity("Proveedor actualizado correctamente.", HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Proveedor proveedor){
		proveedorService.eliminar(proveedor);
		return new ResponseEntity("Proveedor eliminado de forma exitosa.", HttpStatus.OK);
	}
}
