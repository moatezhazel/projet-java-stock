package org.example.demo;
public class CommandeExterneArticle {

    private int commandeId;
    private int articleId;
    private int quantiteCommande;

    public CommandeExterneArticle(int commandeId, int articleId, int quantiteCommande) {
        this.commandeId = commandeId;
        this.articleId = articleId;
        this.quantiteCommande = quantiteCommande;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }
}
