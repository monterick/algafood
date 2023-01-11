package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	public List<Restaurante> listarRestaurantes();
	public Restaurante buscarRestaurante(long id);
	public Restaurante adicionarRestaurante(Restaurante restaurante);
	public Restaurante alterarRestaurante(long id, Restaurante restaurante);
	public void removerRestaurante(long id);
	
}