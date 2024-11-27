package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;

    /**
     * Constructeur de l'écouteur de la liste des comptes.
     *
     * @param client l'objet Client pour communiquer avec le serveur
     */
    public EcouteurListeComptes(Client client) {
        this.client = client;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // Vérifie si l'événement est un double-clic
        if (evt.getClickCount() == 2) {
            // Source de l'événement
            JList<?> liste = (JList<?>) evt.getSource();
            int compteSelect = liste.locationToIndex(evt.getPoint()); // Récupère l'index de l'élément cliqué

            if (compteSelect!= -1) { // Vérifie que l'élément est valide car locationToIndex retourne -1
                                     // si l'utilisateur ne double click pas sur les comptes;
                client.envoyer("SELECT");
            }
        }
    }
}