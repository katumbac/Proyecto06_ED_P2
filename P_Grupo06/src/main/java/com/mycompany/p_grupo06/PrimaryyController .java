/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.p_grupo06;

import Arboles.BinaryTree;
import com.mycompany.p_grupo06.App;

import data.DataManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author kathe
 */
public class PrimaryyController implements Initializable {


    @FXML
    private Label lblPreguntas;
    @FXML
    private Button btnSi;
    @FXML
    private Button btnNo;
    @FXML
    private Button btnSalir;
    @FXML
    private Label nPreguntas;
    @FXML
    private TextField preg;
    @FXML
    private Label lblrespuesta;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EventHandler<ActionEvent> eventSI = (ActionEvent e) -> {
            lblrespuesta.setText("si");
        };
        btnSi.setOnAction(eventSI);
        
        EventHandler<ActionEvent> eventNO = (ActionEvent e) -> {
            lblrespuesta.setText("no");
        };
        btnNo.setOnAction(eventNO);
        //Carga del archivo de los animales con sus caracteristicas
        DataManager dm = new DataManager(App.pathArchivoRespuestas);
        nPreguntas.setText("3");
        putQuestionNodes();    
        
       
        
    } 
    
    public void llenarNPreguntas(String s){
        //nPreguntas.setText(s);   
        preg.setText(s);
    }
    
    //Agregado 06082022
    public BinaryTree<String> putQuestionNodes(){

        //Cantidad de preguntas
        int n = 0;
        int contadorNodo = 0;
        
        int nivel = 0;
        int contador = 0;
        BufferedReader br = null;
        
        //Linea de prueba agregado 06082022
        
        Queue<BinaryTree<String>> queue = new LinkedList<>();
        
        //Constructor vacio
        BinaryTree<String> bt = new BinaryTree<>();
        try{
            
            br = new BufferedReader(new FileReader(App.pathFileQuestions));        
            String line = br.readLine();
            
            
            if(bt == null){
            //System.out.println("No tiene nada");
            }
            
            while(line != null){
                
                if(n == 0){
                    bt.setRootContent(line);
                    queue.offer(bt);
                    n++;
                    line = br.readLine();
                    continue;
                }

                int nodosHojas = (int) Math.pow(2, n);
                             
                while(contadorNodo < nodosHojas){

                    BinaryTree temp = queue.poll();
                    if(temp.getLeft() == null){
                        temp.setLeft(new BinaryTree(line));
                        queue.offer(temp.getLeft());
                        contadorNodo++;

                    }
                    if(temp.getRight() == null){
                        temp.setRight(new BinaryTree(line));
                        queue.offer(temp.getRight());
                        contadorNodo++;
                    }
                                           
                }
                contadorNodo = 0;
                n++;
                nivel++;
                line = br.readLine();
                
            }          

        }catch(IOException e){   
            System.out.println("Archivo no encontrado");
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        respuestaPorNivel(bt);
        String num = nPreguntas.getText();
        int x = Integer.parseInt(num);
        Display(bt,x);
        //menu(bt,bt.countLevelsRecursive()-1);//por las respuestas no son preguntas
        return bt;
    }
    
    
    public void Display(BinaryTree<String> bt, int N){
        System.out.println("Ingrese si o no");
        Stack<BinaryTree<String>> pila= new Stack<>();
        System.out.println(bt.getRootContent());
        lblPreguntas.setText(bt.getRootContent());
 
        String text = lblrespuesta.getText();

        System.out.println(text);
        /*if(text.equalsIgnoreCase("si")){
            pila.push(bt.getLeft());
        }
        if(text.equalsIgnoreCase("no")){
            pila.push(bt.getRight());
        }
        if(N==1){
            pila.pop().showLeaf();
        }
        while(N>1){
            BinaryTree<String> arbol=pila.pop();
            
            System.out.println(arbol.getRootContent());
            lblPreguntas.setText(arbol.getRootContent());
            String text1 = lblrespuesta.getText();
            System.out.println("btn: "+ text1);
            if(arbol.isLeaf()){
                System.out.println("Estabas pensando en un: "+arbol.getRootContent());
           
            }
            if(N==1 && !arbol.isLeaf()){
                System.out.println("hojas");
                arbol.showLeaf();
                
                
            }else if (text1.equalsIgnoreCase("SI") && arbol.getLeft()!=null){
                pila.push(arbol.getLeft());
            
            }else if(text1.equalsIgnoreCase("NO") && arbol.getRight()!=null){
                pila.push(arbol.getRight());
            }else{
                System.out.println("no es posible Determinar");
                System.exit(0);
            }
            --N;
        }
        if(pila.size()==1){
            System.out.print("Posiblemente estes pensando en un: ");
            //pila.pop().showLeaf(); 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Respuesta");
            alert.setHeaderText("Posiblemente estes pensando en un: ");
            alert.setContentText(pila.pop().showLeaf());
            
        }*/
              
    }
          
    
    public BinaryTree<String> respuestaPorNivel(BinaryTree<String> bt){    
  
        //mapa donde estan como clave los animales y como valor su respuestas a caracterisiticas en preguntas
        Map<String, List<String>> animalsChar = DataManager.animalsResponses;
        
        Stack<BinaryTree<String>> pila = new Stack<>();
        

        pila.push(bt);
        for(Map.Entry<String, List<String>> entry : animalsChar.entrySet()){
            List<String> values= entry.getValue();  

            for(int i=0; i<values.size(); i++){    

                BinaryTree<String> temp = pila.pop();
                
                if(values.get(i).equalsIgnoreCase("no") && temp.getRight() != null){
                    pila.push(temp.getRight());
                }
                if(values.get(i).equalsIgnoreCase("si") && temp.getLeft() != null){
                    pila.push(temp.getLeft());
                }
                if(values.get(i).equalsIgnoreCase("no") && (temp.getRight() == null)){

                    temp.setRight(new BinaryTree<>(entry.getKey()));

                    pila.push(bt);
                }

                if(values.get(i).equalsIgnoreCase("si") && (temp.getLeft() == null)){
                    

                    temp.setLeft(new BinaryTree<>(entry.getKey()));  
                    pila.push(bt);
                    
                }
                
            }
        }

        return pila.peek();

    }

    


    @FXML
    private void Salir(MouseEvent event) {
        Platform.exit();
    }
    
    @FXML
    private void AnadirAnimal(ActionEvent event){
        
        try {
            App.setRoot("primaryy - copia");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    

}
