/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.mycompany.p_grupo06.App;

/**
 *
 * @author alexx
 * ESTA CLASE MAIN SOLO VA A SER COMO TESTEO. NO VA A PERTENECER AL PROYECTO EN SI
 */
public class MainDM {
    
    public static void main(String args[]){
        DataManager dm = new DataManager(App.pathArchivo);
        System.out.println(dm.attributes);
        System.out.println(dm.recordMatrix);
        int n1 = 1;
        int n = (int)Math.pow(5, n1);
        System.out.println(n);
        n1++;
        n = (int)Math.pow(5, n1);
        System.out.println(n);
    }
}
