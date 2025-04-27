
//8888888888888888
package org.example.demo;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.io.File;
import java.awt.Desktop;
import javafx.stage.FileChooser;
//8888888888
import javafx.event.ActionEvent;

import java.io.File;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class AppController implements Initializable {
    @FXML
    private AnchorPane pageCommandeExterne;
    @FXML
    private AnchorPane pageCommandeInterne;
    // For command management
    // private CommandeExterne selectedCommandeExterne;
    private CommandeInterne selectedCommandeInterne;
    private ObservableList<CommandeExterne> commandesExternesList = FXCollections.observableArrayList();
    private ObservableList<CommandeInterne> commandesInternesList = FXCollections.observableArrayList();
    private ObservableList<LigneCommandeExterne> lignesCommandeExterneList = FXCollections.observableArrayList();
    private ObservableList<LigneCommandeInterne> lignesCommandeInterneList = FXCollections.observableArrayList();
    //ffff
    @FXML
    private TableView<CommandeExterne> tableCommandeExterne;
    @FXML
    private TableColumn<CommandeExterne, Integer> colIdCommandeExterne;
    @FXML
    private TableColumn<CommandeExterne, String> colFournisseurCommandeExterne;
    @FXML
    private TableColumn<CommandeExterne, LocalDate> colDateCommandeExterne;
    @FXML
    private TableColumn<CommandeExterne, String> colStatutCommandeExterne;
    @FXML
    private TableColumn<CommandeExterne, String> colDescriptionCommandeExterne;

    @FXML
    private ComboBox<Fournisseur> comboFournisseurCommandeExterne;
    @FXML
    private DatePicker dateDateCommandeExterne;
    @FXML
    private TextArea txtDescriptionCommandeExterne;

    @FXML
    private TableView<LigneCommandeExterne> tableLignesCommandeExterne;
    @FXML
    private TableColumn<LigneCommandeExterne, Integer> colRefArticleCommandeExterne;
    @FXML
    private TableColumn<LigneCommandeExterne, String> colNomArticleCommandeExterne;
    @FXML
    private TableColumn<LigneCommandeExterne, Integer> colQuantiteCommandeExterne;
    @FXML
    private TableColumn<LigneCommandeExterne, String> colLocalCommandeExterne;

    @FXML
    private ComboBox<Article> comboArticleCommandeExterne;
    @FXML
    private ComboBox<Local> comboLocalCommandeExterne;
    @FXML
    private TextField txtQuantiteCommandeExterne;
    // Section Gestion des commandes internes
    @FXML
    private TableView<CommandeInterne> tableCommandeInterne;
    @FXML
    private TableColumn<CommandeInterne, Integer> colIdCommandeInterne;
    @FXML
    private TableColumn<CommandeInterne, String> colServiceCommandeInterne;
    @FXML
    private TableColumn<CommandeInterne, LocalDate> colDateCommandeInterne;
    @FXML
    private TableColumn<CommandeInterne, String> colStatutCommandeInterne;
    @FXML
    private TableColumn<CommandeInterne, String> colDescriptionCommandeInterne;

    @FXML
    private ComboBox<Service> comboServiceCommandeInterne;
    @FXML
    private DatePicker dateDateCommandeInterne;
    @FXML
    private TextArea txtDescriptionCommandeInterne;

    @FXML
    private TableView<LigneCommandeInterne> tableLignesCommandeInterne;
    @FXML
    private TableColumn<LigneCommandeInterne, Integer> colRefArticleCommandeInterne;
    @FXML
    private TableColumn<LigneCommandeInterne, String> colNomArticleCommandeInterne;
    @FXML
    private TableColumn<LigneCommandeInterne, Integer> colQuantiteCommandeInterne;
    @FXML
    private TableColumn<LigneCommandeInterne, String> colLocalCommandeInterne;

    @FXML
    private ComboBox<Article> comboArticleCommandeInterne;
    @FXML
    private ComboBox<Local> comboLocalCommandeInterne;
    @FXML
    private TextField txtQuantiteCommandeInterne;



    //limite
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
    private Button btnCommandeExterne;

    @FXML
    private Button btnCommandeInterne;


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
    @FXML private Button btnInventaire;


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
    //mmm

    //mmmmm
    private void initCommandeInterneView() {
        // Initialiser les colonnes du tableau des commandes internes
        colIdCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
        colServiceCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("nomService"));
        colDateCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("dateCommande"));
        colStatutCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colDescriptionCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Initialiser les colonnes du tableau des lignes de commande interne
        colRefArticleCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("refArticle"));
        colNomArticleCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
        colQuantiteCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colLocalCommandeInterne.setCellValueFactory(new PropertyValueFactory<>("localSource"));

        // Charger les services dans le combobox
        loadServicesIntoComboBox();

        // Charger les articles dans le combobox
        loadArticlesIntoComboBox();

        // Charger les locaux dans le combobox
        loadLocauxIntoComboBox();

        // Définir la date actuelle par défaut
        dateDateCommandeInterne.setValue(LocalDate.now());

        // Charger toutes les commandes internes
        loadCommandesInternes();

        // Ajouter un listener pour la sélection d'une commande
        tableCommandeInterne.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedCommandeInterne = newSelection;
                loadLignesCommandeInterne(selectedCommandeInterne.getIdCommande());
            }
        });
    }
    //mmmmmm
    



    @FXML
    private void switchPage(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        // Liste de toutes les pages avec leur bouton correspondant
        // Impossible d'utiliser Map.of() car il est limité à 10 paires clé-valeur
        // Utilisons une méthode alternative pour créer la map
        Map<Button, AnchorPane> pageMap = new HashMap<>();
        pageMap.put(btnGestionnaireArticle, pageGestionnaireArticle);
        pageMap.put(btnGestionnaireLocal, pageGestionnaireLocal);
        pageMap.put(btnGestionnaireFournisseur, pageGestionnaireFournisseur);
        pageMap.put(btngS, panedeService);
        pageMap.put(btnCommandeExterne, pageCommandeExterne);
        pageMap.put(btnCommandeInterne, pageCommandeInterne);
        pageMap.put(btnInventaire, pageInventaire); // Ajout de la page d'inventaire

        // Cacher toutes les pages
        pageMap.values().forEach(page -> page.setVisible(false));

        // Afficher la page sélectionnée
        AnchorPane selectedPage = pageMap.get(clickedButton);
        if (selectedPage != null) {
            selectedPage.setVisible(true);

            // Chargements spécifiques pour les pages
            if (clickedButton == btnCommandeExterne) {
                loadCommandesExternes();
            } else if (clickedButton == btnCommandeInterne) {
                loadCommandesInternes();
            } else if (clickedButton == btnInventaire) {
                // Charger les données d'inventaire quand cette page est sélectionnée
                loadInventaireData();
            }
        }
    }
    private void loadCommandesInternes() {
        try {
            String sql = "SELECT ci.*, s.nom AS nom_service FROM commande_interne ci " +
                    "JOIN service s ON ci.id_service = s.id " +
                    "ORDER BY ci.date_commande DESC";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<CommandeInterne> commandesList = FXCollections.observableArrayList();

            while (rs.next()) {
                CommandeInterne commande = new CommandeInterne(
                        rs.getInt("id_commande"),
                        rs.getInt("id_service"),
                        rs.getString("nom_service"),
                        rs.getDate("date_commande").toLocalDate(),
                        rs.getString("statut"),
                        rs.getString("description")

                );
                commandesList.add(commande);
            }

            tableCommandeInterne.setItems(commandesList);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des commandes internes: " + e.getMessage());
        }
    }
    @FXML
    private void createCommandeInterne() {
        try {
            // Vérifier les entrées obligatoires
            if (comboServiceCommandeInterne.getValue() == null || dateDateCommandeInterne.getValue() == null) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez sélectionner un service et une date.");
                return;
            }

            // Créer la commande interne
            String sql = "INSERT INTO commande_interne (id_service, date_commande, statut, description) " +
                    "VALUES (?, ?, ?, ?)";

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, comboServiceCommandeInterne.getValue().getIdservice());
            pstmt.setDate(2, Date.valueOf(dateDateCommandeInterne.getValue()));
            pstmt.setString(3, "En attente"); // Statut par défaut
            pstmt.setString(4, txtDescriptionCommandeInterne.getText());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // Récupérer l'ID généré
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);

                    showMsg(Alert.AlertType.INFORMATION, "Succès", "Commande interne créée avec succès. ID: " + generatedId);

                    // Réinitialiser les champs
                    comboServiceCommandeInterne.setValue(null);
                    dateDateCommandeInterne.setValue(LocalDate.now());
                    txtDescriptionCommandeInterne.clear();

                    // Recharger les commandes
                    loadCommandesInternes();
                }
                rs.close();
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la création de la commande: " + e.getMessage());
        }
    }
    @FXML
    private void addLigneCommandeInterne() {
        try {
            // Vérifier qu'une commande est sélectionnée
            if (selectedCommandeInterne == null) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez sélectionner une commande interne.");
                return;
            }

            // Vérifier que la commande n'est pas déjà validée
            if ("Validée".equals(selectedCommandeInterne.getStatut())) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Impossible de modifier une commande validée.");
                return;
            }

            // Vérifier les entrées obligatoires
            if (comboArticleCommandeInterne.getValue() == null ||
                    comboLocalCommandeInterne.getValue() == null ||
                    txtQuantiteCommandeInterne.getText().isEmpty()) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez remplir tous les champs.");
                return;
            }

            // Vérifier que la quantité est un nombre positif
            int quantite;
            try {
                quantite = Integer.parseInt(txtQuantiteCommandeInterne.getText());
                if (quantite <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                showMsg(Alert.AlertType.WARNING, "Validation", "La quantité doit être un nombre entier positif.");
                return;
            }

            // Ajouter la ligne de commande
            String sql = "INSERT INTO ligne_commande_interne (id_commande, ref_article, quantite, local_source) " +
                    "VALUES (?, ?, ?, ?)";

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, selectedCommandeInterne.getIdCommande());
            pstmt.setInt(2, comboArticleCommandeInterne.getValue().getRef());
            pstmt.setInt(3, quantite);
            pstmt.setString(4, comboLocalCommandeInterne.getValue().getNom());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                showMsg(Alert.AlertType.INFORMATION, "Succès", "Ligne de commande ajoutée avec succès.");

                // Réinitialiser les champs
                comboArticleCommandeInterne.setValue(null);
                comboLocalCommandeInterne.setValue(null);
                txtQuantiteCommandeInterne.clear();

                // Recharger les lignes de commande
                loadLignesCommandeInterne(selectedCommandeInterne.getIdCommande());
            }


            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de l'ajout de la ligne: " + e.getMessage());
        }
    }
    private void loadLignesCommandeInterne(int idCommande) {
        try {
            // Requête SQL pour récupérer les lignes de commande avec les noms d'articles
            String sql = "SELECT lci.*, a.nom AS nom_article FROM ligne_commande_interne lci " +
                    "JOIN article a ON lci.ref_article = a.reference " +
                    "WHERE lci.id_commande = ?";

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCommande);
            ResultSet rs = pstmt.executeQuery();

            ObservableList<LigneCommandeInterne> lignesList = FXCollections.observableArrayList();

            while (rs.next()) {
                LigneCommandeInterne ligne = new LigneCommandeInterne(
                        rs.getInt("id_ligne"),
                        rs.getInt("id_commande"),
                        rs.getInt("ref_article"),
                        rs.getString("nom_article"),
                        rs.getInt("quantite"),
                        rs.getString("local_source")
                );
                lignesList.add(ligne);
            }

            // Mettre à jour la TableView avec les lignes récupérées
            tableLignesCommandeInterne.setItems(lignesList);

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur",
                    "Erreur lors du chargement des lignes de commande interne: " + e.getMessage());
        }
    }
    @FXML
    private void validateCommandeInterne() {
        try {
            // Vérifier qu'une commande est sélectionnée
            if (selectedCommandeInterne == null) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez sélectionner une commande interne.");
                return;
            }

            // Vérifier que la commande n'est pas déjà validée
            if ("Validée".equals(selectedCommandeInterne.getStatut())) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Cette commande a déjà été validée.");
                return;
            }

            // Demander confirmation
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setHeaderText("Valider la commande interne");
            confirmAlert.setContentText("Êtes-vous sûr de vouloir valider cette commande ? Cette action mettra à jour le stock et ne pourra pas être annulée.");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Connection conn = null;
                try {
                    conn = DB.getConnection();
                    conn.setAutoCommit(false);

                    // 1. Mettre à jour le statut de la commande
                    String updateCommandeSql = "UPDATE commande_interne SET statut = 'Validée' WHERE id_commande = ?";
                    PreparedStatement updateCommandeStmt = conn.prepareStatement(updateCommandeSql);
                    updateCommandeStmt.setInt(1, selectedCommandeInterne.getIdCommande());
                    updateCommandeStmt.executeUpdate();
                    updateCommandeStmt.close();

                    // 2. Récupérer toutes les lignes de la commande (avec ResultSet scrollable)
                    String getLignesSql = "SELECT * FROM ligne_commande_interne WHERE id_commande = ?";
                    PreparedStatement getLignesStmt = conn.prepareStatement(
                            getLignesSql,
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    getLignesStmt.setInt(1, selectedCommandeInterne.getIdCommande());
                    ResultSet lignesRs = getLignesStmt.executeQuery();

                    // 3. Vérifier d'abord que tous les articles sont disponibles en stock
                    String checkStockSql = "SELECT reference, qte FROM article WHERE reference = ?";
                    PreparedStatement checkStockStmt = conn.prepareStatement(checkStockSql);

                    boolean stockDisponible = true;
                    List<Integer> articlesInsuffisants = new ArrayList<>();

                    while (lignesRs.next()) {
                        int refArticle = lignesRs.getInt("ref_article");
                        int quantite = lignesRs.getInt("quantite");

                        checkStockStmt.setInt(1, refArticle);
                        ResultSet stockRs = checkStockStmt.executeQuery();

                        if (stockRs.next()) {
                            int qteDisponible = stockRs.getInt("qte");
                            if (qteDisponible < quantite) {
                                stockDisponible = false;
                                articlesInsuffisants.add(refArticle);
                            }
                        }
                        stockRs.close();
                    }

                    if (!stockDisponible) {
                        conn.rollback();
                        showMsg(Alert.AlertType.ERROR, "Erreur", "Stock insuffisant pour les articles: " + articlesInsuffisants);
                        return;
                    }

                    // 4. Si tout est OK, procéder à la mise à jour du stock
                    lignesRs.beforeFirst(); // Maintenant possible car le ResultSet est scrollable

                    String updateStockSql = "UPDATE article SET qte = qte - ? WHERE reference = ?";
                    PreparedStatement updateStockStmt = conn.prepareStatement(updateStockSql);

                    String insertMouvementSql = "INSERT INTO mouvement_stock (ref_article, date_mouvement, type_mouvement, quantite, source_destination) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertMouvementStmt = conn.prepareStatement(insertMouvementSql);

                    while (lignesRs.next()) {
                        int refArticle = lignesRs.getInt("ref_article");
                        int quantite = lignesRs.getInt("quantite");

                        // Mettre à jour le stock
                        updateStockStmt.setInt(1, quantite);
                        updateStockStmt.setInt(2, refArticle);
                        updateStockStmt.executeUpdate();

                        // Enregistrer le mouvement
                        insertMouvementStmt.setInt(1, refArticle);
                        insertMouvementStmt.setDate(2, Date.valueOf(LocalDate.now()));
                        insertMouvementStmt.setString(3, "SORTIE");
                        insertMouvementStmt.setInt(4, quantite);
                        insertMouvementStmt.setString(5, "Commande interne #" + selectedCommandeInterne.getIdCommande());
                        insertMouvementStmt.executeUpdate();
                    }

                    // Fermer toutes les ressources
                    lignesRs.close();
                    getLignesStmt.close();
                    updateStockStmt.close();
                    insertMouvementStmt.close();
                    checkStockStmt.close();

                    conn.commit();
                    showMsg(Alert.AlertType.INFORMATION, "Succès", "La commande a été validée et le stock a été mis à jour.");

                    // Recharger les commandes
                    loadCommandesInternes();
                } catch (SQLException e) {
                    if (conn != null) {
                        try {
                            conn.rollback();
                        } catch (SQLException ex) {
                            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du rollback: " + ex.getMessage());
                        }
                    }
                    showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la validation: " + e.getMessage());
                } finally {
                    if (conn != null) {
                        try {
                            conn.setAutoCommit(true);
                            conn.close();
                        } catch (SQLException e) {

                            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la fermeture de la connexion: " + e.getMessage());
                        }
                    }
                }
            }
            updateInventaireFromCommandeInterne(selectedCommandeInterne.getIdCommande());


        } catch (Exception e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la validation: " + e.getMessage());
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



        // Charger les données initiales


    }


    //88//
    // Variable pour stocker la commande externe sélectionnée
    private CommandeExterne selectedCommandeExterne;

    // Méthode pour initialiser la vue des commandes externes
    private void initCommandeExterneView() {
        // Initialiser les colonnes du tableau des commandes externes
        colIdCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
        colFournisseurCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("nomFournisseur"));
        colDateCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("dateCommande"));
        colStatutCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colDescriptionCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Initialiser les colonnes du tableau des lignes de commande externe
        colRefArticleCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("refArticle"));
        colNomArticleCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
        colQuantiteCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colLocalCommandeExterne.setCellValueFactory(new PropertyValueFactory<>("localDestination"));

        // Charger les fournisseurs dans le combobox
        loadFournisseursIntoComboBox();

        // Charger les articles dans le combobox
        loadArticlesIntoComboBox();

        // Charger les locaux dans le combobox
        loadLocauxIntoComboBox();

        // Définir la date actuelle par défaut
        dateDateCommandeExterne.setValue(LocalDate.now());

        // Charger toutes les commandes externes
        loadCommandesExternes();

        // Ajouter un listener pour la sélection d'une commande
        tableCommandeExterne.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedCommandeExterne = newSelection;
                loadLignesCommandeExterne(selectedCommandeExterne.getIdCommande());
            }
        });
    }

    // Méthode pour charger les commandes externes depuis la base de données
    private void loadCommandesExternes() {
        try {
            String sql = "SELECT ce.*, f.nom AS nom_fournisseur FROM commande_externe ce " +
                    "JOIN fournisseur f ON ce.id_fournisseur = f.id_fournisseur " +
                    "ORDER BY ce.date_commande DESC";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<CommandeExterne> commandesList = FXCollections.observableArrayList();

            while (rs.next()) {
                CommandeExterne commande = new CommandeExterne(
                        rs.getInt("id_commande"),
                        rs.getInt("id_fournisseur"),
                        rs.getString("nom_fournisseur"),
                        rs.getDate("date_commande").toLocalDate(),
                        rs.getString("statut"),
                        rs.getString("description")
                );
                commandesList.add(commande);
            }

            tableCommandeExterne.setItems(commandesList);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des commandes externes: " + e.getMessage());
        }
    }

    // Méthode pour charger les lignes d'une commande externe spécifique
    private void loadLignesCommandeExterne(int idCommande) {
        try {
            String sql = "SELECT lce.*, a.nom AS nom_article FROM ligne_commande_externe lce " +
                    "JOIN article a ON lce.ref_article = a.reference " +
                    "WHERE lce.id_commande = ?";

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCommande);
            ResultSet rs = pstmt.executeQuery();

            ObservableList<LigneCommandeExterne> lignesList = FXCollections.observableArrayList();

            while (rs.next()) {
                LigneCommandeExterne ligne = new LigneCommandeExterne(
                        rs.getInt("id_ligne"),
                        rs.getInt("id_commande"),
                        rs.getInt("ref_article"),
                        rs.getString("nom_article"),
                        rs.getInt("quantite"),
                        rs.getString("local_destination")
                );
                lignesList.add(ligne);
            }

            tableLignesCommandeExterne.setItems(lignesList);

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des lignes de commande: " + e.getMessage());
        }
    }

    // Méthode pour créer une nouvelle commande externe
    @FXML
    private void createCommandeExterne() {
        try {
            // Vérifier les entrées
            if (comboFournisseurCommandeExterne.getValue() == null || dateDateCommandeExterne.getValue() == null) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez sélectionner un fournisseur et une date.");
                return;
            }

            // Créer la commande
            String sql = "INSERT INTO commande_externe (id_fournisseur, date_commande, statut, description) " +
                    "VALUES (?, ?, ?, ?)";

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, comboFournisseurCommandeExterne.getValue().getId_fournisseur());
            pstmt.setDate(2, Date.valueOf(dateDateCommandeExterne.getValue()));
            pstmt.setString(3, "En attente");
            pstmt.setString(4, txtDescriptionCommandeExterne.getText());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // Récupérer l'ID généré
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);

                    showMsg(Alert.AlertType.INFORMATION, "Succès", "Commande externe créée avec succès. ID: " + generatedId);

                    // Réinitialiser les champs
                    comboFournisseurCommandeExterne.setValue(null);
                    dateDateCommandeExterne.setValue(LocalDate.now());
                    txtDescriptionCommandeExterne.clear();

                    // Recharger les commandes
                    loadCommandesExternes();
                }
                rs.close();
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la création de la commande: " + e.getMessage());
        }
    }

    // Méthode pour ajouter une ligne à la commande externe sélectionnée
    @FXML
    private void addLigneCommandeExterne() {
        try {
            // Vérifier qu'une commande est sélectionnée
            if (selectedCommandeExterne == null) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez sélectionner une commande externe.");
                return;
            }

            // Vérifier que la commande n'est pas déjà validée
            if ("Validée".equals(selectedCommandeExterne.getStatut())) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Impossible de modifier une commande validée.");
                return;
            }

            // Vérifier les entrées
            if (comboArticleCommandeExterne.getValue() == null ||
                    comboLocalCommandeExterne.getValue() == null ||
                    txtQuantiteCommandeExterne.getText().isEmpty()) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez remplir tous les champs.");
                return;
            }

            // Vérifier que la quantité est un nombre positif
            int quantite;
            try {
                quantite = Integer.parseInt(txtQuantiteCommandeExterne.getText());
                if (quantite <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                showMsg(Alert.AlertType.WARNING, "Validation", "La quantité doit être un nombre entier positif.");
                return;
            }

            // Ajouter la ligne de commande
            String sql = "INSERT INTO ligne_commande_externe (id_commande, ref_article, quantite, " +
                    "local_destination) " +
                    "VALUES (?, ?, ?, ?)";

            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, selectedCommandeExterne.getIdCommande());
            pstmt.setInt(2, comboArticleCommandeExterne.getValue().getRef());
            pstmt.setInt(3, quantite);
            pstmt.setString(4, comboLocalCommandeExterne.getValue().getNom());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                showMsg(Alert.AlertType.INFORMATION, "Succès", "Ligne de commande ajoutée avec succès.");

                // Réinitialiser les champs
                comboArticleCommandeExterne.setValue(null);
                comboLocalCommandeExterne.setValue(null);
                txtQuantiteCommandeExterne.clear();

                // Recharger les lignes de commande
                loadLignesCommandeExterne(selectedCommandeExterne.getIdCommande());
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de l'ajout de la ligne: " + e.getMessage());
        }
    }
    //55

    //55

    // Méthode pour valider une commande externe et mettre à jour le stock
    @FXML
    private void validateCommandeExterne() {
        try {
            // Vérifier qu'une commande est sélectionnée
            if (selectedCommandeExterne == null) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Veuillez sélectionner une commande externe.");
                return;
            }

            // Vérifier que la commande n'est pas déjà validée
            if ("Validée".equals(selectedCommandeExterne.getStatut())) {
                showMsg(Alert.AlertType.WARNING, "Validation", "Cette commande a déjà été validée.");
                return;
            }

            // Demander confirmation
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setHeaderText("Valider la commande externe");
            confirmAlert.setContentText("Êtes-vous sûr de vouloir valider cette commande ? Cette action mettra à jour le stock et ne pourra pas être annulée.");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Connection conn = null;
                try {
                    conn = DB.getConnection();
                    conn.setAutoCommit(false);

                    // Mettre à jour le statut de la commande
                    String updateCommandeSql = "UPDATE commande_externe SET statut = 'Validée' WHERE id_commande = ?";
                    PreparedStatement updateCommandeStmt = conn.prepareStatement(updateCommandeSql);
                    updateCommandeStmt.setInt(1, selectedCommandeExterne.getIdCommande());
                    updateCommandeStmt.executeUpdate();
                    updateCommandeStmt.close();

                    // Récupérer toutes les lignes de la commande
                    String getLignesSql = "SELECT * FROM ligne_commande_externe WHERE id_commande = ?";
                    PreparedStatement getLignesStmt = conn.prepareStatement(getLignesSql);
                    getLignesStmt.setInt(1, selectedCommandeExterne.getIdCommande());
                    ResultSet lignesRs = getLignesStmt.executeQuery();

                    // Mettre à jour le stock pour chaque ligne
                    String updateStockSql = "UPDATE article SET qte = qte + ? WHERE reference = ?";
                    PreparedStatement updateStockStmt = conn.prepareStatement(updateStockSql);

                    // Ajouter les mouvements de stock
                    String insertMouvementSql = "INSERT INTO mouvement_stock (ref_article, date_mouvement, type_mouvement, quantite, source_destination) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertMouvementStmt = conn.prepareStatement(insertMouvementSql);

                    while (lignesRs.next()) {
                        int refArticle = lignesRs.getInt("ref_article");
                        int quantite = lignesRs.getInt("quantite");



                        // Mettre à jour le stock
                        updateStockStmt.setInt(1, quantite);
                        updateStockStmt.setInt(2, refArticle);
                        updateStockStmt.executeUpdate();

                        // Enregistrer le mouvement
                        insertMouvementStmt.setInt(1, refArticle);
                        insertMouvementStmt.setDate(2, Date.valueOf(LocalDate.now()));
                        insertMouvementStmt.setString(3, "ENTREE");
                        insertMouvementStmt.setInt(4, quantite);
                        insertMouvementStmt.setString(5, "Commande externe #" + selectedCommandeExterne.getIdCommande());
                        insertMouvementStmt.executeUpdate();
                    }

                    lignesRs.close();
                    getLignesStmt.close();
                    updateStockStmt.close();
                    insertMouvementStmt.close();

                    conn.commit();

                    showMsg(Alert.AlertType.INFORMATION, "Succès", "La commande a été validée et le stock a été mis à jour.");

                    // Recharger les commandes
                    loadCommandesExternes();
                } catch (SQLException e) {
                    if (conn != null) {
                        try {
                            conn.rollback();
                        } catch (SQLException ex) {
                            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du rollback: " + ex.getMessage());
                        }
                    }
                    showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la validation: " + e.getMessage());
                } finally {
                    if (conn != null) {
                        try {
                            conn.setAutoCommit(true);
                            conn.close();
                        } catch (SQLException e) {
                            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la fermeture de la connexion: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la validation: " + e.getMessage());
        }
    }
    // Méthode pour charger les fournisseurs dans le ComboBox
    private void loadFournisseursIntoComboBox() {
        try {
            String sql = "SELECT * FROM fournisseur ORDER BY nom";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<Fournisseur> fournisseursList = FXCollections.observableArrayList();

            while (rs.next()) {
                Fournisseur fournisseur = new Fournisseur(
                        rs.getInt("id_fournisseur"),
                        rs.getString("nom"),
                        rs.getString("contact"),
                        rs.getString("adresse")
                );
                fournisseursList.add(fournisseur);
            }

            comboFournisseurCommandeExterne.setItems(fournisseursList);

            // Définir comment afficher les fournisseurs dans le ComboBox
            comboFournisseurCommandeExterne.setCellFactory(param -> new ListCell<Fournisseur>() {
                @Override
                protected void updateItem(Fournisseur item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNom());
                    }
                }
            });

            comboFournisseurCommandeExterne.setConverter(new StringConverter<Fournisseur>() {
                @Override
                public String toString(Fournisseur fournisseur) {
                    if (fournisseur == null) {
                        return null;
                    }
                    return fournisseur.getNom();
                }

                @Override
                public Fournisseur fromString(String string) {
                    return null; // Non utilisé
                }
            });

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des fournisseurs: " + e.getMessage());
        }
    }

    // Méthode pour charger les articles dans le ComboBox
    private void loadArticlesIntoComboBox() {
        try {
            String sql = "SELECT * FROM article ORDER BY nom";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<Article> articlesList = FXCollections.observableArrayList();

            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("reference"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getInt("qte"),
                        rs.getString("local"),
                        rs.getInt("qteMin"),
                        rs.getDate("date") != null ? rs.getDate("date").toLocalDate() : null
                );
                articlesList.add(article);
            }

            // Configurer les ComboBox pour les commandes externes et internes
            comboArticleCommandeExterne.setItems(articlesList);
            comboArticleCommandeInterne.setItems(articlesList);

            // Définir comment afficher les articles dans le ComboBox (commandes externes)
            comboArticleCommandeExterne.setCellFactory(param -> new ListCell<Article>() {
                @Override
                protected void updateItem(Article item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getRef() + " - " + item.getNom());
                    }
                }
            });

            comboArticleCommandeExterne.setConverter(new StringConverter<Article>() {
                @Override
                public String toString(Article article) {
                    if (article == null) {
                        return null;
                    }
                    return article.getRef() + " - " + article.getNom();
                }

                @Override
                public Article fromString(String string) {
                    return null; // Non utilisé
                }
            });

            // Définir comment afficher les articles dans le ComboBox (commandes internes)
            comboArticleCommandeInterne.setCellFactory(param -> new ListCell<Article>() {
                @Override
                protected void updateItem(Article item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getRef() + " - " + item.getNom());
                    }
                }
            });

            comboArticleCommandeInterne.setConverter(new StringConverter<Article>() {
                @Override
                public String toString(Article article) {
                    if (article == null) {
                        return null;
                    }
                    return article.getRef() + " - " + article.getNom();
                }

                @Override
                public Article fromString(String string) {
                    return null; // Non utilisé
                }
            });

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des articles: " + e.getMessage());
        }
    }

    // Méthode pour charger les locaux dans le ComboBox
    private void loadLocauxIntoComboBox() {
        try {
            String sql = "SELECT * FROM local ORDER BY nom";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<Local> locauxList = FXCollections.observableArrayList();

            while (rs.next()) {
                Local local = new Local(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("type")
                );
                locauxList.add(local);
            }

            // Configurer les ComboBox pour les commandes externes et internes
            comboLocalCommandeExterne.setItems(locauxList);
            comboLocalCommandeInterne.setItems(locauxList);

            // Définir comment afficher les locaux dans le ComboBox (commandes externes)
            comboLocalCommandeExterne.setCellFactory(param -> new ListCell<Local>() {
                @Override
                protected void updateItem(Local item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNom() + " (" + item.getType() + ")");
                    }
                }
            });

            comboLocalCommandeExterne.setConverter(new StringConverter<Local>() {
                @Override
                public String toString(Local local) {
                    if (local == null) {
                        return null;
                    }
                    return local.getNom() + " (" + local.getType() + ")";
                }

                @Override
                public Local fromString(String string) {
                    return null; // Non utilisé
                }
            });

            // Définir comment afficher les locaux dans le ComboBox (commandes internes)
            comboLocalCommandeInterne.setCellFactory(param -> new ListCell<Local>() {
                @Override
                protected void updateItem(Local item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNom() + " (" + item.getType() + ")");
                    }
                }
            });

            comboLocalCommandeInterne.setConverter(new StringConverter<Local>() {
                @Override
                public String toString(Local local) {
                    if (local == null) {
                        return null;
                    }
                    return local.getNom() + " (" + local.getType() + ")";
                }

                @Override
                public Local fromString(String string) {
                    return null; // Non utilisé
                }
            });

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des locaux: " + e.getMessage());
        }
    }




    // Méthode pour charger les services dans le ComboBox
    private void loadServicesIntoComboBox() {
        try {
            String sql = "SELECT * FROM service ORDER BY nom";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<Service> servicesList = FXCollections.observableArrayList();

            while (rs.next()) {
                Service service = new Service(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("contact"),
                        rs.getString("responsable")
                );
                servicesList.add(service);
            }

            comboServiceCommandeInterne.setItems(servicesList);

            // Définir comment afficher les services dans le ComboBox
            comboServiceCommandeInterne.setCellFactory(param -> new ListCell<Service>() {
                @Override
                protected void updateItem(Service item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNom());
                    }
                }
            });

            comboServiceCommandeInterne.setConverter(new StringConverter<Service>() {
                @Override
                public String toString(Service service) {
                    if (service == null) {
                        return null;
                    }
                    return service.getNom();
                }

                @Override
                public Service fromString(String string) {
                    return null; // Non utilisé
                }
            });

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des services: " + e.getMessage());
        }
    }

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

        initCommandeExterneView();
        initCommandeInterneView();
        initInventaireView();


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
                int id = rs.getInt("id_fournisseur");
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
                localArticle.getItems().add(rs.getString("nom"));
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
            localArticle.getItems().add(nomLocal.getText());
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
            localArticle.getItems().remove(a.getNom());
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
        String req2 = "SELECT COALESCE(MAX(id_fournisseur), 0) + 1 FROM fournisseur";
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
                + "WHERE id_fournisseur = ?";
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
        String req = "SELECT * FROM fournisseur WHERE id_fournisseur = ?";
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
        String req = "DELETE FROM fournisseur WHERE id_fournisseur = ?";
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
    //ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
    @FXML private AnchorPane pageInventaire;
    @FXML private ComboBox<Service> comboServiceInventaire;
    @FXML private ComboBox<Local> comboLocalInventaire;
    @FXML private ComboBox<String> comboCategorieInventaire;
    @FXML private TextField rechercheArticleInventaire;
    @FXML private TableView<InventaireItem> tableInventaire;
    @FXML private TableColumn<InventaireItem, Integer> colRefArticleInventaire;
    @FXML private TableColumn<InventaireItem, String> colNomArticleInventaire;
    @FXML private TableColumn<InventaireItem, String> colCategorieArticleInventaire;
    @FXML private TableColumn<InventaireItem, String> colServiceInventaire;
    @FXML private TableColumn<InventaireItem, String> colLocalInventaire;
    @FXML private TableColumn<InventaireItem, Integer> colQuantiteInventaire;
    @FXML private TableColumn<InventaireItem, LocalDate> colDateAffectationInventaire;
    @FXML private Label totalItemsInventaire;
    @FXML private Pane chartServiceInventaire;
    @FXML private Pane chartLocalInventaire;

    private ObservableList<InventaireItem> inventaireItems = FXCollections.observableArrayList();

    // Méthode pour initialiser la vue d'inventaire dans la méthode initialize()
    private void initInventaireView() {
        // Initialiser les colonnes du tableau d'inventaire
        colRefArticleInventaire.setCellValueFactory(new PropertyValueFactory<>("refArticle"));
        colNomArticleInventaire.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
        colCategorieArticleInventaire.setCellValueFactory(new PropertyValueFactory<>("categorieArticle"));
        colServiceInventaire.setCellValueFactory(new PropertyValueFactory<>("service"));
        colLocalInventaire.setCellValueFactory(new PropertyValueFactory<>("local"));
        colQuantiteInventaire.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colDateAffectationInventaire.setCellValueFactory(new PropertyValueFactory<>("dateAffectation"));

        // Format de date pour la colonne de date
        colDateAffectationInventaire.setCellFactory(column -> new TableCell<InventaireItem, LocalDate>() {
            @Override
            protected void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (empty || date == null) {
                    setText(null);
                } else {
                    setText(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
            }
        });

        // Charger les services dans le ComboBox
        loadServicesIntoInventaireComboBox();

        // Charger les locaux dans le ComboBox
        loadLocauxIntoInventaireComboBox();

        // Charger les catégories dans le ComboBox
        loadCategoriesIntoInventaireComboBox();

        // Initialiser le tableau avec les données d'inventaire
        loadInventaireData();
    }

// Ajouter cette référence dans la map des pages dans switchPage()
// Map<Button, AnchorPane> pageMap = Map.of(
//     ...
//     btnInventaire, pageInventaire
// );

    // Méthode pour charger les services dans le ComboBox d'inventaire
    private void loadServicesIntoInventaireComboBox() {
        try {
            String sql = "SELECT * FROM service ORDER BY nom";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<Service> servicesList = FXCollections.observableArrayList();
            // Ajouter une option "Tous les services"
            servicesList.add(new Service(0, "Tous les services", "", "", ""));

            while (rs.next()) {
                Service service = new Service(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("contact"),
                        rs.getString("responsable")
                );
                servicesList.add(service);
            }

            comboServiceInventaire.setItems(servicesList);
            comboServiceInventaire.getSelectionModel().selectFirst(); // Sélectionne "Tous les services"

            // Définir comment afficher les services dans le ComboBox
            comboServiceInventaire.setCellFactory(param -> new ListCell<Service>() {
                @Override
                protected void updateItem(Service item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNom());
                    }
                }
            });

            comboServiceInventaire.setConverter(new StringConverter<Service>() {
                @Override
                public String toString(Service service) {
                    if (service == null) {
                        return null;
                    }
                    return service.getNom();
                }

                @Override
                public Service fromString(String string) {
                    return null; // Non utilisé
                }
            });

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des services: " + e.getMessage());
        }
    }

    // Méthode pour charger les locaux dans le ComboBox d'inventaire
    private void loadLocauxIntoInventaireComboBox() {
        try {
            String sql = "SELECT * FROM local ORDER BY nom";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<Local> locauxList = FXCollections.observableArrayList();
            // Ajouter une option "Tous les locaux"
            locauxList.add(new Local(0, "Tous les locaux", ""));

            while (rs.next()) {
                Local local = new Local(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("type")
                );
                locauxList.add(local);
            }

            comboLocalInventaire.setItems(locauxList);
            comboLocalInventaire.getSelectionModel().selectFirst(); // Sélectionne "Tous les locaux"

            // Définir comment afficher les locaux dans le ComboBox
            comboLocalInventaire.setCellFactory(param -> new ListCell<Local>() {
                @Override
                protected void updateItem(Local item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNom() + (item.getType().isEmpty() ? "" : " (" + item.getType() + ")"));
                    }
                }
            });

            comboLocalInventaire.setConverter(new StringConverter<Local>() {
                @Override
                public String toString(Local local) {
                    if (local == null) {
                        return null;
                    }
                    return local.getNom() + (local.getType().isEmpty() ? "" : " (" + local.getType() + ")");
                }

                @Override
                public Local fromString(String string) {
                    return null; // Non utilisé
                }
            });

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des locaux: " + e.getMessage());
        }
    }

    // Méthode pour charger les catégories dans le ComboBox d'inventaire
    private void loadCategoriesIntoInventaireComboBox() {
        try {
            String sql = "SELECT DISTINCT categorie FROM article ORDER BY categorie";

            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<String> categoriesList = FXCollections.observableArrayList();
            // Ajouter une option "Toutes les catégories"
            categoriesList.add("Toutes les catégories");

            while (rs.next()) {
                String categorie = rs.getString("categorie");
                if (categorie != null && !categorie.isEmpty()) {
                    categoriesList.add(categorie);
                }
            }

            comboCategorieInventaire.setItems(categoriesList);
            comboCategorieInventaire.getSelectionModel().selectFirst(); // Sélectionne "Toutes les catégories"

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des catégories: " + e.getMessage());
        }
    }

    // Méthode pour charger les données d'inventaire
    private void loadInventaireData() {
        try {
            // Base de la requête SQL
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT i.ref_article, a.nom AS nom_article, a.categorie, ");
            sqlBuilder.append("s.nom AS nom_service, l.nom AS nom_local, i.quantite, i.date_affectation ");
            sqlBuilder.append("FROM inventaire i ");
            sqlBuilder.append("JOIN article a ON i.ref_article = a.reference ");
            sqlBuilder.append("JOIN service s ON i.id_service = s.id ");
            sqlBuilder.append("JOIN local l ON i.id_local = l.id ");

            // Ajouter des conditions de filtrage si nécessaire
            List<Object> parameters = new ArrayList<>();
            boolean whereAdded = false;

            if (comboServiceInventaire.getValue() != null && comboServiceInventaire.getValue().getIdservice() != 0) {
                sqlBuilder.append(whereAdded ? " AND " : " WHERE ");
                sqlBuilder.append("i.id_service = ?");
                parameters.add(comboServiceInventaire.getValue().getIdservice());
                whereAdded = true;
            }

            if (comboLocalInventaire.getValue() != null && comboLocalInventaire.getValue().getId() != 0) {
                sqlBuilder.append(whereAdded ? " AND " : " WHERE ");
                sqlBuilder.append("i.id_local = ?");
                parameters.add(comboLocalInventaire.getValue().getId());
                whereAdded = true;
            }

            if (comboCategorieInventaire.getValue() != null && !comboCategorieInventaire.getValue().equals("Toutes les catégories")) {
                sqlBuilder.append(whereAdded ? " AND " : " WHERE ");
                sqlBuilder.append("a.categorie = ?");
                parameters.add(comboCategorieInventaire.getValue());
                whereAdded = true;
            }

            String rechercheText = rechercheArticleInventaire.getText().trim();
            if (!rechercheText.isEmpty()) {
                sqlBuilder.append(whereAdded ? " AND " : " WHERE ");
                sqlBuilder.append("a.nom LIKE ?");
                parameters.add("%" + rechercheText + "%");
                whereAdded = true;
            }

            // Ordre
            sqlBuilder.append(" ORDER BY s.nom, l.nom, a.nom");

            // Exécuter la requête
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString());

            // Définir les paramètres
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            ResultSet rs = pstmt.executeQuery();

            ObservableList<InventaireItem> items = FXCollections.observableArrayList();

            while (rs.next()) {
                InventaireItem item = new InventaireItem(
                        rs.getInt("ref_article"),
                        rs.getString("nom_article"),
                        rs.getString("categorie"),
                        rs.getString("nom_service"),
                        rs.getString("nom_local"),
                        rs.getInt("quantite"),
                        rs.getDate("date_affectation") != null ? rs.getDate("date_affectation").toLocalDate() : null
                );
                items.add(item);
            }

            tableInventaire.setItems(items);
            inventaireItems = items;

            // Mettre à jour le compteur total
            totalItemsInventaire.setText("Total: " + items.size() + " articles");

            rs.close();
            pstmt.close();
            conn.close();

            // Mettre à jour les graphiques statistiques
            updateInventaireCharts();

        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement des données d'inventaire: " + e.getMessage());
        }
    }

    // Mise à jour des graphiques de l'inventaire
    private void updateInventaireCharts() {
        // Cette partie serait implémentée avec JavaFX Charts (PieChart, BarChart, etc.)
        // Mais nécessite des dépendances et du code supplémentaire pour la visualisation
        // Je fournis ici le squelette de la méthode que vous pourrez compléter
    }

    // Méthode pour la recherche d'inventaire par article
    @FXML
    private void rechercherInventaireParArticle(KeyEvent event) {
        loadInventaireData();
    }

    // Méthode pour rechercher dans l'inventaire
    @FXML
    private void rechercherInventaire() {
        loadInventaireData();
    }

    // Méthode pour réinitialiser les filtres d'inventaire
    @FXML
    private void resetInventaire() {
        comboServiceInventaire.getSelectionModel().selectFirst();
        comboLocalInventaire.getSelectionModel().selectFirst();
        comboCategorieInventaire.getSelectionModel().selectFirst();
        rechercheArticleInventaire.clear();
        loadInventaireData();
    }

    // Méthode pour exporter l'inventaire en PDF
    @FXML
    private void exporterInventairePDF() {
        try {
            // Create a file chooser to select the save location
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Enregistrer le rapport d'inventaire");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fileChooser.setInitialFileName("Inventaire_" +
                    LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".pdf");
            File file = fileChooser.showSaveDialog(null);

            if (file == null) {
                return; // User canceled the file chooser
            }

            // Initialize PDF writer and document
            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4.rotate()); // Landscape format
            document.setMargins(20, 20, 20, 20);

            // Add title
            document.add(new Paragraph("Rapport d'Inventaire")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold()
                    .setMarginBottom(20));

            // Add report date
            document.add(new Paragraph("Date du rapport: " +
                    LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(12)
                    .setMarginBottom(10));

            // Add filter information table
            Table infoTable = new Table(new float[]{1, 3});
            infoTable.setWidth(UnitValue.createPercentValue(100));
            infoTable.addCell(new Cell().add(new Paragraph("Service:")).setBold());
            infoTable.addCell(new Cell().add(new Paragraph(comboServiceInventaire.getValue() != null ?
                    comboServiceInventaire.getValue().getNom() : "Tous les services")));
            infoTable.addCell(new Cell().add(new Paragraph("Local:")).setBold());
            infoTable.addCell(new Cell().add(new Paragraph(comboLocalInventaire.getValue() != null ?
                    comboLocalInventaire.getValue().getNom() : "Tous les locaux")));
            infoTable.addCell(new Cell().add(new Paragraph("Catégorie:")).setBold());
            infoTable.addCell(new Cell().add(new Paragraph(comboCategorieInventaire.getValue() != null ?
                    comboCategorieInventaire.getValue() : "Toutes les catégories")));

            String rechercheText = rechercheArticleInventaire.getText().trim();
            if (!rechercheText.isEmpty()) {
                infoTable.addCell(new Cell().add(new Paragraph("Recherche:")).setBold());
                infoTable.addCell(new Cell().add(new Paragraph(rechercheText)));
            }

            document.add(infoTable);
            document.add(new Paragraph("\n"));

            // Create inventory data table
            Table table = new Table(new float[]{1, 3, 2, 2, 2, 1, 2});
            table.setWidth(UnitValue.createPercentValue(100));

            // Add table headers
            String[] headers = {"Référence", "Article", "Catégorie", "Service", "Local", "Quantité", "Date d'affectation"};
            for (String header : headers) {
                table.addHeaderCell(new Cell()
                        .add(new Paragraph(header))
                        .setBold()
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.CENTER));
            }

            // Add data rows
            int total = 0;
            for (InventaireItem item : inventaireItems) {
                table.addCell(new Cell()
                        .add(new Paragraph(String.valueOf(item.getRefArticle())))
                        .setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(item.getNomArticle())));
                table.addCell(new Cell().add(new Paragraph(item.getCategorieArticle())));
                table.addCell(new Cell().add(new Paragraph(item.getService())));
                table.addCell(new Cell().add(new Paragraph(item.getLocal())));
                table.addCell(new Cell()
                        .add(new Paragraph(String.valueOf(item.getQuantite())))
                        .setTextAlignment(TextAlignment.CENTER));
                String dateStr = item.getDateAffectation() != null ?
                        item.getDateAffectation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
                table.addCell(new Cell()
                        .add(new Paragraph(dateStr))
                        .setTextAlignment(TextAlignment.CENTER));
                total += item.getQuantite();
            }

            document.add(table);

            // Add total
            document.add(new Paragraph("Total des articles: " + total)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(12)
                    .setBold()
                    .setMarginTop(10));

            // Add footer
            document.add(new Paragraph("Document généré automatiquement par le système de gestion de stock")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8)
                    .setMarginTop(20));

            // Close the document
            document.close();
            writer.close();

            // Show success message
            showMsg(Alert.AlertType.INFORMATION, "Export PDF",
                    "Le rapport d'inventaire a été exporté avec succès vers:\n" + file.getAbsolutePath());

            // Open the PDF with the default application
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showMsg(Alert.AlertType.ERROR, "Erreur",
                    "Erreur lors de l'exportation du PDF: " + e.getMessage());
        }
    }


    // Méthode pour exporter l'inventaire en Excel
    @FXML
    private void exporterInventaireExcel() {
        // Cette méthode nécessite des bibliothèques pour la génération d'Excel comme Apache POI
        showMsg(Alert.AlertType.INFORMATION, "Export Excel", "Fonctionnalité d'export Excel à implémenter.");
    }

    // Méthode pour mettre à jour l'inventaire lors de la validation d'une commande interne
// À appeler depuis validateCommandeInterne après la mise à jour du stock
    private void updateInventaireFromCommandeInterne(int idCommande) {
        try {
            Connection conn = DB.getConnection();
            conn.setAutoCommit(false);

            try {
                // 1. Récupérer toutes les lignes de la commande
                String getLignesSql = "SELECT lci.*, ci.id_service, a.nom AS nom_article, a.categorie " +
                        "FROM ligne_commande_interne lci " +
                        "JOIN commande_interne ci ON lci.id_commande = ci.id_commande " +
                        "JOIN article a ON lci.ref_article = a.reference " +
                        "WHERE lci.id_commande = ?";

                PreparedStatement getLignesStmt = conn.prepareStatement(getLignesSql);
                getLignesStmt.setInt(1, idCommande);
                ResultSet lignesRs = getLignesStmt.executeQuery();

                // 2. Pour chaque ligne, mettre à jour ou créer une entrée d'inventaire
                String checkInventaireSql = "SELECT id FROM inventaire WHERE ref_article = ? AND id_service = ? AND id_local = ?";
                PreparedStatement checkInventaireStmt = conn.prepareStatement(checkInventaireSql);

                String updateInventaireSql = "UPDATE inventaire SET quantite = quantite + ? WHERE id = ?";
                PreparedStatement updateInventaireStmt = conn.prepareStatement(updateInventaireSql);

                String insertInventaireSql = "INSERT INTO inventaire (ref_article, id_service, id_local, quantite, date_affectation) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertInventaireStmt = conn.prepareStatement(insertInventaireSql);

                String getLocalIdSql = "SELECT id FROM local WHERE nom = ?";
                PreparedStatement getLocalIdStmt = conn.prepareStatement(getLocalIdSql);

                while (lignesRs.next()) {
                    int refArticle = lignesRs.getInt("ref_article");
                    int idService = lignesRs.getInt("id_service");
                    String localSource = lignesRs.getString("local_source");
                    int quantite = lignesRs.getInt("quantite");

                    // Récupérer l'ID du local source
                    getLocalIdStmt.setString(1, localSource);
                    ResultSet localRs = getLocalIdStmt.executeQuery();

                    if (localRs.next()) {
                        int idLocal = localRs.getInt("id");

                        // Vérifier si une entrée d'inventaire existe déjà
                        checkInventaireStmt.setInt(1, refArticle);
                        checkInventaireStmt.setInt(2, idService);
                        checkInventaireStmt.setInt(3, idLocal);
                        ResultSet inventaireRs = checkInventaireStmt.executeQuery();

                        if (inventaireRs.next()) {
                            // Mettre à jour l'entrée existante
                            int idInventaire = inventaireRs.getInt("id");
                            updateInventaireStmt.setInt(1, quantite);
                            updateInventaireStmt.setInt(2, idInventaire);
                            updateInventaireStmt.executeUpdate();
                        } else {
                            // Créer une nouvelle entrée
                            insertInventaireStmt.setInt(1, refArticle);
                            insertInventaireStmt.setInt(2, idService);
                            insertInventaireStmt.setInt(3, idLocal);
                            insertInventaireStmt.setInt(4, quantite);
                            insertInventaireStmt.setDate(5, Date.valueOf(LocalDate.now()));
                            insertInventaireStmt.executeUpdate();
                        }

                        inventaireRs.close();
                    }

                    localRs.close();
                }

                // Fermer les ressources
                lignesRs.close();
                getLignesStmt.close();
                checkInventaireStmt.close();
                updateInventaireStmt.close();
                insertInventaireStmt.close();
                getLocalIdStmt.close();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            showMsg(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la mise à jour de l'inventaire: " + e.getMessage());
        }
    }

// Modifier la méthode validateCommandeInterne pour inclure la mise à jour de l'inventaire
// À la fin de la méthode validateCommandeInterne, après avoir validé la commande, ajouter:
// updateInventaireFromCommandeInterne(selectedCommandeInterne.getIdCommande());
@FXML
private void exporterCommandesInternesPDF() {
    try {
        // Reload data to ensure the list is populated
        loadCommandesInternes();

        // Get data from TableView
        ObservableList<CommandeInterne> data = tableCommandeInterne.getItems();

        // Check if data is empty
        if (data.isEmpty()) {
            showMsg(Alert.AlertType.WARNING, "Aucune Donnée", "Aucune commande interne à exporter. Veuillez vérifier les données.");
            return;
        }

        // Create a file chooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le rapport des commandes internes");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        fileChooser.setInitialFileName("CommandesInternes_" +
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".pdf");
        File file = fileChooser.showSaveDialog(null);

        if (file == null) {
            return; // User canceled the file chooser
        }

        // Initialize PDF writer and document
        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate()); // Landscape format
        document.setMargins(20, 20, 20, 20);

        // Add title
        document.add(new Paragraph("Rapport des Commandes Internes")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(20)
                .setBold()
                .setMarginBottom(20));

        // Add report date
        document.add(new Paragraph("Date du rapport: " +
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(12)
                .setMarginBottom(10));

        // Add filter information table
        Table infoTable = new Table(new float[]{1, 3});
        infoTable.setWidth(UnitValue.createPercentValue(100));
        infoTable.addCell(new Cell().add(new Paragraph("Service:")).setBold());
        infoTable.addCell(new Cell().add(new Paragraph(comboServiceCommandeInterne.getValue() != null ?
                comboServiceCommandeInterne.getValue().getNom() : "Tous les services")));

        document.add(infoTable);
        document.add(new Paragraph("\n"));

        // Create commands data table
        Table table = new Table(new float[]{1, 3, 2, 2, 3});
        table.setWidth(UnitValue.createPercentValue(100));

        // Add table headers
        String[] headers = {"ID Commande", "Service", "Date Commande", "Statut", "Description"};
        for (String header : headers) {
            table.addHeaderCell(new Cell()
                    .add(new Paragraph(header))
                    .setBold()
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                    .setTextAlignment(TextAlignment.CENTER));
        }

        // Add data rows
        for (CommandeInterne item : data) {
            table.addCell(new Cell()
                    .add(new Paragraph(String.valueOf(item.getIdCommande())))
                    .setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(item.getNomService() != null ? item.getNomService() : "")));
            String dateStr = item.getDateCommande() != null ?
                    item.getDateCommande().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
            table.addCell(new Cell()
                    .add(new Paragraph(dateStr))
                    .setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(item.getStatut() != null ? item.getStatut() : "")));
            table.addCell(new Cell().add(new Paragraph(item.getDescription() != null ? item.getDescription() : "")));
        }

        document.add(table);

        // Add total
        document.add(new Paragraph("Total des commandes: " + data.size())
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(12)
                .setBold()
                .setMarginTop(10));

        // Add footer
        document.add(new Paragraph("Document généré automatiquement par le système de gestion de stock")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(8)
                .setMarginTop(20));

        // Close the document
        document.close();
        writer.close();

        // Show success message
        showMsg(Alert.AlertType.INFORMATION, "Export PDF",
                "Le rapport des commandes internes a été exporté avec succès vers:\n" + file.getAbsolutePath());

        // Open the PDF with the default application
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }
    } catch (Exception e) {
        e.printStackTrace();
        showMsg(Alert.AlertType.ERROR, "Erreur",
                "Erreur lors de l'exportation du PDF: " + e.getMessage());
    }
}
@FXML

private void exporterCommandesExternesPDF() {
    try {
        // Reload data to ensure the list is populated
        loadCommandesExternes();

        // Get data from TableView
        ObservableList<CommandeExterne> data = tableCommandeExterne.getItems();

        // Check if data is empty
        if (data.isEmpty()) {
            showMsg(Alert.AlertType.WARNING, "Aucune Donnée", "Aucune commande externe à exporter. Veuillez vérifier les données.");
            return;
        }

        // Create a file chooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le rapport des commandes externes");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        fileChooser.setInitialFileName("CommandesExternes_" +
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".pdf");
        File file = fileChooser.showSaveDialog(null);

        if (file == null) {
            return; // User canceled the file chooser
        }

        // Initialize PDF writer and document
        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate()); // Landscape format
        document.setMargins(20, 20, 20, 20);

        // Add title
        document.add(new Paragraph("Rapport des Commandes Externes")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(20)
                .setBold()
                .setMarginBottom(20));

        // Add report date
        document.add(new Paragraph("Date du rapport: " +
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(12)
                .setMarginBottom(10));

        // Add filter information table
        Table infoTable = new Table(new float[]{1, 3});
        infoTable.setWidth(UnitValue.createPercentValue(100));
        infoTable.addCell(new Cell().add(new Paragraph("Fournisseur:")).setBold());
        infoTable.addCell(new Cell().add(new Paragraph(comboFournisseurCommandeExterne.getValue() != null ?
                comboFournisseurCommandeExterne.getValue().getNom() : "Tous les fournisseurs")));

        document.add(infoTable);
        document.add(new Paragraph("\n"));

        // Create commands data table
        Table table = new Table(new float[]{1, 3, 2, 2, 3});
        table.setWidth(UnitValue.createPercentValue(100));

        // Add table headers
        String[] headers = {"ID Commande", "Fournisseur", "Date Commande", "Statut", "Description"};
        for (String header : headers) {
            table.addHeaderCell(new Cell()
                    .add(new Paragraph(header))
                    .setBold()
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                    .setTextAlignment(TextAlignment.CENTER));
        }

        // Add data rows
        for (CommandeExterne item : data) {
            table.addCell(new Cell()
                    .add(new Paragraph(String.valueOf(item.getIdCommande())))
                    .setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(item.getNomFournisseur() != null ? item.getNomFournisseur() : "")));
            String dateStr = item.getDateCommande() != null ?
                    item.getDateCommande().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
            table.addCell(new Cell()
                    .add(new Paragraph(dateStr))
                    .setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(item.getStatut() != null ? item.getStatut() : "")));
            table.addCell(new Cell().add(new Paragraph(item.getDescription() != null ? item.getDescription() : "")));
        }

        document.add(table);

        // Add total
        document.add(new Paragraph("Total des commandes: " + data.size())
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(12)
                .setBold()
                .setMarginTop(10));

        // Add footer
        document.add(new Paragraph("Document généré automatiquement par le système de gestion de stock")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(8)
                .setMarginTop(20));

        // Close the document
        document.close();
        writer.close();

        // Show success message
        showMsg(Alert.AlertType.INFORMATION, "Export PDF",
                "Le rapport des commandes externes a été exporté avec succès vers:\n" + file.getAbsolutePath());

        // Open the PDF with the default application
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }
    } catch (Exception e) {
        e.printStackTrace();
        showMsg(Alert.AlertType.ERROR, "Erreur",
                "Erreur lors de l'exportation du PDF: " + e.getMessage());
    }
}

}



