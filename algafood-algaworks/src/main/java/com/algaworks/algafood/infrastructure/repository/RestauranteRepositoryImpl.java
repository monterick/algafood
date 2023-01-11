package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Restaurante> listarRestaurantes() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscarRestaurante(long id) {
		return manager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public Restaurante adicionarRestaurante(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	@Override
	@Transactional
	public Restaurante alterarRestaurante(long id, Restaurante restaurante) {
		Restaurante restauranteAtual = buscarRestaurante(id);
		if(restauranteAtual!=null) {
			BeanUtils.copyProperties(restaurante, restauranteAtual,"id");
			adicionarRestaurante(restauranteAtual);
		}
		return restauranteAtual;
	}

	@Override
	@Transactional		
	public void removerRestaurante(long id) {		
		Restaurante restaurante = buscarRestaurante(id);
		if(restaurante == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(restaurante);
	}

}
