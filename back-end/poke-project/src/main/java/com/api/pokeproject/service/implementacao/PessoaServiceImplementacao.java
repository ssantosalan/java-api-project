package com.api.pokeproject.service.implementacao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Pessoa> findById(UUID id) {
        return pessoaRepository.findById(id);          
    }

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

}
