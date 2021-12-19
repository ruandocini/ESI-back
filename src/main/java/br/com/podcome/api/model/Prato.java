package br.com.podcome.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prato {

    @Id
    @NotNull
    private String nomeDoPrato;

    @NotNull
    private String nomeDoRestaurante;

    @NotNull
    private Float preco;

  
    public Prato() {
    }

    public Prato(String nomeDoPrato, String nomeDoRestaurante, Float preco) {
        this.nomeDoPrato = nomeDoPrato;
        this.nomeDoRestaurante = nomeDoRestaurante;
        this.preco = preco;
    
    }

    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    public void setNomeDoPrato(String nomeDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
    }

    public String getNomeDoRestaurante() {
        return nomeDoRestaurante;
    }

    public void setNomeDoRestaurante(String nomeDoRestaurante) {
        this.nomeDoRestaurante = nomeDoRestaurante;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
