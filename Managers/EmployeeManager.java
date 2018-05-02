/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Employee.Employee;
import Person.Person;
import Utils.Menu.MenuNode;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ashh412
 */
public class EmployeeManager extends PersonManager {

    private static EmployeeManager instance = null;    //Singleton Singleton Pattern

    //Singleton Singleton Pattern
    protected EmployeeManager() {

    }
    //Singleton Singleton Pattern

    public static EmployeeManager getInstance() {
        if (instance == null) {
            instance = new EmployeeManager();
        }
        return instance;
    }

    @Override
    public Employee generateRandomPerson() {

        Employee employee;
        employee = (Employee) super.generateRandomPerson();
        add(employee);

        //Guardamos el empleado en la coleccion 
        save();
        System.out.println("Empleado generado: " + employee.getDni() + " " + employee.getFirstName());
        return employee;

        //  String a = scanner.nextLine();
    }

////Propósito: crear un nuevo employee con los datos de entrada de consola
    /**
     *
     * @param enode
     * @param node
     * @return
     * @throws IOException
     */
//    @Override
//    public Employee createObject(MenuNode[] node) {
//
//        MenuNode enode = node[0];
//        ArrayList<String> nodesData = enode.convertTreeChildToList();
//        int i = 0;
//
//        Employee employee = new Employee(nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), nodesData.get(i++));
//
////Guardamos el employee en la coleccion
//        add(employee);
//        save();
//
//        return employee;
//    }
    @Override
    public boolean handleProcess(MenuNode[] enode) {

        MenuNode node = enode[0];

        switch (node.getValue()) {

            case 41: {

                createObject(enode);

                return true;
            }
            case 42: //Actualizar
                update(node);
                return true;

            case 43: //Eliminar
                delete(node);
                return true;
            //Listar clientes 
            case 44:
                listEmployees();
                return true;
           
            case 45://buscar

                StringBuilder outString = new StringBuilder();
                Person employee = (Employee) search(node, outString);
                //printRecord(client);
                return true;

            case 46://menu superior
                return false;
        }
        return false;
    }

    void listEmployees() {

        Scanner scanner = new Scanner(System.in);

        list();
        pressKey();

    }

    private void pressKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulsa una tecla para continuar ...");
        String a = scanner.nextLine();
    }

    @Override
    public void print(Person e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
