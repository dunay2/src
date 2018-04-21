/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Employee.Employee;
import Person.Person;
import Utils.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412
 */
public class EmployeeManager extends PersonManager {

    @Override
    public Employee generateRandomPerson() {

        Employee employee;
        employee = (Employee) super.generateRandomPerson();
        add(employee);

        //Guardamos el empleado en la coleccion 
        save();
        System.out.println("Empleado generado: " + employee.getDni() + " " + employee.getfirstName());
        return employee;

        //  String a = scanner.nextLine();
    }

////Propósito: crear un nuevo employee con los datos de entrada de consola
    @Override
    public Employee createObject(Node node) throws IOException {

        ArrayList<String> nodesData = node.convertTreeChildToList();
        int i = 0;

        Employee employee = new Employee(nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), Double.parseDouble(nodesData.get(i++)));

//Guardamos el employee en la coleccion
        add(employee);
        save();

        return employee;
    }

    @Override
    public boolean handleProcess(Node node) {
        switch (node.getValue()) {

            case 41: {
                try {
                    createObject(node);
                } catch (IOException ex) {
                    Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
            case 42: //Actualizar
                update(node);
                return true;
            case 43: //Eliminar
                return true;
            //Listar clientes 
            case 44:
                listEmployees();
                return true;
            //Crear cliente aleatorio
            case 45:
                generateRandomPerson();
                return true;
            case 46://buscar
                StringBuilder outString=null;
                search(node,outString);
            case 47://menu superior
                return true;
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
