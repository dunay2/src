/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import Utils.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuMain extends MenuBase {

    static private MenuNode rootNode;

    //Propósito: Agregar entradas al menú principal
    //Padre: null
    //Menú mnuMain
    static public MenuNode getRootNode() {

        if (rootNode == null) {
            rootNode = new MenuNode(null, 0, "rootMenu", "", null);
            mainMenuEntries("rootMenu");

        }
        return rootNode;

    }

    static protected void mainMenuEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();

//Creamos el nodo raíz mnuMain
        //Menu principal
        entries.add(new MenuStruct("mnuTransaction", "Realizar una Transacción"));
        entries.add(new MenuStruct("mnuClients", "Gestión de Clientes"));
        entries.add(new MenuStruct("mnuStock", "Gestión de Stock"));
        entries.add(new MenuStruct("mnuEmployee", "Gestión de Empleados"));
        entries.add(new MenuStruct("", "Listar Facturas"));
        entries.add(new MenuStruct("mnuCancelTransaction", "Realizar una devolución"));
        entries.add(new MenuStruct("mnuExit", "Salir de la aplicación"));

        convertToChildNode(parentMnuName, entries);
        addTransactionMnu();
        addClientMnu();
    }
    
    
    private static void addTransactionMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        MenuSale.transactionEntries("mnuTransaction").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuTransaction", entries);
        entries.clear();
        MenuSale.addItemToCartEntries("mnuAddItemToCart").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuAddItemToCart", entries);
        entries.clear();
//        MenuSale.createFinanceMessage("mnuTransaction").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//    convertToChildNode("mnuBuying", entries);
        MenuSale.paymentTypeEntries("mnuBuying").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuBuying", entries);
        entries.clear();

//         MenuSale.getItemCode("mnuAddItemToCart").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuAddItemToCart", entries);
//        entries.clear();
    }
 

    private static void addClientMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        MenuClient.addClientEntries("mnuClients").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuTransaction", entries);
        entries.clear();
        
        MenuSale.addItemToCartEntries("mnuAddItemToCart").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuAddItemToCart", entries);
        entries.clear();
//        MenuSale.createFinanceMessage("mnuTransaction").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//    convertToChildNode("mnuBuying", entries);
        MenuSale.paymentTypeEntries("mnuBuying").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuBuying", entries);
        entries.clear();

//         MenuSale.getItemCode("mnuAddItemToCart").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuAddItemToCart", entries);
//        entries.clear();
    }

    //Propósito: Agregar entradas al menú cancelar venta
    //Padre: mnuMain
    //Menú input menu
    static protected void cancelTransactionEntries(String parentMnuName) {
        //21. mnuCancelTransaction  

//Input menu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Introduzca el código de la factura a cancelar"));

        convertToChildNode(parentMnuName, entries);

    }
}
