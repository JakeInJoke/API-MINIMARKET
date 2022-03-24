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

import com.market.model.Producto;
import com.market.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> lista = productoService.lista();
		return new ResponseEntity<List<Producto>>(lista,HttpStatus.OK);	
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Optional<Producto>> buscar(@PathVariable("id") String id){
		Optional<Producto> prod = productoService.buscar(id);
		return new ResponseEntity<Optional<Producto>>(prod,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Producto producto){
		productoService.agregar(producto);
		return new ResponseEntity("Producto agregado con exito.",HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Producto producto){
		productoService.actualizar(producto);
		return new ResponseEntity("Producto actualizado con exito.", HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Producto producto){
		productoService.eliminar(producto);
		return new ResponseEntity("producto eliminado de forma exitosa.",HttpStatus.OK);
	}
	
}
