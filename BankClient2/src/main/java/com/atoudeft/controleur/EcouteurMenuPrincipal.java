package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauConfigServeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class EcouteurMenuPrincipal implements ActionListener {
    private Client client;
    private JFrame fenetre;

    public EcouteurMenuPrincipal(Client client, JFrame fenetre) {
        this.client = client;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String action;
        String alias;
        int res;

        if (source instanceof JMenuItem) {
            action = ((JMenuItem) source).getActionCommand();
            switch (action) {
                case "CONNECTER":
                    if (!client.isConnecte()) {
                        if (!client.connecter()) {
                            JOptionPane.showMessageDialog(fenetre, "Le serveur ne répond pas");
                            break;
                        }
                    }
                    break;
                case "DECONNECTER":
                    if (!client.isConnecte())
                        break;
                    res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                            "Confirmation Déconnecter",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (res == JOptionPane.OK_OPTION) {
                        client.deconnecter();
                    }
                    break;
                case "CONFIGURER":
                    //Question 1.3 - Fait par Mathis Odjo'o Ada
                    if (!client.isConnecte()) { // Vérifie si l'utilisateur n'est pas déja connecté sur un serveur
                        boolean config = true;
                        PanneauConfigServeur configurationPanel = new PanneauConfigServeur(client.getAdrServeur(), client.getPortServeur());
                        while (config) {
                            try {
                                res = JOptionPane.showConfirmDialog(fenetre, configurationPanel,
                                        "Configuration serveur", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                                if (res == JOptionPane.OK_OPTION) {
                                    client.setAdrServeur(configurationPanel.getAdresseServeur());
                                    int port = Integer.parseInt(configurationPanel.getPortServeur());
                                    client.setPortServeur(port);
                                    config = false;
                                }
                                else if (res == JOptionPane.CANCEL_OPTION) { break; }
                                //Si l'utilisateur rentre un port avec des lettres ou si le port est null
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null,"Veuillez rentrer un numéro de port valide"
                                ,"Port invalide",JOptionPane.ERROR_MESSAGE); }
                        }
                    }
                    break;

                case "QUITTER":
                    if (client.isConnecte()) {
                        res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                                "Confirmation Quitter",
                                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (res == JOptionPane.OK_OPTION) {
                            client.deconnecter();
                            System.exit(0);
                        }
                    } else
                        System.exit(0);
                    break;
            }
        }
    }
}