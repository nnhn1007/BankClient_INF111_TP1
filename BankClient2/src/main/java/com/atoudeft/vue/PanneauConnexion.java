package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauConnexion extends JPanel {
    private final static int TRENTE = 30, TROIS = 3, UN = 1, DEUX_CENT = 200;
    private JTextField txtNumCompteClient, txtNip;
    private JButton bNouveau, bConnecter;

    public PanneauConnexion() {
        JLabel lNumCompteClient = new JLabel("Numero compte-client : "),
                lNip = new JLabel("NIP : ");
        txtNumCompteClient = new JTextField(TRENTE);
        txtNip = new JTextField(TRENTE);

        txtNumCompteClient.setBorder(BorderFactory.createTitledBorder("Numero compte-client : "));
        txtNip.setBorder(BorderFactory.createTitledBorder("NIP : "));

        bNouveau = new JButton("Créer compte");
        bConnecter = new JButton("Connexion");

        bNouveau.setActionCommand("NOUVEAU");
        bConnecter.setActionCommand("CONNECT");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel pTout = new JPanel(new GridLayout(TROIS,UN));

        p1.add(txtNumCompteClient);
        p2.add(txtNip);
//
//        p2.add(lNip);
//        p2.add(txtNip);

        p3.add(bNouveau);
        p3.add(bConnecter);

        this.setLayout(new BorderLayout());
        pTout.add(p1);
        pTout.add(p2);
        pTout.add(p3);
        this.add(pTout, BorderLayout.NORTH);
        this.setBorder(BorderFactory.createLineBorder(new Color(0x00000000,true),DEUX_CENT));
    }
    public void setEcouteur(ActionListener ecouteur) {
        bNouveau.addActionListener(ecouteur);
        bConnecter.addActionListener(ecouteur);
    }
    public String getNumeroCompteClient() {
        return this.txtNumCompteClient.getText();
    }
    public String getNip() {
        return this.txtNip.getText();
    }
    public void effacer() {
        this.txtNumCompteClient.setText("");
        this.txtNip.setText("");
    }
}
