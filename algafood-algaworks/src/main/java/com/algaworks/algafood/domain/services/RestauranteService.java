package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
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
	public Restaurante adicionarRestaurante(Restaurante restaurante) {
		return restauranteRepository.adicionarRestaurante(restaurante);
	}
	public Restaurante alterarRestaurante(long id, Restaurante restaurante) {
		return restauranteRepository.alterarRestaurante(id, restaurante);
	}
	public void removerRestaurante(long id) {
	   try {	
		restauranteRepository.removerRestaurante(id);
	   }catch (EmptyResultDataAccessException e) {
		throw new EntidadeNaoEncontadaException(String.format("Não existe Restaurante cadastrado com código %d", id));
	   }
	}
	
}
