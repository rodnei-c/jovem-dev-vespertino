package atividade_02.dados.service;

import java.util.List;

import atividade_02.dados.dto.ApostaDto;

public interface ApostaService {

	void letsGoGambling(int qtdDados, double valorAposta);
	
	List<ApostaDto> iCantStopWinning();
		
	int somarDados();
	
	
}
