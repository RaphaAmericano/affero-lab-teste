package com.estoque;

import com.estoque.db.ProdutoDAO;
import com.estoque.resources.ProdutoResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class ProdutoServiceApplication extends Application<ProdutoServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ProdutoServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "ProdutoService";
    }

    @Override
    public void initialize(final Bootstrap<ProdutoServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ProdutoServiceConfiguration configuration,
                    final Environment environment) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
        ProdutoDAO produtoDao = jdbi.onDemand(ProdutoDAO.class);


        ProdutoResource produtoResource = new ProdutoResource(produtoDao);
        environment.jersey().register(produtoResource);
    }

}
