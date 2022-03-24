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

import com.market.model.Marca;
import com.market.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
	
	@Autowired
	MarcaService marcaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Marca>> listar(){
		List<Marca> lista = marcaService.listar();
		return new ResponseEntity<List<Marca>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Optional<Marca>> buscar(@PathVariable("id") Integer id){
		Optional<Marca> objMa = marcaService.buscar(id);
		return new ResponseEntity<Optional<Marca>>(objMa,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Marca marca){
		marcaService.agregar(marca);
		return new ResponseEntity("Marca agregada de manera exitosa.", HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Marca marca){
		marcaService.actualizar(marca);
		return new ResponseEntity("Marca actualizada con exito", HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar (@RequestBody Marca marca){
		marcaService.eliminar(marca);
		return new ResponseEntity("Marca eliminada con exito", HttpStatus.OK);
	}
}
