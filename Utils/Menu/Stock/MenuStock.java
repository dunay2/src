/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock;

import Utils.Menu.MenuBase;
import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuStock extends MenuBase {

    /**
     *
     * Propósito: Agregar entradas a los menús de items +Menú principal
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> stockEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        //1. mnuItem
        entries.add(new MenuStruct("mnuAddItem", "Agregar Producto"));
        entries.add(new MenuStruct("mnuEditItem", "Actualizar Producto "));
        entries.add(new MenuStruct("mnuDeleteItem", "Eliminar Producto"));
        entries.add(new MenuStruct("", "Listar Productos"));
        entries.add(new MenuStruct("", "Cargar Items de prueba."));
        entries.add(new MenuStruct("mnuSearchItem", "Buscar Producto"));

        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));
        return entries;
    }

    /**Propósito: Agregar entradas al menú de selección mnuAddItem
    
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addItemEntries(String parentMnuName) {
        // mnuAddItem  

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("mnuGenComputers", "Ordenadores"));
        entries.add(new MenuStruct("mnuHome", "Hogar"));
        entries.add(new MenuStruct("mnuGenPhone", "Telefonía"));
        entries.add(new MenuStruct("mnuImage", "Imagen"));
        entries.add(new MenuStruct("mnuSound", "Sonido"));
        entries.add(new MenuStruct("tail", "volver"));

        return entries;
    }

     /**Propósito: Agregar entradas al menú de selección de computadores o periféricos
   
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> computerSectionEntries(String parentMnuName) {
        // mnuComputerSection  
        //
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("mnuComponents", "Periféricos y componentes"));
        entries.add(new MenuStruct("mnuComputers", "Equipos"));
        entries.add(new MenuStruct("tail", "Volver"));

        return entries;
    }

 /**Propósito: Agregar entradas al menú de tipo de computador 
   
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addComputerComponentEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("mnuKeyboard", "Teclados"));
        entries.add(new MenuStruct("mnuMemory", "Memorias"));
        entries.add(new MenuStruct("mnuMouse", "Ratones"));
        entries.add(new MenuStruct("mnuPrinter", "Impresoras"));
        entries.add(new MenuStruct("mnuProcesor", "Procesadores"));
        entries.add(new MenuStruct("tail", "volver"));

        return entries;
    }

     /**Propósito: Agregar entradas al menú de componentes 
   
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addComputerTypeEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("mnuPda", "PDA'S"));
        entries.add(new MenuStruct("mnuLabtop", "Portatiles"));
        entries.add(new MenuStruct("mnuDesktop", "Sobremesa"));
        entries.add(new MenuStruct("mnuNoteBook", "NoteBooks"));
        entries.add(new MenuStruct("tail", "volver"));
        return entries;
    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addHomeEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // mnuAddItem
        entries.add(new MenuStruct("mnuDishWasher", "Lavaplatos"));
        entries.add(new MenuStruct("mnuFridge", "Neveras"));
        entries.add(new MenuStruct("mnuHoover", "Aspiradoras"));
        entries.add(new MenuStruct("mnuWashingMachine", "Lavadoras"));
        entries.add(new MenuStruct("tail", "volver"));

        return entries;
    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addPhoneEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // mnuAddItem
        entries.add(new MenuStruct("mnuMobil", "Móviles"));
        entries.add(new MenuStruct("mnuPhone", "Fijos"));
        entries.add(new MenuStruct("tail", "volver"));

        return entries;
    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addImageEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // mnuAddItem
        entries.add(new MenuStruct("mnuPlasma", "Plasma"));
        entries.add(new MenuStruct("mnuLed", "Led"));

        entries.add(new MenuStruct("tail", "volver"));

        return entries;
    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addSoundEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // mnuAddItem
        entries.add(new MenuStruct("mnuAltavoces", "Altavoces"));
        entries.add(new MenuStruct("mnuAuriculares", "Auriculares"));
        entries.add(new MenuStruct("mnuMinicadena", "Minicadenas"));
        entries.add(new MenuStruct("tail", "volver"));

        return entries;
    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> addCommonItemEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();

        // addCommonItemEntries
        //Input menu
        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
        entries.add(new MenuStruct("output", "Introduzca nombre de artículo"));
        entries.add(new MenuStruct("output", "Introduzca marca del artículo"));

        entries.add(new MenuStruct("output", "Introduzca descripción de artículo"));

        entries.add(
                new MenuStruct("output", "Introduzca precio de compra"));
        entries.add(
                new MenuStruct("output", "Introduzca precio de venta"));
        entries.add(
                new MenuStruct("output", "Introduzca cantidad en stock"));

        return entries;
    }

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> editItemEntries(String parentMnuName) {

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

    /**
     *
     * @param parentMnuName
     * @return
     */
    public static ArrayList<MenuStruct> deleteItemEntries(String parentMnuName) {

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
    public static ArrayList<MenuStruct> searchItemEntries(String parentMnuName) {

        //8. mnuSearchItem  
        //Input mnu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("output", "Introduzca el código de artículo"));

        return entries;

    }

}
