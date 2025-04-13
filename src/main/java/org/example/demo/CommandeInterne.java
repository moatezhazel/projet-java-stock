package org.example.demo;


import java.time.LocalDate;

public class CommandeInterne {

    private int id;
    private String service;  // Identifiant ou nom du service
    private LocalDate dateCommande;  // Date de la commande

    public CommandeInterne(int id, String service, LocalDate dateCommande) {
        this.id = id;
        this.service = service;
        this.dateCommande = dateCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande Interne{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", dateCommande=" + dateCommande +
                '}';
    }
}

