package org.acme;

import java.time.Instant;
import java.util.Random;

public class TransactionIdentificator {
    private String prefix;
    private int transactionId;
    private Instant start;

    public TransactionIdentificator(String prefixa ) {
        super();
        this.prefix=prefixa;
        this.transactionId = new Random().nextInt();;
        this.start = Instant.now();
    }

    public String getTransactionIdentificator(){
        return prefix + transactionId+ " - "+ start;
    }
}
