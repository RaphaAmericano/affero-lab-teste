package com.estoque;

import com.estoque.resources.ProdutoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        ProdutoResource produtoResource = new ProdutoResource();
        environment.jersey().register(produtoResource);
    }

}
