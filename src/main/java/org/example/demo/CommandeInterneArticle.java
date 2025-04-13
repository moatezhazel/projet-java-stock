package org.example.demo;

public class CommandeInterneArticle {

    private int commandeId;
    private int articleId;
    private int quantiteDemandee;

    public CommandeInterneArticle(int commandeId, int articleId, int quantiteDemandee) {
        this.commandeId = commandeId;
        this.articleId = articleId;
        this.quantiteDemandee = quantiteDemandee;
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

    public int getQuantiteDemandee() {
        return quantiteDemandee;
    }

    public void setQuantiteDemandee(int quantiteDemandee) {
        this.quantiteDemandee = quantiteDemandee;
    }
}

