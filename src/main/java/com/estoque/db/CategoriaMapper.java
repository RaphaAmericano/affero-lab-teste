package com.estoque.db;

import com.estoque.api.Categoria;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {
    @Override
    public Categoria map(ResultSet rs, StatementContext ctx ) throws SQLException {
        return new Categoria(
                rs.getInt("id_cat"),
                rs.getString("nome_cat")
        );
    }
}
