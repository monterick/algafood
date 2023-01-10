package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
		Cozinha cozinha = buscarCozinha(id);
		if(cozinha!=null) {
		 cozinhaRepository.removerCozinha(id);
		}
	}
	
}
