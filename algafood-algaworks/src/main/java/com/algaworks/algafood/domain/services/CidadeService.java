package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Cidade> listarCidades(){
		return cidadeRepository.listarCidades();
	}
	public Cidade buscarCidade(long id) {
		Cidade cidade = cidadeRepository.buscarCidade(id);
		if(cidade == null) {
			throw new EntidadeNaoEncontadaException(String.format("Cidade de código %d não está cadastrada", id));
		}
		return cidade;
	}
	public Cidade salvarCidade(Cidade cidade) {
		long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscarEstado(estadoId);
		if(estado == null) {
			throw new EntidadeNaoEncontadaException(String.format("Estado com código %d não está cadastrado", estadoId));
		}
		return cidadeRepository.salvarCidade(cidade);
	}
	public Cidade alterarCidade(long id, Cidade cidade) {
	  
		long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscarEstado(estadoId);
		if(estado == null) {
			throw new EntidadeNaoEncontadaException(String.format("Não foi encontrado Estado com código %d",estadoId));
		}
		Cidade cidade2 = cidadeRepository.alterarCidade(id, cidade);
	
		
		return cidade2;
	}
	public void removerCidade(long id) {
	try {	
		cidadeRepository.removerCidade(id);
	}catch (EmptyResultDataAccessException e) {
		throw new EntidadeNaoEncontadaException(String.format("Não existe Cidade com código %d", id));
	}	
	}
	
}
