package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private Panel panel;

    public EcouteurOperationsCompte(Client client, Panel panneauClient) {
        this.client = client;
        this.panel=panneauClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //à compléter :

    }
}
