package com.febatis.xerifetest.controller;

import java.net.URI;
import java.util.List;

import com.febatis.xerifetest.entity.Greeting;
import com.febatis.xerifetest.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@GetMapping()
	public List<Greeting> greeting() {
		return greetingService.findAll();
	}

	@PostMapping()
	public ResponseEntity<Object> createStudent(@RequestBody Greeting greeting) {
		Greeting savedStudent = greetingService.save(greeting);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}