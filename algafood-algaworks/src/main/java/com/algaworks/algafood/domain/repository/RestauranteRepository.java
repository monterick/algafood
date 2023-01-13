package com.algaworks.algafood.domain.repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

	public List<Restaurante> nome(String nome);
	
	public List<Restaurante> findBytaxaFreteBetween(BigDecimal init, BigDecimal fim);
	
	public Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	@Query("from Resturante where nome like '%:nome%' and cozinha.id = :id")
	public List<Restaurante> consultaPorNome(@Param(value = "nome") String nome, @Param(value = "id") Long id);


	
}
