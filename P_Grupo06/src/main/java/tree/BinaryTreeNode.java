/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import java.util.List;
import java.util.Map;

/**
 *
 * @author alexx
 */
public class BinaryTreeNode {
    // Por cada nivel se encuentra una pregunta
    private int nivel;
    private String pregunta;
    // respuestasPerNode sera para que se gyarde las solucioes que corresponde a cada pregunta despues de su filtrado
    private Map<String, List<String>> respuestasPerNode;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTreeNode(String pregunta, int nivel) {
        this.pregunta = pregunta;
        this.nivel = nivel;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(String pregunta, BinaryTree left, BinaryTree right) {
        this.pregunta = pregunta;
        this.left = left;
        this.right = right;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Map<String, List<String>> getRespuestasPerNode() {
        return respuestasPerNode;
    }

    public void setRespuestasPerNode(Map<String, List<String>> respuestasPerNode) {
        this.respuestasPerNode = respuestasPerNode;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
    
    
}
