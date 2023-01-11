package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	CozinhaRepository cozinhaRepository;
	
	public List<Cozinha> listarCozinhas(){
		return cozinhaRepository.listarCozinhas();
	}
	
	public Cozinha buscarCozinha(long id) {
		return cozinhaRepository.buscarCozinha(id);
	}
	
	public Cozinha salvarCozinha(Cozinha cozinha) {
		return cozinhaRepository.salvarCozinha(cozinha);
	}
	public Cozinha alterarCozinha(long id, Cozinha cozinha) {
		Cozinha cozinhaAtual = buscarCozinha(id);
		if(cozinhaAtual!=null) {
		 BeanUtils.copyProperties(cozinha, cozinhaAtual,"id");
		 salvarCozinha(cozinhaAtual);
		}
		return cozinhaAtual;
	}
	public void removerCozinha(long id) {
	  try {	
	  	cozinhaRepository.removerCozinha(id);
	  }catch (EmptyResultDataAccessException e) {
		throw new EntidadeNaoEncontadaException(String.format("Não existe um cadastro de cozinha com o código %d", id));	  
	  }catch (DataIntegrityViolationException e) {
		throw new EntidadeEmUsoException(String.format("Cozinha de código %d está em uso ",id));
	  }
	}
	
}
