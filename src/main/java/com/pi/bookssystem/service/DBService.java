package com.pi.bookssystem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.bookssystem.domain.Categoria;
import com.pi.bookssystem.domain.Livro;
import com.pi.bookssystem.repositories.CategoriaRepository;
import com.pi.bookssystem.repositories.LivroRepository;

@Service
public class DBService {	
	//para salvar no banco de dados, é preciso do repository injetado 
	//camada de acesso aos dados
	@Autowired
	private CategoriaRepository categoriaRespository;
	
	//camada de acesso aos dados
	@Autowired
	private LivroRepository livroRespository;
	
	
	public void instaciaBaseDeDados() {		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "O mistério do além");
		Categoria cat3 = new Categoria(null, "Biografica", "Livros de Biografias");
		
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machime", "H.G. Wells", "lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The Was of the Worlds", "H.G. Wells", "lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "lorem ipsum", cat2);		
			
		//o livro conhece a sua categoria, mas a categoria não conhece o livro
		//adicionando o livro na categoria
		cat1.getLivros().addAll( Arrays.asList(l1, l2) );
		cat2.getLivros().addAll( Arrays.asList(l3, l4, l5) );
		
		
		//salvando
		categoriaRespository.saveAll( Arrays.asList(cat1, cat2, cat3) );
		livroRespository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
		
	}

}
