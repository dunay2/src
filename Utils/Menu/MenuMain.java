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
        entries.add(new MenuStruct("mnuSaleDept", "Gestión de ventas"));
        entries.add(new MenuStruct("mnuRepairDept", "Departamento de reparaciones"));
        convertToChildNode(parentMnuName, entries);
        entries.clear();
        parentMnuName="mnuSaleDept";

        entries.add(new MenuStruct("mnuTransaction", "Realizar una Transacción"));
        entries.add(new MenuStruct("mnuClient", "Gestión de Clientes"));
        entries.add(new MenuStruct("mnuStock", "Gestión de Stock"));
        entries.add(new MenuStruct("mnuEmployee", "Gestión de Empleados"));
        entries.add(new MenuStruct("", "Listar Facturas"));
        entries.add(new MenuStruct("mnuCancelTransaction", "Realizar una devolución"));
        entries.add(new MenuStruct("mnuExit", "Salir de la aplicación"));

        convertToChildNode(parentMnuName, entries);
        addTransactionMnu();
        addClientMnu();
        addStockMnu();
    }

    private static void addTransactionMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        //menú principal
        MenuSale.transactionEntries("mnuTransaction").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuTransaction", entries);
        entries.clear();

        //Agregar items al carrito
        MenuSale.addItemToCartEntries("mnuAddItemToCart").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuAddItemToCart", entries);
        entries.clear();
//        MenuSale.createFinanceMessage("mnuTransaction").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//    convertToChildNode("mnuBuying", entries);

        //Obtener id cliente
        MenuSale.getClientIdEntries("mnuBuying").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuBuying", entries);
        entries.clear();

//        //obtener datos de cliente
//        MenuSale.addClientEntriesNoID("mnuBuyGetClientId").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuBuyGetClientId", entries);
//        entries.clear();
        MenuSale.paymentTypeEntries("mnuBuyGetClientId").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuBuyGetClientId", entries);
        entries.clear();

//         MenuSale.getItemCode("mnuAddItemToCart").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuAddItemToCart", entries);
//        entries.clear();
    }

    private static void addClientMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        MenuClient.clientEntries("mnuClient").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuClient", entries);
        entries.clear();

        //Propósito: Agregar clientes
        //Padre: mnuClient
        //Menú mnuAddClient
        MenuClient.addClientEntries("mnuAddClient").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuAddClient", entries);
        entries.clear();

        //Propósito: Editar clientes
        //Padre: mnuClient
        //Menú mnuEditClient
        MenuClient.editClientEntries("mnuEditClient").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuEditClient", entries);
        entries.clear();

        //Propósito: Deshabilitar clientes
        //Padre: mnuClient
        //Menú mnuDeleteClient
        MenuClient.deleteClientEntries("mnuDeleteClient").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuDeleteClient", entries);
        entries.clear();
        //Propósito: Buscar clientes
        //Padre: mnuClient
        //Menú mnuSearchClient

        MenuClient.searchClientEntries("mnuSearchClient").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuSearchClient", entries);
        entries.clear();

//
//    //Propósito: Agregar entradas al menú para solicitar entrada de codigo cliente
//    static protected ArrayList<MenuStruct> getClientIdEntries(String parentMnuName) {
//        //19. mnuGetClientId 
//
//        ArrayList<MenuStruct> entries = new ArrayList();
//        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));
//
//        convertToChildNode("", entries);
//        return entries;
//    }
//        MenuSale.addItemToCartEntries("mnuAddItemToCart").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuAddItemToCart", entries);
//        entries.clear();
////        MenuSale.createFinanceMessage("mnuTransaction").forEach((menuStruct) -> {
////            entries.add(menuStruct);
////        });
////    convertToChildNode("mnuBuying", entries);
//        MenuSale.paymentTypeEntries("mnuBuying").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuBuying", entries);
//        entries.clear();
//         MenuSale.getItemCode("mnuAddItemToCart").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuAddItemToCart", entries);
//        entries.clear();
    }

    private static void addStockMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();
//Menú principal de la rama
        MenuStock.stockEntries("mnuStock").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuStock", entries);
        entries.clear();

        //Propósito: Agregar 
        //Padre: mnuStock
        //Menú mnuAddItem
        MenuStock.addItemEntries("mnuAddItem").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuAddItem", entries);
        entries.clear();

        //Propósito: Editar 
        //Padre: mnuStock
        //Menú mnuEditItem
        MenuStock.editItemEntries("mnuEditItem").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuEditItem", entries);
        entries.clear();

        //Propósito: Deshabilitar 
        //Padre: mnuStock
        //Menú mnuDeleteItem
        MenuStock.deleteItemEntries("mnuDeleteItem").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuDeleteItem", entries);
        entries.clear();
        //Propósito: Buscar 
        //Padre: mnuClient
        //Menú mnuSearchClient

        MenuStock.searchItemEntries("mnuSearchItem").forEach((menuStruct) -> {
            entries.add(menuStruct);
        });
        convertToChildNode("mnuSearchItem", entries);
        entries.clear();

//
//    //Propósito: Agregar entradas al menú para solicitar entrada de codigo cliente
//    static protected ArrayList<MenuStruct> getClientIdEntries(String parentMnuName) {
//        //19. mnuGetClientId 
//
//        ArrayList<MenuStruct> entries = new ArrayList();
//        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));
//
//        convertToChildNode("", entries);
//        return entries;
//    }
//        MenuSale.addItemToCartEntries("mnuAddItemToCart").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuAddItemToCart", entries);
//        entries.clear();
////        MenuSale.createFinanceMessage("mnuTransaction").forEach((menuStruct) -> {
////            entries.add(menuStruct);
////        });
////    convertToChildNode("mnuBuying", entries);
//        MenuSale.paymentTypeEntries("mnuBuying").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuBuying", entries);
//        entries.clear();
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
