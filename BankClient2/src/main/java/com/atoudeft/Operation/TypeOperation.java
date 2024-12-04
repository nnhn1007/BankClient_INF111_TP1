package com.atoudeft.Operation;

import java.io.Serializable;

/**
 * L'énumération TypeOperation définit l'ensemble des types d'opérations bancaires disponibles;
 *      - DÉPÔT: dépôt d'argent
 *      - RETRAIT: retrait d'argent
 *      - FACTURE: paiement de facture
 *      - TRANSFER: transfert d'argent
 */
public enum TypeOperation implements Serializable {

    /**
     * Opération de dépôt d'argent
     */
    DEPOT("DEPOT"),

    /**
     * Opération de retrait d'argent
     */
    RETRAIT("RETRAIT"),

    /**
     * Opération de paiement de facture
     */
    FACTURE("FACTURE"),

    /**
     * Opération de transfert d'argent
     */
    TRANSFER("TRANSFER");

    //Chaîne de caractères représentant l'opération
    public final String action;

    /**
     * Constructeur de TypeOperation permettant d'associer 'action' à son type d'opération
     * @param action chaîne de caractères représentant l'opération
     */
    TypeOperation(String action) {
        this.action = action;
    }

    /**
     * Méthode qui retourne l'action (l'opération) associée à son type d'opération respectif
     * @return chaîne de caractères représentant l'opération
     */
    public String getAction() {
        return action;
    }

}
