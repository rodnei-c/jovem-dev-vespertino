package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
		
	@GetMapping
	public List<TarefaDto> listarTarefas(){
		return tarefaService.getTarefas();
	}
	
	
	@PostMapping("/criaTarefas/{id}")
	public TarefaDto criaTarefas(@RequestBody TarefaDto criaTarefas) {
		return tarefaService.criaTarefas(criaTarefas);

	}
	
	@GetMapping("/{id}")
	public Optional<TarefaDto> buscarPorId(@PathVariable("id") Long id){
		Optional<TarefaDto> tarefa = tarefaService.findById(id);
		return tarefa;	
	}
	
	@PutMapping("/{id}")
	public TarefaDto atualizar(@PathVariable("id") Long id,@RequestBody TarefaDto tarefaAtualizada) {
		return tarefaService.updateTarefa(id, tarefaAtualizada);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		tarefaService.deleteTarefas(id);
	}
	
}
