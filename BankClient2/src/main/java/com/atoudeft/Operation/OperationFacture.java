package com.atoudeft.Operation;

import com.atoudeft.Operation.TypeOperation;

import javax.swing.*;

/**
 * La classe OperationFacture représente les operations de paiement de facture
 * Elle est une sous-classe de la classe Operation et stocke les détails du paiement de facture;
 * - sa date de transaction, le type de transaction, et le montant de transaction
 *
 * @author Mathis Odjo'o Ada
 */
public class OperationFacture extends Operation {
    private final double montantFacture;
    private final String numeroFacture;
    private final String descriptionFacture;

    /**
     * Fait par Mathis Odjo'o Ada
     * Constructeur de l'opération de paiement de facture
     *
     * @param montantFacture     le montant de la facture
     * @param numeroFacture      le numero de la facture
     * @param descriptionFacture la description de la facture
     */
    public OperationFacture(double montantFacture, String numeroFacture, String descriptionFacture) {
        super(TypeOperation.FACTURE);
        this.montantFacture = montantFacture;
        this.numeroFacture = numeroFacture;
        this.descriptionFacture = descriptionFacture;
    }

    /**
     * Fait par Melissa Sehad
     * Methode qui retourne le montant de la facture
     *
     * @return le montant de la facture
     */
    public double getMontantFacture() {
        return montantFacture;
    }

    /**
     * Fait par Melissa Sehad
     * Methode qui retourne la numero de la facture
     *
     * @return le numero de la facture
     */
    public String getNumeroFacture(JTextField numeroFacture) {
        return String.valueOf(numeroFacture);
    }

    /**
     * Fait par Melissa Sehad
     * Methode qui retourne la description de la facture
     *
     * @return la description de la facture
     */
    public String getDescriptionFacture(JTextField descriptionFacture) {
        return String.valueOf(descriptionFacture);
    }

    /**
     * Fait par Nancy Nguyen et Melissa Sehad
     * Décrit les détails de transaction (paiement de facture ):
     *      - montant, numéro de facture, et description de la facture
     *
     * @return chaîne de format: "FACTURE [montantFacture]  [numéroFacture]  [descriptionFacture]
     */
    public String toString() {
        return "FACTURE " + " "+ montantFacture + " " + numeroFacture+ " " + descriptionFacture;
    }
}