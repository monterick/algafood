package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	public List<Estado> listarEstados();
	public Estado buscarEstado(long id);
	public Estado salvarEstado(Estado estado);
	public Estado alterarEstado(long id, Estado estado);
	public void removerEstado(long id);
	
}
