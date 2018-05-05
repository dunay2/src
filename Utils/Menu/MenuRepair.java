/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuRepair extends MenuBase {

    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuRepair
    static protected ArrayList<MenuStruct> repairEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuOpenPart", "Abrir un parte de reparaciones"));
        entries.add(new MenuStruct("mnuRepairSearch", "Gestionar una reparacion"));
        entries.add(new MenuStruct("mnuRepairInsertItem", "Dar entrada producto"));
        entries.add(new MenuStruct("", "Listar reparaciones")); //indicando quién las tiene
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }
    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuTransaction

    static protected ArrayList<MenuStruct> OpenParteEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de venta"));
        entries.add(new MenuStruct("output", "Introduzca código de producto averiado"));
        entries.add(new MenuStruct("output", "Introduzca descripción de la avería"));
//        Gestionar las funciones identificadas en el nivel 3.
//• Permitir la asignación de fichas de reparación a un técnico de la tienda (se supone que la tienda cuenta
//con un grupo de técnicos que es fijo en esta versión del sistema).

//• Permitir que cada técnico vea las fichas que le toca gestionar y pueda editar los datos dejando
//constancia del trabajo realizado y el estado de reparación (por ejemplo, pendiente, en proceso, parado
//[hace falta piezas, pendiente de confirmación del cliente], fase de prueba, terminado).

//• Producir diferentes listados del funcionamiento de la tienda: las piezas que hace falta pedir para las
//reparaciones, las fichas procesadas por cada técnico, las confirmaciones que hay que solicitar a los
//clientes, las fichas en proceso y un historial de cada técnico y cada electrodoméstico.
entries.add(new MenuStruct("output", "Introduzca acción a realizar: 1. Pedir piezas "));
       

        return entries;
    }

    static protected ArrayList<MenuStruct> transactionCancelEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca la Referencia de Factura:"));

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

    //Menu obtener codigo producto 
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

        entries.add(new MenuStruct("mnuCash", "Efectivo"));
        entries.add(new MenuStruct("mnuCard", "Tarjeta"));
        entries.add(new MenuStruct("mnuFinance", "Financiado"));
        entries.add(new MenuStruct("tail", "Cancelar"));

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

    //Propósito: Agregar clientes
    //Padre: mnuBuying
    //Menú mnuAddClient
    static protected ArrayList<MenuStruct> addClientEntriesNoID(String parentMnuName) {
//Input menu
        //1. mnuAddClient
        return MenuClient.addClientEntriesNoID("mnuBuying");

        // convertToChildNode(parentMnuName, entries);
    }

    static protected ArrayList<MenuStruct> getClientIdEntries(String parentMnuName) {
//Input menu

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("output,mnuBuyGetClientId", "Introduzca DNI del cliente"));
        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));
        entries.add(new MenuStruct("output", "Introduzca nombre"));
        entries.add(new MenuStruct("output", "Introduzca Apellido"));
        entries.add(new MenuStruct("output", "Introduzca Domicilio"));
        entries.add(new MenuStruct("output", "Introduzca Teléfono"));

        return entries;

        // convertToChildNode(parentMnuName, entries);
    }

}
