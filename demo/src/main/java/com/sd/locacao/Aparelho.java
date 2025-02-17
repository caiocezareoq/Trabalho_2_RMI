package com.sd.locacao;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Gerador.class, name = "gerador"),
    @JsonSubTypes.Type(value = Mesas.class, name = "mesas"),
    @JsonSubTypes.Type(value = Palco.class, name = "palco"),
    @JsonSubTypes.Type(value = Talheres.class, name = "talheres")
})

abstract class Aparelho implements Serializable {
    private static final long serialVersionUID = 1L; 

    private String nome;
    private double precoLocacao;

    // Construtor padrão (sem argumentos)
    public Aparelho() {
    }

    public Aparelho(String nome, double precoLocacao) {
        this.nome = nome;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }


}
