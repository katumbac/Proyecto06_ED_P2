/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.p_grupo06;

import com.mycompany.p_grupo06.SecondaryController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author kathe
 */
public class IngPreguntasController implements Initializable {


    @FXML
    private TextField txtNumeroPreguntas;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnInfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

    }    

    @FXML
    private void btnIngresar(MouseEvent event) throws IOException {
        String numP = txtNumeroPreguntas.getText();
        System.out.println(numP);
        //if(numP != null){
            int n = Integer.parseInt(numP);
            if(n>0 && n<=20){
                System.out.println("Ingreso correcto de cantidad de numeros");
                //String n = txtNumeroPreguntas.getText();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primaryy.fxml"));//no tiene el controlador especificado
                PrimaryyController ct = new PrimaryyController();
        
                
        
                fxmlLoader.setController(ct);//se asigna el controlador
                ct.llenarNPreguntas(numP);

                App.setRoot("primaryy");

            }else if(n>20){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Ingrese número de preguntas correcto");
                alert.setContentText("Recuerde que el máximo de preguntas es de 20");
                
            }
        //}
        
        
    }

    
    private void getNumPreguntas() throws IOException {
        String n = txtNumeroPreguntas.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primaryy.fxml"));//no tiene el controlador especificado
        PrimaryyController ct = new PrimaryyController();
        
        VBox root = (VBox) fxmlLoader.load();
        
        fxmlLoader.setController(ct);//se asigna el controlador
        ct.llenarNPreguntas(n);

        App.changeRoot(root);

    }

    @FXML
    private void btnInfo(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Ingrese número de preguntas");
        alert.setContentText("Recuerde que el máximo de preguntas es de 20");

        alert.showAndWait();
    }


     
    
}
