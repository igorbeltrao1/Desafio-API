package com.pactomais.api.model.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "conta")
@Data
public class Conta {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String nomeTitular;
	
	private String numeroConta;
	
	private Double saldoConta;
	
	@ManyToMany
    @JoinTable(
            name = "conta_transacao",
            joinColumns = @JoinColumn(name = "conta_id"),
            inverseJoinColumns = @JoinColumn(name = "transacao_id")
    )
	private List<Transacao> transacoes = new ArrayList();

	public Conta() {
	}
}
