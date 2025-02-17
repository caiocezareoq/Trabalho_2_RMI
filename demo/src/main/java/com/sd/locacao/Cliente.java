package com.sd.locacao;

import java.io.Serializable;

class Cliente implements Serializable {
    private String nome;
    private String cpf;

    // Construtor padrão (sem argumentos)
    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
