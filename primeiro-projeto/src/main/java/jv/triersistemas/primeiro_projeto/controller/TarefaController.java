package jv.triersistemas.primeiro_projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.Tarefa;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;
import jv.triersistemas.primeiro_projeto.service.impl.TarefaServiceImpl;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	public List<TarefaDto> listarTarefas(){
		return tarefaService.getTarefas();
	}
	
	
	@PostMapping("/criaTarefas")
	public void criaTarefas(@RequestBody TarefaDto criaTarefas) {
		tarefaService.criaTarefas(criaTarefas);

	}
	
	@GetMapping("/{id}")
	public TarefaDto buscarPorId(@PathVariable("id") Long id){
		return tarefaService.findById(id);
		
	}
	
//	@PutMapping("/{id}")
//	public TarefaDto atualizar(@PathVariable("id") Long id, TarefaDto tarefaAtualizada) {
//		return tarefaService.updateTarefa(id, tarefaAtualizada);
//		
//	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		tarefaService.deleteTarefas(id);
	}
	
}
