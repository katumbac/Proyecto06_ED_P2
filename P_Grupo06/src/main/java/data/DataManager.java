/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.mycompany.p_grupo06.App;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author alexx
 * Clase la cual va a manejar los datos del archivo
 */
public class DataManager{
    public static final String SEPARADOR = ",";
    public static List<String> attributes = new ArrayList<String>();
    Map<String, Set<String>> possibleValues = new HashMap<String, Set<String>>();
    List<List<String>> recordMatrix = new ArrayList<List<String>>();
    
    /*
    Agregado 04082022
    Probando metiendolos en un diccionario. 
    La clave es el animal y como Value estan las caracateristicas que se pone como 1 o 0
    */
    public static Map<String, List<String>> individualsAnimal = new HashMap<String, List<String>>();
    /////////////////////////////////
    
    // Parametro 
    public DataManager(String path){
        Scanner sc;
        try {
            sc = new Scanner(new File(path));
            loadAttributes(sc.nextLine());
            loadAnimalCharacteristics(sc);
            //loadData(sc);
            
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
    }
    
    // Cargar la primera linea del archivo que contiene los nombres de los aributos
    private void loadAttributes(String line) {
        String[] atts = line.split(SEPARADOR);
        String animal = atts[0];


        for (String s : atts) {
            attributes.add(s);
            possibleValues.put(s, new HashSet<String>());
            // recordMatrix.add(new ArrayList<String>());
		}
    }
    
    /**
	 * Loads the data that has been previously loaded in the scanner.
	 */
	private void loadData(Scanner sc) {
		while (sc.hasNext()) {
			// Read the line and split it by the separator (def: ',');
			String line = sc.nextLine();
			String[] instanceValues = line.split(SEPARADOR);
                        

			// Generate the new record
			// We assume the data for each attribute comes correctly ordered
			// which is a rather stupid assumption to make.
			List<String> record = new ArrayList<String>();
			for (int i = 0; i < instanceValues.length; i++) {
				record.add(instanceValues[i]);

				String attribute = attributes.get(i);
				Set<String> pValues = possibleValues.get(attribute);
				if (!pValues.contains(instanceValues[i])) {
					pValues.add(instanceValues[i]);
				}
			}

			recordMatrix.add(record);
		}
	}
        
        private void loadAnimalCharacteristics(Scanner sc){
            while (sc.hasNext()) {
			// Read the line and split it by the separator (def: ',');
			String line = sc.nextLine();
			String[] instanceValues = line.split(SEPARADOR);
                        String animal = instanceValues[0];

			List<String> characteristics = new ArrayList<String>();
			for (int i = 1; i < instanceValues.length; i++) {
				characteristics.add(instanceValues[i]);

			}

			individualsAnimal.put(animal, characteristics);
		}
        }
}
