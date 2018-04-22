package ScreenInterfaces;

import Utils.Node;

public interface IInterface {

    public void addInputMenu(Node node, String mnuText,  int index);
//Agregar los elementos de un menu a un nodo
 //Nodo sobre el que crear, array de mnu asociado, indice de funcion y verdadero si el ultimo elemento no tiene hijos
    public void addMenu(Node node,String[] mnuText, int index, boolean isTail);

    public Node printMenu(Node node);

}
