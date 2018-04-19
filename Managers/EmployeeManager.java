/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Employee.Employee;
import Utils.Node;
import java.io.IOException;
import java.util.ArrayList;

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
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

}
