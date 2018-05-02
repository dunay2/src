/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Computers.Components;

import Utils.Menu.Stock.MenuAddItemCommonEntriesFooter;
import Utils.Menu.Stock.MenuAddItemCommonEntriesHeader;
import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuProcesor {

    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = MenuAddItemCommonEntriesHeader.addResponseEntries("");
        entries.add(new MenuStruct("output", "Introduzca MHz"));
        entries.addAll(MenuAddItemCommonEntriesFooter.addResponseEntries(""));

        return entries;
    }
}
