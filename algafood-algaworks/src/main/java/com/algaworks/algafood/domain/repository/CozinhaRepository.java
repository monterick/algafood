package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	public List<Cozinha> listarCozinhas();
	public Cozinha BuscarCozinha(long id);
	public Cozinha adicionarCozinha(Cozinha cozinha);
	public Cozinha atualizarCozinha(long id, Cozinha cozinha);
	public void removerCozinha(long id);
	
}
