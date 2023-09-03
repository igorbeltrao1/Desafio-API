package com.pactomais.api.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pactomais.api.model.enun.TipoOperacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transacao")
@Data
public class Transacao {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private TipoOperacao tipoOperacao;
	
	private Double valor;
	
	private LocalDateTime dataTransacao;
	
	@ManyToMany(mappedBy = "transacoes")
	private List<Conta> contas = new ArrayList();

	public Transacao() {
	}

	public List<Conta> getContas() {
		return this.contas;
	}

}
