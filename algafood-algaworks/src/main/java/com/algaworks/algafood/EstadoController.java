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
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoService estadoService;
	
	@GetMapping
	public List<Estado> listarEstados(){
		return estadoService.listarEstados();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscarEstado(@PathVariable(value = "id") long id){
		Estado estado = estadoService.buscarEstado(id);
		if(estado != null) {
			return ResponseEntity.ok(estado);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionarEstado(@RequestBody Estado estado) {
		return estadoService.adicionarEstado(estado);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Estado> alterarEstado(@PathVariable(value = "id") long id, @RequestBody Estado estado) {
	  try {
		Estado estado2 = estadoService.alterarEstado(id, estado);
		return ResponseEntity.ok(estado2);
	  }catch (EntidadeNaoEncontadaException e) {
		return ResponseEntity.notFound().build();
	  }
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Estado> removerEstado(@PathVariable(value = "id") long id) {
		try {
			estadoService.removerEstado(id);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontadaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
