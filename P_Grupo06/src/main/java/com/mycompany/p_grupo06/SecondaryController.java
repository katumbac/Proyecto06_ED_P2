package com.mycompany.p_grupo06;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController {

    @FXML
    private Label lblText;
    @FXML
    private Button secondaryButton;

    
    IngPreguntasController IngPreguntascontroller_inprimary;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primaryy");
    }
    
    @FXML
    public void getNumPreguntas(IngPreguntasController stage1,String text){
        /*String textNum = txtNumeroPreguntas.getText();
        int nu = Integer.parseInt(textNum);
        System.out.println(nu);*/
        lblText.setText(text);

        IngPreguntascontroller_inprimary= stage1;
        
    }
}