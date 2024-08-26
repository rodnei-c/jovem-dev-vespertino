package jv.triersistemas.primeiro_projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	private static List<Tarefa> tarefas = new ArrayList<>();
	private AtomicLong contador =  new AtomicLong();
	
	@GetMapping
	public List<Tarefa> listarTarefas(){
		return tarefas;
	}
	
	@PostMapping
	public void criaTarefa(@RequestBody Tarefa tarefa) {
		tarefa.setId(contador.incrementAndGet());
		tarefas.add(tarefa); 
	}
	
	@GetMapping("/{id}")
	public List<Tarefa> buscarPorId(@PathVariable("id") Long id){
		return (List<Tarefa>) tarefas.stream().filter(elemento -> elemento.getId().equals(id)).findFirst().orElse(null);
		
	}
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable("id") Long id) {
		
	}
	
	@DeleteMapping
	public void deletar(@RequestBody Tarefa tarefa) {
		tarefas.remove(tarefa);
	}
	
}
