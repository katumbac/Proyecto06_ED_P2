/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.p_grupo06;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author kathe
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button btnSi;
    @FXML
    private Button btnNo;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSi(MouseEvent event) {
    }

    @FXML
    private void btnNo(MouseEvent event) {
    }

    @FXML
    private void Salir(MouseEvent event) {
        Platform.exit();
    }
    
}
