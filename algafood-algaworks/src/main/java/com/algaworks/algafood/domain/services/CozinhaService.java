package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CozinhaService {

	@PersistenceContext
	EntityManager manager;
	
	public List<Cozinha> listarCozinhas(){
		return manager.createQuery("from Cozinha",Cozinha.class).getResultList();
	}
	
	public Cozinha BuscarCozinha(long id) {
		return manager.find(Cozinha.class, id);
	}
	
}
