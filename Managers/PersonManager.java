/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import java.util.HashMap;
import DataBase.TextDatabase;
import Person.Client.Client;
import Person.Employee.Employee;
import Utils.Generator.PersonGenerator;
import Person.Person;
import Person.PersonFactory;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ashh412 Propósito: hacer de gestor genérico de la clase Person
 * Extiende la clase TextDatabase lo que le da persistencia
 *
 */
public abstract class PersonManager extends TextDatabase implements Imanager<Person, MenuNode> {

    private HashMap<String, Person> persons = new HashMap<>();

//Extension de database
    //Guardamos

    /**
     *
     */
    public void save() {
        save(persons);
    }

//el nombre de los managers debe ser NombreClaseManager
//para que esta clase los guarde correctamente
//Cargar la base de datos de personas

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public Person generateRandomPerson() {

        Person person;

        person = new Client(PersonGenerator.generateDni());

        person.setFirstName(PersonGenerator.generateFirstName());
        person.setLastName(PersonGenerator.generateLastName());

        person.setSalary(1000D);
        return person;
    }

    //Propósito: 
    //Buscar la clave en el HashMap devolver el objeto person si existe
    @Override
    public Person search(MenuNode node, StringBuilder outString) {

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
    public void update(MenuNode node) {

        StringBuilder outString = new StringBuilder();
        Person person = search(node, outString);

        if (person != null) {
            ArrayList<String> nodesData = node.convertTreeChildToListIdx();
            int i = 0;

            person.setFirstName(nodesData.get(i++));
            person.setLastName(nodesData.get(i++));
            person.setAddress(nodesData.get(i++));
            person.setPhone(nodesData.get(i++));

            //Guardar los datos 
            save();

        } else {
            System.out.println("La persona no existe");
            TextInterface.pressKey();
        }
    }
    //Propósito: Listar las personas por consola

    @Override
    public void print(Person person) {
        printHeader();
        listFormat(person);
    }

    private void printHeader() {
        System.out.printf("%-13s%-20s%-20s%-20s%-20s%-20s%-10s%-10s%n", "ROL", "DNI", "APELLIDOS", "NOMBRE", "DIRECCION", "TELEFONO", "NOMINA", "ACTIVO");

    }

    @Override
    public void list() {

        Iterator<Map.Entry<String, Person>> it = persons.entrySet().iterator();

        printHeader();
        while (it.hasNext()) {

            listFormat(it.next().getValue());
        }
        clearScreen();
    }

    private void listFormat(Person person) {

        Object objectType = person;
//Guardamos el nombre de la clase hija
        String Rol = objectType.getClass().getSimpleName();

        System.out.printf("%-13s%-20s%-20s%-20s%-20s%-20s%-10s%-10s%n", Rol, person.getDni(), person.getLastName(), person.getFirstName(), person.getAddress(), person.getPhone(), person.getSalary(), person.isActive());

    }

    /**
     *
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person createObject(MenuNode[] enode) {
        String key;
        MenuNode node = enode[0];
        ArrayList<String> nodesData;
        MenuNode nodeAux = node.getChildNodes().get(0);//comprobacion de respuesta
        int i = 0;
        String typeOfPerson = node.getMnuName();
        typeOfPerson = typeOfPerson.replace("mnuBuying", "mnuAddClient");

        Person person = null;
//creacion estandar
//No hay datos en los nodos hijos
        if (nodeAux.getResponseValue() == null) {
            StringBuilder outString = new StringBuilder();

            if (typeOfPerson.equals("mnuAddClient")) {
                person = (Client) search(node, outString);
            }

            if (typeOfPerson.equals("mnuAddEmployee")) {
                person = (Employee) search(node, outString);
            }

            if (person == null) {
                key = outString.toString();
            } else {
                node.getChildNodes().get(0).clearResponse();
                System.out.println("El registro ya existe");
                TextInterface.pressKey();
                return null;
            }

        } else {//Creación por búsqueda, ya hemos obtenido el dni

            key = nodeAux.getResponseValue();
        }
        //Tomamos la entrada de datos para la persona que vamos a crear
        nodesData = node.convertTreeChildToListIdx();

        node.getChildNodes()
                .get(0).clearResponse();

        //Creamos un cliente
        if (typeOfPerson.equals("mnuAddClient")) {

            person = new Client(key, nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), nodesData.get(i++));
        }
        //Creamos el tipo de empleado indicado
        if (typeOfPerson.equals("mnuAddEmployee")) {

            int TypeofEmployee = Integer.parseInt(nodesData.get(nodesData.size() - 1));

            person = PersonFactory.getPerson(TypeofEmployee, key);
            person.setFirstName(nodesData.get(i++));
            person.setLastName(nodesData.get(i++));
            person.setAddress(nodesData.get(i++));
            person.setPhone(nodesData.get(i++));

        }

//Guardamos la persona en la coleccion
        add(person);
        //Guardar los datos 

        save();

        return person;
    }

    /**
     *
     * @param node
     */
    protected void delete(MenuNode node) {

        StringBuilder outString = new StringBuilder();
        Person person = search(node, outString);
        if (person == null) {
            System.out.println("La persona no existe");
            TextInterface.pressKey();

        } else {
            person.setActive(false);
            System.out.println("Persona desactivado. Pulse una tecla para continuar");
            TextInterface.pressKey();
        }
    }

}
