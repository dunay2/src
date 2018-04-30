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
public class MenuEmployee extends MenuBase {

    //Propósito: Agregar entradas al menú empleados
    //Padre: mnuMain
    //Menú mnuEmployee
    static protected ArrayList<MenuStruct> employeeEntries(String parentMnuName) {

        //1. mnuEmployee
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuaddEmployee", "Agregar Empleado"));
        entries.add(new MenuStruct("mnueditEmployee", "Actualizar Empleado "));
        entries.add(new MenuStruct("mnusearchEmployee", "Buscar Empleado"));
        entries.add(new MenuStruct("", "Listar Empleados"));
        entries.add(new MenuStruct("mnudeleteEmployee", "Eliminar Empleado"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }
//Propósito: Agregar entradas al menú agregar empleados
    //Padre: mnuEmployee
    //Menú mnuAddEmployee

    static protected ArrayList<MenuStruct> addEmployeeEntries(MenuNode node) {

        //9. mnuAddEmployee
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuTransaction", "Introduzca DNI del Empleado"));
        entries.add(new MenuStruct("mnuTransaction", "Introduzca nombre del Empleado"));
        entries.add(new MenuStruct("mnuTransaction", "Introduzca Apellido del Empleado "));
        entries.add(new MenuStruct("mnuTransaction", "Introduzca nómina"));

        return entries;
    }
//Propósito: Agregar entradas al menú editar empleados
    //Padre: mnuEmployee
    //Menú mnuEditEmployee

    static protected ArrayList<MenuStruct> editEmployeeEntries(MenuNode node) {
//Input Menu
        //10. mnuEditEmployee    
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("", "Introduzca DNI del Empleado"));
        entries.add(new MenuStruct("", "Introduzca nombre del Empleado"));
        entries.add(new MenuStruct("", "Introduzca Apellido del Empleado "));
        entries.add(new MenuStruct("", "Introduzca nómina"));
        entries.add(new MenuStruct("", "Volver al Menú Principal"));

        return entries;

    }
    //Propósito: Agregar entradas al menú borrar empleados
    //Padre: mnuEmployee
    //Menú mnuDeleteEmployee

    static protected ArrayList<MenuStruct> deleteEmployeeEntries(MenuNode node) {

        //3. mnuDeleteClient  
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuTransaction", "Introduzca DNI del Empleado"));

        convertToChildNode("mnuEmployee", entries);
        return entries;
    }

//    //Propósito: Agregar menú búsqueda de empleado
//    private ArrayList<String> searchEmployeeEntries(MenuNode node) {
//        ArrayList<String> code = new ArrayList();
//        //4. mnuSearchClient    
//        code.add("Introduzca DNI del empleado");
//        return convertToChildNode(node, code);
//    }
}
