/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Home;


import Utils.Menu.Stock.MenuAddItemCommonEntriesHeader;
import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuHomeCommon {

    //  Common Item Entries
    //Input menu
    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = MenuAddItemCommonEntriesHeader.addResponseEntries("");
        entries.add(new MenuStruct("output", "Introduzca Ancho"));
        entries.add(new MenuStruct("output", "Introduzca Alto"));
        entries.add(new MenuStruct("output", "Introduzca Fondo"));
        entries.add(new MenuStruct("output", "Introduzca Potencia"));
        entries.add(new MenuStruct("output", "Introduzca Categoría Energetica"));

        return entries;
    }

}


