package com.algaworks.algafood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.services.RestauranteService;

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
	public ResponseEntity<Restaurante> buscarRestaurante(@PathVariable(value = "id") long id){
		Restaurante restaurante = restauranteService.buscarRestaurante(id);
		if(restaurante!=null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public Restaurante salvarRestaurante(@RequestBody Restaurante restaurante) {
		return restauranteService.salvarRestaurante(restaurante);
	}
	@PutMapping("/{id}") 
	public Restaurante atualizarRestaurante(@PathVariable(value = "id") long id,@RequestBody Restaurante restaurante) {
		return restauranteService.atualizarRestaurante(id, restaurante) ;
	}
	@DeleteMapping("/{id}")
	public void removerRestaurante(long id) {
		restauranteService.removerRestaurante(id);
	}
	
}
