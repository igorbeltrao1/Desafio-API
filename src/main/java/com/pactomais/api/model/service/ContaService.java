package com.pactomais.api.model.service;

import java.util.List;

import com.pactomais.api.model.dto.ContaAtualizacaoDTO;
import com.pactomais.api.model.dto.ContaDTO;
import com.pactomais.api.model.dto.ContaListagemDTO;
import com.pactomais.api.model.entities.Conta;

public interface ContaService {
	
	 Conta cadastrarConta(ContaDTO contaDTO);
	List<ContaListagemDTO> listarContas();
	Conta atualizarConta(Long id, ContaAtualizacaoDTO contaAtualizacaoDTO) ;
	void  deletarConta(Long id);
	ContaListagemDTO buscarPorId(Long id) throws Exception;
	
}

