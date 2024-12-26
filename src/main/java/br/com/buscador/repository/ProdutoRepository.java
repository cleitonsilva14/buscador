package br.com.buscador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.buscador.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM tb_produto WHERE codigo = ?1")
	Optional<ProdutoModel> findByCode(Long code);
	
}
