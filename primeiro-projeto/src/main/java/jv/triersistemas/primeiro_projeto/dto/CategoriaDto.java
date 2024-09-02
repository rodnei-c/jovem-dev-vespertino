package jv.triersistemas.primeiro_projeto.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.enuns.PrioridadeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDto {

	private Long id;
	private String nome;
	private String descricao;
	private PrioridadeEnum prioridade;
//	private List<TarefaEntity> tarefas;
	
	public CategoriaDto(CategoriaEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.prioridade = entity.getPrioridade();
//		this.tarefas = entity.getTarefas();
		
	}
	
}
