/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Utils.Generator.PersonGenerator;
import Person.Client.Client;
import Person.Person;
import ScreenInterfaces.TextInterface;
import Utils.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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

        client = new Client(PersonGenerator.generateDni());

        client.setFirstName(PersonGenerator.generateName());

        return client;
    }
//Propósito: modificar los datos de un cliente

//Propósito: gestionar las peticiones del controlador principal
    @Override
    public boolean handleProcess(Node node) {

        switch (node.getValue()) {

            case 21: {
                try {
                    createObject(node);
                } catch (IOException ex) {
                    Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                generateRandomPerson();
                return true;
            case 26://buscar
                StringBuilder outString=new StringBuilder();
                Client client = (Client) search(node, outString);

                print(client);
            case 27://menu superior
                return true;
        }
        return false;
    }

////Propósito: crear un nuevo cliente con los datos de entrada de consola
    @Override
    public Client createObject(Node node) throws IOException {

        ArrayList<String> nodesData = node.convertTreeChildToList();
        int i = 0;

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
    @Override
    public Client generateRandomPerson() {
        Scanner scanner = new Scanner(System.in);
        Client client = (Client) super.generateRandomPerson();// generateRandomClient();
        //Guardamos el cliente en la coleccion
        add(client);
        //Guardar los datos 
        save();
        System.out.println("Cliente generado: " + client.getDni() + " " + client.getfirstName());
        System.out.println("Pulse una tecla para continuar");
        String a = scanner.nextLine();
        return client;

    }

    void listClients() {

        list();
        TextInterface.pressKey();

    }

    

}
