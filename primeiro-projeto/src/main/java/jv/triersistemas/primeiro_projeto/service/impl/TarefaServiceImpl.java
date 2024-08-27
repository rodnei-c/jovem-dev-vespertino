package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.Tarefa;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService{
	
	private static List<TarefaDto> tarefas = new ArrayList<>();
	private AtomicLong contador =  new AtomicLong();
	
	@Override
	public List<TarefaDto> getTarefas() {
		return tarefas;
	}
	
	@Override
	public TarefaDto findById(Long id) {
		return tarefas.stream().filter(elemento -> elemento.getId().equals(id)).findFirst().orElse(null);
	}
	
	@Override
	public void deleteTarefas(Long id) {
		tarefas.removeIf(elemento -> elemento.getId().equals(id));
	}
	
	@Override
	public void criaTarefa(TarefaDto tarefa) {
		tarefa.setId(contador.incrementAndGet());
		tarefas.add(tarefa); 
	}
	
	@Override
	public void criaTarefas(TarefaDto criaTarefas) {
		criaTarefas.setId(contador.incrementAndGet());
		tarefas.add(criaTarefas);
	}
	
	@Override
	public TarefaDto updateTarefa(Long id, TarefaDto tarefaAtualizada) {
		

        return null;
	}

}
