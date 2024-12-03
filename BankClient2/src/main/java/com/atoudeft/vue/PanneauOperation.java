package com.atoudeft.vue;

import com.atoudeft.Operation.TypeOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.atoudeft.Operation.*;

/**
 *
 */
public class PanneauOperation extends JPanel {
    private static final int ESPACE = 15, COLONNE = 0, LIGNE = 1;
    private JButton btnConfirmer;
    private TypeOperation typeOperation;
    private JPanel pMontant;
    private JLabel tete;
    private JPanel content;
    private JTextField montant;
    private JTextField facture;
    private JTextField description;
    private JTextField destinataire;

    public PanneauOperation(TypeOperation type, ActionListener ecouteur) {
        try {

            switch (type) {

                case DEPOT, RETRAIT:
                    this.typeOperation = type;
                    creerButton(ecouteur);
                    creerChampsMontant(type);
                    creerPanels();
                    add(content, BorderLayout.CENTER);
                    break;

                case FACTURE:

            }

        } catch(NullPointerException operationInexistante) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ce type d'opération n'est pas dans la liste disponible : "+operationInexistante,
                    "Erreur de saisie",
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
        content = new JPanel();
        content.setLayout(new GridLayout(COLONNE, LIGNE, 5, 5));
        content.add(tete);
        content.add(pMontant);
        content.add(btnConfirmer);
    }

    /**
     * @param typeOperation
     */
    private void creerChampsMontant(TypeOperation typeOperation) {
        tete = new JLabel(typeOperation.getAction(), SwingConstants.CENTER);
        pMontant = new JPanel();
        montant = new JTextField(8);
        pMontant.add(new JLabel("Montant:"));
        pMontant.add(montant, BorderLayout.SOUTH);
    }

    /**
     * @return
     */
    public double getMontant() {
        return Double.parseDouble(montant.getText());
    }

    /**
     *
     */
    public Operation getOperation() {
        Operation operation = null;
        //TODO peut être mettre le code ici en TRY catch pour gérer les
        // cas d'exeptions (ex: si on ne met pas de valeur)
        switch (typeOperation) {
            case DEPOT:
                operation = new OperationDepot(getMontant());
                break;
            case RETRAIT:
                operation = new OperationRetrait(getMontant());
                break;
        }
        return operation;
    }

}