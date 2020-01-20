package com.febatis.xerifetest.controller;

import java.net.URI;
import java.util.List;

import com.febatis.xerifetest.entity.Estabelecimento;
import com.febatis.xerifetest.service.EstabelecimentoService;

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
@RequestMapping(path = "estabelecimento", 
produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@GetMapping()
	public ResponseEntity<List<Estabelecimento>> findAll() {
		return ResponseEntity.ok(estabelecimentoService.findAll());
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Estabelecimento> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(estabelecimentoService.findById(id).get());
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> create(@RequestBody Estabelecimento estabelecimento) {
		Estabelecimento savedEstabelecimento = estabelecimentoService.save(estabelecimento);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEstabelecimento.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping(path = "{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Estabelecimento estabelecimento) {
		estabelecimento.setId(id);
		Estabelecimento updatedEstabelecimento = estabelecimentoService.update(estabelecimento);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(updatedEstabelecimento.getId()).toUri();

		return ResponseEntity.ok(location);

	}

	@DeleteMapping(path = "{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {

		estabelecimentoService.deleteById(id);

		return ResponseEntity.ok().build();

	}

}