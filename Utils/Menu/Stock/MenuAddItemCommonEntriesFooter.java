/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock;

import Utils.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuAddItemCommonEntriesFooter {
    
     public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // addCommonItemEntries
        //Input menu
 entries.add(new MenuStruct("output", "Introduzca periodo de garantía"));
         entries.add(new MenuStruct("output", "Introduzca precio de compra"));
        entries.add(new MenuStruct("output", "Introduzca precio de venta"));
        entries.add(new MenuStruct("output", "Introduzca cantidad en stock"));


        
        
        return entries;
    }
    
}
