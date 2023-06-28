package com.api.pokeproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokeproject.entity.Pessoa;
import com.api.pokeproject.entity.dto.PessoaDTO;
import com.api.pokeproject.service.impl.PessoaServiceImplementacao;

@RequestMapping("/pessoa")
@RestController
public class PessoaController {
    @Autowired
    private PessoaServiceImplementacao pessoaServiceImplementacao;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoaById(@PathVariable Integer id) {
        System.out.println("AQUI");
        Optional<Pessoa> pessoa = pessoaServiceImplementacao.findById(id);

        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO ENCONTRADO PAPI");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new PessoaDTO(pessoa.get()));
        }
    }

}
