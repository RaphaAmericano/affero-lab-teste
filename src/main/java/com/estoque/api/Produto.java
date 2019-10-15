package com.estoque.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {

    @JsonProperty
    private int id;
    @JsonProperty
    private int cod_barras;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String descricao;
    @JsonProperty
    private int quantidade;
    @JsonProperty
    private Categoria categoria;

    public Produto(){}

    public Produto(int id, int cod_barras, String nome, int quantidade, String descricao, int categoria ) {
        this.id = id;
        this.cod_barras = cod_barras;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = new Categoria(categoria);
    }

    public Produto(int id, int cod_barras, String nome, int quantidade, String descricao, int id_cat, String nome_cat ) {
        this.id = id;
        this.cod_barras = cod_barras;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = new Categoria(id_cat, nome_cat);
    }

    public int getId(){
        return this.id;
    }

    public int getCodBarras(){
        return this.cod_barras;
    }

    public String getNome() { return this.nome; }

    public int getQuantidade() { return this.quantidade; }

    public String getDescricao(){
        return this.descricao;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }
}
