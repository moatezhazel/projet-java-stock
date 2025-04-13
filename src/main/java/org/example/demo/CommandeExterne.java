package org.example.demo;

import java.time.LocalDate;

public class CommandeExterne {

    private int id;
    private String fournisseur;  // Identifiant ou nom du fournisseur
    private LocalDate dateCommande;  // Date de la commande

    public CommandeExterne(int id, String fournisseur, LocalDate dateCommande) {
        this.id = id;
        this.fournisseur = fournisseur;
        this.dateCommande = dateCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande Externe{" +
                "id=" + id +
                ", fournisseur='" + fournisseur + '\'' +
                ", dateCommande=" + dateCommande +
                '}';
    }
}
