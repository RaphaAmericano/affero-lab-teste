package com.estoque.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {

    @JsonProperty
    private int id;
    @JsonProperty
    private int cod_barras;
    @JsonProperty
    private String descricao;
    @JsonProperty
    private String categoria;

    public Produto(){}

    public Produto(int id, int cod_barras, String descricao, String categoria ) {
        this.id = id;
        this.cod_barras = cod_barras;
        this.descricao = descricao;
        this.categoria = categoria;
    }
}
