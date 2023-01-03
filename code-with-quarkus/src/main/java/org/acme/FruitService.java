package org.acme;

import io.quarkus.arc.Lock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Lock
@ApplicationScoped
public final class FruitService {

    @Inject
    TransactionIdentificator transactionIdentificator;

    @Lock(value = Lock.Type.READ, time = 2, unit = TimeUnit.SECONDS)
    public List<Fruit> listFruit() {
        System.out.println(transactionIdentificator.getTransactionIdentificator());
        return Fruit.listAll();
    }

    @Transactional
    public void newFruit(FruitDTO fruitDTO) {
        System.out.println(transactionIdentificator.getTransactionIdentificator());
        Fruit fruit = new Fruit();
        fruit.name = fruitDTO.getName();
        fruit.qtde = fruitDTO.getQtd();
        fruit.persist();
    }
}
