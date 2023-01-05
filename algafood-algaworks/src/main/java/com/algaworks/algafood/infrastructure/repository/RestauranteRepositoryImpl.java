package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.services.CozinhaService;
import com.algaworks.algafood.domain.services.RestauranteService;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@Autowired
	RestauranteService restauranteService;
	
	@Override
	public List<Restaurante> listarRestaurantes() {
		
		return restauranteService.listarRestaurantes();
	}

	@Override
	public Restaurante buscarRestaurante(long id) {
		// TODO Auto-generated method stub
		return restauranteService.buscarRestaurante(id);
	}

	@Override
	public Restaurante salvarRestaurante(Restaurante restaurante) {
		return restauranteService.salvarRestaurante(restaurante);
	}

	@Override
	public void removerRestaurante(long id) {
	   restauranteService.removerRetaurante(id);		
	}

	@Override
	public Restaurante atualizarRestaurante(long id, Restaurante restaurante) {
		return restauranteService.atualizarRestaurante(id, restaurante);		
	}
	
	

}
