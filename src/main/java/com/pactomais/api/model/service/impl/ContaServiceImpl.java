package com.pactomais.api.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactomais.api.model.dto.ContaDTO;
import com.pactomais.api.model.entities.Conta;
import com.pactomais.api.model.repository.ContaRepository;
import com.pactomais.api.model.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	ContaRepository repository;

	public Conta cadastrarConta(ContaDTO contaDTO) {
		Conta conta = new Conta();
		conta.setNumeroConta(contaDTO.getNumeroConta());
		conta.setSaldoConta(contaDTO.getSaldoConta());
		repository.save(conta);
		return conta;
	}

	
}
