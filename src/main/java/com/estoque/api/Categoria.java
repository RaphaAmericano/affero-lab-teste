package com.estoque.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Categoria {

    @JsonProperty
    private int id;
    @JsonProperty
    private String nome;

    public Categoria(){}

    public Categoria(String nome){
        this.nome = nome;
    }
    public Categoria(int id ){
        this.id = id;
    }

    public Categoria(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }

}
