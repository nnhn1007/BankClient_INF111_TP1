package com.atoudeft.vue;

import com.atoudeft.Operation.TypeOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.atoudeft.Operation.*;

/**
 *
 */
public class PanneauOperations extends JPanel {
    private static final int COLONNE = 0, LIGNE = 1, DIX = 10, HUIT = 8, QUATORZE = 14;
    private JButton btnConfirmer;
    private TypeOperation typeOperation;
    private JPanel pMontant;
    private JLabel titre;
    private final JPanel controle;
    private JTextField montant;
    private JTextField texteNumerofacture;
    private JTextField texteDescription;
    private JTextField compteDestinataire;

    /**
     * Fait par Mathis Odjo'o Ada
     * Constructeur initialisant un panneau d'opérations
     *
     * @param type     type d'opération à effectuer (DEPOT, RETRAIT, FACTURE ou TRANSFER)
     * @param ecouteur écouteur gestionnaire d'événement du bouton 'CONFIRMER'
     */
    public PanneauOperations(TypeOperation type, ActionListener ecouteur) {
        controle = new JPanel();
        try {
            switch (type) {
                case DEPOT, RETRAIT, FACTURE, TRANSFER:
                    this.typeOperation = type;
                    titre = new JLabel(typeOperation.getAction(), SwingConstants.CENTER);
                    controle.add(titre);

                    creerBoutton(ecouteur);
                    creerChampsMontant();
                    switch (type) {
                        case FACTURE  -> dessinerFacture();
                        case TRANSFER -> dessinerTransfert();
                    }
                    break;
                default: System.err.println("Aucune opération possible.");
            }

            creerPanels();
            add(controle, BorderLayout.CENTER);
        } catch (NullPointerException operationInexistante) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ce type d'opération n'est pas dans la liste disponible",
                    "ERREUR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui crée et configure le bouton 'CONFIRMER' du panneau
     * @param ecouteur écouteur d'événements pour le bouton 'CONFIRMER'
     */
    private void creerBoutton(ActionListener ecouteur) {
        btnConfirmer = new JButton("VALIDER");
        btnConfirmer.setActionCommand("VALIDER");
        btnConfirmer.addActionListener(ecouteur);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui configure les panneaux en organisant leurs composantes
     */
    private void creerPanels() {
        controle.setLayout(new GridLayout(COLONNE, LIGNE));
        controle.add(pMontant);
        controle.add(btnConfirmer);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui crée un champ de texte pour saisir le montant d'une opération
     */
    private void creerChampsMontant() {
        pMontant = new JPanel();
        montant = new JTextField(HUIT);
        pMontant.add(new JLabel("Montant:"));
        pMontant.add(montant, BorderLayout.SOUTH);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui retourne le montant saisi par l'utilisateur
     * @return montant saisi par l'utilisateur
     */
    private double getMontant(JTextField montant) {
        return Double.parseDouble(montant.getText());
    }

    /**
     * Méthode qui récupère l'opération que l'utilisateur effectue
     * @return instance d'Operation représentant son type
     */
    public Operation getOperation() {
        Operation operation = null;
        try {
            operation = switch (typeOperation) {
                case DEPOT -> new OperationDepot(getMontant(montant));
                case RETRAIT -> new OperationRetrait(getMontant(montant));
                case FACTURE -> new OperationFacture(getMontant(montant), getNumeroFacture(texteNumerofacture)
                        , getDescription(texteDescription));
                case TRANSFER -> new OperationTransfer(getMontant(montant),
                        getNumeroCompteDestinataire(compteDestinataire));
            };
        } catch (Exception gererException) {
            JOptionPane.showMessageDialog(
                    null,
                    "L'opération que vous venez d'effectuer n'est pas possible ! :",
                    "ERREUR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return operation;
    }

    /**
     * Fait par Mathis Odjo'o Ada et Melissa Sehad
     * Méthode configurant les champs de saisie et des étiquettes pour l'opération FACTURE
     */
    private void dessinerFacture() {
        JPanel champNumeroFacture = new JPanel();
        champNumeroFacture.add(new JLabel("Numero de facture : "), SwingConstants.CENTER);
        texteNumerofacture = new JTextField(DIX);
        champNumeroFacture.add(texteNumerofacture);
        controle.add(champNumeroFacture);

        JPanel champDescriptionFacture = new JPanel();
        champDescriptionFacture.add(new JLabel("Description : "), SwingConstants.CENTER);
        texteDescription = new JTextField(QUATORZE);
        champDescriptionFacture.add(texteDescription);
        controle.add(champDescriptionFacture);
    }

    /**
     * Fait par Nancy Nguyen
     * Méthode configurant les champs de saisie et des étiquettes pour l'opération TRANSFER
     */
    private void dessinerTransfert() {
        JPanel champCompteDestinataire = new JPanel();
        champCompteDestinataire.add(new JLabel("Compte Destinataire : "), SwingConstants.CENTER);
        compteDestinataire = new JTextField(DIX);
        champCompteDestinataire.add(compteDestinataire);
        controle.add(champCompteDestinataire);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Accesseur: Récupère la description de la facture
     *
     * @param texteDescription champ de texte pour la description de la facture
     * @return le champ de texte saisi dans 'texteDescription' par le client
     */
    private String getDescription(JTextField texteDescription) {
        return texteDescription.getText();
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Accesseur: Récupère le numéro de la facture*
     *
     * @param numerofacture numéro de la facture saisie
     * @return le numéro de la facture saisi par le client
     */
    private String getNumeroFacture(JTextField numerofacture) {
        return numerofacture.getText();
    }

    /**
     * Fait par Nancy Nguyen
     * Accesseur: Récupère le numéro de compte du compte destinataire
     *
     * @param compteDestinataire nnuméro du compte destinataire
     * @return le numéro du compte destinataire
     */
    private String getNumeroCompteDestinataire(JTextField compteDestinataire) {
        return compteDestinataire.getText();
    }

}