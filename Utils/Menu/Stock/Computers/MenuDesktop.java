/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Computers;

import Utils.Menu.Stock.MenuAddItemCommonEntriesFooter;
import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuDesktop {
      // addCommonItemEntries
    //Input menu
    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
     ArrayList<MenuStruct> entries = MenuComputer.addResponseEntries("");
        entries.addAll(MenuAddItemCommonEntriesFooter.addResponseEntries(""));

        return entries;
    }
}
