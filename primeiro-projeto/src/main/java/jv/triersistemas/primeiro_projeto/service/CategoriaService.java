package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;

public interface CategoriaService{

public List<CategoriaDto> getCategorias();
	
	public Optional<CategoriaDto> findById(Long id);
	
	public void deleteCategoria(Long id);
	
	public CategoriaDto criaCategoria(CategoriaDto criaCategoria);
	
	public CategoriaDto updateCategoria(Long id, CategoriaDto categoriaAtualizada);

	CategoriaEntity buscaId(Long id);

	
}
