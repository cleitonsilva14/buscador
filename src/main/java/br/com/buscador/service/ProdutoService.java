package br.com.buscador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.buscador.model.ProdutoModel;
import br.com.buscador.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public List<ProdutoModel> buscaTodosProdutos(){
		return produtoRepository.findAll();
	}
	
	public ProdutoModel salvarProduto(ProdutoModel produto) {
		return produtoRepository.save(produto);
	}
	
	public List<ProdutoModel> salvarProdutos(List<ProdutoModel> produtos) {
		return produtoRepository.saveAll(produtos);
	}

	public Optional<ProdutoModel> buscaPorId(Long codigo) {
		return produtoRepository.findByCode(codigo);
	}
	
	
	
}
