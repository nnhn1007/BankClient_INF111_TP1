package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauDepot;

import javax.swing.*;

import com.atoudeft.Operation.TypeOperation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private final Client client;
    private PanneauDepot panneauDepot;
    private JPanel panneauCompteClient;


    public EcouteurOperationsCompte(Client client, JPanel panneauClient) {
        this.client = client;
        this.panneauCompteClient=panneauClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String action;
        action = ((JButton) source).getActionCommand();
        System.out.println(action);
        switch (action) {
            case "EPARGNE":
                client.lire();
                client.envoyer(action);
                break;
            case "SELECT":
                caseSelect(action);
                break;
            case "DEPOT":
                caseDepot(action);
                break;
            case "RETRAIT":
                client.envoyer(action);
                break;
            case "FACTURE":
                break;
            case "TRANSFER":
                break;
            case "HIST":
                client.envoyer(action);
                break;
            /******************* TRAITEMENT PAR DÉFAUT *******************/
            default:
                System.out.println("COMMANDE: " + e.getActionCommand());
        }

    }

    private void caseSelect(String action) {
      client.envoyer(action);
    }

    private void caseDepot(String action) {
      panneauDepot = new PanneauDepot(TypeOperation.DEPOT,action);
    }
}

