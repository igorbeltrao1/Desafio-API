package com.pactomais.api.model.dto;

import lombok.Data;

@Data
public class ContaListagemDTO {
	
	private Long id;
		
	private String nomeTitular;
	
	private String numeroConta;
	
	private Double saldoConta;

	public ContaListagemDTO() {
		
	}
	
}
