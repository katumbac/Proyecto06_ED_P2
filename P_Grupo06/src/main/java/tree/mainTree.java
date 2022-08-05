/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import com.mycompany.p_grupo06.App;
import data.DataManager;

/**
 *
 * @author alexx ESTA CLASE AMIN SOLO ES DE TESETO, NO PERTENECESE AL PROYECTO
 * EN SI
 */
public class mainTree {

    public static void main(String args[]) {
        //BinaryTree bt = new BinaryTree();
        //bt.putQuestionNodes();
        DataManager dm = new DataManager(App.pathArchivo);

        System.out.println(BinaryTree.putQuestionNodes());
        System.out.println("\nImpresion del root del arbol");
        System.out.println(BinaryTree.putQuestionNodes().getRootPregunta());
        System.out.println("\nImpresion del arcbol drecho (nivel1)");
        //System.out.println(BinaryTree.putQuestionNodes().getRight().getRootPregunta());
        System.out.println(BinaryTree.putQuestionNodes().getRight());
        System.out.println("\nImpresion del arbol drecho del derecho(nivel2)");
        //System.out.println(BinaryTree.putQuestionNodes().getRight().getRight().getRootPregunta());
        System.out.println(BinaryTree.putQuestionNodes().getRight().getRight());
        System.out.println("Metodo respuestas por nivel");
        BinaryTree.putQuestionNodes();
        

    }

}
