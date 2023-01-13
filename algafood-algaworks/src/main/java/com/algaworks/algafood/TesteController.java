package com.algaworks.algafood;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	CozinhaRepository cozinhaRepository;
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> listarPorNome(@RequestParam("nome") String nome){
		return cozinhaRepository.nome(nome);
	}
	@GetMapping("/cozinhas/like-por-nome")
	public List<Cozinha> likePorNome(@RequestParam("nome") String nome){
		return cozinhaRepository.nomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/like-por-nome2")
	public Optional<Restaurante> likePorNome2(@RequestParam("nome") String nome){
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/taxafrete")
	public List<Restaurante> byTaxaFrete(@RequestParam(value = "ini") BigDecimal ini, @RequestParam(value = "fim") BigDecimal fim){
		return restauranteRepository.findBytaxaFreteBetween(ini, fim);
	}
	
	
}
