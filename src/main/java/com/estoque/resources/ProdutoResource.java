package com.estoque.resources;

import com.estoque.api.Produto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @GET
    public Response getAllProdutos(){
        Produto produto = new Produto(1, 20, "bonita camisa", "camisa");
        return Response.ok(produto).build();
    }
}
