package com.estoque.db;

import com.estoque.api.Categoria;
import com.estoque.api.Produto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoMapper implements RowMapper<Produto> {
    @Override
    public Produto map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Produto(
                rs.getInt("id"),
                rs.getInt("cod_barras"),
                rs.getString("nome"),
                rs.getInt("quantidade"),
                rs.getString("descricao"),
                rs.getInt("id_cat"),
                rs.getString("nome_cat")
        );
    }
}
