/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.utils;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Compte;
import models.Partenaire;
import services.Transaction;

/**
 *
 * @author ASUS
 */
public class Utils {
     @FXML
    public static ObservableList<Compte> handleSearchPartenaire(
            TextField txtNci ,
            TextField txtNomPrenom,
            TextField txtTelephone, 
            TextField txtAdress, 
            TextField txtLogin, 
            TextField txtMdp, 
            Partenaire part, 
            ObservableList oblComptes,
            Transaction service,
            TableView<Compte> tblvCompte,TableColumn<Compte, String> tblcNumero ,TableColumn<Compte, String> tblcSolde
    ) {
        
        String nci = txtNci.getText();
        
        if (oblComptes !=null) {
              oblComptes.clear();

        }
        
  
        part = service.getPartenaireByCni(nci);
        if (part != null) {
            txtNomPrenom.setText(part.getNomComplet());
            txtTelephone.setText(part.getTel());
            txtAdress.setText(part.getAdresse());
            txtLogin.setText(part.getLogin());
            txtMdp.setText(part.getPwd());
            activeOrDisableFields(true, txtNomPrenom,txtTelephone , txtAdress, txtLogin, txtMdp);
            List<Compte> comptes = service.getCompteByPartenaire(part);
            oblComptes = FXCollections.observableArrayList(comptes);
            loadTableView( tblvCompte, tblcNumero, tblcSolde, oblComptes);

        } else {
            activeOrDisableFields(false,txtNomPrenom,txtTelephone , txtAdress, txtLogin, txtMdp);
            clearFields(txtNomPrenom, txtTelephone, txtAdress, txtLogin, txtMdp);
        }
        return oblComptes;
    }
    
    public static void activeOrDisableFields(boolean etat,
            TextField txtNomPrenom,
            TextField txtTelephone, 
            TextField txtAdress, 
            TextField txtLogin, 
            TextField txtMdp ) {
        txtNomPrenom.setDisable(etat);
        txtAdress.setDisable(etat);
        txtTelephone.setDisable(etat);
        txtLogin.setDisable(etat);
        txtMdp.setDisable(etat);
    }
     
   public static void clearFields(TextField txtNomPrenom,TextField txtTelephone , TextField txtAdress, TextField txtLogin, TextField txtMdp) {
        txtNomPrenom.clear();
        txtAdress.clear();
        txtTelephone.clear();
        txtLogin.clear();
        txtMdp.clear();
    
    }
    
    public static void loadTableView(TableView<Compte> tblvCompte,TableColumn<Compte, String> tblcNumero ,TableColumn<Compte, String> tblcSolde, ObservableList oblComptes) {
        tblcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tblcSolde.setCellValueFactory(new PropertyValueFactory<>("solde"));
        tblvCompte.setItems(oblComptes);
    }
    
    
    
    
}
