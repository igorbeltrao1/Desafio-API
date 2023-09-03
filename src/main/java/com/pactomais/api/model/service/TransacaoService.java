package com.pactomais.api.model.service;

import com.pactomais.api.model.dto.TransacaoDTO;
import com.pactomais.api.model.entities.Conta;
import com.pactomais.api.model.entities.Transacao;


public interface TransacaoService {

	Transacao cadastrarTransacao(TransacaoDTO transacaoDto);

	Conta sacarConta(Long id, Double valor);

	Conta depositarConta(Long id, Double valor);
}
