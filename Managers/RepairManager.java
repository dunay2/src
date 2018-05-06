/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.Menu.MenuStruct;
import Utils.Record.Record;
import Utils.Record.Repair;
import Utils.Record.Sale;
import java.util.HashMap;

/**
 *
 * @author ashh412
 */
public class RepairManager extends OperationsManager {

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


 

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   



    @Override
    public boolean handleProcess(MenuNode[] enode) 
    {  MenuNode node = enode[0];
        StringBuilder outString;
        Sale sale;

        switch (node.getValue()) {

            //Devolución
            case 12:

                outString = new StringBuilder();
                sale = (Sale) search(node, outString);
                if (sale == null) {
                    System.out.println("La factura no existe");
                    TextInterface.pressKey();
                    return true;
                }
                if (sale.getActive().equals("Y")) {

                    //cancelTransaction(sale);

                    System.out.println("La factura ".concat(sale.getOperCode().concat(" ha sido cancelada")));
                    TextInterface.pressKey();
                } else {
                    System.out.println("La factura ".concat(sale.getOperCode().concat(" ya está cancelada")));
                    TextInterface.pressKey();
                }

                return true;

            case 13:
                list();
                TextInterface.pressKey();
                return true;

            case 14: // Buscar una Factura"
                outString = new StringBuilder();
                Repair repair = (Repair) search(node, outString);

              //  printRecord(sale);
                return true;

            //Consultar el importe actual
            case 111:
                //itemList();
                return true;
            //"12. Añadir electrodomestico al carrito"
            case 112:
                //addItem(node);
                return true;

            //13. Cobrar Compra
            case 113:
                //identificar al cliente o solicitar alta 
                //Si el carrito está vacío cancelar el cobro
                //Si no, seguimos navegando por los hijos
                if (createObject(enode) == null) {
                    return true;
                }
               // enode[0] = callNextMenu(node);
                break;
       

            

            case 11314://cancel
             //   clearShoppingCart();
                enode[0] = callMainMenu(node);
                return true;

            case 113131://Mensaje final financiado
                enode[0] = callMainMenu(node);

        }
        return false;//Profundiza
    }
    
//          entries.add(new MenuStruct("mnuOpenPart", "Abrir un parte de reparaciones"));
//        entries.add(new MenuStruct("mnuRepairSearch", "Gestionar una reparacion"));
//        entries.add(new MenuStruct("mnuRepairInsertItem", "Dar entrada producto"));
//        entries.add(new MenuStruct("", "Listar reparaciones")); //indicando quién las tiene

    @Override
    public Record createObject(MenuNode[] node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

  
    
}
