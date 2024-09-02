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

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDto> listarCategorias(){
		return categoriaService.getCategorias();
	}
	
	@PostMapping("/criaCategoria")
	public CategoriaDto criaCategoria(@RequestBody CategoriaDto criaCategoria) {
		return categoriaService.criaCategoria(criaCategoria);

	}
	
	@GetMapping("/{id}")
	public Optional<CategoriaDto> buscarPorId(@PathVariable("id") Long id){
		Optional<CategoriaDto> categoria = categoriaService.findById(id);
		return categoria;	
	}
	
	@PutMapping("/{id}")
	public CategoriaDto atualizar(@PathVariable("id") Long id,@RequestBody CategoriaDto categoriaAtualizada) {
		return categoriaService.updateCategoria(id, categoriaAtualizada);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		categoriaService.deleteCategoria(id);
	}
	
}
