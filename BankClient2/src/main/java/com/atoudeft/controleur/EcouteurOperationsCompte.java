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
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        enleverDerniereOperation();

        switch (commande) {
            case "EPARGNE":
                client.envoyer(commande);
                break;
            case "DEPOT":
                //TODO PS :this permet de rediriger les actions
                //TODO de PanneauOperation vers le actionPerformed ici  (enlever le TODO à la fin).
                panneauOperation = new PanneauOperation(TypeOperation.DEPOT, this);
                break;
            case "RETRAIT":
                panneauOperation = new PanneauOperation(TypeOperation.RETRAIT, this);
                break;
            case "TRANSFER":
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

    private void redessinerInterface() {
        if (panneauOperation != null) {
            panneauCompteClient.add(panneauOperation, BorderLayout.CENTER);
            panneauCompteClient.revalidate(); // Réorganise les composants
            panneauCompteClient.repaint(); // Rafraîchit l'affichage
        }
    }

    private void enleverDerniereOperation() {
        if (panneauOperation != null) {
            panneauCompteClient.remove(panneauOperation);
        }
    }
}



