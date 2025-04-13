package org.example.demo;

import java.time.LocalDate;

public class Article {
    private int ref, qte, qteMin;
    private String nom, categorie, local;
    private LocalDate date;

    public Article(int ref, String nom, String categorie, int qte, String local, int qteMin, LocalDate date) {
        this.ref = ref;
        this.qte = qte;
        this.qteMin = qteMin;
        this.nom = nom;
        this.categorie = categorie;
        this.local = local;
        this.date = date;
    }

    public int getRef() {
        return ref;
    }

    public int getQte() {
        return qte;
    }

    public int getQteMin() {
        return qteMin;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getLocal() {
        return local;
    }

    public LocalDate getDate() {
        return date;
    }
}