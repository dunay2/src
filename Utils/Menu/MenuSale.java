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
public class MenuSale extends MenuBase {

    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuTransaction
    static protected ArrayList<MenuStruct> transactionEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuQuery", "Consultar el importe actual"));
        entries.add(new MenuStruct("mnuAddItemToCart", "Añadir producto al carrito"));
        entries.add(new MenuStruct("mnuBuying", "Cobrar Compra"));
        entries.add(new MenuStruct("tail", "Cancelar venta"));

        return entries;
    }

    //Menu añadir producto al carrito
    //Padre: mnuTransaction
    //Menú mnuAddItemToCart
    static protected ArrayList<MenuStruct> addItemToCartEntries(String parentMnuName) {
        //16 mnuAddItemToCart

        //Input menu
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
        entries.add(new MenuStruct("output", "Introduzca cantidad"));

        return entries;
    }
    
    
    
     //Menu añadir producto al carrito
    //Padre: mnuAddItemToCart
    //Menú output
    static protected ArrayList<MenuStruct> getItemCode(String parentMnuName) {
        //getItemCode

        //Input menu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
    

        return entries;
    }

    

    //Menu código de artículo
    //Padre: mnuBuying
    //Menú 
//    private ArrayList<MenuNode> buyingEntries(MenuNode node) {
//        //16 mnuAddItemToCart
//        //Input menu
//        ArrayList<MenuStruct> entries = new ArrayList();
//
//        entries.add(new MenuStruct("", "Seguir Comprando"));
//        entries.add(new MenuStruct("", "Cancelar Compra"));
//
//        return convertToChildNode(node, entries);
//    }
    //Propósito: Agregar entradas al menú forma de pago
    //Menu seguir comprando
    //Padre: mnuBuying
    //Menú mnuPaymentType
    static protected ArrayList<MenuStruct> paymentTypeEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();
        //6. mnuPaymentType   

        entries.add(new MenuStruct("", "Efectivo"));
        entries.add(new MenuStruct("", "Tarjeta"));
        entries.add(new MenuStruct("", "Financiado"));

        return entries;

    }
    //Propósito: Agregar entrada con mensaje financiacion
    //Menu seguir comprando
    //Padre: ???
    //Menú mensaje

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> createFinanceMessage(String parentMnuName) {

        //18. 
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Por favor, para terminar la compra pase por el departamento financiero e indique su DNI"));
//el hijo es main, es tail
        return entries;

    }
}
