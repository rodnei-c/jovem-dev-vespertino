package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository repository;
	
	@Override
	public List<CategoriaDto> getCategorias() {
		List<CategoriaEntity> listaEntidade = repository.findAll();
		return listaEntidade.stream().map(CategoriaDto::new).toList();
	}

	@Override
	public Optional<CategoriaDto> findById(Long id) {
		Optional<CategoriaEntity> buscaId = repository.findById(id);
		return buscaId.map(CategoriaDto::new);
	}

	@Override
	public void deleteCategoria(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public CategoriaDto criaCategoria(CategoriaDto criaCategoria) {
		var entidadePersistida = repository.save(new CategoriaEntity(criaCategoria));
		CategoriaDto categoria = new CategoriaDto(entidadePersistida);
		return categoria;
	}

	@Override
	public CategoriaDto updateCategoria(Long id, CategoriaDto categoriaAtualizada) {
		Optional<CategoriaEntity> categoriaEntity = repository.findById(id);
        if (categoriaEntity.isPresent()) {
        	categoriaEntity.get().atualizaCategoria(categoriaAtualizada);
        	var entidadePersistida = repository.save(categoriaEntity.get());
        	return new CategoriaDto(entidadePersistida);
        }
        return null;
	}
	
	@Override
	public CategoriaEntity buscaId(Long id) {
		return repository.getById(id);
	}

	
	
}
