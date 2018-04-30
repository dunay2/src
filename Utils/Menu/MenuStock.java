/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import Utils.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuStock extends MenuBase {

    //Propósito: Agregar entradas a los menús  de items
    static protected ArrayList<MenuStruct> stockEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        //1. mnuItem
        entries.add(new MenuStruct("mnuAddItem", "Agregar Producto"));
        entries.add(new MenuStruct("mnuEditItem", "Actualizar Producto "));
        entries.add(new MenuStruct("mnuDeleteItem", "Eliminar Producto"));
        entries.add(new MenuStruct("", "Listar Productos"));
        entries.add(new MenuStruct("", "Crear Aleatorio .No implementando."));     
        entries.add(new MenuStruct("mnuSearchItem", "Buscar Producto"));
   
        

        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));
        return entries;
    }

    static protected ArrayList<MenuStruct> ItemSectionEntries(String parentMnuName) {

        //18. mnuItemSectionArrayList<String> entries = new ArrayList();
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "PDA'S"));
        entries.add(new MenuStruct("", "Portatiles"));
        entries.add(new MenuStruct("", "Sobremesa"));
        entries.add(new MenuStruct("", "NoteBooks"));

        return entries;

    }

    static protected ArrayList<MenuStruct> addItemEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        //5. mnuAddItem
        //Input menu
        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
        entries.add(new MenuStruct("output", "Introduzca código de familia: 1.  Ordenadores   2. Hogar   3. Telefonía   4. Imagen   5. Sonido"));
        entries.add(new MenuStruct("output", "Introduzca nombre de artículo"));
        entries.add(new MenuStruct("output", "Introduzca descripción de artículo"));
        entries.add(new MenuStruct("output", "Introduzca precio de compra"));
        entries.add(new MenuStruct("output", "Introduzca precio de venta"));
        entries.add(new MenuStruct("output", "Introduzca cantidad en stock"));

        return entries;
    }

    static protected ArrayList<MenuStruct> editItemEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();

        //6. mnuEditItem   
        //Input menu
        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
        entries.add(new MenuStruct("output", "Introduzca nombre de artículo"));
        entries.add(new MenuStruct("output", "Introduzca descripción de artículo"));
        entries.add(new MenuStruct("output", "Introduzca precio de compra"));
        entries.add(new MenuStruct("output", "Introduzca precio de venta"));
        entries.add(new MenuStruct("output", "Introduzca cantidad en stock"));

        return entries;
    }

    static protected ArrayList<MenuStruct> deleteItemEntries(String parentMnuName) {

//7. "mnuDeleteItem";
        ArrayList<MenuStruct> entries = new ArrayList();
//InputMnu
        //1. mnuItem
        entries.add(new MenuStruct("output", "Introduzca el código de artículo"));

        return entries;

    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> searchItemEntries(String parentMnuName) {

        //8. mnuSearchItem  
        //Input mnu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("output", "Introduzca el código de artículo"));

        return entries;

    }

    //Propósito: Agregar entradas al menú de selección de computadores
    static protected ArrayList<MenuStruct> computerSectionEntries(String parentMnuName) {
        //21. mnuComputerSection  

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("mnuComponents", "Periféricos y componentes"));
        entries.add(new MenuStruct("mnuComputers", "Equipos"));
        entries.add(new MenuStruct("tail", "Volver"));

        return entries;
    }

    private int addItemFamilyMenu(String mnuName[], int k) {

        //Menús específicos de ele ctrodomésticos
        mnuName[k++] = "mnuComputerSection";
        mnuName[k++] = "mnuAddTv";
        mnuName[k++] = "mnuAddFridge";
        mnuName[k++] = "mnuAddImage";
        mnuName[k++] = "mnuAddLabtop";
        mnuName[k++] = "mnuAddNotebook";
        mnuName[k++] = "mnuAddPda";
        mnuName[k++] = "mnuAddPhone";
        mnuName[k++] = "mnuAddImage";
        mnuName[k++] = "mnuAddComputer";
        return k;
    }

}
