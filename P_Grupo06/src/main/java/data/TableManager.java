/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;
import java.util.Set;

/**
 *
 * @author alexx
 */
public interface TableManager {
    List<List<String>> getRows();
    List<String> getRow(int row);
    List<String> getColumn(int column);
    List<String> getColumn(String column);
    List<List<String>> getRowsByKeyValue(String attribute, String value);
    Set<String> getPossibleValues(String attribute);
    String getObjectiveAttribute();
    List<String> getAttributes();
    Set<String> getObjectiveAttributeValues();
    TableManager getSubTable(String attribute, String value);
    Double getProbability(String attribute, String value);
    List<String> getNonObjectiveAttributes();
    String getBestObjectiveValueFromAttribute(String attribute, String value);
    String hasOneObjectiveValue(String attribute, String value);
    TableManager getTrainAndProbeSet(Double percent);
}
