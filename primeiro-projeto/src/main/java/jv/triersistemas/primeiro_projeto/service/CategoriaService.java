package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;

public interface CategoriaService{

public List<CategoriaDto> getCategorias();
	
	public Optional<CategoriaDto> findById(Integer id);
	
	public void deleteCategoria(Integer id);
	
	public CategoriaDto criaCategoria(CategoriaDto criaCategoria);
	
	public CategoriaDto updateCategoria(Integer id, CategoriaDto categoriaAtualizada);

	
}
