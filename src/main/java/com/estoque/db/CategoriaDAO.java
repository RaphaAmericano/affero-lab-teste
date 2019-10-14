package com.estoque.db;

import com.estoque.api.Categoria;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(CategoriaMapper.class)
public interface CategoriaDAO {
    @SqlQuery("SELECT * FROM Categorias")
    List<Categoria> getAllCategorias();

    @SqlUpdate("INSERT INTO Categorias (nome_cat) VALUES (:nome_cat)")
    void insertCategoria(@Bind("nome_cat") String nome);

}
