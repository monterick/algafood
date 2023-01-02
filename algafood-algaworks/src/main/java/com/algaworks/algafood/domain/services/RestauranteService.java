package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class RestauranteService {

	@PersistenceContext
	EntityManager manager;
	
	public List<Restaurante> listarRestaurantes(){
		return manager.createQuery("from Restaurante",Restaurante.class).getResultList();
	}
	
	public Restaurante buscarRestaurante(long id) {
		return manager.find(Restaurante.class, id);
	}
	@Transactional
	public Restaurante salvarRestaurante(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
}
