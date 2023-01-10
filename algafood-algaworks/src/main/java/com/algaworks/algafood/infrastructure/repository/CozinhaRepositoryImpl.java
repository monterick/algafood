package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Cozinha> listarCozinhas() {
		return manager.createQuery("from Cozinha",Cozinha.class).getResultList();
	}

	@Override
	public Cozinha buscarCozinha(long id) {
		return manager.find(Cozinha.class, id);
	}

	@Override
	@Transactional
	public Cozinha salvarCozinha(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

	@Override
	@Transactional
	public void removerCozinha(long id) {
		Cozinha cozinha = buscarCozinha(id);
		manager.remove(cozinha);		
	}

}
