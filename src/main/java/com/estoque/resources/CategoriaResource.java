package com.estoque.resources;

import com.estoque.api.Categoria;
import com.estoque.db.CategoriaDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    CategoriaDAO categoriaDAO;

    public CategoriaResource(CategoriaDAO categoriaDAO) { this.categoriaDAO = categoriaDAO ;}

    @GET
    public Response getAllCategorias(){
        List<Categoria> allCategorias = categoriaDAO.getAllCategorias();
        return Response.ok(allCategorias).build();
    }

    @POST
    public Response createCategoria(String name){
        categoriaDAO.insertCategoria(name);
        return Response.status(Response.Status.CREATED).build();
    }
}
