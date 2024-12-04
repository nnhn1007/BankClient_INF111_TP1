package com.atoudeft.Operation;


import com.atoudeft.Operation.TypeOperation;

import java.io.Serializable;

/**
 * La classe OperationRetrait représente les opérations de retrait bancaire
 * Elle est une sous-classe de la classe Operation et stocke les détails du retrait bancaire ;
 * - sa date de transaction, le type de transaction, et le montant de transaction
 *
 * @author Mathis Odjo'o Ada
 */
public class OperationRetrait extends Operation implements Serializable {
    private final double montantRetrait;

    /**
     * Fait par Mathis Odjo'o Ada
     * Constructeur de l'opération de retrait bancaire
     *
     * @param montantRetrait Le type de l'Opération que le client veut exécuter
     */
    public OperationRetrait(double montantRetrait) {
        super(TypeOperation.RETRAIT);
        this.montantRetrait = montantRetrait;
    }

    /**
     * Fait par Melissa Sehad
     * Methode qui retourne le montant de retrait
     *
     * @return le montant du retrait bancaire
     */
    public double getMontantRetrait() {
        return montantRetrait;
    }

    /**
     * Fait par Nancy Nguyen et Melissa Sehad
     * Décrit les détails de transaction (Retrait): montant du retrait
     *
     * @return chaîne de format: "RETRAIT [montantRetrait]"
     */
    public String toString() {
        return "RETRAIT " + montantRetrait;
    }
}

