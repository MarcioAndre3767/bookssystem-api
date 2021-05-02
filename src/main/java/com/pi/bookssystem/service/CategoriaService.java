package com.pi.bookssystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pi.bookssystem.domain.Categoria;
import com.pi.bookssystem.repositories.CategoriaRepository;
import com.pi.bookssystem.service.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	//Exception-ID
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);

		return obj.orElseThrow( () -> new ObjectNotFoundException("Não foi encontrado o ID que você solicitou: "  + 
		id + ", Tipo: " + Categoria.class.getName()));
	}
	
	//lista de categoria - service
	public List<Categoria> findAll(){
		
		return repository.findAll();
	}
	
	
	//create-categoria	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		
		return repository.save(obj);
	}

	
	//update-categoria
	public Categoria update(Integer id, Categoria objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		
		return repository.save(obj);
	}

	//delete-categoria
	
//	public void delete(Integer id) {
//		findById(id);
//		repository.deleteById(id);
//	}
	
	
 	public void delete(Integer id) {
		findById(id);		
		try {
			repository.deleteById(id);		
		} catch (DataIntegrityViolationException e) {
			throw new com.pi.bookssystem.service.exceptions.DataIntegrityViolationException("O número da categoria"
					+ " que deseja deletar há livros associados ao ID digitado.");
		}	
	}
	
	
	

}















