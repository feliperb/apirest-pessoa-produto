package com.pessoaEproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoaEproduto.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	
}
