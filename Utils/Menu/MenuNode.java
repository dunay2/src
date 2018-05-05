/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ashh412
 */
public class MenuNode {

    private final MenuNode parent;
    private int parentValue = 0;
    private final int value;
    private ArrayList<MenuNode> childNodes = new ArrayList();
    private  String mnuName;//Nombre del menú
    private final String label;//Texto de menu
    private boolean isInput = false;//Es un nodo de lectura
    private String response; //Devolucion de datos de nodo de lectura

    /**
     *
     * @param node
     */
    public void addNode(MenuNode node) {
        childNodes.add(node);
    }

    /**
     *
     * @param mnuName
     */
    public void setMnuName(String mnuName) {
        this.mnuName = mnuName;
    }

    /**
     *
     * @return
     */
    public MenuNode getParent() {
        return parent;
    }

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param parent
     * @param value
     * @param mnuName
     * @param label
     * @param childNodes
     */
    public MenuNode(MenuNode parent, int value, String mnuName, String label, ArrayList<MenuNode> childNodes) {
        this.parent = parent;
        this.value = value;
        this.mnuName = mnuName;
        this.label = label;

        if (childNodes != null) {
            this.childNodes = childNodes;
        }

        if (parent != null) {
            parentValue = parent.getValue();
        }
    }

    /**
     *
     * @return
     */
    public int getParentValue() {
        return parentValue;
    }

    /**
     *
     * @return
     */
    public ArrayList<MenuNode> getChildNodes() {
        return childNodes;
    }

    /**
     *
     * @param childnodes
     */
    public void setChildnodes(ArrayList<MenuNode> childnodes) {
        this.childNodes = childnodes;
    }

    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @return
     */
    public boolean isInput() {
        return isInput;
    }

    /**
     *
     * @param isInput
     */
    public void isInput(boolean isInput) {
        this.isInput = isInput;
    }
    //propósito: leer los datos introducidos por consola

    /**
     *
     * @return
     */
    public String getResponse() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (this.isInput()) {

            try {
                System.out.println(this.label);
                this.setResponse(br.readLine());
            } catch (IOException e) {
                System.out.println(e.getCause());
            }
        }
        return response;
    }

    /**
     *
     */
    public void clearResponse() {
        response = null;
    }

    /**
     *
     * @return
     */
    public String getResponseValue() {
        return response;
    }

    /**
     *
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    //Propósito: Convertir los hijos en una lista
    //de nodos input que toman como valor devuelto
    //la entrada de teclado
    //sin devolver el primer elemento

    /**
     *
     * @return
     */
    public ArrayList<String> convertTreeChildToListIdx() {
        ArrayList<String> nodeDataList = new ArrayList();
        int i = 0;
        MenuNode childNode;
        //Convertimos los nodos en arraylist
        Iterator<MenuNode> it = this.getChildNodes().iterator();

        while (it.hasNext()) {
            if (i == 0) {
                childNode = it.next();
                i++;
            }

            childNode = it.next();
            nodeDataList.add(childNode.getResponse());
        }
        return nodeDataList;

    }
    //Propósito: Convertir los hijos en una lista
    //de nodos input que toman como valor devuelto
    //la entrada de teclado

    /**
     *
     * @return
     */
    public ArrayList<String> convertTreeChildToList() {
        ArrayList<String> nodeDataList = new ArrayList();

        MenuNode childNode;
        //Convertimos los nodos en arraylist
        Iterator<MenuNode> it = this.getChildNodes().iterator();

        while (it.hasNext()) {
            childNode = it.next();
            nodeDataList.add(childNode.getResponse());
        }
        return nodeDataList;

    }

    /**
     *
     * @return
     */
    public String getMnuName() {
        return mnuName;
    }

}
