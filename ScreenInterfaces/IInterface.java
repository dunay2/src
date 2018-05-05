package ScreenInterfaces;

import Utils.Menu.MenuNode;
import Utils.Node;

/**
 *
 * @author ashh412
 */
public interface IInterface {

    /**
     *
     * @param node
     * @param mnuText
     * @param index
     */
    public void addInputMenu(Node node, String mnuText,  int index);

    /**Propósito: Agregar los elementos de un menu a un nodo
     *Nodo sobre el que crear, array de mnu asociado, indice de funcion y verdadero si el ultimo elemento no tiene hijos

     * @param node
     * @param mnuText
     * @param index
     * @param isTail
     */
    public void addMenu(Node node,String[] mnuText, int index, boolean isTail);

    /**
     *
     * @param node
     * @return
     */
    public MenuNode printMenu(MenuNode node);

}
