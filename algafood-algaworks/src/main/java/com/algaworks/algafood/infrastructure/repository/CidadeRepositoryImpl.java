package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Cidade> listarCidades() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscarCidade(long id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	@Transactional
	public Cidade salvarCidade(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	@Transactional
	public Cidade alterarCidade(long id, Cidade cidade) {
		Cidade cidade2 = buscarCidade(id);
		
		if(cidade2!=null) {
			BeanUtils.copyProperties(cidade, cidade2, "id");
			salvarCidade(cidade2);
		}
		return cidade2;
	}

	@Override
	@Transactional
	public void removerCidade(long id) {
		Cidade cidade = buscarCidade(id);
		if(cidade == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cidade);
	}

}
