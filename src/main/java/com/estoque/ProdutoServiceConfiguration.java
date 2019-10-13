package com.estoque;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class ProdutoServiceConfiguration extends Configuration {
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDatabase(){
        return database;
    }

    public void setDatabase(DataSourceFactory database) {
        this.database = database;
    }

}
