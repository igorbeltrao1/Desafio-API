package com.pactomais.api.model.service;

import com.pactomais.api.model.dto.ContaDTO;
import com.pactomais.api.model.entities.Conta;

public interface ContaService {
	
	 Conta cadastrarConta(ContaDTO contaDTO);
}
