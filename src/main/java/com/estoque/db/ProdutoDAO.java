package com.estoque.db;

import com.estoque.api.Produto;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(ProdutoMapper.class)
public interface ProdutoDAO {
    @SqlQuery("SELECT * FROM Produtos")
    List<Produto> getAllProdutos();
}
