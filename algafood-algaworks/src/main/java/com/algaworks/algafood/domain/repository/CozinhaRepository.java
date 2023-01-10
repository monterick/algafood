package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	public List<Cozinha> listarCozinhas();
	public Cozinha buscarCozinha(long id);
	public Cozinha salvarCozinha(Cozinha cozinha);
	public void removerCozinha(long id);
	
}
