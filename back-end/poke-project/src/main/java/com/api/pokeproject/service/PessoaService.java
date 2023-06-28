package com.api.pokeproject.service;

import java.util.Optional;

import com.api.pokeproject.entity.Pessoa;

public interface PessoaService {
    Pessoa findByEmail(String email);
    Optional <Pessoa> findById(Integer id);
}
