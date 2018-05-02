/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Home;

import Utils.Menu.Stock.MenuAddItemCommonEntriesFooter;
import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuFridge {

    //Input menu
    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = MenuHomeCommon.addResponseEntries("");

        entries.add(new MenuStruct("output", "Introduzca Capacidad de la Nevera"));
        entries.add(new MenuStruct("output", "Introduzca Capacidad del Congelador"));
        entries.add(new MenuStruct("output", "Introduzca Cantidad de Cajones"));
        
        entries.addAll(MenuAddItemCommonEntriesFooter.addResponseEntries(""));

        return entries;
    }

}
