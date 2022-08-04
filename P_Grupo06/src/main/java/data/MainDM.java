/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.mycompany.p_grupo06.App;
import java.util.Scanner;
import tree.BinaryTree;

/**
 *
 * @author alexx
 * ESTA CLASE MAIN SOLO VA A SER COMO TESTEO. NO VA A PERTENECER AL PROYECTO EN SI
 */
public class MainDM {
    
    public static void main(String args[]){
        BinaryTree prueba=new BinaryTree();
        prueba.setRootContent("pregunta1", 0);
        prueba.setLeft(new BinaryTree("pregunta2",1));
        prueba.setRight(new BinaryTree("pregunta2",1));
        prueba.getLeft().setLeft(new BinaryTree("oso",2));
        prueba.getLeft().setRight(new BinaryTree("perro",2));
        prueba.getRight().setLeft(new BinaryTree("perro2",2));
        prueba.getRight().setRight(new BinaryTree("oso2",2));
        
        
        
        menu(prueba);
        /*DataManager dm = new DataManager(App.pathArchivo);
        System.out.println(dm.attributes);
        System.out.println(dm.recordMatrix);
        int n1 = 1;
        int n = (int)Math.pow(5, n1);
        System.out.println(n);
        n1++;
        n = (int)Math.pow(5, n1);
        System.out.println(n);*/
    }
    
    public static void menu(BinaryTree t){
        int options;
        Scanner input= new Scanner(System.in);
        System.out.println("----------Ingrese una opcion----------\n1. Start\n2. Salir ");
        options = input.nextInt();
        switch(options){
            case 1:
                questionsDisplay(t);
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Opcion Invalida\n3");
                menu(t);
        }    
    }
    
    public static void questionsDisplay(BinaryTree root){
        if(root.getRight()!=null && root.getLeft()!=null){
            System.out.print("Tu Animal es: ");
            System.out.println(root.getRootPregunta());
            Scanner input= new Scanner(System.in);
            String answer=input.nextLine();
            
            if(answer.equalsIgnoreCase("Y")){
                if(root.getLeft()!=null){
                    questionsDisplay(root.getLeft());
                }
                
            }else if(answer.equalsIgnoreCase("N")){
                if(root.getRight()!=null){
                    questionsDisplay(root.getRight());
                }
            }else{
                System.out.println("Responda con Y/N");
                questionsDisplay(root);
            }
        }else{
            System.out.println("Estas pensando en un: ");
            System.out.println(root.getRootPregunta());
        }    
                
    }   
}
