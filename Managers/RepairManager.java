/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import static Managers.OperationsManager.clearScreen;
import Person.Client.Client;
import Person.Client.ClientHistory;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.Record.Record;
import Utils.Record.Repair;
import Utils.Record.Sale;
import Utils.ShoppingCart;
import Utils.ShoppingCart.Line;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ashh412
 */
public class RepairManager extends OperationsManager {

    private static RepairManager instance = null;    //Singleton  Pattern
    private String operCode = "ORDER ".concat(String.valueOf(size()));
    private final SaleManager saleManager;
    private Repair curRepair;

    //Singleton Singleton Pattern
    /**
     *
     * @param clientManager
     * @param saleManager
     */
    protected RepairManager(ClientManager clientManager, SaleManager saleManager) {
        super(clientManager, null);
        this.saleManager = saleManager;
    }

    //Singleton Singleton Pattern
    /**
     *
     * @param clientManager
     * @param saleManager
     * @return
     */
    public static RepairManager getInstance(ClientManager clientManager, SaleManager saleManager) {
        if (instance == null) {
            instance = new RepairManager(clientManager, saleManager);
        }
        return instance;
    }

    @Override

    public boolean handleProcess(MenuNode[] enode) {
        MenuNode node = enode[0];
//        StringBuilder outString;
//        Repair repair;

        switch (node.getValue()) {
//    51. Abrir un parte de reparaciones
            case 51:
                if (createObject(enode) != null) {
                    return true;
                }
                // enode[0] = callNextMenu(node);
                enode[0] = node.getParent();
                break;

            case 52: // gestionar una reparación
                //0 buscar la reparacion
                // 1 cambiar el estado de la reparación
                //añadir comentarios

                curRepair = handleRepair(node);
                if (curRepair != null) {

                    enode[0] = node.getChildNodes().get(0);
                    //  System.out.println("Introduzca nuevo estado de reparación");
                    return false;
                } else {
                    System.out.println("Código de Reparación no válido");
                    return true;
                }

            case 53: //Buscar referencias por factura// Identificamos los productos de una venta
                StringBuilder outString = new StringBuilder();
                Sale sale = (Sale) saleManager.search(node, outString);

                if (sale == null || !(sale.getStatus().equals("A"))) {
                    System.out.println("factura no valida");

                } else {

                    HndInvoice.printInvoiceRef(sale);

                }
                TextInterface.pressKey();
                return true;
//54X listados
            case 541: //"Reparaciones Pendientes" Listar reparaciones de un tecnico
                printByStatus("P");
                TextInterface.pressKey();
                return true;
            case 542: //Reparaciones en Pruebas
                printByStatus("T");
                TextInterface.pressKey();
                return true;
            case 543: //Reparaciones Paradas
                printByStatus("S");
                TextInterface.pressKey();
                return true;

            case 544: //Reparaciones Finalizadas
                printByStatus("F");
                TextInterface.pressKey();
                return true;
            case 545: //Listar reparaciones de un tecnico

                list();
                return true;

            case 5213: //volver al menú anterior
                enode[0] = node.getParent().getParent();
                return true;
            case 5211:

                listRepairHistory(curRepair);

                TextInterface.pressKey();
                return true;
            case 52121:  // R--> EN REPARACION

                setNewStatus(node, curRepair, "R");
                curRepair = null;
                save();
                enode[0] = node.getParent().getParent().getParent();
                return true;

            case 52122:       // P--> PENDIENTE

                setNewStatus(node, curRepair, "P");
                curRepair = null;
                save();
                enode[0] = node.getParent().getParent().getParent();
                return true;
            case 52123:    // S--> PARADO

                setNewStatus(node, curRepair, "S");
                curRepair = null;
                save();
                enode[0] = node.getParent().getParent().getParent();
                return true;
            case 52124:       // T--> TEST

                setNewStatus(node, curRepair, "T");
                curRepair = null;
                save();
                enode[0] = node.getParent().getParent().getParent();
                return true;
            case 52125: //F--> FINALIZADO
                setNewStatus(node, curRepair, "F");
                curRepair = null;

                save();
                enode[0] = node.getParent().getParent().getParent();
                return true;
//
            case 521256: //E--> ENTREGADO
                setNewStatus(node, curRepair, "E");

                returnItemToClient(curRepair);

                curRepair = null;

                save();
                enode[0] = node.getParent().getParent().getParent();
                return true;

//          
        }
        return false;//Profundiza
    }

    /**
     * **
     */
    private void returnItemToClient(Repair repair) {

        client = (Client) clientManager.searchPerson(repair.getCliCode());

        Iterator<Record> it = client.getOperations().iterator();

        while (it.hasNext()) {

            try {
                Sale sale = (Sale) it.next();

                if (repair.getInvoiceRef().equals(sale.getOperCode())) {

                    sale.getShoppingCart().getItems().stream().filter((line) -> (line.getReferences().containsKey(repair.getItemRef()))).forEachOrdered((line) -> {
                        line.getReferences().put(repair.getItemRef(), "A");
                    });
                }
            } catch (Exception e) {

            }

        }
 

    }

    private void setNewStatus(MenuNode node, Repair repair, String status) {
        int i = 0;
        ArrayList<String> nodesData = node.convertTreeChildToList();

        repair.setStatus(status);

        String auxStr = nodesData.get(i);
        if (!nodesData.get(i++).isEmpty()) {
            repair.addHistory(auxStr);
        }

    }

    private Repair handleRepair(MenuNode node) {
        StringBuilder outString = new StringBuilder();
        Repair repair = (Repair) search(node, outString);

        if (repair != null && repair.getEmpCode().equals(employee.getDni())) {
            return repair;
        }
        return null;

    }

//Recorremos las referencias
    @Override
    public Record createObject(MenuNode[] enode) {
        client = null;

        MenuNode node = enode[0];

        //1. buscar cliente 
        StringBuilder outString = new StringBuilder();

        //Devolvemos el código introducido por teclado en el StringBuilder de salida
        client = (Client) clientManager.search(node, outString);
        if (client == null) {
            System.out.println("El cliente no existe");
            return null;
        }

        if (!client.isActive()) {
            System.out.println("El cliente no está activo.");
            TextInterface.pressKey();
            return null;
        }

        //tomamos el resto de valores output
        ArrayList<String> nodesData = node.convertTreeChildToListIdx();

        node.getChildNodes().get(0).clearResponse();

//llamar a obtencion de nodos index
        int i = 0;

        //"Introduzca código de factura"));
        String invoiceRef = nodesData.get(i++);
        //introduzca referencia de producto
        String itemRef = nodesData.get(i++);
        //intruzca nota //Introduzca descripción del problema
        String note = nodesData.get(i++);

        //Creamos un nuevo parte identificando la referencia del objeto
        Repair repair = createRepair(invoiceRef, itemRef, client.getDni(), employee.getDni(), note);
        //damos seguimiento al objeto

        if (repair == null) {
            System.out.println("Datos incorrectos.");
            return null;
        }

        save();

        client.addOperation(repair);

        clientManager.save();
        saleManager.save();
        System.out.println("Orden de reparación creada");
        System.out.println("Su referencia es ".concat(repair.getOperCode()));

        return repair;

    }

    private String getNewRepairNumber() {
        operCode = "ORDER0000".concat(String.valueOf(size()));
        return operCode;
    }

    private Repair createRepair(String invoiceRef, String itemKeyCode, String clientCode, String empCode, String note) {

        // String invoiceRef = getInvoiceRef(itemKeyCode);
        //Buscamos la venta para obtener el producto
        Sale sale = (Sale) saleManager.searchRecord(invoiceRef);
        if (sale == null || !(sale.getStatus().equals("A"))) {
            return null;
        }
        if (!clientCode.equals(sale.getCliCode())) {
            System.out.println("La factura indicada no hace referencia al identificador del cliente ");
            return null;
        }

        if (sale.getStatus().equals("W")) {
            System.out.println("La factura indicada está pendiente de financiación ");
            return null;
        }

        ShoppingCart shoppingCart = sale.getShoppingCart();

        //Bloqueamos el registro en la factura
        Boolean changed = false;
//Buscamos la referencia del artículo en las líneas
        for (Line line : shoppingCart.getItems()) {

            if (line.getReferences().get(itemKeyCode) != null) {
                if (line.getReferences().get(itemKeyCode).equals("A")) {
                    line.getReferences().put(itemKeyCode, "R");
                    changed = true;
                    break;
                }
            }
        }
        if (!changed) {
            return null;
        }

        //Creamos un nuevo parte identificando la referencia del objeto
        //
        //damos seguimiento al objeto
        Repair repair = new Repair(getNewRepairNumber() + getItemRef(itemKeyCode), clientCode, empCode, sale.getOperCode(), itemKeyCode);

        //Introduzca descripción del problema
        repair.addHistory(note);

        if (add(repair)) {

            return repair;
        }
        return null;

    }

    private static String getInvoiceRef(String code) {

        String[] parts = code.split("-");
        return parts[0];

    }

    private static String getItemRef(String code) {

        String[] parts = code.split("-");
        return parts[1];

    }

    @Override
    public void list() {

        Iterator<Map.Entry<String, Record>> it = this.getAll().entrySet().iterator();

        printHeader();
        while (it.hasNext()) {
            Repair repair = (Repair) it.next().getValue();
            if (repair.getEmpCode().equals(this.employee.getDni())) {
                print(repair);
            }

        }
        TextInterface.pressKey();
        clearScreen();
    }

    private void printHeader() {
        System.out.printf("%-25s%-15s%-15s%-20s%-20s%n", "OPERACION", "CLIENTE", "EMPLEADO", "FECHA", "ESTADO");

    }

    private void listRepairHistory(Repair repair) {
        String status;

        status = repair.getStatus();

        switch (status) {
            case "T":
                status = " En Pruebas";
                break;
            case "R":
                status = " En Reparación";
                break;
            case "P":
                status = " Pendiente";
                break;

            case "S":
                status = " Parado";
                break;

            case "F":
                status = " Finalizado";
                break;

        }

        System.out.println("El estado actual de la reparación es: " + status);
        System.out.println("****************");
        repair.getHistory().forEach((ClientHistory r) -> {
            System.out.println("Fecha: " + r.getDate());
            System.out.println("Nota: " + r.getNote());
        });
        System.out.println("****************");

    }

    //Propósito:
    //Imprimir las reparaciones que estén en un determinado estado
    //Parámetro de entrada status--> estado que consultamos
    // Buscamos en la coleción de reparaciones
    private void printByStatus(String status) {

        System.out.println("****Listado por estado ".concat(status));

        System.out.println("Operación " + "Código de cliente " + " Código de empleado");
        getAll().forEach((String s, Record r) -> {

            if (r.getStatus().equals(status)) {
                System.out.println(r.getOperCode() + " " + r.getCliCode() + " " + r.getEmpCode());
            }
        });

    }

    public Repair getRepair(String operCod) {

        Repair repair = (Repair) searchRecord(operCod);

        return repair;

    }

    private void changeOperStatus(String operCode, String newStatus) {

        Iterator<Record> it = client.getOperations().iterator();

        while (it.hasNext()) {

            Record record = (Record) it.next();
            if (record.getOperCode().equals(operCode)) {
                record.setStatus(newStatus);
            }
        }
    }

}
