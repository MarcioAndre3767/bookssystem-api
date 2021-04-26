package com.pi.bookssystem.service;

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

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);

		return obj.orElseThrow( () -> new ObjectNotFoundException("Não foi encontrado o ID que você solicitou: "  + 
		id + ", Tipo: " + Categoria.class.getName()));
	}

}
