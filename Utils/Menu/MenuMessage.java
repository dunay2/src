/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ashh412
 */
//Definimos las entries como todas las opciones de un menú
//Cada opción a su vez da paso a un menú
public class MenuMessage {

    private static MenuNode mainNode;

    private static Map hashmap = new HashMap<String, String[]>();
//para agregar un menu debemos hacer lo siguiente:
    //1. Agregar un elemento a mnuName con el nombre del menu
    //2. Poblar el menu en el array code 
    //de forma ordenada 

    public MenuMessage() {

//Inicializacion de menus definiendo las funciones que va a ejecutar el sistemas
//Creamos el nodo raíz mnuMain
        //Menu principal
//        mainNode = MenuMain.getRootNode();
        //Agregamos los menús al nodo principal
//        MenuMain.mainMenuEntries("rootMenu");//main Node
//        MenuSale.transactionEntries("mnuTransaction");//Transaction Node
//        MenuClient.clientEntries("mnuClients"); //Client Node
//        MenuEmployee.employeeEntries("mnuEmployee"); //Employee node
//        //MenuEmployee.employeeEntries("mainNode");
//        MenuMain.cancelTransactionEntries("mnuCancelTransaction");

//        entries.add(new MenuStruct("mnuTransaction", "Realizar una Transacción"));
//        entries.add(new MenuStruct("mnuClients", "Gestión de Clientes"));
//        entries.add(new MenuStruct("mnuStock", "Gestión de Stock"));
//        entries.add(new MenuStruct("mnuEmployee", "Gestión de Empleados"));
//        entries.add(new MenuStruct("", "Listar Facturas"));
//        entries.add(new MenuStruct("mnuCancelTransaction", "Realizar una devolución"));
//        entries.add(new MenuStruct("mnuExit", "Salir de la aplicación"));
        // addEntry(node, mnuName);
        //Menu Ventas
        //Obtenemos el nodo que va a ser el padre
//        MenuNode node = mainNode.getChildNodes().get(k++);
//        node.setChildnodes(transactionEntries(node));
        //  addTransactionMenu(node.getChildNodes().get());
        //Menu Gestión de clientes
//        node = mainNode.getChildNodes().get(k++);
//        node.setChildnodes(clientEntries(node));
    }
//   
//0. mnuMain 
//

    public static MenuNode getRootNode() {
        return mainNode;
    }

    public static String[] getMenu(String s) {
        return (String[]) hashmap.get(s);

    }
}
