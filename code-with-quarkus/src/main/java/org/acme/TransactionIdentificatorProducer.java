package org.acme;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class TransactionIdentificatorProducer {
    @Produces
    @DefaultBean
    @RequestScoped
    public TransactionIdentificator produceTest ( ){
        return new TransactionIdentificator("Teste - ");
    }
    @Produces
    @IfBuildProfile("prod")
    public TransactionIdentificator produceProd ( ){
        return new TransactionIdentificator("Prod - ");
    }
}
