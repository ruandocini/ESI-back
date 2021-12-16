package br.com.podcome.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurante {

    @Id
    @NotNull
    private String nome;

    @NotNull
    private String endereco;

    @NotNull
    private String restricao;

    @NotNull
    private Float latitude;

    @NotNull
    private Float longitude;

    @NotNull
    private String preco;

    @NotNull
    private Float nota;

    @NotNull
    private Boolean temEntrega;

    public Restaurante() {
    }

    public Restaurante(String nome, String endereco, String restricao, Float latitude, Float longitude, String preco, Float nota, Boolean temEntrega) {
        this.nome = nome;
        this.endereco = endereco;
        this.restricao = restricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.preco = preco;
        this.nota = nota;
        this.temEntrega = temEntrega;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Boolean getTemEntrega() {
        return temEntrega;
    }

    public void setTemEntrega(Boolean temEntrega) {
        this.temEntrega = temEntrega;
    }
}
