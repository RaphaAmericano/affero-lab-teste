package com.estoque.resources;

import com.estoque.api.Produto;
import com.estoque.db.ProdutoDAO;

import javax.ws.rs.*;
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

    @GET
    @Path("/{id}")
    public Response getProduto(@PathParam("id") int id ){
        Produto produto = produtoDAO.findById(id);
        if(produto == null ) {
            throw new WebApplicationException("Produto nao existe", Response.Status.NOT_FOUND);
        }
        return Response.ok(produto).build();
    }

    @POST
    public Response createProduto(Produto produto){
        produtoDAO.insertProduto(produto);
        return Response.status(Response.Status.CREATED).build();
    }

    //Update
    @PUT
    @Path("/{id}")
    public Response updateProduto(@PathParam("id") int id,  Produto produto){
        produtoDAO.updateDescricao(id, produto.getCodBarras(), produto.getCategoria(), produto.getDescricao());
        return Response.ok().build();
    }

}
