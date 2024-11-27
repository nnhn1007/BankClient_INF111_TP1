package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauRetrait extends JPanel {
    private JLabel txtmontant;
    private JTextField montant;
    private JButton btnValider;
    private JButton btnAnnuler;

    public PanneauRetrait() {
        creerChampMontant();
        creerBouton();
        creerPanel();
    }

    public void setEcouteur(ActionListener ecouteur) {
        btnValider.addActionListener(ecouteur);
        btnAnnuler.addActionListener(ecouteur);
    }

    private void creerChampMontant() {
        final int LARGEUR_CHAMP = 10;
        txtmontant = new JLabel("Montant : ");
        montant = new JTextField(LARGEUR_CHAMP);
    }

    private void creerBouton() {
        btnValider = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
    }

    private void creerPanel() {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(txtmontant);
        add(montant);
        add(btnValider);
        add(btnAnnuler);
    }
}