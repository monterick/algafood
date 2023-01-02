package com.algaworks.algafood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.infrastructure.repository.CozinhaRepositoryImpl;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listarCozinhas(){
		return cozinhaRepository.listarCozinhas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscarCozinha(@PathVariable(value = "id") long id){
		Cozinha cozinha = cozinhaRepository.BuscarCozinha(id);
		if(cozinha!=null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionarCozinha(@RequestBody Cozinha cozinha) {
		return cozinhaRepository.adicionarCozinha(cozinha);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> alterarCozinha(@PathVariable(value = "id") long id,@RequestBody Cozinha cozinha) {
		Cozinha cozinhaAlterada = cozinhaRepository.atualizarCozinha(id, cozinha);
		if(cozinhaAlterada!=null) {
			return ResponseEntity.ok(cozinhaAlterada);
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable(value = "id") long id) {
		cozinhaRepository.removerCozinha(id);
	}
	
	
}
