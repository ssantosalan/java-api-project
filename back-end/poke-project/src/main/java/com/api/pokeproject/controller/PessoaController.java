package com.api.pokeproject.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokeproject.entity.Pessoa;
import com.api.pokeproject.entity.dto.PessoaDTO;
import com.api.pokeproject.service.PessoaService;

@RequestMapping("/pessoa")
@RestController
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService service) {
        this.pessoaService = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoaById(@PathVariable UUID id) {
        Optional<Pessoa> pessoaOptional = pessoaService.findById(id);

        if (pessoaOptional.isPresent()) {
            PessoaDTO pessoaDTO = new PessoaDTO(pessoaOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(pessoaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO ENCONTRADO PAPI");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPessoa(@RequestBody Pessoa pessoa) {

        try {
            Pessoa novaPessoa = pessoaService.createPessoa(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" - Erro ao criar a Pessoa");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Pessoa>> getAllPessoa() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

}
