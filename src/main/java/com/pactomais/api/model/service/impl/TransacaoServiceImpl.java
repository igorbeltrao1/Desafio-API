package com.pactomais.api.model.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactomais.api.exception.SaldoInsuficienteException;
import com.pactomais.api.model.dto.ContaListagemDTO;
import com.pactomais.api.model.dto.TransacaoDTO;
import com.pactomais.api.model.entities.Conta;
import com.pactomais.api.model.entities.Transacao;
import com.pactomais.api.model.enun.TipoOperacao;
import com.pactomais.api.model.repository.ContaRepository;
import com.pactomais.api.model.repository.TransacaoRepository;
import com.pactomais.api.model.service.TransacaoService;

import jakarta.transaction.Transactional;

@Service
public class TransacaoServiceImpl implements TransacaoService {
	
	@Autowired
	TransacaoRepository repository;
	
	@Autowired
	ContaRepository contaRepository;

	public Transacao cadastrarTransacao(TransacaoDTO transacaoDto) {
		Transacao transacao = new Transacao();
		transacao.setDataTransacao(transacaoDto.getDataTransicao());
		transacao.setTipoOperacao(transacaoDto.getTipoOperacao());
		transacao.setValor(transacaoDto.getValor());
		repository.save(transacao);
		return null;
	}
	


	@Transactional
	public Conta depositarConta(Long id, Double valor) {

		Conta conta = contaRepository.findById(id).get();
		
		if (conta == null) {
			throw new RuntimeException("Conta não encontrada");
		} else {
			Transacao transacao = new Transacao();
			
			transacao.setTipoOperacao(TipoOperacao.PAGAMENTO);
			transacao.setDataTransacao(LocalDateTime.now());
			transacao.setValor(valor);
			conta.getTransacoes().add(transacao);
			transacao.getContas().add(conta);
			conta.setSaldoConta(conta.getSaldoConta() + valor);
			
			repository.save(transacao);
			contaRepository.save(conta);
			return conta;
		}
	}

	@Transactional
	public Conta sacarConta(Long id, Double valor) {
		
		Conta conta = contaRepository.findById(id).get();
		Transacao transacao = new Transacao();
	
		if (conta.getSaldoConta() < valor) {
			throw new SaldoInsuficienteException();
		} else {
			conta.setSaldoConta(conta.getSaldoConta() - valor);
			transacao.setTipoOperacao(TipoOperacao.SAQUE);
			transacao.setDataTransacao(LocalDateTime.now());
			transacao.setValor(valor);
			conta.getTransacoes().add(transacao);
			transacao.getContas().add(conta);
			
			repository.save(transacao);
			contaRepository.save(conta);
			
			return conta;
		}
	}
	
	
}
