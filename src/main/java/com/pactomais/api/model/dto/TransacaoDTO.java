package com.pactomais.api.model.dto;

import java.time.LocalDateTime;

import com.pactomais.api.model.enun.TipoOperacao;

import lombok.Data;

@Data
public class TransacaoDTO {
	private ContaListagemDTO contaListagemDto;
	private TipoOperacao tipoOperacao;
	private Double valor;
	private LocalDateTime dataTransicao;

	public TransacaoDTO() {
	}

}
