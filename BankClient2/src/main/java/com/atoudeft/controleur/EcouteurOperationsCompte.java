package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private JPanel panel;

    public EcouteurOperationsCompte(Client client, JPanel panneauClient) {
        this.client = client;
        this.panel=panneauClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String action;
        action = ((JButton) source).getActionCommand();

        switch (action) {
            case "EPARGNE":
                client.lire();
                client.envoyer(action);
                break;
            case "SELECT":
                client.envoyer(action);
                break;
            case "DEPOT", "RETRAIT":
                client.envoyer(action);
                break;
            case "FACTURE":
                break;
            case "TRANSFER":
                break;
            case "HIST":
                break;
            /******************* TRAITEMENT PAR DÉFAUT *******************/
            default:
                System.out.println("COMMANDE: " + e.getActionCommand());
        }

    }
}

