package com.estoque.db;

import com.estoque.api.Produto;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface ProdutoDAO {
    @SqlQuery("SELECT * FROM Produtos")
    public List<Produto> getAllProdutos();
}
