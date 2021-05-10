package com.pi.bookssystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.bookssystem.domain.Livro;
import com.pi.bookssystem.repositories.LivroRepository;
import com.pi.bookssystem.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaservice;
	
	
	
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaservice.findById(id_cat);
		
		return repository.findAllByCategoria(id_cat);
	}

}









