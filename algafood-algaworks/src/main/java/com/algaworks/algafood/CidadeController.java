package com.algaworks.algafood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontadaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired 
	CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listarCidades(){
		return cidadeService.listarCidades();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscarCidade(@PathVariable(value = "id") long id){
		try {
		  Cidade cidade = cidadeService.buscarCidade(id);
		  return ResponseEntity.ok(cidade);
		}catch (EntidadeNaoEncontadaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping	
	public ResponseEntity<?> salvarCidade(@RequestBody Cidade cidade) {
	  try {
		Cidade cidade2 = cidadeService.salvarCidade(cidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(cidade2);
	  }catch (EntidadeNaoEncontadaException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	  }
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> editarCidade(@PathVariable(value = "id") long id, @RequestBody Cidade cidade) {
		try {
			Cidade cidade2 = cidadeService.alterarCidade(id, cidade);
			if(cidade2 != null) {
				return ResponseEntity.ok(cidade2);
			}
			
			return ResponseEntity.notFound().build();
			
		}catch (EntidadeNaoEncontadaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cidade> removerCidade(@PathVariable(value = "id") long id) {
	  try {	
		cidadeService.removerCidade(id);
		return ResponseEntity.noContent().build();
	  }catch (EntidadeNaoEncontadaException e) {
		return ResponseEntity.notFound().build(); 
	  }
	}
}
