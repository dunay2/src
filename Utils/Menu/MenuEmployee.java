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

        entries.add(new MenuStruct("mnuAddEmployee", "Agregar Empleado"));
        entries.add(new MenuStruct("mnuEditEmployee", "Actualizar Empleado "));
        entries.add(new MenuStruct("mnuDeleteEmployee", "Eliminar Empleado"));
        entries.add(new MenuStruct("mnuListEmployee", "Listar Empleados"));
        entries.add(new MenuStruct("mnuSearchEmployee", "Buscar Empleado"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }
    //Identificar el tipo de empleado a crear para asignarle un rol
    
//Propósito: Agregar entradas al menú agregar empleados
    //Padre: mnuEmployee
    //Menú mnuAddEmployee

    static protected ArrayList<MenuStruct> addEmployeeEntries(String parentMnuName) {

        //9. mnuAddEmployee
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca nombre del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca Apellido del Empleado "));
        entries.add(new MenuStruct("output", "Introduzca Domicilio"));
        entries.add(new MenuStruct("output", "Introduzca Teléfono"));
        entries.add(new MenuStruct("output", "Introduzca rol: 1. Vendedor 2. Tecnico 3. Financiero"));

        return entries;
    }
//Propósito: Agregar entradas al menú editar empleados
    //Padre: mnuEmployee
    //Menú mnuEditEmployee

    static protected ArrayList<MenuStruct> editEmployeeEntries(String parentMnuName) {
//Input Menu
        //10. mnuEditEmployee    
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca nombre del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca Apellido del Empleado "));
        entries.add(new MenuStruct("output", "Introduzca Direccion"));
        entries.add(new MenuStruct("output", "Telefono"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;

    }
    //Propósito: Agregar entradas al menú borrar empleados
    //Padre: mnuEmployee
    //Menú mnuDeleteEmployee

    static protected ArrayList<MenuStruct> deleteEmployeeEntries(String parentMnuName) {

        //3. mnuDeleteEmployee  
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));

        return entries;
    }

    //Propósito: Agregar menú búsqueda de empleado
    static protected ArrayList<MenuStruct> searchEmployeeEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();
        //4. mnuSearchEmployee    
        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));

        return entries;
    }
}
