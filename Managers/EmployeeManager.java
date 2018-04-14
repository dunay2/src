/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Employee.Employee;
import java.io.IOException;

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

////Propósito: crear un nuevo cliente con los datos de entrada de consola
    @Override
    public Object createObject() throws IOException {
        Employee employee;
        employee = (Employee) super.createObject();

//Guardamos el cliente en la coleccion
        add(employee);
//        //Guardar los datos 
        save();
        return employee;
    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean handleProcess(int e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;
    }

}
