package com.estoque.db;

import com.estoque.api.Produto;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(ProdutoMapper.class)
public interface ProdutoDAO {
    @SqlQuery("SELECT * FROM Produtos")
    List<Produto> getAllProdutos();

    @SqlUpdate("INSERT INTO Produtos (cod_barras, descricao, categoria) VALUES ( :cod_barras, :descricao, :categoria)")
    void insertProduto(@BindBean Produto produto);

    @SqlQuery("SELECT * FROM Produtos WHERE id = :id")
    Produto findById(@Bind("id") int id);

    @SqlUpdate("UPDATE Produtos SET descricao = :descricao, cod_barras = :cod_barras, categoria = :categoria WHERE id = :id")
    void updateDescricao(@Bind("id") int id,
                         @Bind("cod_barras") int cod_barras,
                         @Bind("categoria") String categoria,
                         @Bind("descricao") String descricao );
    //void updateDescricao(@Bind("id") int id,  @BindBean Produto produto);

}
