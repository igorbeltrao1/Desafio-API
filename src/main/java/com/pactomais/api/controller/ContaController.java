package com.pactomais.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactomais.api.model.dto.ContaDTO;
import com.pactomais.api.model.entities.Conta;
import com.pactomais.api.model.repository.ContaRepository;
import com.pactomais.api.model.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

	  	@Autowired
	    ContaRepository repository;
	  	
	    @Autowired
	    ContaService service; 

	    @PostMapping
	    public ResponseEntity cadastrarConta(@RequestBody ContaDTO contaDTO) {
	        Conta conta = service.cadastrarConta(contaDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
	    }

	    @GetMapping
	    public ResponseEntity<List<Conta>> listarConta() {
	        List<Conta> lista = repository.findAll();
	        return ResponseEntity.ok(lista);
	    }
}
