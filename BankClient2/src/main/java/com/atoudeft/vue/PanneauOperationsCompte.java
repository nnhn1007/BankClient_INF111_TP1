package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauOperationsCompte extends JPanel {
    private JButton bEpargne, bDepot, bRetrait, bTransfert, bFacture, bHistorique;
    private JLabel lblSolde;

    public PanneauOperationsCompte() {
        bEpargne = new JButton("Créer compte épargne");
        bDepot = new JButton("Déposer");
        bRetrait = new JButton("Retirer");
        bTransfert = new JButton("Transferer");
        bFacture = new JButton("Payer Facture");
        bHistorique = new JButton("Historique du compte");
        lblSolde = new JLabel("Solde : ");

        bEpargne.setActionCommand("EPARGNE");
        bDepot.setActionCommand("DEPOT");
        bRetrait.setActionCommand("RETRAIT");
        bTransfert.setActionCommand("TRANSFER");
        bFacture.setActionCommand("FACTURE");
        bHistorique.setActionCommand("HIST");

        //à compléter :
        JPanel panneauSolde = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panneauSolde.add(lblSolde);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(lblSolde);

        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(panneauSolde);
        this.add(lblSolde);
        this.add(bEpargne);
        this.add(bDepot);
        this.add(bRetrait);
        this.add(bTransfert);
        this.add(bFacture);
        this.add(bHistorique);
    }

    public void setEcouteur(ActionListener ecouteur) {
        bEpargne.addActionListener(ecouteur);
        bDepot.addActionListener(ecouteur);
        bRetrait.addActionListener(ecouteur);
        bTransfert.addActionListener(ecouteur);
        bFacture.addActionListener(ecouteur);
        bHistorique.addActionListener(ecouteur);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Mutateur: Méthode qui permet de mettre à jour l'affichage du solde actuel du GUI sur le panneau
     * @param solde solde du compte à afficher
     */
    public void SetSolde(double solde) {
        lblSolde.setText("Solde : " + solde);
    }
}
