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
public class MenuClient extends MenuBase {

    //Propósito: Agregar entradas al clientes
    //Padre: mnuTransaction
    //Menú mnuClient
    static protected ArrayList<MenuStruct> clientEntries(String parentMnuName) {

        //1. mnuClient
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuSearchClient", "Buscar Cliente"));
        entries.add(new MenuStruct("mnuAddClient", "Agregar Cliente"));
        entries.add(new MenuStruct("mnuUpdateClient", "Actualizar Cliente "));
        entries.add(new MenuStruct("mnuListClient", "Listar Cliente"));
        entries.add(new MenuStruct("mnuDeleteClient", "Eliminar Cliente"));
        entries.add(new MenuStruct("mnuAddClient", "Agregar Cliente aleatorio"));
        entries.add(new MenuStruct("", "Volver al Menú Principal"));

        convertToChildNode(parentMnuName, entries);
        return entries;
    }

    //Propósito: Agregar clientes
    //Padre: mnuClient
    //Menú mnuAddClient
    static protected ArrayList<MenuStruct> addClientEntries(String parentMnuName) {
//Input menu
        //1. mnuAddClient
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("", "Introduzca nombre"));
        entries.add(new MenuStruct("", "Introduzca Apellido"));
        entries.add(new MenuStruct("", "Introduzca Domicilio"));
        entries.add(new MenuStruct("", "Introduzca Teléfono"));

        convertToChildNode(parentMnuName, entries);
        return entries;
    }
    //Propósito: Editar clientes
    //Padre: mnuClient
    //Menú mnuEditClient

    static protected ArrayList<MenuStruct> editClientEntries(String parentMnuName) {
        //1. mnuEditClient
//InputMenu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));
        entries.add(new MenuStruct("", "Introduzca nombre"));
        entries.add(new MenuStruct("", "Introduzca Apellido"));
        entries.add(new MenuStruct("", "Introduzca Domicilio"));
        entries.add(new MenuStruct("", "Introduzca Teléfono"));
        convertToChildNode(parentMnuName, entries);
        return entries;
    }

    //Propósito: Deshabilitar clientes
    //Padre: mnuClient
    //Menú mnuDeleteClient
    static protected ArrayList<MenuStruct> deleteClientEntries(String parentMnuName) {
//InputMenu
        //3. mnuDeleteClient  
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));
        convertToChildNode(parentMnuName, entries);
        return entries;
    }

    //Propósito: Deshabilitar clientes
    //Padre: mnuClient
    //Menú mnuSearchClient
    static protected ArrayList<MenuStruct> searchClientEntries(String parentMnuName) {

        //4. mnuSearchClient    
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));
        convertToChildNode(parentMnuName, entries);
        return entries;
    }

    //Propósito: Agregar entradas al menú para solicitar entrada de codigo cliente
    static protected ArrayList<MenuStruct> getClientIdEntries(String parentMnuName) {
        //19. mnuGetClientId 

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Introduzca DNI del cliente"));

        convertToChildNode("", entries);
        return entries;
    }

}
