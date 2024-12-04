package com.atoudeft.controleur;

import com.atoudeft.Operation.Operation;
import com.atoudeft.client.Client;

import javax.swing.*;

import com.atoudeft.Operation.TypeOperation;
import com.atoudeft.vue.PanneauOperation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    JPanel panneauCompteClient;
    PanneauOperation panneauOperation;
    Operation operation;

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
        enleverDerniereOperation();

        switch (commande) {
            case "EPARGNE":
                client.envoyer(commande);
                break;
            case "DEPOT":
                panneauOperation = new PanneauOperation(TypeOperation.DEPOT, this);
                break;
            case "RETRAIT":
                panneauOperation = new PanneauOperation(TypeOperation.RETRAIT, this);
                break;
            case "TRANSFER":
                panneauOperation = new PanneauOperation(TypeOperation.TRANSFER, this);
                break;
            case "FACTURE":
                panneauOperation = new PanneauOperation(TypeOperation.FACTURE, this);
                break;
            case "HIST":
                client.envoyer("HIST");
                break;
            case "CONFIRMER":
                assert panneauOperation != null;
                operation = panneauOperation.getOperation();
                if (operation != null) {
                    client.envoyer(operation.toString());
                }
                break;
        }
        redessinerInterface();
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Méthode qui redessine l'interface ;
     *      - ajout du panneau d'opérations au panneauCompteClient
     *      - Réorganisation des composantes
     *      - Mise-à-jour de l'affichage
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
     * Méthode qui enlève le dernier panneau d'opérations du panneauCompteClient, permettant d'éviter les doublons
     */
    private void enleverDerniereOperation() {
        if (panneauOperation != null) {
            panneauCompteClient.remove(panneauOperation);
        }
    }
}



