package org.example.demo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CommandeArticle {

    private StringProperty nomArticle;
    private IntegerProperty quantite;
    private int idArticle;  // ID de l'article pour la suppression

    // Constructeur
    public CommandeArticle(String nomArticle, int quantite, int idArticle) {
        this.nomArticle = new SimpleStringProperty(nomArticle);
        this.quantite = new SimpleIntegerProperty(quantite);
        this.idArticle = idArticle;  // Initialisation de l'ID
    }

    // Getters pour les propriétés JavaFX
    public StringProperty nomArticleProperty() {
        return nomArticle;
    }

    public IntegerProperty quantiteProperty() {
        return quantite;
    }

    // Getters et Setters pour idArticle
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    // Getter pour nomArticle
    public String getNomArticle() {
        return nomArticle.get();
    }

    // Setter pour nomArticle
    public void setNomArticle(String nomArticle) {
        this.nomArticle.set(nomArticle);
    }

    // Getter pour quantite
    public int getQuantite() {
        return quantite.get();
    }

    // Setter pour quantite
    public void setQuantite(int quantite) {
        this.quantite.set(quantite);
    }
}
