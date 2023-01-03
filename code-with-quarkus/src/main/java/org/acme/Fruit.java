package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;

@Entity
public class Fruit extends PanacheEntity {
    public String name;
    public int qtde;


}
