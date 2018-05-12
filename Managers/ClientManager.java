/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;

import ScreenInterfaces.TextInterface;
import Utils.Generator.PersonGenerator;
import Utils.Menu.MenuNode;
import Utils.Record.Finance;
import Utils.Record.Record;
import Utils.Record.Repair;
import Utils.Record.Sale;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 *
 * @author ashh412 Propósito: gestor de operaciones de clientes
 *///
public class ClientManager extends PersonManager {

    private static ClientManager instance = null;    //Singleton Pattern
    private SaleManager saleManager;
    private RepairManager repairManager;

    /**
     *
     * @return
     */
    public SaleManager getSaleManager() {
        return saleManager;
    }

    /**
     *
     * @param saleManager
     */
    public void setSaleManager(SaleManager saleManager) {
        this.saleManager = saleManager;
    }

    //Singleton Singleton Pattern
    /**
     *
     */
    protected ClientManager() {

    }
    //Singleton Singleton Pattern

    /**
     *
     * @return
     */
    public static ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager();
        }
        return instance;
    }

    public RepairManager getRepairManager() {
        return repairManager;
    }

    public void setRepairManager(RepairManager repairManager) {
        this.repairManager = repairManager;
    }

    //Propósito: crear un cliente aleatorio
    /**
     *
     * @return
     */
    public Client generateRandomClient() {

        Client client;
        // public PersonOperation(String dni, String firstName, String lastName, Double salary) {
        //  super(dni, firstName, lastName, salary);
        client = new Client(PersonGenerator.generateDni());
        client.setFirstName(PersonGenerator.generateFirstName());
        client.setLastName(PersonGenerator.generateLastName());
        System.out.println("Cliente generado: " + client.getDni() + " " + client.getFirstName());
        add(client);
//        //Guardar los datos 
        save();
        TextInterface.pressKey();
        return client;
    }
//Propósito: modificar los datos de un cliente

//Propósito: gestionar las peticiones del controlador principal
    /**
     *
     * @param enode
     * @return
     */
    @Override
    public boolean handleProcess(MenuNode[] enode) {

        MenuNode node = enode[0];

        switch (node.getValue()) {

            case 21:

                createObject(enode);
                return true;

            case 22: //Actualizar

                update(node);
                return true;

            case 23: //Eliminar

                delete(node);
                return true;
            //Listar clientes 
            case 24:
                listClients();
                return true;
            //Crear cliente aleatorio
            case 25:
                generateRandomClient();
                return true;
            case 26://buscar

                StringBuilder outString = new StringBuilder();
                Client client = (Client) search(node, outString);
                printRecord(client);
                return true;
            case 27://menu superior
                return false;
        }
        return false;
    }

//    private void delete(MenuNode node) {
//
//        StringBuilder outString = new StringBuilder();
//        Client client = (Client) search(node, outString);
//        if (client == null) {
//            System.out.println("El cliente no existe");
//            TextInterface.pressKey();
//
//        } else {
//            client.setActive(false);
//            System.out.println("Cliente desactivado. Pulse una tecla para continuar");
//            TextInterface.pressKey();
//        }
//    }
    private void printRecord(Client client) {
        if (client == null) {
            System.out.println("el cliente no existe");
            TextInterface.pressKey();
            return;
        }

        print(client);
        System.out.println("Operaciones del cliente");

        System.out.printf("%-12s%-20s%-20s%-20s%-20s%n", "Operación", "Código", "Atentido por", "Fecha", "TOTAL");

        printRecords(client);

        TextInterface.pressKey();
    }

    private void printRepairRecords(Repair repair) {

        if (repair != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
// Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String strDate = formatter.format(repair.getDate());

            System.out.printf("%-12s%-20s%-20s%-20s%-20s%n", "Reparación", repair.getOperCode(), repair.getEmpCode(), strDate, "");
        }

    }

    private void printFinanceRecords(Finance finance) {

        if (finance != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
// Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String strDate = formatter.format(finance.getDate());

            String strFinStatus;

            if (finance.isApproved()) {
                strFinStatus = "Aprobada";
            } else {
                strFinStatus = "Rechazada";

            }
            System.out.printf("%-12s%-20s%-20s%-20s%-20s%n", "Financiero", finance.getOperCode(), finance.getEmpCode(), strDate, strFinStatus);
        }

    }

    private void printSaleRecords(Sale sale) {
        //    Sale sale = saleManager.getSale((String) it.next());
        if (sale != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
// Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String strDate = formatter.format(sale.getDate());

            String strTotal = String.valueOf(sale.getTotal());

            if (sale.getStatus().equals("W")) {
                strTotal = strTotal.concat(" Pendiente de aprobación financiera");
            }

            System.out.printf("%-12s%-20s%-20s%-20s%-20s%n", "Venta", sale.getOperCode(), sale.getEmpCode(), strDate, strTotal);
        }
    }
    //private void 

    private void printRecords(Client client) {
        Iterator<Record> it = client.getOperations().iterator();

        while (it.hasNext()) {

            Record record = (Record) it.next();

            switch (record.getRecordType()) {

                case "S":
                    printSaleRecords((Sale) record);
                    break;
                case "R":
                    printRepairRecords((Repair) record);
                    break;
                case "F":
                    printFinanceRecords((Finance) record);
                    break;
            }

        }

    }

    void listClients() {

        list();
        TextInterface.pressKey();

    }

}
