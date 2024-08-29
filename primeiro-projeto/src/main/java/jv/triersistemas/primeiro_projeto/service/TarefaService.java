package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;

public interface TarefaService {

	public List<TarefaDto> getTarefas();
	
	public Optional<TarefaDto> findById(Long id);
	
	public void deleteTarefas(Long id);
	
	public TarefaDto criaTarefas(TarefaDto criaTarefas, CategoriaDto categoria);
	
	public TarefaDto updateTarefa(Long id, TarefaDto tarefaAtualizada);

	
}
