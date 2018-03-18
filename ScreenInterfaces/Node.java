/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScreenInterfaces;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author ashh412 Esta clase se crea para gestionar los menus de texto de la
 * aplicación
 */
public class Node  {

    private ArrayList<Node> nodes = new ArrayList<>();//Hijos del nodo
    private int value; //Valor del nodo
    private Node parent;//Padre del nodo
    private String label; //Etiqueta del nodo


    public Node(int value, Node parent, String label) {
        this.value = value;
        this.parent = parent;
        this.label = label;
    }

    public Node getParent() {
        return parent;
    }
    
    public void addChild (Node node)
    {
        nodes.add(node);
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Node> getChildNodes() {
        return nodes;
    }

    
    public  void setChildNodes(ArrayList<Node> nodes) {
        this.nodes=nodes;
    }
    public int getValue() {
        return value;
    }

}
