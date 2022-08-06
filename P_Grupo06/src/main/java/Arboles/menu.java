/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Arboles;


import com.mycompany.p_grupo06.App;
import data.DataManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author juand
 */
public class menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
        /*BinaryTree<String> prueba=new BinaryTree();
        prueba.setRootContent("pregunta1");
        prueba.setLeft(new BinaryTree<String>("pregunta2"));
        prueba.setRight(new BinaryTree<String>("pregunta2"));
        prueba.getLeft().setLeft(new BinaryTree<String>("oso"));
        prueba.getLeft().setRight(new BinaryTree<String>("perro"));
        prueba.getRight().setLeft(new BinaryTree<String>("perro2"));
        //prueba.getRight().setRight(new BinaryTree<String>("oso2"));
        menu(prueba,prueba.countLevelsRecursive()-1);//por las respuestas no son preguntas*/
        
        //Carga del archivo de los animales con sus caracteristicas
        DataManager dm = new DataManager(App.pathArchivo);
        putQuestionNodes();
       
    }
    public static void Display(BinaryTree<String> bt, int N){
        Stack<BinaryTree<String>> pila= new Stack<>();
        System.out.println(bt.getRootContent());
        Scanner sc=new Scanner(System.in);
        String answer1=sc.nextLine();
        if(answer1.equalsIgnoreCase("y")){
            pila.push(bt.getLeft());
        }
        if(answer1.equalsIgnoreCase("n")){
            pila.push(bt.getRight());
        }
        if(N==1){
            pila.pop().showLeaf();
        }
        while(N>1){
            BinaryTree<String> arbol=pila.pop();
            
            System.out.println(arbol.getRootContent());
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if(arbol.isLeaf()){
                System.out.println("Estabas pensando en un: "+arbol.getRootContent());
           
            }
            if(N==1 && !arbol.isLeaf()){
                System.out.println("hojas");
                arbol.showLeaf();
                
            }else if (answer.equalsIgnoreCase("Y") && arbol.getLeft()!=null){
                pila.push(arbol.getLeft());
            
            }else if(answer.equalsIgnoreCase("N") && arbol.getRight()!=null){
                pila.push(arbol.getRight());
            }else{
                System.out.println("no es posible Determinar");
                System.exit(0);
            }
            --N;
        }
        if(pila.size()==1){
            System.out.print("Posiblemente estes pensando en un: ");
            pila.pop().showLeaf();
        
        }
                
    }
    
    ///menu recibe el arbol cargado y el tamano del arbol  que se obtiene con arbol.countLevelRecursive -1
    public static void menu(BinaryTree t,int i){
        int N;
        int options;
        boolean flag=true;
        System.out.println("Akinator");
        System.out.println("Piensa en un animal");
        System.out.print(">>>>>>>preguntas a responder,pero recuerda que puedes hacer maximo ->"+i+" preguntas"+"<<<<<<<\n>");
        
        Scanner input= new Scanner(System.in);
        N= input.nextInt();
        while(N>i){
            System.out.print("El numero supera el maximo de preguntas, Ingrese un valor dentro del rango\n>");
            Scanner input2= new Scanner(System.in);
            N= input2.nextInt();
        }
        while(flag){
            System.out.print("Estas Listo\n1. Start\n2. salir\n>");
            Scanner inputOpt= new Scanner(System.in);
            options=inputOpt.nextInt();
        
            switch(options){
                case 1:
                    Display(t,N);
                    flag=false;
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Opcion Invalida\n3");
                
         
            
            }
        }
    }
    
    //Agregado 06082022
    //public static BinaryTree putQuestionNodes(){
    public static void putQuestionNodes(){
        //Cantidad de preguntas
        int n = 0;
        int contadorNodo = 0;
        
        int nivel = 0;
        int contador = 0;
        BufferedReader br = null;
        
        
        
        //Linea de prueba agregado 06082022
        
        /////////////////////////////////////
        
        Queue<BinaryTree<String>> queue = new LinkedList<>();
        
        //Constructor vacio
        //BinaryTree<String> bt = new BinaryTree<>();
        BinaryTree<String> bt = new BinaryTree<>();
        try{
            
            br = new BufferedReader(new FileReader(App.pathFileQuestions));
            
            String line = br.readLine();
            System.out.println("Linea fuera del while: " + line);
            
            if(bt == null){
            System.out.println("No tiene nada");
            }
            
            
            // Adjuncion de la pregunta enel primer nodo que es la raiz
            /*bt.setRootContent(line);
            
            queue.offer(bt);
            //se suma ya que se agrego la primera pregunta
            n++;
            nivel++;*/
            
            
            while(line != null){
                System.out.println("Linea dentro del while: " + line);
                
                if(n == 0){
                    bt.setRootContent(line);
                    queue.offer(bt);
                    n++;
                    System.out.println("Dentro de la condicional n ==0: " + bt.getRootContent());
                    line = br.readLine();
                    continue;
                }

                int nodosHojas = (int) Math.pow(2, n);
                
                
                while(contadorNodo < nodosHojas){
                    
                    /*if(nivel == 0){
                        bt = new BinaryTree<>(line);
                        queue.offer(bt);
                        
                        nivel++;
                        
                    }*/
                    
                    /*if(n == 0){
                        bt.setRootContent(line);
                        //bt = new BinaryTree(line);
                        queue.offer(bt);
                        //se suma ya que se agrego la primera pregunta
                        n++;
                    }*/
                    
                    BinaryTree temp = queue.poll();
                    if(temp.getLeft() == null){
                        temp.setLeft(new BinaryTree(line));
                        queue.offer(temp.getLeft());
                        //linea testeo
                        //System.out.println("hola");
                        //System.out.println("Pregunta: " + temp.getLeft().getRootPregunta() + "Nivel: " + temp.getLeft().getRootNivel());
                        ////////////////////////
                        contadorNodo++;
                        //System.out.println("Contador nodo: " + contadorNodo);
                    }
                    if(temp.getRight() == null){
                        temp.setRight(new BinaryTree(line));
                        queue.offer(temp.getRight());
                        //linea testeo
                        //System.out.println("Pregunta: " + temp.getRight().getRootPregunta() + "Nivel: " + temp.getLeft().getRootNivel());
                        ///////////////////////////
                        contadorNodo++;
                        //System.out.println("Contador nodo: " + contadorNodo);
                    }
                    
                    //System.out.println();
                         
                }
                contadorNodo = 0;
                n++;
                nivel++;
                
 
                line = br.readLine();
                
            }
            
        //aqui llamar al metodo para poner las soluciones filtradas por cada nivel  
        //respuestaPorNivel(bt);

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
        
        //menu(bt,bt.countLevelsRecursive()-1);//por las respuestas no son preguntas
        menu(bt,bt.countLevelsRecursive()-1);//por las respuestas no son preguntas
        
    }
    ////////////////////////////////////////////
    
    //private static void respuestaPorNivel(BinaryTree bt){
    private static BinaryTree<String> respuestaPorNivel(BinaryTree<String> bt){    
        
        
        
        //mapa donde estan como clave los animales y como valor su respuestas a caracterisiticas en preguntas
        Map<String, List<String>> animalsChar = DataManager.individualsAnimal;
        
        Stack<BinaryTree<String>> pila = new Stack<>();
        

        pila.push(bt);
        for(Map.Entry<String, List<String>> entry : animalsChar.entrySet()){
            List<String> values= entry.getValue();  

            for(int i=0; i<values.size(); i++){    

                BinaryTree<String> temp = pila.pop();
                
                if(values.get(i).equalsIgnoreCase("1") && temp.getRight() != null){
                    pila.push(temp.getRight());
                }
                if(values.get(i).equalsIgnoreCase("0") && temp.getLeft() != null){
                    pila.push(temp.getLeft());
                }
                if(values.get(i).equalsIgnoreCase("1") && (temp.getRight() == null)){

                    temp.setRight(new BinaryTree<>(entry.getKey()));

                    pila.push(bt);
                }
                if(values.get(i).equalsIgnoreCase("0") && (temp.getLeft() == null)){
                    

                    temp.setLeft(new BinaryTree<>(entry.getKey()));  
                    pila.push(bt);
                    
                }
                
            }
        }
        
        return pila.peek();
        
        
        
        
    }

}