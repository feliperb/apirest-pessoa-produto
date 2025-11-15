package com.pessoaEproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoaEproduto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
}