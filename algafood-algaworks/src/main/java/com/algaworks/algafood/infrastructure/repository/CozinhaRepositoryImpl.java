package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.services.CozinhaService;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

	@Autowired
	CozinhaService cozinhaService;
	
	@Override
	public List<Cozinha> listarCozinhas() {		
		return cozinhaService.listarCozinhas();
	}

	@Override
	public Cozinha BuscarCozinha(long id) {		
		return cozinhaService.BuscarCozinha(id);
	}

}