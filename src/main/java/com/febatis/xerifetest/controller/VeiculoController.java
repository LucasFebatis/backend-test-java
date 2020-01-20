package com.febatis.xerifetest.controller;

import java.net.URI;
import java.util.List;

import com.febatis.xerifetest.entity.Veiculo;
import com.febatis.xerifetest.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping()
	public List<Veiculo> veiculo() {
		return veiculoService.findAll();
	}

	@PostMapping()
	public ResponseEntity<Object> createVeiculo(@RequestBody Veiculo veiculo) {
		Veiculo savedVeiculo = veiculoService.save(veiculo);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVeiculo.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}