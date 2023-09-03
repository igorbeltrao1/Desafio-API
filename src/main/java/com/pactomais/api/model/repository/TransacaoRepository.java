package com.pactomais.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pactomais.api.model.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
}
