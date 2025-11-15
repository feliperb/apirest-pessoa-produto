package com.pessoaEproduto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoaEproduto.model.Pessoa;
import com.pessoaEproduto.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

	private final PessoaRepository pessoaRepository;

    // Endpoint para buscar todas as pessoas
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();  // busca todas as pessoas do banco
        return ResponseEntity.ok(pessoas);
    }
	
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa salva = pessoaRepository.save(pessoa); // salva no banco
        return ResponseEntity.ok(salva); // retorna a pessoa salva
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // retorna 404 se não existir
        }
        pessoaRepository.deleteById(id); // deleta do banco
        return ResponseEntity.noContent().build(); // retorna 204
    }
	
	
}
