/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import com.mycompany.p_grupo06.App;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    

    
    public void putQuestionNodes(){
        //Cantidad de preguntas
        int n = 0;
        int contadorNodo = 0;
        
        int nivel = 0;
        int contador = 0;
        BufferedReader br = null;
        Queue<BinaryTree> queue = new LinkedList<>();
        
        try{
            
            br = new BufferedReader(new FileReader(App.pathFileQuestions));
            String line = br.readLine();
            BinaryTree bt = new BinaryTree(line, nivel);
            queue.offer(bt);
            //se suma ya que se agrego la primera pregunta
            n++;
            nivel++;
            while(line != null){
                
                int nodosHojas = (int) Math.pow(2, n);
                while(contadorNodo < nodosHojas){
                    //System.out.println("Nodos hojas: " + nodosHojas);
                
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

        }catch(IOException e){   
            System.out.println("Archivo no encontrado");
        }
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
}
