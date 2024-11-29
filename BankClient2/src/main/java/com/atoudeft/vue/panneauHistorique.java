package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class panneauHistorique extends JPanel {
    public panneauHistorique(String historique) {
        if(historique.isEmpty()){
            historique="L'historique du compte est vide.";

            JTextArea histogramme= new JTextArea(historique);
            histogramme.setEditable(false);

            JScrollPane defilement= new JScrollPane(histogramme);
            add(defilement , BorderLayout.SOUTH);

        }
    }
}
