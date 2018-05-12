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
public class MenuCredit extends MenuBase {

    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuTransaction
    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> financeEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de cliente"));
        entries.add(new MenuStruct("output", "Introduzca código de factura"));
        entries.add(new MenuStruct("output", "Introduzca nómina"));
        entries.add(new MenuStruct("output", "Introduzca periodo de financiación"));

        return entries;
    }
   

}
