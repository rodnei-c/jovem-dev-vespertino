package jv.triersistemas.primeiro_projeto.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "tarefa")
public class TarefaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	private String descricao;
	private boolean completa;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id", nullable = false)
	private CategoriaEntity categoria;
	
	public TarefaEntity(TarefaDto dto, CategoriaEntity categoria) {
		this.id = dto.getId();
		this.titulo = dto.getTitulo();
		this.descricao = dto.getDescricao();
		this.completa = dto.isCompleta();
		this.categoria = categoria;
		
	}
	
	public TarefaEntity atualizaTarefa(TarefaDto dto) {
    	this.titulo = dto.getTitulo();
    	this.descricao = dto.getDescricao();
    	this.completa = dto.isCompleta();
    	this.categoria = new CategoriaEntity(dto.getCategoria());
    	return this;
    }
}
