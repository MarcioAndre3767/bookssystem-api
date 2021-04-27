package com.pi.bookssystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	//crete-categoria
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		
		return repository.save(obj);
	}
	

}















