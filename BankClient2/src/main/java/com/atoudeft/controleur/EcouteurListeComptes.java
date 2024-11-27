package com.atoudeft.controleur;

import com.atoudeft.client.Client;

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
    private JList<String> jList; //ajout pour la question 3.1

    //constructeur modifié
    public EcouteurListeComptes(Client client, JList<String> jList) {
        this.client = client;
        this.jList = jList; //ajout pour la question 3.1
    }

    /**
     * Question 3.1 - Nancy Nguyen
     * M
     * @param evt the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        //1. Vérifier si l'événement est bien un double-clic
        if(evt.getClickCount() == 2){

            //2. Récupérer le compte sélectionné
            String compteSelectionne = (String) jList.getSelectedValue();
            if(!compteSelectionne.isEmpty()){
                client.envoyer("SELECT");
            } else {
                client.envoyer("SELECT NO");
            }
        }
    }
}
