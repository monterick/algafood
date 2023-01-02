package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

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
	
	@Transactional	
	public Cozinha adicionarCozinha(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	@Transactional
	public Cozinha atualizarCozinha(long id, Cozinha cozinha) {
		Cozinha cozinhaAtual = BuscarCozinha(id);
		if(cozinhaAtual!=null) {
		 BeanUtils.copyProperties(cozinha, cozinhaAtual,"id");
		}
		return cozinhaAtual;
	}
	@Transactional
	public void deletarCozinha(long id) {
	
		Cozinha cozinhaAtual = BuscarCozinha(id);
		if(cozinhaAtual == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cozinhaAtual);
		
	}
	
}
