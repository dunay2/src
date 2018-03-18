/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Generator.PersonGenerator;
import Person.Client.Client;
import Person.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412 Propósito: gestor de operaciones de clientes
 */
public class ClientManager extends PersonManager {

  

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
    public void loadClients() {

        System.out.println("===============Carga de clientes");

        HashMap<String, Person> hm;
        hm = load("Client");

    }
//Propósito: gestionar las peticiones del controlador principal

    @Override
    public boolean handleProcess(int e) {

        Scanner scanner = new Scanner(System.in);
        String a = "";

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
                list();
                a = scanner.nextLine();
                return true;
            //Crear cliente aleatorio
            case 25:
                createRandomClient();
                a = scanner.nextLine();
                return true;
        }
        return false;
    }
//Propósito: Listar los clientes por consola

    @Override
    public void list() {

        HashMap<String, Person> persons = new HashMap<>();
        Person person;

        persons = getAll();

        Iterator<Map.Entry<String, Person>> it = persons.entrySet().iterator();

        System.out.println("================Listado de Clientes============");

        while (it.hasNext()) {
            Map.Entry<String, Person> e = it.next();

            person = e.getValue();

            System.out.println("Dni: " + person.getDni());
            System.out.println("Name: " + person.getFirstName());
            System.out.println("Address: " + person.getAddress());

        }
        System.out.println("Pulsa una tecla para continuar ...");
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
        Client client = generateRandomClient();
        //Guardamos el cliente en la coleccion
        add(client);
        //Guardar los datos 
        save();
        System.out.println("Cliente generado: " + client.getDni() + " " + client.getfirstName());
        System.out.println("Pulse una tecla para continuar");
    }

}
