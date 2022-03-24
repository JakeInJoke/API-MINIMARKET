package com.market.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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

import com.market.model.Categoria;
import com.market.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Categoria>> lista(){
		
		List<Categoria> lista = categoriaService.lista();
		return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(HttpServletRequest httpServletRequest,@RequestBody Categoria categoria){
		categoriaService.agregar(categoria);
		return new ResponseEntity("Categoria insertada correctamente.", HttpStatus.CREATED);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Optional<Categoria>> obtener(HttpServletRequest httpServletRequest,@PathVariable("id") Integer id){
		Optional<Categoria> categoria = categoriaService.getById(id);
		return new ResponseEntity<Optional<Categoria>>(categoria, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(HttpServletRequest httpServletRequest,@RequestBody Categoria categoria){
		categoriaService.eliminar(categoria);
		return new ResponseEntity("Categoria eliminada de manera logica correctamente.", HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/editar")
	public ResponseEntity<?> editar(HttpServletRequest httpServletRequest,@RequestBody Categoria categoria){
		categoriaService.actualizar(categoria);
		return new ResponseEntity("Categoria editada correctamente.", HttpStatus.OK);
	}

}
