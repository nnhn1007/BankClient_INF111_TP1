package com.atoudeft.Operation;

import com.atoudeft.Operation.TypeOperation;

import javax.swing.*;
import java.io.Serializable;

/**
 * La classe OperationTransfer représente une opération de transfert bancaire.
 * Elle est une sous-classe de la classe Operation et stocke les détails du transfert bancaire;
 * - sa date de transaction, le type de transaction, et le montant de transaction
 *
 * @author Mathis Odjo'o Ada
 */
public class OperationTransfer extends Operation implements Serializable {
    private final double montantTransfer;
    private final String numeroCompteDestinataire;

    /**
     * Fait par Mathis Odjo'o Ada
     * Constructeur de l'opération de transfert bancaire
     *
     * @param montantTransfer          Le montant du transfert
     * @param numeroCompteDestinataire Le numéro de compte du destinataire
     */
    public OperationTransfer(double montantTransfer, String numeroCompteDestinataire) {
        super(TypeOperation.TRANSFER);
        this.montantTransfer = montantTransfer;
        this.numeroCompteDestinataire = numeroCompteDestinataire;
    }

    /**
     * Fait par Melissa Sehad
     * Methode qui retourne le montant de transfert
     *
     * @return le montant du transfert
     */
    public double getMontantTransfer() {
        return montantTransfer;
    }

    /**
     * Fait par Nancy Nguyen
     * Methode qui retourne le numero de compte du destinataire
     *
     * @return le numero de compte du destinataire
     */
    public String getNumeroCompteDestinataire(JTextField numeroCompteDestinataire) {
        return String.valueOf(numeroCompteDestinataire.getText());
    }

    /**
     * Fait par Nancy Nguyen et Melissa Sehad
     * Décrit les détails de transaction (Transfer): montant du transferte et numéro de compte destinataire
     *
     * @return chaîne de format: "TRANSFER [montantTransfer] [numeroCompteDestinataire]"
     */
    public String toString() {
        return "TRANSFER "  + montantTransfer + " " + numeroCompteDestinataire;
    }

}