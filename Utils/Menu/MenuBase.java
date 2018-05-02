/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ashh412
 */
public class MenuBase {

    /**
     *
     * @param parentMnuName
     * @param mnu
     *
     */
    static protected void convertToChildNode(String parentMnuName, ArrayList<MenuStruct> mnu) {

        Iterator<MenuStruct> it = mnu.iterator();
        //Búscamos en el árbol la rama que contenga el menú indicado
        MenuNode parent = searchMenu(MenuMain.getRootNode(), parentMnuName);
        int i = 1;
        while (it.hasNext()) {

//Numeramos los nodos empezando en uno.
//El valor de cada hijo es el valor del padre * 10
            MenuStruct mnuStruct = it.next();

            MenuNode node = new MenuNode(parent, i++ + parent.getValue() * 10, mnuStruct.getMnuNanme(), mnuStruct.getMnuText(), null);

            String mnuName = mnuStruct.getMnuNanme();
            String output = mnuName;

            //Tratamiento de nodos output con menú
            String[] parts = mnuName.split(",");
            if (parts.length > 1) {
                output = parts[0];
                mnuName = parts[1];
            }

            if (output.equals("output")) {
                node.isInput(true);
                node.setMnuName(mnuName);

            }
            //Si es un nodo de devolución volvemos al abuelo
            if (mnuStruct.getMnuNanme().equals("tail")) {
                node.setChildnodes(parent.getParent().getChildNodes());
            }

            parent.addNode(node);
        }

    }

//Busca en profundidad un menú en un árbol
    static private MenuNode searchMenu(MenuNode node, String mnuName) {
        MenuNode findNode = null;
//Comprobamos el padre
        if (node.getMnuName().equals(mnuName)) {
            return node;
        }
//Recorremos los hijos
        for (MenuNode eNode : node.getChildNodes()) {
            if (!eNode.getMnuName().equals("tail")) {
                //Si lo encontramos salimos
                if (eNode.getMnuName().equals(mnuName)) {
                    return eNode;
                } else {
//Profundizamos la búsqueda
                    findNode = searchMenu(eNode, mnuName);
                }
                if (findNode != null) {
                    break;
                }
            }
            //Siguiente hermano
        }

        return findNode;

    }

}
