package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	@Override
	public List<TarefaDto> getTarefas() {
		List<TarefaEntity> listaEntidade = repository.findAll();
		return listaEntidade.stream().map(TarefaDto::new).toList();
	}

	@Override
	public Optional<TarefaDto> findById(Long id) {
		Optional<TarefaEntity> buscaId = repository.findById(id);
		return buscaId.map(TarefaDto::new);
	}

	@Override
	public void deleteTarefas(Long id) {
		repository.deleteById(id);
	}

	@Override
	public TarefaDto criaTarefas(TarefaDto criaTarefas) {
		
		var entidadePersistida = repository.save(new TarefaEntity(criaTarefas, null));
		return new TarefaDto(entidadePersistida);
	}

	@Override
	public TarefaDto updateTarefa(Long id, TarefaDto tarefaAtualizada) {
		Optional<TarefaEntity> tarefaEntity = repository.findById(id);
        if (tarefaEntity.isPresent()) {
        	tarefaEntity.get().atualizaTarefa(tarefaAtualizada);
        	var entidadePersistida = repository.save(tarefaEntity.get());
        	return new TarefaDto(entidadePersistida);
        }
        return null;
	}

}
