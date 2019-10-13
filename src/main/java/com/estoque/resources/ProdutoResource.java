package com.estoque.resources;

import com.estoque.api.Produto;
import com.estoque.db.ProdutoDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    ProdutoDAO produtoDAO;

    public ProdutoResource(ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    @GET
    public Response getAllProdutos(){
        List<Produto> allProdutos = produtoDAO.getAllProdutos();
        return Response.ok(allProdutos).build();
    }
}
