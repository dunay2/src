/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import java.util.HashMap;
import DataBase.TextDatabase;
import Person.Person;

/**
 *
 * @author ashh412 Propósito: hacer de gestor genérico de la clase Person
 * Extiende la clase TextDatabase lo que le da persistencia
 *
 */
public abstract class PersonManager extends TextDatabase implements Imanager {

    private final HashMap<String, Person> persons = new HashMap<>();

    //Extension de database
    //Guardamos
    public void save() {
        save(persons);
    }

    @Override
    public abstract boolean handleProcess(int e);

//Cargar la base de datos de personas
    public HashMap<String, Person> load() {
        return load("Person");//Pasamos el nombre del fichero
    }

    @Override
    public HashMap<String, Person> load(String filename) {
        return super.load(filename);//Pasamos el nombre del fichero
    }

//Devuelve todo el listado de personas
    @Override
    public HashMap<String, Person> getAll() {
        return persons;
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
    //por tanto esto será string
    public void delete(Object person) {
        Person lperson;
        lperson = (Person) person;
        persons.remove(lperson);
        System.out.println("Student: Roll No " + lperson.getfirstName() + ", deleted from database");

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

    /*        public static void guardarProducto(String codigo, float precio, HashMap<String, Float> listaProductos) {
        if (listaProductos.containsKey(codigo)) {
            System.out.println("No se puede introducir el producto. El código esta repetido.");
        } else {
            listaProductos.put(codigo, precio);
        }
    }*/
    //Porpósito: 
    //Buscar la clave en el HashMapy devolver el objeto person si existe
    @Override
    public Object search(String e) {
        if (persons.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return persons.get(e);
        }
        return null;
    }

//  /*
//            
//        /* This is how to declare HashMap */
//        HashMap<String, Node> hmap = new HashMap<>();
//
//        /*Adding elements to HashMap*/
//        hmap.put(12, "Chaitanya");
//        hmap.put(2, "Rahul");
//        hmap.put(7, "Singh");
//        hmap.put(49, "Ajeet");
//        hmap.put(3, "Anuj");
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
}
