package com.atoudeft.controleur;

import com.atoudeft.Operation.Operation;
import com.atoudeft.client.Client;

import javax.swing.*;

import com.atoudeft.Operation.TypeOperation;
import com.atoudeft.vue.PanneauOperations;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private final JPanel panneauCompteClient;
    private PanneauOperations panneauOperation;
    private Operation operation;

    /**
     * Fait par Mathis Odjo'op
     * Constructeur des différentes Panneau Opérations de la banque.
     *
     * @param client              le client associé au compte bancaire.
     * @param panneauCompteClient le panneau d'affichage principal pour les opérations (GUI).
     */
    public EcouteurOperationsCompte(Client client, JPanel panneauCompteClient) {
        this.client = client;
        this.panneauCompteClient = panneauCompteClient;
    }

    @Override
    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui traite les commandes envoyées par le GUI
     */
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        enleverPanneauOperationPrecedent();

        switch (commande) {
            case "EPARGNE", "HIST":
                client.envoyer(commande);
                break;
            case "DEPOT", "RETRAIT", "TRANSFER", "FACTURE":
                choirirPanneauOperation(TypeOperation.valueOf(commande));
                break;
            case "VALIDER":
                validerOperation();
                break;
            default: System.err.println("Commande inconnue : " + commande);
        }
        redessinerInterface();
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui redessine l'interface ;
     * - ajout du panneau d'opérations au panneauCompteClient
     * - Réorganisation des composantes
     * - Mise-à-jour de l'affichage
     */
    private void redessinerInterface() {
        if (panneauOperation != null) {
            panneauCompteClient.add(panneauOperation, BorderLayout.CENTER);
            panneauCompteClient.revalidate(); // Réorganise les composants
            panneauCompteClient.repaint(); // Rafraîchit l'affichage
        }
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui enlève le dernier panneau d'opérations du panneauCompteClient,
     * permettant d'éviter les doublons de panneau
     */
    private void enleverPanneauOperationPrecedent() {
        if (panneauOperation != null) {
            panneauCompteClient.remove(panneauOperation);
        }
    }

    private void choirirPanneauOperation(TypeOperation type) {
        panneauOperation = new PanneauOperations(type, this);
    }

    private void validerOperation() {
        if (panneauOperation != null) {
            operation = panneauOperation.getOperation();
            if (operation != null) {
                client.envoyer(operation.toString());
            }
        }
    }
}



