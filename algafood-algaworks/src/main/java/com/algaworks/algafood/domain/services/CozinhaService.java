package com.algaworks.algafood.domain.services;

import java.util.List;
import java.util.Optional;

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
		return cozinhaRepository.findAll();
	}
	
	public Optional<Cozinha> buscarCozinha(long id) {
		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);
		return cozinha;
	}
	
	public Cozinha salvarCozinha(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	public Cozinha alterarCozinha(long id, Cozinha cozinha) {
		Optional<Cozinha> cozinhaAtual = buscarCozinha(id);
		if(cozinhaAtual!=null) {
		 BeanUtils.copyProperties(cozinha, cozinhaAtual.get(),"id");
		 salvarCozinha(cozinhaAtual.get());
		}
		return cozinhaAtual.get();
	}
	public void removerCozinha(long id) {
	  try {	
		Cozinha cozinha = buscarCozinha(id).get();  
	  	cozinhaRepository.delete(cozinha);
	  }catch (EmptyResultDataAccessException e) {
		throw new EntidadeNaoEncontadaException(String.format("Não existe um cadastro de cozinha com o código %d", id));	  
	  }catch (DataIntegrityViolationException e) {
		throw new EntidadeEmUsoException(String.format("Cozinha de código %d está em uso ",id));
	  }
	}
	
}
