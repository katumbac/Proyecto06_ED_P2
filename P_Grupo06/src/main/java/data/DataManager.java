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
    List<String> attributes = new ArrayList<String>();
    Map<String, Set<String>> possibleValues = new HashMap<String, Set<String>>();
    List<List<String>> recordMatrix = new ArrayList<List<String>>();
    
    // Parametro 
    public DataManager(String path){
        Scanner sc;
        try {
            sc = new Scanner(new File(path));
            loadAttributes(sc.nextLine());
            loadData(sc);
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
    }
    
    // Cargar la primera linea del archivo que contiene los nombres de los aributos
    private void loadAttributes(String line) {
        String[] atts = line.split(SEPARADOR);

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
}
