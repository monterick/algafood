package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {

	public List<Cidade> listarCidades();
	public Cidade buscarCidade(long id);
	public Cidade salvarCidade(Cidade cidade);
	public Cidade alterarCidade(long id, Cidade cidade);
	public void removerCidade(long id);
	
}
