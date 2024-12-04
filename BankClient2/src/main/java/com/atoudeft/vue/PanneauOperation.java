package com.atoudeft.vue;

import com.atoudeft.Operation.TypeOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.atoudeft.Operation.*;

/**
 *
 */
public class PanneauOperation extends JPanel {
    private static final int ESPACE = 5, COLONNE = 0, LIGNE = 1;
    private JButton btnConfirmer;
    private TypeOperation typeOperation;
    private JPanel pMontant;
    private JLabel titre;
    private JPanel content;
    private JTextField montant;
    private JTextField texteNumerofacture;
    private JTextField texteDescription;
    private JTextField compteDestinataire;

    /**
     * Constructeur initialisant un panneau d'opérations
     *
     * @param type     type d'opération à effectuer (DEPOT, RETRAIT, FACTURE ou TRANSFER)
     * @param ecouteur écouteur gestionnaire d'événement du bouton 'CONFIRMER'
     */
    public PanneauOperation(TypeOperation type, ActionListener ecouteur) {
        content = new JPanel();
        try {
            switch (type) {
                case DEPOT, RETRAIT, FACTURE, TRANSFER:
                    this.typeOperation = type;
                    titre = new JLabel(typeOperation.getAction(), SwingConstants.CENTER);
                    content.add(titre);

                    creerButton(ecouteur);
                    creerChampsMontant();
                    switch (type) {
                        case FACTURE -> dessinerFacture();
                        case TRANSFER -> dessinerTransfert();
                    }
                    break;
            }
            creerPanels();
            add(content, BorderLayout.CENTER);
        } catch (NullPointerException operationInexistante) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ce type d'opération n'est pas dans la liste disponible",
                    "ERREUR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /** Méthode qui crée et configure le bouton 'CONFIRMER' du panneau
     * @param ecouteur écouteur d'événements pour le bouton 'CONFIRMER'
     */
    private void creerButton(ActionListener ecouteur) {
        btnConfirmer = new JButton("CONFIRMER");
        btnConfirmer.setActionCommand("CONFIRMER");
        btnConfirmer.addActionListener(ecouteur);
    }

    /**
     * @author
     * Méthode qui configure les panneaux en organisant leurs composantes
     */
    private void creerPanels() {

        content.setLayout(new GridLayout(COLONNE, LIGNE));
        content.add(pMontant);
        content.add(btnConfirmer);
    }

    /**
     * Méthode qui crée un champ de texte pour saisir le montant d'une opération
     */
    private void creerChampsMontant() {
        pMontant = new JPanel();
        montant = new JTextField(8);
        pMontant.add(new JLabel("Montant:"));
        pMontant.add(montant, BorderLayout.SOUTH);
    }

    /**
     * Méthode qui retourne le montant saisi par l'utilisateur
     * @return montant saisi par l'utilisateur
     */
    private double getMontant() {
        return Double.parseDouble(montant.getText());
    }

    /**
     * Méthode qui récupère l'opération que l'utilisateur effectue
     * @return instance d'Operation représentant son type
     */
    public Operation getOperation() {
        Operation operation = null;
        //TODO peut être mettre le code ici en TRY catch pour gérer les
        // cas d'exeptions (ex: si on ne met pas de valeur)
        try {
            switch (typeOperation) {
                case DEPOT:
                    operation = new OperationDepot(getMontant());
                    break;
                case RETRAIT:
                    operation = new OperationRetrait(getMontant());
                    break;
                case FACTURE:
                    operation= new OperationFacture(getMontant(),getNumeroFacture(texteNumerofacture),getDescription(texteDescription));
                    break;
                case TRANSFER:
                    operation = new OperationTransfer(getMontant(),getNumeroCompteDestinataire(compteDestinataire));
                    break;
            }
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
     * Fait par Mathis Odjo'o Ada
     * Méthode configurant les champs de saisie et des étiquettes pour l'opération FACTURE
     */
    private void dessinerFacture() {
        JPanel champNumeroFacture = new JPanel();
        champNumeroFacture.add(new JLabel("Numero de facture : "), SwingConstants.CENTER);
        texteNumerofacture = new JTextField(10);
        champNumeroFacture.add(texteNumerofacture);
        content.add(champNumeroFacture);

        JPanel champDescriptionFacture = new JPanel();
        champDescriptionFacture.add(new JLabel("Description : "), SwingConstants.CENTER);
        texteDescription = new JTextField(14);
        champDescriptionFacture.add(texteDescription);
        content.add(champDescriptionFacture);
    }

    /** Fait par Mathis Odjo'o Ada
     * Méthode configurant les champs de saisie et des étiquettes pour l'opération TRANSFER
     */
    private void dessinerTransfert(){
        JPanel champCompteDestinataire = new JPanel();
        champCompteDestinataire.add(new JLabel("Compte Destinataire : "), SwingConstants.CENTER);
        compteDestinataire = new JTextField(14);
        champCompteDestinataire.add(compteDestinataire);
        content.add(champCompteDestinataire);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Accesseur: Récupère la description de la facture
     *
     * @param texteDescription champ de texte pour la description de la facture
     * @return le champ de texte saisi dans 'texteDescription' par le client
     */
    private String getDescription(JTextField texteDescription){
        System.out.println(texteDescription.getText());
        return texteDescription.getText();
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Accesseur: Récupère le numéro de la facture
     *
     * @param numerofacture  numéro de la facture saisie
     * @return le numéro de la facture saisi par le client
     */
    private String getNumeroFacture(JTextField numerofacture){
        System.out.println(numerofacture.getText());
        return numerofacture.getText();
    }

    /**
     * Fait par Nancy Nguyen
     * Accesseur: Récupère le numéro de compte du compte destinataire
     *
     * @param compteDestinataire  nnuméro du compte destinataire
     * @return le numéro du compte destinataire
     */
    private String getNumeroCompteDestinataire(JTextField compteDestinataire){
        System.out.println(compteDestinataire.getText());
        return compteDestinataire.getText();
    }

}