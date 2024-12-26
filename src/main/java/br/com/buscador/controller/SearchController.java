package br.com.buscador.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.buscador.model.ProdutoModel;
import br.com.buscador.service.ProdutoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class SearchController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/search/{codigo}")
	public ResponseEntity<Object> searchByCodigo(@PathVariable(name = "codigo") Long codigo) {
		
		Optional<ProdutoModel> productObj = produtoService.buscaPorId(codigo);
		if(productObj.isPresent()) {
			return ResponseEntity.status(OK).body(productObj.get());
		}
		return ResponseEntity.status(OK).body(new ProdutoModel(codigo, 0L, "produto: " + codigo  + ", não encontrado", 0.0, 1));
	}
	
	@PostMapping("/save")
	public void save(@RequestBody List<ProdutoModel> produtos) {
		System.out.println(produtos);
	}
	
	@PostMapping("/produtos/salvar")
    public void salvarProdutos(@ModelAttribute List<ProdutoModel> produtos) {
        // Exibe os produtos recebidos
        System.out.println(produtos.toString());
    }
	
	
	
	
}
