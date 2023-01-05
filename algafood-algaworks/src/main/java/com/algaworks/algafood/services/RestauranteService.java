package com.algaworks.algafood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;
	
	public List<Restaurante> listarRestaurantes(){
		return restauranteRepository.listarRestaurantes();
	}
	public Restaurante buscarRestaurante(long id) {
		return restauranteRepository.buscarRestaurante(id);
	}
	public Restaurante salvarRestaurante(Restaurante restaurante) {
		return restauranteRepository.salvarRestaurante(restaurante);
	}
	public Restaurante atualizarRestaurante(long id, Restaurante restaurante) {
		return restauranteRepository.atualizarRestaurante(id, restaurante);
	}
	public void removerRestaurante(long id) {
		restauranteRepository.removerRestaurante(id);
	}
	
}
