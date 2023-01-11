package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Estado> listarEstados(){
		return estadoRepository.listarEstados();
	}
	
	public Estado buscarEstado(long id){
		return estadoRepository.buscarEstado(id);
	}
	
	public Estado adicionarEstado(Estado estado) {
		return estadoRepository.salvarEstado(estado);
	}
	public Estado alterarEstado(long id, Estado estado) {
      Estado estado2 = estadoRepository.alterarEstado(id, estado);
      if(estado2 == null) {
    	  throw new EntidadeNaoEncontadaException(String.format("Não existe um estado cadastrado com o código %d", id));
      }
      return estado2;
	}
	public void removerEstado(long id){
	   try {	
		estadoRepository.removerEstado(id);
	   }catch (EmptyResultDataAccessException e) {
		throw new EntidadeNaoEncontadaException(String.format("Estado com código %d não está cadastrado", id));
	   }
	}
	
}
