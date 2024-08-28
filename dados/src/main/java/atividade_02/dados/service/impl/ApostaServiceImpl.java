package atividade_02.dados.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import atividade_02.dados.dto.ApostaDto;
import atividade_02.dados.service.ApostaService;

@Service
public class ApostaServiceImpl implements ApostaService{
	
	private List<ApostaDto> apostasFeitas = new ArrayList<>();
	private List<Integer> dadosJogados = new ArrayList<>();
	
	private double percentual;

	@Override
	public void letsGoGambling(int qtdDados, double valorAposta) {

		if(validarDados(qtdDados) == true) {
			for(int i = 0; i < qtdDados; i++) {
				int valorDados = new Random().nextInt(1, 6);
				dadosJogados.add(valorDados);
			}
			apostasFeitas.add(new ApostaDto(valorAposta, qtdDados));
			percentual(valorAposta);
		} else {
			erro();
		}	
	}
	
	public void erro() {
		throw new IllegalArgumentException();
	}
	
	@Override
	public int somarDados() {
		int total = 0;
		for (Integer result : dadosJogados) {		
			total += result;
		}
		return total;
	}
	
	public double percentual(double valorAposta) {
		double sub = valorAposta / somarDados() * 100;
		percentual = 100 - sub;
		
		return percentual;
	}

	public boolean validarDados(int qtdDados) {		
		if(qtdDados < 4) {
			if(qtdDados > 0) {
				return true;
			}
			return false;
		}	
		return false;		
	}
	
//	@Override
//	public void criaAposta(ApostaDto aposta) {
//		apostasFeitas.add(aposta);
//	}

	@Override
	public List<ApostaDto> iCantStopWinning() {
		return apostasFeitas;
	}

//	@Override
//	public void criaAposta(ApostaDto aposta) {
//		// TODO Auto-generated method stub
//		
//	}

	

}
