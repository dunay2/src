package Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ashh412 Esta clase se crea para gestionar los menus de texto de la
 * aplicación
 */
public class Node {

    private ArrayList<Node> nodes; //Hijos del nodo
    //Hijos del nodo
    private final int value; //Valor del nodo
    private final Node parent;//Padre del nodo
    private final String label; //Etiqueta del nodo
    private boolean isInput = false;//Es un nodo de lectura
    private String response; //Devolucion de datos de nodo de lectura
    private boolean Tail = false;//Es un nodo de lectura

//Constructor
    /**
     *
     * @param value
     * @param parent
     * @param label
     */
    public Node(int value, Node parent, String label) {
        this.nodes = new ArrayList<>();
        this.value = value;
        this.parent = parent;
        this.label = label;
    }

    public boolean isTail() {
        return Tail;
    }

    public void isTail(boolean Tail) {
        this.Tail = Tail;
    }

    //Propósito: Convertir los hijos en una lista
    //de nodos input que toman como valor devuelto
    //la entrada de teclado
    public ArrayList<String> convertTreeChildToList() {
        ArrayList<String> nodeDataList = new ArrayList();

        Node childNode;
        //Convertimos los nodos en arraylist
        Iterator<Node> it = this.getChildNodes().iterator();

        while (it.hasNext()) {
            childNode = it.next();
            nodeDataList.add(childNode.getResponse());
        }
        return nodeDataList;

    }

    //No devuelve el primer elemento
    public ArrayList<String> convertTreeChildToListIdx() {
        ArrayList<String> nodeDataList = new ArrayList();
        int i = 0;
        Node childNode;
        //Convertimos los nodos en arraylist
        Iterator<Node> it = this.getChildNodes().iterator();

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

    //propósito: leer los datos introducidos por consola
    public String getResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (this.isInput()) {
            System.out.println(this.getLabel());
            try {
                this.setResponse(br.readLine());
            } catch (IOException e) {

            }
        }
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isInput() {
        return isInput;
    }

    public void isInput(boolean isInput) {
        this.isInput = isInput;
    }

    public Node getParent() {
        return parent;
    }

    public void addChild(Node node) {
        nodes.add(node);
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Node> getChildNodes() {
        return nodes;
    }

    public void setChildNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public int getValue() {
        return value;
    }

}
