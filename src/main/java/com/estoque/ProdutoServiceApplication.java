package com.estoque;

import com.estoque.db.CategoriaDAO;
import com.estoque.db.ProdutoDAO;
import com.estoque.resources.CategoriaResource;
import com.estoque.resources.ProdutoResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.jdbi.v3.core.Jdbi;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
        // CORS
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
        ProdutoDAO produtoDao = jdbi.onDemand(ProdutoDAO.class);
        CategoriaDAO categoriaDao = jdbi.onDemand(CategoriaDAO.class);

        ProdutoResource produtoResource = new ProdutoResource(produtoDao);
        CategoriaResource categoriaResource = new CategoriaResource(categoriaDao);
        environment.jersey().register(categoriaResource);
        environment.jersey().register(produtoResource);
    }

}
