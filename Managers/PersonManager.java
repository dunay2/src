/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import java.util.HashMap;
import DataBase.TextDatabase;
import Generator.PersonGenerator;
import Person.Client.Client;
import Person.Person;
import ScreenInterfaces.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ashh412 Propósito: hacer de gestor genérico de la clase Person
 * Extiende la clase TextDatabase lo que le da persistencia
 *
 */
public abstract class PersonManager extends TextDatabase implements Imanager {

    private HashMap<String, Person> persons = new HashMap<>();

    //Extension de database
    //Guardamos
    public void save() {
        save(persons);
    }

    @Override
    public abstract boolean handleProcess(Node node);
//el nombre de los managers debe ser NombreClaseManager
//para que essta clase los guarde correctamente
//Cargar la base de datos de personas

    public void load() {
        persons = load(getClassName().replace("Manager", ""));//Pasamos el nombre del fichero   
    }

    @Override
    public HashMap<String, Person> load(String filename) {
        persons = super.load(filename);
        return persons;//Pasamos el nombre del fichero
    }

//Devuelve todo el listado de personas
    @Override
    public HashMap<String, Person> getAll() {
        return persons;
    }

    //Propósito: crear un nuevo cliente con los datos de entrada de consola
    @Override
    public Object createObject(Node node) throws IOException {

        Person person;

//Creamos un lector
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//Creamos una persona
        System.out.println("Por favor introduzca DNI");//Se pide un dato al usuario
        person = new Client(br.readLine());

        System.out.println("Introduzca nombre");//Se pide un dato al usuario
        person.setfirstName(br.readLine());

        System.out.println("Introduzca apellido");//Se pide un dato al usuario
        person.setLastName(br.readLine());

        System.out.println("Introduzca nómina");//Se pide un dato al usuario
        person.setNomina(Double.parseDouble(br.readLine()));

        return person;

    }

    @Override
    public Person get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //necesitamos el codigo del elemento, 

    public void delete(Object person) {
        Person lperson;
        lperson = (Person) person;
        persons.remove(lperson);

    }

    @Override
    public boolean add(Object pperson) {
        Person person = (Person) pperson;

        if (persons.containsKey(person.getDni())) {
            System.out.println("No se puede introducir la persona. El código esta repetido.");
            return false;
        }

        try {
            //Agregamos una persona al hasmap
            persons.put(person.getDni(), person);
            return true;

        } catch (Exception e) {
            System.out.println("No se puede introducir la persona. Ha habido un error.");
            return false;
        }

    }

    public Person generateRandomPerson() {

        Person person;

        person = new Client(PersonGenerator.generateDni());

        person.setFirstName(PersonGenerator.generateName());

        return person;
    }

    //Propósito: 
    //Buscar la clave en el HashMapy devolver el objeto person si existe
    @Override
    public Object search(String e) {
        if (persons.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return persons.get(e);
        }
        return null;
    }

    //Propósito: Listar las personas por consola
    @Override
    public void list() {
        Person person;

        Iterator<Map.Entry<String, Person>> it = persons.entrySet().iterator();
        System.out.println("DNI*************NAME****************************************ADDRESS********");

        while (it.hasNext()) {
            Map.Entry<String, Person> e = it.next();

            person = e.getValue();

            System.out.println(person.getDni() + "    " + person.getFirstName() + "                           " + person.getAddress());

        }
        clearScreen();
    }
//  /*
//
//        /* Display content using Iterator*/
//        Set set = hmap.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry) iterator.next();
//            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
//            System.out.println(mentry.getValue());
//        }
//
//        /* Get values based on key*/
//        String var = hmap.get(2);
//        System.out.println("Value at index 2 is: " + var);
//
//        /* Remove values based on key*/
//        hmap.remove(3);
//        System.out.println("Map key and values after removal:");
//        Set set2 = hmap.entrySet();
//        Iterator iterator2 = set2.iterator();
//        while (iterator2.hasNext()) {
//            Map.Entry mentry2 = (Map.Entry) iterator2.next();
//            System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
//            System.out.println(mentry2.getValue());
//        }
    // }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
