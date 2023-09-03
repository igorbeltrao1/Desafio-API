package com.pactomais.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pactomais.api.exception.SaldoInsuficienteException;
import com.pactomais.api.model.dto.TransacaoDTO;
import com.pactomais.api.model.entities.Conta;
import com.pactomais.api.model.entities.Transacao;
import com.pactomais.api.model.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	TransacaoService service;

	@PostMapping
	public ResponseEntity<?> cadastrarTransacao(@RequestBody TransacaoDTO TransacaoDTO) {
		Transacao transacao = service.cadastrarTransacao(TransacaoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
	}

	@PostMapping("{id}/saque")
	public ResponseEntity<?> saqueConta(@PathVariable Long id, @RequestParam Double valor) {
		try {
			Conta contaRetorno = service.sacarConta(id, valor);
			return ResponseEntity.status(HttpStatus.CREATED).body(contaRetorno);
		} catch (SaldoInsuficienteException var4) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insulfiente!");
		}
	}

	@PostMapping("{id}/deposito")
	public ResponseEntity<?> depositoConta(@PathVariable Long id, @RequestParam Double valor) {
		try {
			Conta contaRetorno = service.depositarConta(id, valor);
			return ResponseEntity.status(HttpStatus.CREATED).body(contaRetorno);
		} catch (SaldoInsuficienteException var4) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insulfiente!");
		}
	}
}
