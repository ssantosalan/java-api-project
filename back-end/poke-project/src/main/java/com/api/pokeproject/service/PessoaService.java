package com.api.pokeproject.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.pokeproject.entity.Pessoa;

public interface PessoaService {
    Pessoa findByEmail(String email);
    Optional <Pessoa> findById(UUID id);
    Pessoa createPessoa(Pessoa pessoa);
    List<Pessoa> findAll();
}
