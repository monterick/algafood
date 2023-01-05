package com.algaworks.algafood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return cozinhaRepository.BuscarCozinha(id);
	}
	public Cozinha salvarCozinha(Cozinha cozinha) {
		return cozinhaRepository.adicionarCozinha(cozinha);
	}
	public Cozinha atualizarCozinha(long id, Cozinha cozinha) {
		return cozinhaRepository.atualizarCozinha(id, cozinha);
	}
	public void removerCozinha(long id) {
		cozinhaRepository.removerCozinha(id);
	}

}
