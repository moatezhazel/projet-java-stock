package org.example.demo;
import javafx.event.ActionEvent;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.scene.input.KeyEvent;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AppController implements Initializable {
    // Références FXML pour les commandes
    @FXML private TableView<CommandeExterne> tableCommandesExternes;
    @FXML private TableView<CommandeInterne> tableCommandesInternes;
    @FXML private TableColumn<CommandeExterne, Integer> colCmdExtId;
    @FXML private TableColumn<CommandeExterne, String> colCmdExtFournisseur;
    @FXML private TableColumn<CommandeExterne, LocalDate> colCmdExtDate;
    @FXML private TableColumn<CommandeExterne, String> colCmdExtStatut;
    @FXML private TableColumn<CommandeInterne, Integer> colCmdIntId;
    @FXML private TableColumn<CommandeInterne, String> colCmdIntService;
    @FXML private TableColumn<CommandeInterne, LocalDate> colCmdIntDate;
    @FXML private TableColumn<CommandeInterne, String> colCmdIntStatut;

    // Données
    private ObservableList<CommandeExterne> commandesExternes = FXCollections.observableArrayList();
    private ObservableList<CommandeInterne> commandesInternes = FXCollections.observableArrayList();
    //lmm//
    @FXML private AnchorPane pageGestionnaireArticle, pageGestionnaireLocal, pageGestionnaireFournisseur,panedeService;
    @FXML private Button btnGestionnaireArticle, btnGestionnaireLocal, btnGestionnaireFournisseur,btngS;
    @FXML private TextField rechercheArticleRef;
    @FXML
    private TableColumn<Service,Integer > IDService;
    @FXML
    private TableColumn<Service,String > NomService;
    @FXML
    private TableColumn<Service,String > ResponsableService;
    @FXML
    private TableColumn<Service,String > ContactService;
    @FXML
    private TableColumn<Service,String > TypeService;

    @FXML
    private TextField contactService;
    @FXML
    private TextField nomService;
    @FXML
    private TextField rechercherSPI;
    @FXML
    private TextField responsableService;
    @FXML
    private ComboBox<String> typeService;
    @FXML
    private TableColumn<Fournisseur,String> ContactFournisseur;
    @FXML
    private TableColumn<Fournisseur, Integer> IdFournisseur;

    @FXML
    private TableColumn<Local, Integer> identifiantLocal;
    @FXML
    private TableColumn<Fournisseur, String> NomFournisseur;

    @FXML
    private TextField nomFournisseur;
    @FXML
    private TextField adresseFournisseur;
    @FXML
    private TextField contactFournisseur;



    @FXML
    private TableColumn<Local,String> NomLocal;
    @FXML
    private TableColumn<Fournisseur,String> AdresseFournisseur;
    @FXML
    private TextField rechercheParIdLocal;

    @FXML
    private TextField rechercherFournisseur;
    @FXML
    private TableView<Fournisseur> tableFournisseur;

    @FXML
    private TableView<Local> tableLocal;

    @FXML
    private TableColumn<Local,String> TypeLocal;

    @FXML private TextField nomLocal;
    @FXML private ComboBox<String> typeLocal;


    @FXML private Button btnAjouterArticle;


    @FXML private ComboBox<String> categorieArticle;
    @FXML private DatePicker dateArticle;
    @FXML private ComboBox<String> localArticle;
    @FXML private TextField nomArticle;
    @FXML private TextField qteArticle;
    @FXML private TextField qteMinArticle;

    @FXML private TableView<Article> tableArticle;
    @FXML private TableView<Service> tableService;
    @FXML private TableColumn<Article, Integer> tableArticle_ref;
    @FXML private TableColumn<Article, String> tableArticle_nom;
    @FXML private TableColumn<Article, String> tableArticle_categorie;
    @FXML private TableColumn<Article, Integer> tableArticle_qte;
    @FXML private TableColumn<Article, String> tableArticle_local;
    @FXML private TableColumn<Article, Integer> tableArticle_qteMin;
    @FXML private TableColumn<Article, LocalDate> tableArticle_date;



    @FXML
    private void switchPage(Event event) {
        if(event.getSource() == btnGestionnaireArticle) {
            pageGestionnaireArticle.setVisible(true);
            pageGestionnaireFournisseur.setVisible(false);
            pageGestionnaireLocal.setVisible(false);
            panedeService.setVisible(false);
        } else if(event.getSource() == btnGestionnaireLocal) {
            pageGestionnaireArticle.setVisible(false);
            pageGestionnaireFournisseur.setVisible(false);
            pageGestionnaireLocal.setVisible(true);
            panedeService.setVisible(false);
        }
        else if(event.getSource() == btngS) {
            pageGestionnaireArticle.setVisible(false);
            pageGestionnaireFournisseur.setVisible(false);
            pageGestionnaireLocal.setVisible(false);
            panedeService.setVisible(true);
        }else {
            pageGestionnaireArticle.setVisible(false);
            pageGestionnaireFournisseur.setVisible(true);
            pageGestionnaireLocal.setVisible(false);
            panedeService.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /* configureCommandesTables();
        loadCommandesFromDB();*/
        initializeTableColumns();
        initialiseCategorieArticle();
        loadArticlesFromDB();
        initialiseLocalArticle();
        initialiseTypeLocal();
        loadLocalFromDB();
        loadFournisseurFromDB();
        initialiseTypeService();
        loadServiceFromDB();
    }
    //88//

    //88//
    private void initialiseTypeService() {
        ObservableList<String> listDesChoix = FXCollections.observableArrayList(
                "Scolarité",
                "Photocopie",
                "Bibliothèque",
                "Administration",
                "Enseignement",
                "Magasin",
                "Entretien",
                "Informatique",
                "Direction",
                "Divers"
        );
        typeService.setItems(listDesChoix);}

    private void initialiseCategorieArticle() {
        ObservableList<String> listDesChoix = FXCollections.observableArrayList(
                "Bureautique",
                "Informatique",
                "Technologie",
                "Tirage",
                "Nettoyage",
                "Entretient",
                "Jardin",
                "Meuble",
                "Divers"
        );
        categorieArticle.setItems(listDesChoix);
    }
    private void loadServiceFromDB() {
        String query = "SELECT * FROM service";
        try {
            Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            tableService.getItems().clear();
            while (rs.next()) {
                Service a = new Service(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("contact"),
                        rs.getString("responsable")
                );
                tableService.getItems().add(a);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR,"Database Error", e.getMessage());
        }
    }
    private void initialiseLocalArticle() {
        String req = "SELECT nom FROM local WHERE type LIKE ?";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt = c.prepareStatement(req);
            pstmt.setString(1, "Magasin");
            ResultSet res = pstmt.executeQuery();
            while(res.next())
                localArticle.getItems().add(res.getString("nom"));
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "erreur", "erreur BD!");
        }
    }

    private void initializeTableColumns() {
        tableArticle_ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
        tableArticle_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableArticle_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tableArticle_qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
        tableArticle_local.setCellValueFactory(new PropertyValueFactory<>("local"));
        tableArticle_qteMin.setCellValueFactory(new PropertyValueFactory<>("qteMin"));
        tableArticle_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        identifiantLocal.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomLocal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        TypeLocal.setCellValueFactory(new PropertyValueFactory<>("type"));
        AdresseFournisseur.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        IdFournisseur.setCellValueFactory(new PropertyValueFactory<>("id_fournisseur"));
        NomFournisseur.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ContactFournisseur.setCellValueFactory(new PropertyValueFactory<>("contact"));
        IDService.setCellValueFactory(new PropertyValueFactory<>("idservice"));
        NomService.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ContactService.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TypeService.setCellValueFactory(new PropertyValueFactory<>("type"));
        ResponsableService.setCellValueFactory(new PropertyValueFactory<>("responsable"));


    }

    private void loadArticlesFromDB() {
        String query = "SELECT * FROM article";
        try {
            Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            tableArticle.getItems().clear();
            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("reference"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getInt("qte"),
                        rs.getString("local"),
                        rs.getInt("qteMin"),
                        (rs.getDate("date") == null)? null : rs.getDate("date").toLocalDate()
                );
                tableArticle.getItems().add(article);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR,"Database Error", e.getMessage());
        }
    }
    private void loadFournisseurFromDB() {
        String query = "SELECT * FROM fournisseur";
        try {
            Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            tableFournisseur.getItems().clear();
            while (rs.next()) {
                int id = rs.getInt("idfournisseur");
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String contact = rs.getString("contact");
                Fournisseur fournisseur = new Fournisseur(id,nom,contact,adresse);
                tableFournisseur.getItems().add(fournisseur);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR,"Database Error", e.getMessage());
        }
    }


    private void showMsg(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void ajouterArticle() {
        if(nomArticle.getText().isEmpty() || qteArticle.getText().isEmpty() || qteMinArticle.getText().isEmpty() || categorieArticle.getValue() == null || localArticle.getValue() == null) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "tous les champs doit etre rempli");
            return;
        }
        String req1 = "INSERT INTO article VALUES(?,?,?,?,?,?,?)";
        String req2 = "SELECT COALESCE(MAX(reference), 0) + 1 FROM article";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt2 = c.prepareStatement(req2);
            ResultSet res = pstmt2.executeQuery();
            res.next();
            PreparedStatement pstmt1 = c.prepareStatement(req1);
            pstmt1.setInt(1, res.getInt(1));
            pstmt1.setString(2, nomArticle.getText());
            pstmt1.setString(3, categorieArticle.getValue());
            pstmt1.setInt(4, Integer.parseUnsignedInt(qteArticle.getText()));
            pstmt1.setString(5, localArticle.getValue());
            pstmt1.setInt(6, Integer.parseUnsignedInt(qteMinArticle.getText()));
            pstmt1.setDate(7, (dateArticle.getValue() == null)? null : Date.valueOf(dateArticle.getValue()));
            if(pstmt1.executeUpdate() == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne ajoute avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "erreur lors d'ajout de ligne!");
            loadArticlesFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "erreur de connexion a base de donnee");
        } catch (NumberFormatException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "qte et qteMin doit etre numerique positif!");
        }
    }

    @FXML
    private void supprimerArticle() {
        if(tableArticle.getSelectionModel().getSelectedIndex() == -1) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "tu doit selectionne une ligne du tableau!");
        }
        Article a = tableArticle.getSelectionModel().getSelectedItem();
        String req = "DELETE FROM article WHERE reference = ?";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt = c.prepareStatement(req);
            pstmt.setInt(1, a.getRef());
            int numLigneSupprimer = pstmt.executeUpdate();
            if(numLigneSupprimer == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne supprime avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "ligne n'est pas supprimer!");
            loadArticlesFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "erreur connexion BD");
        }
    }
    private void clearFormFields() {
        clearFormFields1();
        clearFormFields2();
        clearFormFields3();
        clearFormFields4();

    }
    private void clearFormFields3(){
        nomFournisseur.clear();
        contactFournisseur.clear();
        adresseFournisseur.clear();
    }
    private void clearFormFields1() {
        nomArticle.clear();
        qteArticle.clear();
        qteMinArticle.clear();
        categorieArticle.getSelectionModel().clearSelection();
        localArticle.getSelectionModel().clearSelection();
        dateArticle.setValue(null);
    }
    private void clearFormFields4() {
        nomService.clear();
        typeService.getSelectionModel().clearSelection();
        contactService.clear();
        responsableService.clear();
    }
    private void clearFormFields2() {
        nomLocal.clear();
        typeLocal.setValue(null);}

    @FXML
    private void handleSelection1() {
        Article selectedArticle = tableArticle.getSelectionModel().getSelectedItem();
        if (selectedArticle == null) {
            clearFormFields();
            return;

        }
        nomArticle.setText(selectedArticle.getNom());
        qteArticle.setText(String.valueOf(selectedArticle.getQte()));
        qteMinArticle.setText(String.valueOf(selectedArticle.getQteMin()));
        categorieArticle.setValue(selectedArticle.getCategorie());
        localArticle.setValue(selectedArticle.getLocal());
        dateArticle.setValue(selectedArticle.getDate());
    }
    @FXML
    private void handleSelection2() {
        Local selectedLocal = tableLocal.getSelectionModel().getSelectedItem();
        if (selectedLocal == null) {
            clearFormFields();
            return;
        }
        nomLocal.setText(selectedLocal.getNom());
        typeLocal.setValue(selectedLocal.getType());
    }
    @FXML
    private void handleSelection3() {
        Fournisseur selectedFournisseur = tableFournisseur.getSelectionModel().getSelectedItem();
        if (selectedFournisseur == null) {
            clearFormFields();
            return;

        }
        nomFournisseur.setText(selectedFournisseur.getNom());
        contactFournisseur.setText(selectedFournisseur.getContact());
        adresseFournisseur.setText(selectedFournisseur.getAdresse());

    }
    @FXML
    private void handleSelection4() {
        Service selectedService = tableService.getSelectionModel().getSelectedItem();
        if (selectedService == null) {
            clearFormFields();
            return;

        }
        nomService.setText(selectedService.getNom());
        typeService.setValue(selectedService.getType());
        contactService.setText(selectedService.getContact());
        responsableService.setText(selectedService.getResponsable());



    }
    @FXML
    private void modifierArticle() {
        Article selectedArticle = tableArticle.getSelectionModel().getSelectedItem();
        if (selectedArticle == null) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner un article à modifier!");
            return;
        }
        if (!validateFormFields()) {
            return;
        }
        String updateQuery = "UPDATE article SET "
                + "nom = ?, "
                + "categorie = ?, "
                + "qte = ?, "
                + "local = ?, "
                + "qteMin = ?, "
                + "date = ? "
                + "WHERE reference = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, nomArticle.getText());
            pstmt.setString(2, categorieArticle.getValue());
            pstmt.setInt(3, Integer.parseInt(qteArticle.getText()));
            pstmt.setString(4, localArticle.getValue());
            pstmt.setInt(5, Integer.parseInt(qteMinArticle.getText()));
            pstmt.setDate(6, dateArticle.getValue() != null ? Date.valueOf(dateArticle.getValue()) : null);
            pstmt.setInt(7, selectedArticle.getRef());
            int updatedRows = pstmt.executeUpdate();
            if (updatedRows == 1) {
                showMsg(Alert.AlertType.INFORMATION, "Succès", "Article modifié avec succès!");
                loadArticlesFromDB();
                clearFormFields();
            } else
                showMsg(Alert.AlertType.ERROR, "Erreur", "Échec de la modification de l'article!");
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur BD", "Erreur lors de la modification: " + e.getMessage());
        } catch (NumberFormatException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Les quantités doivent être des nombres valides!");
        }
    }

    @FXML
    private void rechercherArticleParRef() {
        if(rechercheArticleRef.getText().isEmpty()) {
            loadArticlesFromDB();
            return;
        }
        String req = "SELECT * FROM article WHERE reference = ?";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            pstmt.setInt(1, Integer.parseUnsignedInt(rechercheArticleRef.getText()));
            ResultSet res = pstmt.executeQuery();
            tableArticle.getItems().clear();
            if(res.next()) {
                Article a = new Article(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getString(5),
                        res.getInt(6),
                        (res.getDate(7) == null)? null : res.getDate(7).toLocalDate()
                );
                tableArticle.getItems().add(a);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            tableArticle.getItems().clear();
        }
    }

    @FXML
    private void rechercherArticle() {
        if (nomArticle.getText().isEmpty()
                && qteArticle.getText().isEmpty()
                && qteMinArticle.getText().isEmpty()
                && categorieArticle.getValue() == null
                && localArticle.getValue() == null) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Au moins un champs doit etre remplis!");
            return;
        }
        String req = "SELECT * FROM article WHERE";
        if(!nomArticle.getText().isEmpty())
            req += " nom LIKE ? AND";
        if(!qteArticle.getText().isEmpty())
            req += " qte = ? AND";
        if(!qteMinArticle.getText().isEmpty())
            req += " qteMin = ? AND";
        if(categorieArticle.getValue() != null)
            req += " categorie LIKE ? AND";
        if(localArticle.getValue() != null)
            req += " local LIKE ? AND";
        if(dateArticle.getValue() != null)
            req += " date = ? AND";
        req += " 1=1";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            int i = 1;
            if(!nomArticle.getText().isEmpty())
                pstmt.setString(i++, "%" + nomArticle.getText() + "%");
            if(!qteArticle.getText().isEmpty())
                pstmt.setInt(i++, Integer.parseUnsignedInt(qteArticle.getText()));
            if(!qteMinArticle.getText().isEmpty())
                pstmt.setInt(i++, Integer.parseUnsignedInt(qteMinArticle.getText()));
            if(categorieArticle.getValue() != null)
                pstmt.setString(i++, categorieArticle.getValue());
            if(localArticle.getValue() != null)
                pstmt.setString(i++, localArticle.getValue());
            if(dateArticle.getValue() != null)
                pstmt.setDate(i, Date.valueOf(dateArticle.getValue()));
            ResultSet res = pstmt.executeQuery();
            tableArticle.getItems().clear();
            while(res.next()) {
                Article a = new Article(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getString(5),
                        res.getInt(6),
                        (res.getDate(7) == null)? null : res.getDate(7).toLocalDate()
                );
                tableArticle.getItems().add(a);
            }
        } catch(SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            loadArticlesFromDB();
        }
    }

    @FXML
    private void resetArticle() {
        clearFormFields();
        loadArticlesFromDB();
    }

    @FXML
    private void viderDate() {
        dateArticle.setValue(null);
    }

    private boolean validateFormFields() {
        if (nomArticle.getText().isEmpty()
                || qteArticle.getText().isEmpty()
                || qteMinArticle.getText().isEmpty()
                || categorieArticle.getValue() == null
                || localArticle.getValue() == null) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Tous les champs obligatoires doivent être remplis!");
            return false;
        }
        try {
            Integer.parseInt(qteArticle.getText());
            Integer.parseInt(qteMinArticle.getText());
        } catch (NumberFormatException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Les quantités doivent être des nombres valides!");
            return false;
        }
        return true;
    }

    private void loadLocalFromDB() {
        String query = "SELECT * FROM local";
        try {
            Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            tableLocal.getItems().clear();
            while (rs.next()) {
                Local local = new Local(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("type")
                );
                tableLocal.getItems().add(local);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR,"Database Error", e.getMessage());
        }
    }
    private void initialiseTypeLocal() {
        ObservableList<String> listDesChoix = FXCollections.observableArrayList(
                "bibliothèque",
                "Amphis",
                "Salles d'enseignement",
                "administration",
                "Magasin",
                "Bureaux enseignants"

        );
        typeLocal.setItems(listDesChoix);
    }


    @FXML
    private void ajouterLocal() {
        if(nomLocal.getText().isEmpty()  ||  typeLocal.getValue() == null ) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "tous les champs doit etre rempli");
            return;
        }
        String req1 = "INSERT INTO local VALUES(?,?,?)";
        String req2 = "SELECT COALESCE(MAX(id), 0) + 1 FROM local";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt2 = c.prepareStatement(req2);
            ResultSet res = pstmt2.executeQuery();
            res.next();
            PreparedStatement pstmt1 = c.prepareStatement(req1);
            pstmt1.setInt(1, res.getInt(1));
            pstmt1.setString(2, nomLocal.getText());
            pstmt1.setString(3, typeLocal.getValue());
            if(pstmt1.executeUpdate() == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne ajoute avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "erreur lors d'ajout de ligne!");
            loadLocalFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "erreur de connexion a base de donnee");
        } catch (NumberFormatException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "id doit etre numerique positif!");
        }
    }
    @FXML
    private void supprimerLocal() {
        if(tableLocal.getSelectionModel().getSelectedIndex() == -1) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "tu doit selectionne une ligne du tableau!");
        }
        Local a = tableLocal.getSelectionModel().getSelectedItem();
        String req = "DELETE FROM local WHERE id = ?";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt = c.prepareStatement(req);
            pstmt.setInt(1, a.getId());
            int numLigneSupprimer = pstmt.executeUpdate();
            if(numLigneSupprimer == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne supprime avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "ligne n'est pas supprimer!");
            loadLocalFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "erreur connexion BD");
        }
    }
    @FXML
    private void modifierLocal() {
        Local selectedLocal = tableLocal.getSelectionModel().getSelectedItem();
        if (selectedLocal == null) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner un Local à modifier!");
            return;
        }
        if (!validateFormFields2()) {
            return;
        }
        String updateQuery = "UPDATE local SET "
                + "nom = ?, "
                + "type = ? "
                + "WHERE id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, nomLocal.getText());
            pstmt.setString(2, typeLocal.getValue());
            pstmt.setInt(3, selectedLocal.getId());
            int updatedRows = pstmt.executeUpdate();
            if (updatedRows == 1) {
                showMsg(Alert.AlertType.INFORMATION, "Succès", "Local modifié avec succès!");
                loadLocalFromDB();
                clearFormFields();
            } else
                showMsg(Alert.AlertType.ERROR, "Erreur", "Échec de la modification de local!");
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur BD", "Erreur lors de la modification: " + e.getMessage());
        } catch (NumberFormatException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Le id doit être un  nombre valide!");
        }
    }

    @FXML
    private void rechercherLocalParId() {
        if(rechercheParIdLocal.getText().isEmpty()) {
            loadLocalFromDB();
            return;
        }
        String req = "SELECT * FROM local WHERE id = ?";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            pstmt.setInt(1, Integer.parseUnsignedInt(rechercheParIdLocal.getText()));
            ResultSet res = pstmt.executeQuery();
            tableLocal.getItems().clear();
            if(res.next()) {
                Local a = new Local(res.getInt(1),
                        res.getString(2),
                        res.getString(3)
                );
                tableLocal.getItems().add(a);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            tableLocal.getItems().clear();
        }
    }
    @FXML
    private void resetLocal() {
        clearFormFields();
        loadLocalFromDB();
    }



    private boolean validateFormFields2() {
        if (nomLocal.getText().isEmpty()
                || typeLocal.getValue() == null
        ) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Tous les champs obligatoires doivent être remplis!");
            return false;
        }
        return true;
    }
    @FXML
    private void rechercherLocal() {
        String nom = nomLocal.getText().trim().toLowerCase();
        String type = (typeLocal.getValue() != null) ? typeLocal.getValue().trim().toLowerCase() : null;

        if (nom.isEmpty() && type == null) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Au moins un champ doit être rempli !");
            return;
        }

        String req = "SELECT * FROM local WHERE ";
        if (!nom.isEmpty())
            req += " LOWER(nom) LIKE ? AND ";
        if (type != null)
            req += " LOWER(type) LIKE ? AND ";
        req += " 1=1";

        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            int i = 1;
            if (!nom.isEmpty())
                pstmt.setString(i++, "%" + nom + "%");
            if (type != null)
                pstmt.setString(i++, "%" + type + "%");

            ResultSet res = pstmt.executeQuery();
            tableLocal.getItems().clear();
            while (res.next()) {
                Local a = new Local(res.getInt(1),
                        res.getString(2),
                        res.getString(3));
                tableLocal.getItems().add(a);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur connexion BD : " + e.getMessage());
        } catch (NumberFormatException e) {
            loadLocalFromDB();
        }
    }
    @FXML
    void ajouterFournisseur() {
        if(nomFournisseur.getText().isEmpty() || adresseFournisseur.getText().isEmpty()||  contactFournisseur.getText().isEmpty() ) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "tous les champs doit etre rempli");
            return;
        }
        String req1 = "INSERT INTO fournisseur VALUES(?,?,?,?)";
        String req2 = "SELECT COALESCE(MAX(idfournisseur), 0) + 1 FROM fournisseur";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt2 = c.prepareStatement(req2);
            ResultSet res = pstmt2.executeQuery();
            res.next();
            PreparedStatement pstmt1 = c.prepareStatement(req1);
            pstmt1.setInt(1, res.getInt(1));
            pstmt1.setString(2, nomFournisseur.getText());
            pstmt1.setString(3, contactFournisseur.getText());
            pstmt1.setString(4, adresseFournisseur.getText());
            if(pstmt1.executeUpdate() == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne ajoute avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "erreur lors d'ajout de ligne!");
            loadFournisseurFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "erreur de connexion a base de donnee");
        } catch (NumberFormatException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "id doit etre numerique positif!");
        }
    }
    private boolean validateFormFields3() {
        if (nomFournisseur.getText().isEmpty()
                || adresseFournisseur.getText().isEmpty()
                || contactFournisseur.getText().isEmpty()
        ) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Tous les champs obligatoires doivent être remplis!");
            return false;
        }

        return true;
    }



    @FXML
    private void modifierFournisseur() {
        Fournisseur selectedFournisseur = tableFournisseur.getSelectionModel().getSelectedItem();
        if(selectedFournisseur == null){
            showMsg(Alert.AlertType.ERROR,"Erreur","Veuillez sélectionner un article à modifier!");
            return;}

        if (!validateFormFields3()) {
            return;
        }
        String updateQuery = "UPDATE fournisseur SET "
                + "nom = ?, "
                + "adresse = ?, "
                + "contact = ? "
                + "WHERE idfournisseur = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, nomFournisseur.getText());
            pstmt.setString(2, adresseFournisseur.getText());
            pstmt.setString(3, contactFournisseur.getText());
            pstmt.setInt(4, selectedFournisseur.getId_fournisseur());
            int updatedRows = pstmt.executeUpdate();
            if (updatedRows == 1) {
                showMsg(Alert.AlertType.INFORMATION, "Succès", "Fournisseur modifié avec succès!");
                loadFournisseurFromDB();
                clearFormFields();
            } else
                showMsg(Alert.AlertType.ERROR, "Erreur", "Échec de la modification du fournisseur!");
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur BD", "Erreur lors de la modification: " + e.getMessage());
        }
    }
    @FXML
    private void rechercherFournisseurParRef() {
        if(rechercherFournisseur.getText().isEmpty()) {
            loadFournisseurFromDB();
            return;
        }
        String req = "SELECT * FROM fournisseur WHERE idfournisseur = ?";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            pstmt.setInt(1, Integer.parseUnsignedInt(rechercherFournisseur.getText()));
            ResultSet res = pstmt.executeQuery();
            tableFournisseur.getItems().clear();
            if(res.next()) {
                Fournisseur a = new Fournisseur(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4)


                );
                tableFournisseur.getItems().add(a);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            tableFournisseur.getItems().clear();
        }
    }

    @FXML
    void rechercherFournisseur(){
        if (nomFournisseur.getText().isEmpty()
                && contactFournisseur.getText().isEmpty()
                && adresseFournisseur.getText().isEmpty()
        ) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Au moins un champs doit etre remplis!");
            return;
        }
        String req="select * from fournisseur WHERE ";
        if(!nomFournisseur.getText().isEmpty())
            req+=" nom LIKE ? AND ";
        if(!contactFournisseur.getText().isEmpty())
            req+=" contact  LIKE ? AND ";
        if(!adresseFournisseur.getText().isEmpty())
            req+=" adresse  LIKE ? AND ";
        req+=" 1=1 ";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);


            int i = 1;
            if(!nomFournisseur.getText().isEmpty())
                pstmt.setString(i++, "%" + nomFournisseur.getText() + "%");
            if(!contactFournisseur.getText().isEmpty())
                pstmt.setString(i++,"%" + contactFournisseur.getText() + "%" );
            if(!adresseFournisseur.getText().isEmpty())
                pstmt.setString(i++,"%" + adresseFournisseur.getText() + "%");
            ResultSet res = pstmt.executeQuery();
            tableFournisseur.getItems().clear();
            while(res.next()) {
                Fournisseur a = new Fournisseur(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4)
                );
                tableFournisseur.getItems().add(a);
            }
        } catch(SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            loadArticlesFromDB();
        }
    }

    @FXML
    void resetFournisseur() {
        clearFormFields();
        loadFournisseurFromDB();
    }

    @FXML
    void supprimerFournisseur(){
        if(tableFournisseur.getSelectionModel().getSelectedIndex() == -1) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "tu doit selectionne une ligne du tableau!");
        }
        Fournisseur a = tableFournisseur.getSelectionModel().getSelectedItem();
        String req = "DELETE FROM fournisseur WHERE idfournisseur = ?";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt = c.prepareStatement(req);
            pstmt.setInt(1, a.getId_fournisseur());
            int numLigneSupprimer = pstmt.executeUpdate();
            if(numLigneSupprimer == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne supprime avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "ligne n'est pas supprimer!");
            loadFournisseurFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "erreur connexion BD");
        }


    }
    @FXML
    void ajouterService() {

        if(nomService.getText().isEmpty() || contactService.getText().isEmpty() || responsableService.getText().isEmpty() || typeService.getValue() == null ) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "tous les champs doit etre rempli");
            return;
        }
        String req1 = "INSERT INTO service VALUES(?,?,?,?,?)";
        String req2 = "SELECT COALESCE(MAX(id), 0) + 1 FROM service";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt2 = c.prepareStatement(req2);
            ResultSet res = pstmt2.executeQuery();
            res.next();
            PreparedStatement pstmt1 = c.prepareStatement(req1);
            pstmt1.setInt(1, res.getInt(1));
            pstmt1.setString(2, nomService.getText());
            pstmt1.setString(3, typeService.getValue());
            pstmt1.setString(4, contactService.getText());
            pstmt1.setString(5, responsableService.getText());
            if(pstmt1.executeUpdate() == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne ajoute avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "erreur lors d'ajout de ligne!");
            loadServiceFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR ,"erreur", "erreur de connexion a base de donnee");
        }


    }
    private boolean validateFormFields4() {
        if (nomService.getText().isEmpty()
                || typeService.getValue()==null
                || contactService.getText().isEmpty()
                || responsableService.getText().isEmpty()
        ) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Tous les champs obligatoires doivent être remplis!");
            return false;
        }

        return true;
    }
    @FXML
    void modifierService() {
        Service selectedService = tableService.getSelectionModel().getSelectedItem();
        if (selectedService == null) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner un service à modifier!");
            return;
        }
        if (!validateFormFields4()) {
            return;
        }
        String updateQuery = "UPDATE service SET "
                + "nom = ?, "
                + "type = ?, "
                + "contact = ?, "
                + "responsable = ? "
                + "WHERE id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, nomService.getText());
            pstmt.setString(2, typeService.getValue());
            pstmt.setString(3, contactService.getText());
            pstmt.setString(4, responsableService.getText());
            pstmt.setInt(5, selectedService.getIdservice());
            int updatedRows = pstmt.executeUpdate();
            if (updatedRows == 1) {
                showMsg(Alert.AlertType.INFORMATION, "Succès", "Service modifié avec succès!");
                loadServiceFromDB();
                clearFormFields();
            } else
                showMsg(Alert.AlertType.ERROR, "Erreur", "Échec de la modification de service!");
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur BD", "Erreur lors de la modification: " + e.getMessage());
        }


    }


    @FXML
    void rechercherServiceParID() {

        if(rechercherSPI.getText().isEmpty()) {
            loadServiceFromDB();
            return;
        }
        String req = "SELECT * FROM service WHERE id = ?";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            pstmt.setInt(1, Integer.parseUnsignedInt(rechercherSPI.getText()));
            ResultSet res = pstmt.executeQuery();
            tableService.getItems().clear();
            if(res.next()) {
                Service a = new Service(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                );
                tableService.getItems().add(a);
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            tableService.getItems().clear();
        }

    }
    @FXML
    void resetService() {

        clearFormFields();
        loadServiceFromDB();
    }
    @FXML
    void supprimerService(ActionEvent event) {

        if(tableService.getSelectionModel().getSelectedIndex() == -1) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "tu doit selectionne une ligne du tableau!");
        }
        Service a = tableService.getSelectionModel().getSelectedItem();
        String req = "DELETE FROM service WHERE id = ?";
        try {
            Connection c = DB.getConnection();
            PreparedStatement pstmt = c.prepareStatement(req);
            pstmt.setInt(1, a.getIdservice());
            int numLigneSupprimer = pstmt.executeUpdate();
            if(numLigneSupprimer == 1)
                showMsg(Alert.AlertType.INFORMATION, "Information", "ligne supprime avec succee");
            else showMsg(Alert.AlertType.ERROR, "Erreur", "ligne n'est pas supprimer!");
            loadServiceFromDB();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "erreur connexion BD");
        }



    }
    @FXML
    void rechercherService() {

        if (nomService.getText().isEmpty()
                && responsableService.getText().isEmpty()
                && contactService.getText().isEmpty()
                && typeService.getValue() == null) {

            showMsg(Alert.AlertType.ERROR, "Erreur", "Au moins un champs doit etre remplis!");
            return;
        }
        String req = "SELECT * FROM service WHERE";
        if(!nomService.getText().isEmpty())
            req += " nom LIKE ? AND";
        if(!contactService.getText().isEmpty())
            req += " contact  LIKE ? AND";
        if(!responsableService.getText().isEmpty())
            req += " responsable  LIKE ? AND";
        if(typeService.getValue() != null)
            req += " type LIKE ? AND";
        req += " 1=1";
        try {
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(req);
            int i = 1;
            if(!nomService.getText().isEmpty())
                pstmt.setString(i++, "%" + nomService.getText() + "%");
            if(!contactService.getText().isEmpty())
                pstmt.setString(i++, "%" + contactService.getText() + "%");
            if(!responsableService.getText().isEmpty())
                pstmt.setString(i++, "%" + responsableService.getText() + "%");
            if(typeService.getValue() != null)
                pstmt.setString(i++, typeService.getValue());
            ResultSet res = pstmt.executeQuery();
            tableService.getItems().clear();
            while(res.next()) {
                Service a = new Service(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                );
                tableService.getItems().add(a);
            }
        } catch(SQLException e) {
            showMsg(Alert.AlertType.ERROR , "Erreur", "erreur connexion BD!");
        } catch (NumberFormatException e) {
            loadServiceFromDB();
        }




    }

}