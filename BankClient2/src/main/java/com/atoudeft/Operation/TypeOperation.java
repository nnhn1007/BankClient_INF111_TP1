package com.atoudeft.Operation;

import java.io.Serializable;

public enum TypeOperation implements Serializable {
    DEPOT("DEPOT"),
    RETRAIT("RETRAIT"),
    FACTURE("FACTURE"),
    TRANSFER("TRANSFER");

    public final String action;

    TypeOperation(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
