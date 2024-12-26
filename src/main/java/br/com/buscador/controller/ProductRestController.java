package br.com.buscador.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.buscador.model.ProdutoModel;
import br.com.buscador.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ProductRestController {

	@Autowired
	private ProdutoService produtoService;
	
	@Operation(summary = "Buscar todos os produtos", description = "Obter todas os produtos nesse endpoint.")
	@ApiResponses({
			@ApiResponse(responseCode = "200")
	})
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscaTodosProdutos());
	}
	
//	@Operation(summary = "Salva um novo produto", description = "Salvar um novo produto")
//	@ApiResponses({
//			@ApiResponse(responseCode = "200")
//	})
//	@PostMapping
//	public ProdutoModel save(@RequestBody ProdutoModel produto) {
//		return produtoService.salvarProduto(produto);
//	}
	
	@Operation(summary = "Salva uma lista de produtos", description = "Salvar vários produtos")
	@ApiResponses({
			@ApiResponse(responseCode = "200")
	})
	@PostMapping
	public List<ProdutoModel> saveAll(@RequestBody List<ProdutoModel> produtos) {
		return produtoService.salvarProdutos(produtos);
	}
	
	
	
	
	
}
