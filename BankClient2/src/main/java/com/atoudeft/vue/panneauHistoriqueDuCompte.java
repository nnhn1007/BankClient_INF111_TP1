package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *  La classe panneauHistoriqueDuCompte est un panneau permettant d'afficher l'historique des opérations d'un compte
 *
 * @author Mathis Odjo'o Ada
 */
public class panneauHistoriqueDuCompte extends JPanel {

    /**
     * Constructeur de la classe panneauHistoriqueDuCompte
     * @param historique chaîne caractères affaichant l'historique des opérations d'un compte
     */
    public panneauHistoriqueDuCompte(String historique) {
        JTextArea histogramme = new JTextArea(historique);
        histogramme.setEditable(false);

        JScrollPane defilement = new JScrollPane(histogramme);
        add(defilement, BorderLayout.CENTER);
    }
}
