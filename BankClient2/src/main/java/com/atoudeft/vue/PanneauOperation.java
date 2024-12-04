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
    private JTextField destinataire;

    /**
     * @param type
     * @param ecouteur
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

    /**
     * @param ecouteur
     */
    private void creerButton(ActionListener ecouteur) {
        btnConfirmer = new JButton("CONFIRMER");
        btnConfirmer.setActionCommand("CONFIRMER");
        btnConfirmer.addActionListener(ecouteur);
    }

    /**
     *
     */
    private void creerPanels() {

        content.setLayout(new GridLayout(COLONNE, LIGNE));
        content.add(pMontant);
        content.add(btnConfirmer);
    }

    /**
     *
     */
    private void creerChampsMontant() {
        pMontant = new JPanel();
        montant = new JTextField(8);
        pMontant.add(new JLabel("Montant:"));
        pMontant.add(montant, BorderLayout.SOUTH);
    }

    /**
     * @return
     */
    private double getMontant() {
        return Double.parseDouble(montant.getText());
    }

    /**
     *
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
                    operation= new OperationFacture(getMontant(),getNumeroFacture(texteNumerofacture),getDesription(texteDescription));
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
    private String getDesription(JTextField texteDescription){
        System.out.println(texteDescription.getText());
        return texteDescription.getText();
    }
    private String getNumeroFacture(JTextField numerofacture){
        System.out.println(numerofacture.getText());
        return numerofacture.getText();
    }

}