/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Home;


import Utils.Menu.Stock.MenuAddItemCommonEntriesFooter;
import Utils.Menu.Stock.MenuAddItemCommonEntriesHeader;
import Utils.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuDishWasher {

    // addCommonItemEntries
    //Input menu
    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = MenuAddItemCommonEntriesHeader.addResponseEntries("");
        entries.add(new MenuStruct("output", "Introduzca ancho"));
        entries.add(new MenuStruct("output", "Introduzca alto"));
        entries.add(new MenuStruct("output", "Introduzca fondo"));
        entries.add(new MenuStruct("output", "Introduzca potencia"));
        entries.add(new MenuStruct("output", "Introduzca categoría energetica"));
        entries.addAll(MenuAddItemCommonEntriesFooter.addResponseEntries(""));

        return entries;
    }

}


