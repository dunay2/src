/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Phones;


import Utils.Menu.Stock.MenuAddItemCommonEntriesFooter;
import Utils.Menu.MenuStruct;
import Utils.Menu.Stock.MenuAddItemCommonEntriesHeader;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuPhone {
  private static final long serialVersionUID = -2873344211410398459L;
   

    /**Input menu
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = MenuAddItemCommonEntriesHeader.addResponseEntries("");

        entries.addAll(MenuAddItemCommonEntriesFooter.addResponseEntries(""));

        return entries;
    }

}
