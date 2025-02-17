package com.sd.locacao;


import java.io.Serializable;

abstract class Aparelho implements Serializable {
    private String nome;
    private double precoLocacao;

    public Aparelho(String nome, double precoLocacao) {
        this.nome = nome;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoLocacao() {
        return precoLocacao;
    }
}
