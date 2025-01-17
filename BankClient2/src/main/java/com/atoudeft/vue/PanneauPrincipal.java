package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.Operation.TypeOperation;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;

import javax.swing.*;
import java.awt.*;

/**
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class PanneauPrincipal extends JPanel {
    private static final int DEUX_CENT_CINQUANTE = 250, CINQ_CENT = 500;
    private Client client;
    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;
    private PanneauOperationsCompte panneauOperationsCompte;

    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JDesktopPane bureau;

    public PanneauPrincipal(Client client) {
        this.client = client;

        panneauConnexion = new PanneauConnexion();
        panneauConnexion.setEcouteur(new EcouteurConnexion(client, panneauConnexion));
        panneauCompteClient = new JPanel();

        /** Fait par Mathis Odjo'o Ada
        Création des panneaux d'opérations
        */
        panneauOperationsCompte = new PanneauOperationsCompte();

        /**
         * Fait par Mathis Odjo'o Ada
         * Création d'un EcouteurOperationsCompte pour les différentes opérations (sinon ne compile pas)
         */
        EcouteurOperationsCompte ecouteurOperationsCompte = new EcouteurOperationsCompte(client, panneauCompteClient);
        panneauOperationsCompte.setEcouteur(ecouteurOperationsCompte);

        panneauCompteClient.setLayout(new BorderLayout());
        panneauCompteClient.setBackground(Color.WHITE);
        panneauOperationsCompte.setBackground(Color.WHITE);

        numerosComptes = new DefaultListModel<>();

        jlNumerosComptes = new JList<>(numerosComptes);
        jlNumerosComptes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        jlNumerosComptes.setPreferredSize(new Dimension(DEUX_CENT_CINQUANTE, CINQ_CENT));

        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(jlNumerosComptes, BorderLayout.WEST);

        //Enregistrement de l'écouteur de souris:
        jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client, jlNumerosComptes));

        this.setLayout(new BorderLayout());

        this.add(panneauConnexion, BorderLayout.NORTH);
        this.add(panneauCompteClient, BorderLayout.CENTER);
        panneauCompteClient.setVisible(false);
    }

    /**
     * Vide les éléments d'interface du panneauPrincipal.
     */
    public void vider() {
        this.numerosComptes.clear();
        this.bureau.removeAll();
    }

    public void cacherPanneauConnexion() {
        panneauConnexion.effacer();
        panneauConnexion.setVisible(false);
    }

    public void montrerPanneauConnexion() {
        panneauConnexion.setVisible(true);
    }

    public void cacherPanneauCompteClient() {
        panneauCompteClient.setVisible(false);
        this.numerosComptes.clear();
    }

    public void montrerPanneauCompteClient() {
        panneauCompteClient.setVisible(true);
    }

    /**
     * Affiche un numéro de compte dans le JList des comptes.
     *
     * @param str chaine contenant le numéros de compte
     */
    public void ajouterCompte(String str) {
        numerosComptes.addElement(str);
    }

    /**
     * Fait par Mathis Odjo'o Ada
     * Met à jour le solde du compte dans le panneau des opérations (panneauOperationsCompte)
     *
     * @param arg chaîne représentant le solde du compte à afficher
     */
    public void setSoldeCompte(String arg) {
        double solde = (Double.parseDouble(arg));
        this.panneauOperationsCompte.SetSolde(solde);
    }
}