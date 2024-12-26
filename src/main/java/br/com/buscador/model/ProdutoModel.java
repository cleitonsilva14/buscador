package br.com.buscador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Table(name = "tb_produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private Long codigo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Double preco = 0.0;
	
	@Column(nullable = false)
	private Integer quantidade = 1;
	
}
