package com.algaworks.algafood.domain.exception;

public class EntidadeNaoEncontadaException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontadaException(String mensagem) {
		super(mensagem);
	}
  
}
