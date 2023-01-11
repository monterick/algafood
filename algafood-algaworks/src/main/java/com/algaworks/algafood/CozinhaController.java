package com.algaworks.algafood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.services.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	CozinhaService cozinhaService;
	
	@GetMapping
	public List<Cozinha> listarCozinhas(){
		return cozinhaService.listarCozinhas();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscarCozinha(@PathVariable(value = "id") long id) {
		Cozinha cozinha = cozinhaService.buscarCozinha(id);
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvarCozinha(@RequestBody Cozinha cozinha){		
		return cozinhaService.salvarCozinha(cozinha);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> alterarCozinha(@PathVariable(value = "id") long id, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaService.alterarCozinha(id, cozinha);
		if(cozinhaAtual != null) {
			return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> removerCozinha(@PathVariable(value = "id") long id) {
		try {
			cozinhaService.removerCozinha(id);
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}catch (EntidadeNaoEncontadaException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
