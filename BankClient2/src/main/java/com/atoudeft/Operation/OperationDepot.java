package com.atoudeft.Operation;

import java.io.Serializable;

/**
 * La classe OperationDepot represente une operation de depot bancaire
 * Elle est une sous-classe de la classe Operation et stocke les détails du dépôt bancaire;
 * - sa date de transaction, le type de transaction, et le montant de transaction
 *
 * @author Mathis Odjo'o Ada
 */
public class OperationDepot extends Operation implements Serializable {
    private final double montantDepot;

    /**
     * Fait par Mathis Odjo'o Ada
     * Constructeur de l'operation de depot
     *
     * @param montantDepot Le montant  de depot
     */
    public OperationDepot(double montantDepot) {
        super(TypeOperation.DEPOT);
        this.montantDepot = montantDepot;
    }

    /**
     * Fait par Melissa Sehad
     * Methode qui retourne le montant du depot
     *
     * @return le montant du depot
     */
    public double getMontantDepot() {
        return montantDepot;
    }

    /**
     * Fait par Nancy Nguyen et Melissa Sehad
     * Décrit les détails de transaction (dépôt) : montant de dépôt
     *
     * @return chaîne de format: "DEPOT [montantDepot]"
     */
    public String toString() {
        return "DEPOT " + montantDepot;
    }
}
