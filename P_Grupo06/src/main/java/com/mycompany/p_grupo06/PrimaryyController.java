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
import java.util.Scanner;
import java.util.Stack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    @FXML
    private Label lblTurespuesta;
    @FXML
    private HBox HBoxP;
    @FXML
    private Button btnOk;
    @FXML
    private Button btninfo;
    
    private BinaryTree<String> arbol;
    @FXML
    private HBox opciones;
    
    private Stack<BinaryTree<String>> pila= new Stack<>();
    
    private int N;
    public PrimaryyController() {
        this.arbol = new BinaryTree<>();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Carga del archivo de los animales con sus caracteristicas
        DataManager dm = new DataManager(App.pathArchivoRespuestas);
        arbol = putQuestionNodes();
        lblPreguntas.setText(arbol.getRootContent());

    } 
    /*
    System.out.println(bt.getRootContent());
        lblPreguntas.setText(bt.getRootContent());
        nOpciones();
        String text = prueba.getText();
        
        System.out.println("Resp" + text);
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
   
    @FXML
    private void bInfo() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Ingrese número de preguntas");
        alert.setContentText("Recuerde que el máximo de preguntas es de "+ arbol.countLevelsRecursive());
        alert.showAndWait();      
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
            
            //System.out.println("Linea fuera del while: " + line);
            
            if(bt == null){
            //System.out.println("No tiene nada");
            }
            
            while(line != null){
                //System.out.println("Linea dentro del while: " + line);
                
                if(n == 0){
                    bt.setRootContent(line);
                    queue.offer(bt);
                    n++;
                    //System.out.println("Dentro de la condicional n ==0: " + bt.getRootContent());
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
        return bt;
        
    }
    
    /*public void Display(String s, int N){ 
        if(N==1){
            btnSi.setVisible(false);
            btnNo.setVisible(false);
            lblPreguntas.setText("Tu animal es:");
            lblTurespuesta.setVisible(false);
            String r = pila.pop().showLeaf();
            lblrespuesta.setText("hoja");
        }
        
        
        while(N>1){
            BinaryTree<String> arb=pila.pop();     
            System.out.println(arb.getRootContent());
            lblPreguntas.setText(arb.getRootContent());
            String text1 = lblrespuesta.getText();
            if(arb.isLeaf()){
                System.out.println("Estabas pensando en un: "+arb.getRootContent());
                lblrespuesta.setText("Estabas pensando en un: "+arb.getRootContent());
           
            }
            if(N==1 && !arb.isLeaf()){
                System.out.println("hojas");
                lblrespuesta.setText(arb.showLeaf());
                
                arb.showLeaf();
                
                
            }else if (text1.equalsIgnoreCase("SI") && arb.getLeft()!=null){
                pila.push(arb.getLeft());
            
            }else if(text1.equalsIgnoreCase("NO") && arb.getRight()!=null){
                pila.push(arb.getRight());
            }else{
                System.out.println("no es posible Determinar");
                lblrespuesta.setText("no es posible Determinar");
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
            
        }
    }*/
    
    
    public void Display(String s, int N){  
        String numP = preg.getText();
        int n = Integer.parseInt(numP);
        if(n != arbol.countLevelsRecursive()){
            if(s.equalsIgnoreCase("si")){
                System.out.println(arbol.getRootContent());
                lblPreguntas.setText(arbol.getRootContent());  
                pila.push(arbol.getLeft());
                arbol = arbol.getLeft();      
                System.out.println("si");

            }else if(s.equalsIgnoreCase("no")){
                System.out.println(arbol.getRootContent());
                pila.push(arbol.getLeft());
                arbol = arbol.getRight();
                lblPreguntas.setText(arbol.getRootContent());     
                System.out.println("no");
            } 
        }else{
            System.out.println("n");
        
        }
            
           
    }
          
    
    private BinaryTree<String> respuestaPorNivel(BinaryTree<String> bt){    
  
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
    private void btnOk(MouseEvent event) throws IOException {
        
        String numP = preg.getText();
        //numP=numP.replaceAll(" ", "");
        System.out.println(numP.length());
        N=Integer.parseInt(numP);
        int n = N;
        if(numP!=""){    
            if(n>0 && n<arbol.countLevelsRecursive()){
                System.out.println("Ingreso correcto de cantidad de numeros");
                nPreguntas.setText(numP);
                preg.clear();
                preg.setVisible(false);
                HBoxP.setVisible(true);
                btnOk.setVisible(false);
                btninfo.setVisible(false);

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Ingrese número de preguntas correcto");
                alert.setContentText("Recuerde que el máximo de preguntas es de 20");
                alert.showAndWait();  
                preg.clear();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Ingrese número de preguntas correcto");
            alert.setContentText("Recuerde que el máximo de preguntas es de 20");
            alert.showAndWait();  
            
        }
        putQuestionNodes();  
    }

    @FXML
    private void nOptionSi(){
        lblrespuesta.setText("si");
        N++;
        Display("si",N);
        
    }

    @FXML
    private void nOptionNo() {
        N++;
        lblrespuesta.setText("no");
        Display("no",N);
    }

}
