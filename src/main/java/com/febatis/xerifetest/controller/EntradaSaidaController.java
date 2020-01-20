package com.febatis.xerifetest.controller;

import java.net.URI;
import java.util.List;

import com.febatis.xerifetest.entity.EntradaSaida;
import com.febatis.xerifetest.service.EntradaSaidaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping(path = "entradaSaida", 
produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class EntradaSaidaController {

	@Autowired
	private EntradaSaidaService entradaSaidaService;

	@GetMapping()
	public ResponseEntity<List<EntradaSaida>> findAll() {
		return ResponseEntity.ok(entradaSaidaService.findAll());
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<EntradaSaida> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(entradaSaidaService.findById(id).get());
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> create(@RequestBody EntradaSaida entradaSaida) {
		EntradaSaida savedEntradaSaida = entradaSaidaService.save(entradaSaida);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEntradaSaida.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping(path = "{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody EntradaSaida entradaSaida) {
		entradaSaida.setId(id);
		EntradaSaida updatedEntradaSaida = entradaSaidaService.update(entradaSaida);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(updatedEntradaSaida.getId()).toUri();

		return ResponseEntity.ok(location);

	}

	@DeleteMapping(path = "{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {

		entradaSaidaService.deleteById(id);

		return ResponseEntity.ok().build();

	}

}