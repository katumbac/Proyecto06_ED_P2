/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.mycompany.p_grupo06.App;
import tree.BinaryTree;


/**
 *
 * @author alexx
 * ESTA CLASE MAIN SOLO VA A SER COMO TESTEO. NO VA A PERTENECER AL PROYECTO EN SI
 */
public class MainDM {
    
    public static void main(String args[]){
        DataManager dm = new DataManager(App.pathArchivo);
        /*
        linea agregada 04082022. Como tenemos a las clses repartidad entre paquetes, entonces llamamos unas instancia de la
        c;ase BinaryTree para que haga los metodos que vamos a llamar
        */
        BinaryTree bt = new BinaryTree();
        /////////////////////////
        System.out.println("\nCarga de los atributos");
        System.out.println(dm.attributes);
        System.out.println("\nRepresentacion como matriz");
        System.out.println(dm.recordMatrix);
        
        //Linea testeo
        System.out.println("\nAnimales individuales");
        System.out.println(dm.individualsAnimal);
        /////////////////////////
        
        //Agregado 04082022
        bt.putQuestionNodes();
        
        
        
        
        
    }
}
