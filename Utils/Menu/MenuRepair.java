       
//        Gestionar las funciones identificadas en el nivel 3.
//• Permitir la asignación de fichas de reparación a un técnico de la tienda (se supone que la tienda cuenta
//con un grupo de técnicos que es fijo en esta versión del sistema).

//• Permitir que cada técnico vea las fichas que le toca gestionar y pueda editar los datos dejando
//constancia del trabajo realizado y el estado de reparación (por ejemplo, pendiente, en proceso, parado
//[hace falta piezas, pendiente de confirmación del cliente], fase de prueba, terminado).

//• Producir diferentes listados del funcionamiento de la tienda: las piezas que hace falta pedir para las
//reparaciones, las fichas procesadas por cada técnico, las confirmaciones que hay que solicitar a los
//clientes, las fichas en proceso y un historial de cada técnico y cada electrodoméstico.

       
package Utils.Menu;

import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuRepair extends MenuBase {

    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuRepair
    static protected ArrayList<MenuStruct> repairEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuOpenPart", "Abrir un parte de reparaciones"));
        entries.add(new MenuStruct("mnuRepairSearch", "Gestionar una reparacion"));
//        entries.add(new MenuStruct("mnuRepairInsertItem", "Dar entrada producto"));
        entries.add(new MenuStruct("", "Listar reparaciones")); //indicando quién las tiene
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }
    //Propósito: Menú abrir un parte
    //Padre: mnuRepair
    //Menú mnuOpenPart

    static protected ArrayList<MenuStruct> openParteEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de cliente"));
        entries.add(new MenuStruct("output", "Introduzca referencia de producto averiado"));
        entries.add(new MenuStruct("output", "Introduzca descripción de la avería"));
        entries.add(new MenuStruct("output", "Introduzca acción a realizar: 1. Pedir piezas "));
        
 

        return entries;
    }

    //Una factura puede tener varias reparaciones
    
   //mnuRepairSearch
    static protected ArrayList<MenuStruct> repairSearchEntries(String parentMnuName) {
        //15. 
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Buscar por código de reparacion"));
        entries.add(new MenuStruct("output", "Buscar reparaciones clientes"));
        entries.add(new MenuStruct("output", "Introduzca descripción de la avería"));
        entries.add(new MenuStruct("output", "Introduzca acción a realizar: 1. Pedir piezas "));
        
 

        return entries;
    }
   




}
