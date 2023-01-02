package com.algaworks.algafood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	RestauranteRepository restauranteRepository; 
	
	@GetMapping
	public List<Restaurante> listarRestaurantes(){
		return restauranteRepository.listarRestaurantes();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> buscarRestaurante(@PathVariable(value = "id") long id){
		Restaurante restaurante = restauranteRepository.buscarRestaurante(id);
		if(restaurante!=null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public Restaurante salvarRestaurante(@RequestBody Restaurante restaurante) {
		return restauranteRepository.salvarRestaurante(restaurante);
	}
	
}
