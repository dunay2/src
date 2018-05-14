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
        entries.add(new MenuStruct("mnuRepairSearch", "Gestionar una reparación"));
//        entries.add(new MenuStruct("mnuRepairInsertItem", "Dar entrada producto"));
        entries.add(new MenuStruct("mnuChekcInvoiceItem", "Buscar referencias por factura"));
        entries.add(new MenuStruct("mnuRepairList", "Listar reparaciones")); //indicando quién las tiene
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }

    //Propósito: Gestionar estado de reparación
    //Padre: mnuRepairList
    static protected ArrayList<MenuStruct> mnuRepairListentries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("", "Reparaciones Pendientes"));
        entries.add(new MenuStruct("", "Reparaciones en Pruebas"));
        entries.add(new MenuStruct("", "Reparaciones Paradas"));
        entries.add(new MenuStruct("", "Reparaciones Finalizadas"));
        entries.add(new MenuStruct("", "Mis Reparaciones"));

        entries.add(new MenuStruct("tail", "Volver"));

        return entries;

    }

    //Propósito: Menú abrir un parte
    //Padre: mnuRepair
    //Menú mnuOpenPart
    static protected ArrayList<MenuStruct> openParteEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de cliente"));
        entries.add(new MenuStruct("output", "Introduzca código de factura"));
        entries.add(new MenuStruct("output", "Introduzca referencia de producto averiado"));
        entries.add(new MenuStruct("output", "Introduzca descripción de la avería"));

        return entries;
    }

    //Una factura puede tener varias reparaciones
    //mnuRepairSearch
    static protected ArrayList<MenuStruct> repairSearchEntries(String parentMnuName) {
//        
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnu1", "Introduzca nuevo estado de reparación"));
        entries.add(new MenuStruct("mnu2", "Introduzca comentarios"));

        return entries;
    }

    //Propósito: Gestionar estado de reparación
    //Menu
    //Padre: mnuChekcInvoiceItem
    static protected ArrayList<MenuStruct> ChekcInvoiceItemEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de factura"));

        return entries;
    }

    //Propósito: Gestionar estado de reparación
    //Menu añadir producto al carrito
    //Padre: mnuRepairSearch
    static protected ArrayList<MenuStruct> hndRepairSearchEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output,mnuHndRepairCode", "Introduzca código de reparación"));

        return entries;
    }

    //Propósito: Gestionar estado de reparación
    //Padre: mnuHndRepairCode
    static protected ArrayList<MenuStruct> hndRepairHndEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuRepHist", "Ver historial"));
        entries.add(new MenuStruct("mnuRepChangeStatus", "Cambiar estado de reparación"));
        entries.add(new MenuStruct("tail", "Volver"));

        return entries;
    }

    //Propósito: Gestionar estado de reparación
    //Padre: mnuRepChangeStatus
    static protected ArrayList<MenuStruct> hndRepairStatusEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuRepRep", "En Reparación"));
        entries.add(new MenuStruct("mnuRepPending", "Pendiente"));
        entries.add(new MenuStruct("mnuRepStop", "Parado"));
        entries.add(new MenuStruct("mnuRepTest", "En Pruebas"));
        entries.add(new MenuStruct("mnuRepFinish", "Finalizado"));
           entries.add(new MenuStruct("mnuRepReturn", "Entregar"));

        return entries;
    }

    static protected ArrayList<MenuStruct> mnuRepairAddCommentEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca comentarios"));

        return entries;
    }

}
