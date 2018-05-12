/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Employee.Employee;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import java.util.Scanner;

/**
 *
 * @author ashh412
 */
public class EmployeeManager extends PersonManager {

    private static EmployeeManager instance = null;    //Singleton Singleton Pattern

    //Singleton Singleton Pattern

    /**
     *
     */
    protected EmployeeManager() {

    }
    //Singleton Singleton Pattern

    /**
     *
     * @return
     */
    public static EmployeeManager getInstance() {
        if (instance == null) {
            instance = new EmployeeManager();
        }
        return instance;
    }

    /**
     *
     * @return
     */
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
     * @return
    
     */

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
                Employee employee = (Employee) search(node, outString);
                printRecord(employee);
                return true;

            case 46://menu superior
                return false;
        }
        return false;
    }
   private void printRecord(Employee employee) {
        if (employee == null) {
            System.out.println("el empleado no existe");
            TextInterface.pressKey();
            return;
        }

        print(employee);
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

    
}
