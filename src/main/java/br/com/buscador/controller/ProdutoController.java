package br.com.buscador.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

import br.com.buscador.model.ProdutoModel;


@Controller
public class ProdutoController {

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/produtos")
	    public String listarProdutos(Model model) {
	        model.addAttribute("produtos", List.of(
	            new ProdutoModel(1L, 2L, "Produto 1", 100.0, 2)
	        ));
	        return "produtos";
	    }
	
	
	
}
