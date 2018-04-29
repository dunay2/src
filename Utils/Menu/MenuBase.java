/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import Utils.MenuStruct;
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
        MenuNode parent = searchMenu(MenuMain.getRootNode(), parentMnuName);
        int i = 1;
        while (it.hasNext()) {
            //Búscamos en el árbol la rama que contenga el menú indicado

            MenuStruct mnuStruct = it.next();
            MenuNode node = new MenuNode(parent, i++ + parent.getValue() * 10, mnuStruct.getMnuNanme(), mnuStruct.getMnuText(), null);
            
            if(mnuStruct.getMnuNanme().equals("output"))
            {
                node.isInput(true);
            }
               if(mnuStruct.getMnuNanme().equals("tail"))
            {
                node.setChildnodes(parent.getParent().getChildNodes());
            }
            
            
            
            parent.addNode(node);
        }

        MenuNode node = new MenuNode(parent, ++i + parent.getValue(), "mnuSelect", "Seleccione una opción de menú", null);
        node.isInput(true);
        parent.addNode(node);

        // return nodes;
    }

//Busca en profundidad un menú en un árbol
    static private MenuNode searchMenu(MenuNode node, String mnuName) {
        MenuNode findNode = null;
        if (node.getMnuName().equals(mnuName)) {
            return node;
        }

        for (MenuNode eNode : node.getChildNodes()) {
            if (eNode.getMnuName().equals(mnuName)) {
                return eNode;
            } else {
                findNode = searchMenu(eNode, mnuName);
            }
            if (findNode != null) {
                break;
            }
        }

        return findNode;

    }

}
