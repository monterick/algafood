package com.algaworks.algafood.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;



@Service
public class RestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	public List<Restaurante> listarRestaurantes(){
		return restauranteRepository.findAll();
	}
	
	public Restaurante buscarRestaurante(long id) {
		return restauranteRepository.findById(id).get();
	}
	public Restaurante adicionarRestaurante(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> 
				new EntidadeNaoEncontadaException(
						String.format("Não existe cozinha cadastrada com código %d", cozinhaId))
						);
	
		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}
	public Restaurante alterarRestaurante(long id, Restaurante restaurante) {
		long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(()-> new EntidadeNaoEncontadaException(
						String.format("Não existe cozinha cadastrada com código %d", cozinhaId)))
				;
		Optional<Restaurante> restaurante2 = restauranteRepository.findById(id);
		if(restaurante2.isEmpty()) {
			throw new EntidadeNaoEncontadaException(String.format("Não existe Retaurante cadastrado com código %d", id));
		}
	
	    
		BeanUtils.copyProperties(restaurante, restaurante2.get());
		
		return restaurante2.get();
		
	}
	public void removerRestaurante(long id) {
	   try {	
		restauranteRepository.deleteById(id);
	   }catch (EmptyResultDataAccessException e) {
		throw new EntidadeNaoEncontadaException(String.format("Não existe Restaurante cadastrado com código %d", id));
	   }
	}
	
}
