/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;

import ScreenInterfaces.TextInterface;
import Utils.Generator.PersonGenerator;
import Utils.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412 Propósito: gestor de operaciones de clientes
 *///
public class ClientManager extends PersonManager {

    private static ClientManager instance = null;    //Singleton Singleton Pattern

    //Singleton Singleton Pattern
    protected ClientManager() {
        // Exists only to defeat instantiation.
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
        client = new Client(PersonGenerator.generateDni(), PersonGenerator.generateFirstName(), "", 1000D);
        client.setLastName(PersonGenerator.generateLastName());
        System.out.println("Cliente generado: " + client.getDni() + " " + client.getfirstName());
        add(client);
//        //Guardar los datos 
        save();
        TextInterface.pressKey();
        return client;
    }
//Propósito: modificar los datos de un cliente

//Propósito: gestionar las peticiones del controlador principal
    @Override
     public boolean handleProcess(Node[] enode) {
        Node node = enode[0];

        switch (node.getValue()) {

            case 21: {
               
                    createObject(enode);
              
                return true;
            }
            case 22: //Actualizar
                update(node);
                return true;
            case 23: //Eliminar
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

                print(client);
            case 27://menu superior
                return true;
        }
        return false;
    }

////Propósito: crear un nuevo cliente con los datos de entrada de consola
    @Override
    public Client createObject(Node []enode) {
        
        Node node=enode[0];
        String dni = "";

        ArrayList<String> nodesData = node.convertTreeChildToList();
        int i = 0;
        Node n = node.getChildNodes().get(0);
        n.getResponse();

        Client client = new Client(nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), Double.parseDouble(nodesData.get(i++)));

//Guardamos el cliente en la coleccion
        add(client);
        //Guardar los datos 
        save();

        return client;
    }

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
