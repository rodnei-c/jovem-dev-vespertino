package jv.triersistemas.primeiro_projeto.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	private static Produto produto = new Produto();
	
	@GetMapping
	public Produto getText() {
		return produto;
	}
	
	@PostMapping
	public void salvaProduto(@RequestBody Produto produtoRequest) {
		produto = produtoRequest;
	}
	
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Produto{
	private String nome;
	private BigDecimal preco;
}