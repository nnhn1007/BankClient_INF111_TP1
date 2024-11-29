package com.atoudeft.Operation;

import java.io.Serializable;

public enum TypeOperation implements Serializable {
    DEPOT("DEPOT"),
    RETRAIT("Retirer"),
    FACTURE("Facture"),
    TRANSFER("Transfer");

    public final String action;

    TypeOperation(String action) {
        this.action = action;
    }
}
