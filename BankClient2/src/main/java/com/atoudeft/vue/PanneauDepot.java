package com.atoudeft.vue;

import com.atoudeft.Operation.Operation;
import com.atoudeft.Operation.OperationDepot;
import com.atoudeft.Operation.TypeOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauDepot extends JPanel {
    private JLabel txtmontant;
    private JTextField montant;
    private JButton btnValider;
    private JButton btnAnnuler;
    private TypeOperation typeOperation;


    public PanneauDepot(TypeOperation typeOp, String action) {
        this.typeOperation=typeOp;
        creerChampMontant();
        creerBoutons();
        creerPanel();
    }


    public void setEcouteur(ActionListener ecouteur) {
        btnValider.addActionListener(ecouteur);
        btnAnnuler.addActionListener(ecouteur);
    }

    private void creerChampMontant() {
        final int LARGEUR_CHAMP = 10;
        txtmontant = new JLabel("Montant : ",SwingUtilities.RIGHT);
        montant = new JTextField(LARGEUR_CHAMP);
    }

    private void creerBoutons() {
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
    public Operation operation(){
        return new OperationDepot(getMontant());
    }
    public double getMontant(){
        return Double.parseDouble(montant.getText());
    }
}