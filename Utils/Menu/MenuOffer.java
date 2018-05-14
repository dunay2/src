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
public class MenuOffer extends MenuBase {

    /**
     * Propósito: Menú principal de ofertas //Menu entradas de menú ofertas
     * Padre: mnuOffer //Menú mnuTransaction
     *
     * @param parentMnuName
     * @return
     *
     */
    static protected ArrayList<MenuStruct> offerEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();


        entries.add(new MenuStruct("mnuCreatePromo", "Crear una promocion  "));
        entries.add(new MenuStruct("mnuLisgPromo", "Listar las promociones"));
        entries.add(new MenuStruct("mnuListPromoCli", "Listar los clientes de una promocion"));
        entries.add(new MenuStruct("mnuAddPromoCli", "Agregrar cliente a promocion"));
        entries.add(new MenuStruct("mnuPromoSend", "Enviar correo a listado"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }

    /**
     * Propósito: agregar entradas para añadir una promocion
     * Padre: mnuCreatePromo 
     * 
     *
     * @param parentMnuName
     * @return
     *
     */
    static protected ArrayList<MenuStruct> createPromoEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de Promoción"));
        entries.add(new MenuStruct("output", "Introduzca descripción"));

        return entries;
    }

    /**
     * Propósito: agregar entradas para listar clientes de una promocion
     * Padre: Menú mnuListPromoCli
     *
     * @param parentMnuName
     * @return
     *
     */
    static protected ArrayList<MenuStruct> listPromoCliEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca el identificador de la promoción:"));

        return entries;
    }

    
     /**
     * Propósito: agregar entradas para añdir un cliente a una promocion 
     * Padre: Menú mnuAddPromoCli
     *
     * @param parentMnuName
     * @return
     *
     */
    
    static protected ArrayList<MenuStruct> addPromoCliEntries(String parentMnuName) {
     
        ArrayList<MenuStruct> entries = new ArrayList();

    entries.add(new MenuStruct("output", "Introduzca el identificador de la promoción:"));
    entries.add(new MenuStruct("output", "Introduzca el identificador de cliente:"));
    

        return entries;
    }

 /**
     * Propósito: Menu obtener codigo promocióm para envío de correo 
     * Padre: Menú mnuPromoSend
     *
     * @param parentMnuName
     * @return
     *
     */
    //

    static protected ArrayList<MenuStruct> promoSendEntries(String parentMnuName) {
         //Input menu
        ArrayList<MenuStruct> entries = new ArrayList(); 
         entries.add(new MenuStruct("output", "Introduzca código de promoción"));

        return entries;
    }


   

 

}
