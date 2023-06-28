package com.api.pokeproject.entity.dto;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

import com.api.pokeproject.entity.Pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
public class PessoaDTO {

    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min = 4)
    private String password;
    @CPF
    private String CPF;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.name = pessoa.getName();
        this.email = pessoa.getEmail();
        this.password = pessoa.getPassword();
        this.CPF = pessoa.getCPF();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

}
