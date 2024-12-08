package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *  La classe panneauHistoriqueDuCompte est un panneau permettant d'afficher l'historique des opérations d'un compte
 *
 * @author Mathis Odjo'o Ada
 */
public class PanneauHistoriqueDuCompte extends JPanel {

    /**
     * Fait par Mathis Odjo'o Ada et Melissa Sehad
     * Constructeur de la classe panneauHistoriqueDuCompte
     *
     * @param historique chaîne caractères affaichant l'historique des opérations d'un compte
     */
    public PanneauHistoriqueDuCompte(String historique) {
        JTextArea histogramme = new JTextArea(historique);
        histogramme.setEditable(false); //L'historique ne doit pas pouvoir être édité par l'utilisateur

        JScrollPane defilement = new JScrollPane(histogramme);
        add(defilement, BorderLayout.CENTER);
    }
}
