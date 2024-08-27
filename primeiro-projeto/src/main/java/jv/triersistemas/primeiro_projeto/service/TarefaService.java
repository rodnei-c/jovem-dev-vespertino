package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jv.triersistemas.primeiro_projeto.Tarefa;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;

public interface TarefaService {

	public List<TarefaDto> getTarefas();
	
	public TarefaDto findById(Long id);
	
	public void deleteTarefas(Long id);
	
	public void criaTarefa(TarefaDto tarefa);
	
	public void criaTarefas(TarefaDto criaTarefas);
	
	public TarefaDto updateTarefa(Long id, TarefaDto tarefaAtualizada);

	
}
