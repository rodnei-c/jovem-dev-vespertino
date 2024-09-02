package jv.triersistemas.primeiro_projeto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TarefaDto {
	private Long id;
	private String titulo;
	private String descricao;
	private boolean completa;
	private Long categoria;
	
	public TarefaDto(TarefaEntity entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.completa = entity.isCompleta();
		this.categoria = entity.getCategoria().getId();
	}
}
