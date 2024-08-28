package jv.triersistemas.primeiro_projeto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jv.triersistemas.primeiro_projeto.Tarefa;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaDto {
	private Long id;
	private String titulo;
	private String descricao;
	private boolean completa;
	
	public TarefaDto(TarefaEntity entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.completa = entity.isCompleta();
	}
}
