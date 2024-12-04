package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauOperationsCompte;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;
    //ajouts pour la question 3.1
    private JList<String> jList;

    //constructeur modifié
    public EcouteurListeComptes(Client client, JList<String> jList) {
        this.client = client;
        this.jList = jList; //ajout pour la question 3.1
    }

    /**
     * Question 3.1 - Nancy Nguyen
     * Méthode vérifiant si l'événement est un double-clic, et extrait le type de compte sélectionné.
     * Renvoie la commande SELECT au compte sélectionné
     *
     * @param evt l'événement à traiter
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        //1. Vérifier si l'événement est bien un double-clic
        if (evt.getClickCount() == 2) {

            //2. Récupérer le compte sélectionné
            String compteSelectionne = (String) jList.getSelectedValue();

            //3. Recuperation du type de compte
            if (compteSelectionne != null) {
                String typeCompte = extractionTypeCompte(compteSelectionne);
                if(typeCompte.equals("CHEQUE")) {
                    client.envoyer("SELECT cheque");
                } else if (typeCompte.equals("EPARGNE")) {
                    client.envoyer("SELECT epargne");
                }
            }
        }
    }

    /**
     * Question 3.1 - Fait par Nancy Nguyen
     * Méthode qui extrait le type de compte
     *
     * @param compte compte sélectionné
     * @return le type de compte
     */
    private String extractionTypeCompte(String compte) {
        int indexDebut = compte.indexOf('[');
        int indexFin = compte.indexOf(']');

        if (indexDebut != -1 && indexFin != -1 && indexDebut < indexFin) {
            //Extraire le type de compte entre les crochets
            return compte.substring(indexDebut + 1, indexFin);
        }
        return compte;
    }
}


