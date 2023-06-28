package com.api.pokeproject.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.pokeproject.entity.Pessoa;
import com.api.pokeproject.repository.PessoaRepository;
import com.api.pokeproject.service.PessoaService;

@Service
public class PessoaServiceImplementacao implements PessoaService {
    // @Autowired
    // private PessoaRepository pessoaRepository;

    private PessoaRepository pessoaRepository;

    public PessoaServiceImplementacao(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa findByEmail(String email) {
        return pessoaRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Pessoa não tem EMAIL"));
    }

    @Override
    public Optional<Pessoa> findById(Integer id) {
        return pessoaRepository.findById(id);          
    }

}
