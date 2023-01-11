package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Estado> listarEstados() {
		return manager.createQuery("from Estado",Estado.class).getResultList();
	}

	@Override
	public Estado buscarEstado(long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public Estado salvarEstado(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	@Transactional
	public Estado alterarEstado(long id, Estado estado) {
		Estado estado2 = buscarEstado(id);
		if(estado2!=null) {
		 BeanUtils.copyProperties(estado, estado2, "id");
		 salvarEstado(estado2);
		}
		return estado2;
	}

	@Override
	@Transactional
	public void removerEstado(long id) {
		Estado estado = buscarEstado(id);
		if(estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(estado);		
	}

}
