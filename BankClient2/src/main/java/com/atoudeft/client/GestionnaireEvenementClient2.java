package com.atoudeft.client;

import com.atoudeft.commun.evenement.Evenement;
import com.atoudeft.commun.evenement.GestionnaireEvenement;
import com.atoudeft.commun.net.Connexion;
import com.atoudeft.vue.panneauHistoriqueDuCompte;
import com.atoudeft.vue.PanneauPrincipal;
import com.programmes.MainFrame;

import javax.swing.*;

public class GestionnaireEvenementClient2 implements GestionnaireEvenement {
    private Client client;
    private PanneauPrincipal panneauPrincipal;

    /**
     * Construit un gestionnaire d'événements pour un client.
     *
     * @param client Client Le client pour lequel ce gestionnaire gère des événements
     */
    public GestionnaireEvenementClient2(Client client, PanneauPrincipal panneauPrincipal) {

        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
        this.client.setGestionnaireEvenement(this);
    }

    @Override
    public void traiter(Evenement evenement) {
        Object source = evenement.getSource();
        Connexion cnx;
        String typeEvenement, arg, str;
        int i;
        String[] t;
        MainFrame fenetre;

        if (source instanceof Connexion) {
            cnx = (Connexion) source;
            typeEvenement = evenement.getType();
            switch (typeEvenement) {
                /******************* COMMANDES GÉNÉRALES *******************/
                case "END": //Le serveur demande de fermer la connexion
                    client.deconnecter(); //On ferme la connexion
                    break;
                /******************* CREATION et CONNEXION *******************/
                case "HIST": //Le serveur a renvoyé
                    panneauPrincipal.setVisible(true);
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(panneauPrincipal, new panneauHistoriqueDuCompte(arg), "Historique" +
                            " du compte", JOptionPane.PLAIN_MESSAGE);
                    cnx.envoyer("LIST");
                    break;
                case "OK":
                    panneauPrincipal.setVisible(true);
                    fenetre = (MainFrame) panneauPrincipal.getTopLevelAncestor();
                    fenetre.setTitle(MainFrame.TITRE);//+" - Connecté"
                    break;
                case "NOUVEAU":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal, "Nouveau refusé");
                    } else {
                        panneauPrincipal.cacherPanneauConnexion();
                        panneauPrincipal.montrerPanneauCompteClient();
                        str = arg.substring(arg.indexOf("OK") + 2).trim();
                        panneauPrincipal.ajouterCompte(str);
                    }
                    break;
                case "CONNECT":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal, "Connexion refusée");
                    } else {
                        panneauPrincipal.cacherPanneauConnexion();
                        panneauPrincipal.montrerPanneauCompteClient();
                        str = arg.substring(arg.indexOf("OK") + 2).trim();
                        t = str.split(":");
                        for (String s : t) {
                            panneauPrincipal.ajouterCompte(s.substring(0, s.indexOf("]") + 1));
                        }
                    }
                    break;
                /******************* SÉLECTION DE COMPTES *******************/
                case "EPARGNE":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal, "Création de compte" +
                                " épargne refusée");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(panneauPrincipal, "EPARGNE " + arg);
                        str = arg.substring(arg.indexOf("OK") + 2).trim();
                        panneauPrincipal.ajouterCompte(str);
                    }
                    break;
                case "SELECT": // Question 3.1 - Nancy Nguyen et Mathis Odjo'o Ada
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal, "Connexion refusée");
                        break;
                    } else {
                        arg = evenement.getArgument();
                        arg = arg.substring(arg.indexOf("SELECT") + 3).trim();
                        double solde =  extractionSolde(arg);
                        panneauPrincipal.setSoldeCompte(String.valueOf(solde));
                        JOptionPane.showMessageDialog(panneauPrincipal, "SELECT " + arg);
                        break;
                    }
                    /******************* OPÉRATIONS BANCAIRES *******************/
                case "DEPOT":
                    arg = evenement.getArgument();
                    arg = arg.substring(arg.indexOf("DEPOT") + 3).trim();
                    panneauPrincipal.setSoldeCompte(arg);
                    JOptionPane.showMessageDialog(panneauPrincipal, "DEPOT " + arg);

                    break;
                case "RETRAIT":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal, "RETRAIT REFUSÉ !");
                    } else {
                        arg = arg.substring(arg.indexOf("RETRAIT") + 3);
                        panneauPrincipal.setSoldeCompte(arg);
                        JOptionPane.showMessageDialog(panneauPrincipal, "RETRAIT : " + arg);
                    }
                    break;
                case "FACTURE":
                    arg = evenement.getArgument();
                    if(arg.trim().startsWith("NO")){
                        JOptionPane.showMessageDialog(panneauPrincipal, "FACTURE REFUSÉ !");
                    } else {
                        arg = arg.substring(arg.indexOf("FACTURE") + 3);
                        panneauPrincipal.setSoldeCompte(arg);
                        JOptionPane.showMessageDialog(panneauPrincipal, "FACTURE : " + arg);
                    }
                    break;
                case "TRANSFER": //Question 4.3 - Nancy Nguyen
                    arg = evenement.getArgument();
                    if(arg.trim().startsWith("NO")){
                        JOptionPane.showMessageDialog(panneauPrincipal,"TRANFERT REFUSÉ");
                    } else {
                        arg = arg.substring(arg.indexOf("TRANSFER") + 3);
                        panneauPrincipal.setSoldeCompte(arg);
                        JOptionPane.showMessageDialog(panneauPrincipal, "TRANSFER : " + arg);
                    }
                    break;
                /******************* TRAITEMENT PAR DÉFAUT *******************/
                default:
                    System.out.println("RECU : " + evenement.getType() + " " + evenement.getArgument());
            }
        }
    }

    /**
     * Question 3.1 - Nancy Nguyen
     * @param arg
     * @return le solde
     */
    private double extractionSolde(String arg){
        String[] t = arg.split(" ");
        double solde = Double.parseDouble(t[1]);
        return solde;
    }
}
