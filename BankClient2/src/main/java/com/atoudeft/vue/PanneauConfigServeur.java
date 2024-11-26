package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    /**
     * Question 1.2 - Nancy Nguyen
     * Constructeur par paramètres de la classe PanneauConfigServeur
     * Initialise les champs de texte pour l'adresse  IP et le port d'écoute du serveur
     * @param adr adresse IP
     * @param port Port d'écoute du serveur
     */
    public PanneauConfigServeur(String adr, int port) {
        //1. Définition du champ de texte txtAdrServeur, et des valeurs initiales
        txtAdrServeur = new JTextField(20);
        txtAdrServeur.setText(adr); //Afficher l'adresse IP

        //2. Définition du champ de texte txtNumPort, et des valeurs initiales
        txtNumPort = new JTextField(10);
        txtNumPort.setText(String.valueOf(port)); //Afficher le port

        //3. Configuration du panneau
        setLayout(new GridLayout(2,6)); //

        //4. Ajout des étiquettes et des champs de textes du panneau
        add(new JLabel("Adresse IP: "));
        add(txtAdrServeur);
        add(new JLabel("Port: "));
        add(txtNumPort);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
