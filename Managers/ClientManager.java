/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Generator.PersonGenerator;
import Person.Client.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412 Propósito: gestor de operaciones de clientes
 *///
public class ClientManager extends PersonManager {
//private   HashMap<String, Person> hm;
    //  private final AppInterface myInterface;
//Constructor
    //   public ClientManager(AppInterface myInterface) {
//Pasamos un "puntero" a la interfaz
    //  this.myInterface = myInterface;
    // }
    //Propósito: crear un cliente aleatorio

    public Client generateRandomClient() {

        Client client;

        client = new Client(PersonGenerator.generateDni());

        client.setFirstName(PersonGenerator.generateName());

        return client;
    }

    //Propósito: cargar el fichero de clientes
//    public void loadClients() {
//
//        System.out.println("===============Carga de clientes");
//
//
//    //    hm = load("Client");
//            load();
//
//    }
//Propósito: gestionar las peticiones del controlador principal
    @Override
    public boolean handleProcess(int e) {

        switch (e) {

            //Gestion de clientes introducción de DNI
            case 21: {
                try {
                    createObject();
                    // Este es el nod raiz    myInterface.getNode();
                } catch (IOException ex) {
                    Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
            //Listar clientes 
            case 24:
                ListClient();

                return true;
            //Crear cliente aleatorio
            case 25:
                createRandomClient();
                return true;
        }
        return false;
    }

//Propósito: crear un nuevo cliente con los datos de entrada de consola
    @Override
    public Object createObject() throws IOException {

        Client client;
//Creamos un lector
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//Creamos un cliente
        System.out.println("Por favor introduzca DNI");//Se pide un dato al usuario

        client = new Client(br.readLine());
        System.out.println("Introduzca nombre");//Se pide un dato al usuario
        client.setfirstName(br.readLine());
        System.out.println("Introduzca apellido");//Se pide un dato al usuario
        client.setLastName(br.readLine());
        System.out.println("Introduzca nómina");//Se pide un dato al usuario

        client.setNomina(Double.parseDouble(br.readLine()));

        //Guardamos el cliente en la coleccion
        add(client);
        //Guardar los datos 
        save();

        return client;
    }

//Propósito: Crear un cliente aleatorio
    private void createRandomClient() {
        Scanner scanner = new Scanner(System.in);
        Client client = generateRandomClient();
        //Guardamos el cliente en la coleccion
        add(client);
        //Guardar los datos 
        save();
        System.out.println("Cliente generado: " + client.getDni() + " " + client.getfirstName());
        System.out.println("Pulse una tecla para continuar");
        String a = scanner.nextLine();
    }

    void ListClient() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================Listado de Clientes============");

        list();
        System.out.println("Pulsa una tecla para continuar ...");
        String a = scanner.nextLine();

    }

}
