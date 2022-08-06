/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Arboles;

import Arboles.BinaryTree;
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
        
      
        BinaryTree<String> prueba=new BinaryTree();
        prueba.setRootContent("pregunta1");
        prueba.setLeft(new BinaryTree<String>("pregunta2"));
        prueba.setRight(new BinaryTree<String>("pregunta2"));
        prueba.getLeft().setLeft(new BinaryTree<String>("oso"));
        prueba.getLeft().setRight(new BinaryTree<String>("perro"));
        prueba.getRight().setLeft(new BinaryTree<String>("perro2"));
        //prueba.getRight().setRight(new BinaryTree<String>("oso2"));
        menu(prueba,prueba.countLevelsRecursive()-1);//por las respuestas no son preguntas
       
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
}