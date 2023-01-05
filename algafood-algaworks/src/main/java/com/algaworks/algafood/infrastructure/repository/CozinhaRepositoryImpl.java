package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}

	@Override
	public Cozinha BuscarCozinha(long id) {		
		return manager.find(Cozinha.class, id);
	}

	@Override
	@Transactional
	public Cozinha adicionarCozinha(Cozinha cozinha) {		
		return manager.merge(cozinha);
	}

	@Override
	@Transactional
	public Cozinha atualizarCozinha(long id, Cozinha cozinha) {		
		Cozinha cozinhaAtual = BuscarCozinha(id);
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		return cozinhaAtual;
	}

	@Override
	@Transactional
	public void removerCozinha(long id) {
		Cozinha cozinha = BuscarCozinha(id);
		manager.remove(cozinha);
	}

}
