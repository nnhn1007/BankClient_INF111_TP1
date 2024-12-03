package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class panneauHistoriqueDuCompte extends JPanel {
    public panneauHistoriqueDuCompte(String historique) {
            JTextArea histogramme = new JTextArea(historique);
            histogramme.setEditable(false);

            JScrollPane defilement = new JScrollPane(histogramme);
            add(defilement, BorderLayout.CENTER);
        }
    }
