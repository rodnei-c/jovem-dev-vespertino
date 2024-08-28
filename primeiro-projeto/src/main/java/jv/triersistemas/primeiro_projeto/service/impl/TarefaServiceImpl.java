package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.Tarefa;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository repository;

	private static List<TarefaDto> tarefas = new ArrayList<>();
	private AtomicLong contador = new AtomicLong();

	@Override
	public List<TarefaDto> getTarefas() {
		return tarefas;
	}

	@Override
	public Optional<TarefaDto> findById(Long id) {
		return tarefas.stream().filter(elemento -> elemento.getId().equals(id)).findFirst();
	}

	@Override
	public void deleteTarefas(Long id) {
		tarefas.removeIf(elemento -> elemento.getId().equals(id));
	}

	@Override
	public TarefaDto criaTarefas(TarefaDto criaTarefas) {
		var entidadePersistida = repository.save(new TarefaEntity(criaTarefas));
		TarefaDto tarefa = new TarefaDto(entidadePersistida);
		tarefas.add(tarefa);
		return tarefa;
	}

	@Override
	public TarefaDto updateTarefa(Long id, TarefaDto tarefaAtualizada) {
		Optional<TarefaDto> tarefa = findById(id);
		if (tarefa.isPresent()) {
			tarefa.get().setTitulo(tarefaAtualizada.getTitulo());
			tarefa.get().setDescricao(tarefaAtualizada.getDescricao());
			tarefa.get().setCompleta(tarefaAtualizada.isCompleta());
			return tarefa.get();
		}
		return null;
	}

}
