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
import Utils.Record.Sale;
import java.util.Iterator;

/**
 *
 * @author ashh412 Propósito: gestor de operaciones de clientes
 *///
public class ClientManager extends PersonManager {

    private static ClientManager instance = null;    //Singleton Singleton Pattern
    SaleManager saleManager;

    public SaleManager getSaleManager() {
        return saleManager;
    }

    public void setSaleManager(SaleManager saleManager) {
        this.saleManager = saleManager;
    }

    //Singleton Singleton Pattern
    protected ClientManager() {

    }
    //Singleton Singleton Pattern

    public static ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager();
        }
        return instance;
    }

    //Propósito: crear un cliente aleatorio
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

    private void delete(MenuNode node) {

        StringBuilder outString = new StringBuilder();
        Client client = (Client) search(node, outString);
        if (client == null) {
            System.out.println("El cliente no existe");
            TextInterface.pressKey();

        } else {
            client.setActive(false);
            System.out.println("Cliente desactivado. Pulse una tecla para continuar");
            TextInterface.pressKey();
        }
    }

    private void printRecord(Client client) {
        if (client == null) {
            System.out.println("el cliente no existe");
            TextInterface.pressKey();
            return;
        }

        print(client);

        Iterator<String> it = client.getOperations().iterator();
        System.out.println("Facturas de cliente");

        System.out.printf("%-20s%-20s%-20s%-20s\n", "Código", "Atentido por", "Fecha", "TOTAL");

        while (it.hasNext()) {
            Sale sale = saleManager.getSale((String) it.next());

            System.out.printf("%-20s%-20s%-20s%-20s\n", sale.getOperCode(), sale.getEmpCode(), sale.getDate(), String.valueOf(sale.getTotal()));

        }

        TextInterface.pressKey();
    }

////Propósito: crear un nuevo cliente con los datos de entrada de consola
//    @Override
//    public Client createObject(MenuNode[] enode) {
//        String key;
//        MenuNode node = enode[0];
//        ArrayList<String> nodesData;
//        MenuNode nodeAux = node.getChildNodes().get(0);//comprobacion de respuesta
//        int i = 0;
////creacion estandar
////No hay datos en los nodos hijos
//        if (nodeAux.getResponseValue() == null) {
//            StringBuilder outString = new StringBuilder();
//            Client client = (Client) search(node, outString);
//            if (client == null) {
//                key = outString.toString();
//            } else {
//                node.getChildNodes().get(0).clearResponse();
//                System.out.println("El registro ya existe");
//                TextInterface.pressKey();
//                return null;
//            }
//
//        } else {//Creación por búsqueda, ya hemos obtenido el dni
//
//            key = nodeAux.getResponseValue();
//        }
//        nodesData = node.convertTreeChildToListIdx();
//        node.getChildNodes().get(0).clearResponse();
//        
//        Client client = new Client(key, nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), nodesData.get(i++));
//
////Guardamos el cliente en la coleccion
//        add(client);
//        //Guardar los datos 
//        save();
//
//        return client;
//    }
//Propósito: Crear un cliente aleatorio
//    private void createRandomClient() {
//    
//    }
//    @Override
//    public PersonOperation generateRandomPerson() {
//        Scanner scanner = new Scanner(System.in);
//        PersonOperation client = (PersonOperation) super.generateRandomPerson();// generateRandomClient();
//        //Guardamos el cliente en la coleccion
//        add(client);
//        //Guardar los datos 
//        save();
//        System.out.println("Cliente generado: " + client.getDni() + " " + client.getfirstName());
//        System.out.println("Pulse una tecla para continuar");
//        String a = scanner.nextLine();
//        return client;
//
//    }
    void listClients() {

        list();
        TextInterface.pressKey();

    }

}
