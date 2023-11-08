package com.pactomais.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactomais.api.model.dto.ContaAtualizacaoDTO;
import com.pactomais.api.model.dto.ContaDTO;
import com.pactomais.api.model.dto.ContaListagemDTO;
import com.pactomais.api.model.entities.Conta;
import com.pactomais.api.model.repository.ContaRepository;
import com.pactomais.api.model.service.ContaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "http://localhost:4200")
public class ContaController {

	  	@Autowired
	    ContaRepository repository;
	  	
	    @Autowired
	    ContaService service; 

	    @PostMapping
	    @Transactional
	    public ResponseEntity cadastrarConta(@RequestBody ContaDTO contaDTO) {
	        Conta conta = service.cadastrarConta(contaDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
	    }

	    @GetMapping
	    public ResponseEntity<List<ContaListagemDTO>> listarContas() {
	        List<ContaListagemDTO> contasDTO = service.listarContas();
	        return ResponseEntity.ok(contasDTO);
	    }
	    
		@GetMapping("/{id}")
		public ResponseEntity<ContaListagemDTO> obterContaId(@PathVariable Long id) throws Exception {
			try {
				return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
			

		}

	    @DeleteMapping("/delete/{id}")	
	    @Transactional
	    public ResponseEntity deleteContaById(@PathVariable Long id) {
	    	service.deletarConta(id);
	    	return ResponseEntity.ok().build();
	    	
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id,
	    		@RequestBody ContaAtualizacaoDTO contadto) {
	    	
	     Conta conta = service.atualizarConta(id, contadto);
	        
	    return ResponseEntity.status(HttpStatus.CREATED).body(conta);
}
}