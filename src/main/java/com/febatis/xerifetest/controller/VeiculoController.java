package com.febatis.xerifetest.controller;

import java.net.URI;
import java.util.List;

import com.febatis.xerifetest.entity.Veiculo;
import com.febatis.xerifetest.service.VeiculoService;

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

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping()
	public ResponseEntity<List<Veiculo>> findAll() {
		return ResponseEntity.ok(veiculoService.findAll());
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(veiculoService.findById(id).get());
	}

	@PostMapping()
	public ResponseEntity<Object> create(@RequestBody Veiculo veiculo) {
		Veiculo savedVeiculo = veiculoService.save(veiculo);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVeiculo.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping(path = "{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		veiculo.setId(id);
		Veiculo updatedVeiculo = veiculoService.update(veiculo);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(updatedVeiculo.getId()).toUri();

		return ResponseEntity.ok(location);

	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		
		veiculoService.deleteById(id);

		return ResponseEntity.ok().build();

	}

}