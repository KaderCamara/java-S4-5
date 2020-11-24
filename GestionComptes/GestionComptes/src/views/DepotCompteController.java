/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.Compte;
import models.Depot;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DepotCompteController implements Initializable {

    @FXML
    private TextField txtNci;
    @FXML
    private TextField txtNomPrenom;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtAdress;
    @FXML
    private TableView<Depot> tblvDepot;
    @FXML
    private TableColumn<Depot, Depot> tblcMnt;
    @FXML
    private TableColumn<Depot, String> tblcDate;
 

    @FXML
    private TableView<Compte> tblvCompte;
    @FXML
    private TableColumn<Compte, String> tblcNumero;
    @FXML
    private TableColumn<Compte, String> tblcSolde;
    @FXML
    private TextField txtMnt;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSearchPartenaire(ActionEvent event) {
    }

    @FXML
    private void handleCreateCompte(ActionEvent event) {
    }
    
}
