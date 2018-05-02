/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock;

import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuAddItemCommonEntriesHeader {

    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // addCommonItemEntries
        //Input menu
        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
        entries.add(new MenuStruct("output", "Introduzca nombre de artículo"));
        entries.add(new MenuStruct("output", "Introduzca marca del artículo"));
        entries.add(new MenuStruct("output", "Introduzca descripción de artículo"));

        
               
 
        
        
        return entries;
    }

}
