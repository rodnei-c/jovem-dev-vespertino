package atividade_02.dados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atividade_02.dados.dto.ApostaDto;
import atividade_02.dados.service.ApostaService;

@RestController
@RequestMapping("/apostas")
public class ApostaController {

	@Autowired
	private ApostaService apostaService;
	
	@PostMapping("/{qtdDados}/{valorAposta}")
	public void fazerAposta(@PathVariable int qtdDados,@PathVariable double valorAposta) {
		try {
		apostaService.letsGoGambling(qtdDados, valorAposta);
		} catch(IllegalArgumentException e) {
			System.err.println("Awww dang it");
		}
	}
	
	@GetMapping
	List<ApostaDto> iCantStopWinning(){
		return apostaService.iCantStopWinning();
	}
	
	
	
}
