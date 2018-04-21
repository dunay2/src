/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Utils.Node;
import java.util.HashMap;
import DataBase.TextDatabase;
import Utils.Generator.PersonGenerator;
import Person.Client.Client;
import Person.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ashh412 Propósito: hacer de gestor genérico de la clase Person
 * Extiende la clase TextDatabase lo que le da persistencia
 *
 */
//public class SingletonInstantiator { 
//  public SingletonInstantiator() { 
//   ClassicSingleton instance = ClassicSingleton.getInstance();
//ClassicSingleton anotherInstance =
//new ClassicSingleton();
//       ... 
//  } 
//}
public abstract class PersonManager extends TextDatabase implements Imanager<Person, Node> {

    private HashMap<String, Person> persons = new HashMap<>();

    //Extension de database
    //Guardamos
    public void save() {
        save(persons);
    }

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

    @Override //necesitamos el codigo del elemento, 
//debe ser un string
    public void delete(Person person) {

        persons.remove(person.getDni());

    }

    @Override
    public boolean add(Person person) {

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
        person.setSalary(1000D);
        return person;
    }

    //Propósito: 
    //Buscar la clave en el HashMapy devolver el objeto person si existe
    @Override
    public Person search(Node node, StringBuilder outString) {

        outString.append(node.getChildNodes().get(0).getResponse());
        Person person = searchPerson(outString.toString());
        if (person != null) {

            return person;

        }
        return null;

    }

    private Person searchPerson(String e) {

        if (persons.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return persons.get(e);
        }
        return null;

    }

    @Override
    public void update(Node node) {

        StringBuilder outString = new StringBuilder();
        Person person = search(node, outString);

        if (person != null) {
            ArrayList<String> nodesData = node.convertTreeChildToListIdx();
            int i = 0;

            person.setFirstName(nodesData.get(i++));
            person.setLastName(nodesData.get(i++));
            person.setSalary(Double.valueOf(nodesData.get(i++)));
            //Guardar los datos 
            save();

        }
    }
    //Propósito: Listar las personas por consola

    @Override
    public void print(Person person) {
        printHeader();
        listFormat(person);
    }

    private void printHeader() {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "DNI", "APELLIDOS", "NOMBRE", "NOMINA");

    }

    @Override
    public void list() {
        Person person;

        Iterator<Map.Entry<String, Person>> it = persons.entrySet().iterator();

        printHeader();
        while (it.hasNext()) {
            Map.Entry<String, Person> e = it.next();

            listFormat(e.getValue());
        }
        clearScreen();
    }

    private void listFormat(Person person) {

        System.out.printf("%-20s%-20s%-20s%-20s\n", person.getDni(), person.getLastName(), person.getFirstName(), person.getSalary());

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

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
