/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import com.mycompany.p_grupo06.App;
import data.DataManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author alexx
 */
public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(String rootContent, int nivel) {
        this.root = new BinaryTreeNode(rootContent, nivel);
    }

    public String getRootPregunta() {
        return this.root.getPregunta();
    }
    
    public int getRootNivel() {
        return this.root.getNivel();
    }

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void setRootContent(String content, int nivel) {
        this.root = new BinaryTreeNode(content, nivel);
    }

    private BinaryTreeNode getRoot() {
        return root;
    }

    private void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    
    public boolean isLeaf(){
        if(this.isEmpty()) return false;
        else if(this.getRootPregunta()!=null && this.getRight()== null && this.getLeft() == null) return true;
        return false;
    }

    public void setLeft(BinaryTree tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        this.root.setRight(tree);
    }

    public BinaryTree getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree getRight() {
        return this.root.getRight();
    }
    
    public void setMapAnswers(Map<String, List<String>> respuestasPerNode){
        this.root.setRespuestasPerNode(respuestasPerNode);
    }
    
    public Map<String, List<String>> getMapAnswers() {
        return this.root.getRespuestasPerNode();
    }
    
    
    public static BinaryTree putQuestionNodes(){
        //Cantidad de preguntas
        int n = 0;
        int contadorNodo = 0;
        
        int nivel = 0;
        int contador = 0;
        BufferedReader br = null;
        Queue<BinaryTree> queue = new LinkedList<>();
        BinaryTree bt = new BinaryTree();
        try{
            
            br = new BufferedReader(new FileReader(App.pathFileQuestions));
            
            String line = br.readLine();

            /*
            // Adjuncion de la pregunta enel primer nodo que es la raiz
            bt = new BinaryTree(line, nivel);
            
            queue.offer(bt);
            //se suma ya que se agrego la primera pregunta
            n++;
            nivel++;*/
            while(line != null){

                
                if(bt.getRoot() == null){
                        bt = new BinaryTree(line);
                        queue.offer(bt);
                        n++;
                        nivel++;
                }
                
                int nodosHojas = (int) Math.pow(2, n);
                
                while(contadorNodo < nodosHojas){
                    //System.out.println("Nodos hojas: " + nodosHojas);
                                   
                    //System.out.println("La linea actual es: " + line);
                    
                
                    if(bt.getRoot() == null){
                        bt = new BinaryTree(line, nivel);
                        queue.offer(bt);
                        n++;
                        nivel++;
                    }*/
                
                    BinaryTree temp = queue.poll();
                    if(temp.getLeft() == null){
                        temp.setLeft(new BinaryTree(line, nivel));
                        queue.offer(temp.getLeft());
                        //linea testeo
                        //System.out.println("hola");
                        //System.out.println("Pregunta: " + temp.getLeft().getRootPregunta() + "Nivel: " + temp.getLeft().getRootNivel());
                        ////////////////////////
                        contadorNodo++;
                        //System.out.println("Contador nodo: " + contadorNodo);
                    }
                    if(temp.getRight() == null){
                        temp.setRight(new BinaryTree(line, nivel));
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
        respuestaPorNivel(bt);

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
        return bt;
    }

    /*public LinkedList<E> preOrderTraversalRecursive() {
        LinkedList<E> traversal = new LinkedList<>();
        if (!this.isEmpty()) {
            traversal.add(this.getRootContent());
        }
        if (this.getLeft() != null) {
            traversal.addAll(this.getLeft().preOrderTraversalRecursive());
        }
        if (this.getRight() != null) {
            traversal.addAll(this.getRight().preOrderTraversalRecursive());
        }
        return traversal;
    }

    public LinkedList<E> preOrderTraversalIterative() {
        LinkedList<E> traversal = new LinkedList<>();
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (!tree.isEmpty()) {
                traversal.add(tree.getRootContent());
            }
            if (tree.getRight()!= null && !tree.getRight().isEmpty()) {
                s.push(tree.getRight());
            }
            if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
                s.push(tree.getLeft());
            }
        }
        return traversal;
    }
    
    
    public LinkedList<E> breadthTraversal() {
        LinkedList<E> traversal = new LinkedList<>();
        Queue<BinaryTree<E>> q = new LinkedList<>();
        q.offer(this);
        while (!q.isEmpty()) {
            BinaryTree<E> tree = q.poll();
            if (!tree.isEmpty()) {
                traversal.add(tree.getRootContent());
            }
            if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
                q.offer(tree.getLeft());
            }
            if (tree.getRight()!= null && !tree.getRight().isEmpty()) {
                q.offer(tree.getRight());
            }
        }
        return traversal;
    }*/
    
    private static void respuestaPorNivel(BinaryTree bt){
        //mapa donde estan como clave los animales y como valor su respuestas a caracterisiticas en preguntas
        Map<String, List<String>> animalsChar = DataManager.individualsAnimal;
        //Queue para ir guradando los nodos por cada nivel y coger de ellos sus hijos
        Queue<BinaryTree> queue = new LinkedList<>();

        //Asiganoms todos los animales respuesta en el nodo root
        bt.getRoot().setRespuestasPerNode(animalsChar);
        queue.offer(bt);
        
        int n = 1;
        
        while( (!queue.isEmpty()) ){
            
            BinaryTree temp = queue.poll(); 
            
            if(temp.getLeft() != null){
                /*
                Las tres lineas que se encuentran a continuacion es cuando el mapa del padre no tiene ningun elemenyo, como no
                tiene entonces ya no es posible, entonces de ahi en adelante le pasamos null al diccionario del hijo
                */
                if(temp.getRoot().getRespuestasPerNode() == null){
                    temp.getLeft().setMapAnswers(null);
                }else{
                    Map<String, List<String>> respuestasTransicion = temp.getRoot().getRespuestasPerNode();
                    //Mapa del nodo actual que estamos tratando
                    ConcurrentHashMap<String, List<String>> respuestasTransicionIzq = new ConcurrentHashMap<>();

                    List<String> valoresResponse;
                    String keyResponse;
                
                    for(Map.Entry<String, List<String>> entry : respuestasTransicion.entrySet()){
                        respuestasTransicionIzq.put(entry.getKey(), entry.getValue());  
                    }
                
                    /*
                    Para que se vaya al lado izquierdo, la respuesta a la pregunta, o caracteristica que se esta tratando debe
                    ser igual a 0. En caso de que sea 1, entonces eliminamos del diccionario que esta contenido dentro del nodo
                    */
                    for(Entry<String, List<String>> item : respuestasTransicionIzq.entrySet()){
                        keyResponse = item.getKey();
                        valoresResponse = item.getValue();
                        if(valoresResponse.get(0).equalsIgnoreCase("1")){
                            respuestasTransicionIzq.remove(item.getKey());
                        }
                    }
                
                    //asignaoms el diccionario filtrado al hijo que se esta tratando
                    temp.getLeft().setMapAnswers(respuestasTransicionIzq);
                
                    //Lineas de testeo
                    System.out.println("Sin el valor de 1");
                    for(Map.Entry<String, List<String>> entry1 : respuestasTransicionIzq.entrySet()){
                        System.out.println("Key : " + entry1.getKey() + " Value : " + entry1.getValue());
                    }
                    /////////////////////////////
                
                    queue.offer(temp.getLeft());
                }

                if(temp.getRoot().getRespuestasPerNode() == null){
                    temp.getRight().setMapAnswers(null);
                }else{
                    //Mapa del nodo actual que estamos tratando
                    ConcurrentHashMap<String, List<String>> respuestasTransicionDer = new ConcurrentHashMap<>();
                    Map<String, List<String>> respuestasTransicion = temp.getRoot().getRespuestasPerNode();
                
                    List<String> valoresResponse;
                    String keyResponse;
                
                    for(Map.Entry<String, List<String>> entry : respuestasTransicion.entrySet()){
                        respuestasTransicionDer.put(entry.getKey(), entry.getValue());  
                    }
                
                    /*
                    Para que se vaya al lado izquierdo, la respuesta a la pregunta, o caracteristica que se esta tratando debe
                    ser igual a 0. En caso de que sea 1, entonces eliminamos del diccionario que esta contenido dentro del nodo
                    */
                    for(Entry<String, List<String>> item : respuestasTransicionDer.entrySet()){
                        keyResponse = item.getKey();
                        valoresResponse = item.getValue();
                        if(valoresResponse.get(0).equalsIgnoreCase("0")){
                            respuestasTransicionDer.remove(item.getKey());
                        }
                    }
                
                    //asignaoms el diccionario filtrado al hijo que se esta tratando
                    temp.getLeft().setMapAnswers(respuestasTransicionDer);
                
                    //Lineas de testeo
                    System.out.println("Sin el valor de 0");
                    for(Map.Entry<String, List<String>> entry1 : respuestasTransicionDer.entrySet()){
                        System.out.println("Key : " + entry1.getKey() + " Value : " + entry1.getValue());
                    }
                    /////////////////////////////
                
                    queue.offer(temp.getRight());
                }
                
                
            }
        }
        
        
        
        

    }
}
