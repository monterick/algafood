package com.algaworks.algafood;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.services.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	
	@GetMapping
	public List<Restaurante> listarRestaurantes(){
		return restauranteService.listarRestaurantes();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> buscarRestaurante(@PathVariable(value = "id") long id) {
		Restaurante restaurante = restauranteService.buscarRestaurante(id);
		if(restaurante!=null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<?> adicionarRestaurante(@RequestBody Restaurante restaurante) {
	   try {
		 Restaurante restaurante2 = restauranteService.adicionarRestaurante(restaurante);
		 return ResponseEntity.status(HttpStatus.CREATED).body(restaurante2); 
	   }catch (EntidadeNaoEncontadaException e) {
		 return ResponseEntity.badRequest().body(e.getMessage());
	   }
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarRestaurante(@PathVariable(value = "id") long id, @RequestBody Restaurante restaurante){
		try {
		 Restaurante restaurante2 = restauranteService.alterarRestaurante(id, restaurante);
		if(restaurante2!=null) {
			return ResponseEntity.ok(restaurante2);
		} 			
		
		return ResponseEntity.notFound().build();
		
		}catch (EntidadeNaoEncontadaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Restaurante> removerRestaurante(@PathVariable(value = "id") long id){
		try {
			restauranteService.removerRestaurante(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (EntidadeNaoEncontadaException e) {
		    return ResponseEntity.notFound().build();
		}
	}
	
}
