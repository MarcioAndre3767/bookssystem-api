package com.pi.bookssystem.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pi.bookssystem.domain.Categoria;
import com.pi.bookssystem.dtos.CategoriaDTO;
import com.pi.bookssystem.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	
	//localhost:8080/categorias/1
	@Autowired
	private CategoriaService service;
	
	@GetMapping( value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	//Endpoint Categoria DTO
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		
		List<CategoriaDTO> listDTO = list.stream().map(ojb -> new CategoriaDTO(ojb)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	//Create
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}	
	
	//create
	//return ResponseEntity.created(uri).body(obj);


	/* Update Categoria*/
	
	@PutMapping( value = "/{id}" )
	public ResponseEntity<CategoriaDTO> update( @PathVariable Integer id, @RequestBody Categoria objDto ){
		Categoria newObj = service.update(id, objDto);
		
		return ResponseEntity.ok().body( new CategoriaDTO( newObj ) );
		
	}
	
	
	
	/* Delete Categoria */
	
	@DeleteMapping(value = "/{id}" )
	public ResponseEntity<Void> delete( @PathVariable Integer id ){
		service.delete(id) ;
		
		return ResponseEntity.noContent().build();	
	}
	
	
	
	
	
	
	
}


































	




























