package com.estoque.db;

import com.estoque.api.Produto;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(ProdutoMapper.class)
public interface ProdutoDAO {
    @SqlQuery("SELECT * FROM Produtos AS P INNER JOIN Categorias AS C ON P.categoria = C.id_cat")
    List<Produto> getAllProdutos();

    //@SqlUpdate("INSERT INTO Produtos (cod_barras, nome, descricao, categoria) VALUES ( :cod_barras, :nome, :descricao, :id_cat)")
    @SqlUpdate("INSERT INTO Produtos (cod_barras, nome, quantidade, descricao, categoria) VALUES ( :cod_barras, :nome, :quantidade, :descricao, :categoria)")
    void insertProduto(@Bind("cod_barras") int cod_barras,
                       @Bind("nome") String nome,
                       @Bind("quantidade") int quantidade,
                       @Bind("descricao") String descricao,
                       @Bind("categoria") int cat);

    @SqlQuery("SELECT * FROM Produtos WHERE id = :id")
    Produto findById(@Bind("id") int id);

    @SqlUpdate("UPDATE Produtos SET  cod_barras = :cod_barras, nome = :nome, descricao = :descricao, quantidade = :quantidade,  categoria = :categoria WHERE id = :id")
    void updateDescricao(@Bind("id") int id,
                         @Bind("cod_barras") int cod_barras,
                         @Bind("nome") String nome,
                         @Bind("descricao") String descricao,
                         @Bind("quantidade") int quantidade,
                         @Bind("categoria") int categoria );

    @SqlUpdate("DELETE FROM Produtos WHERE id = :id")
    void deleteProduto(@Bind("id") int id);

}
