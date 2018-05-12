/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Person.Employee.BackOfTheHouse;
import Person.Employee.Cashier;
import Person.Employee.Clerk;
import Person.Employee.Engineer;
import Person.Employee.FAssintance;

/**
 *
 * @author ashh412
 */
public class PersonFactory {

    public static Person getPerson(int tipo, String dni) {

        switch (tipo) {
            case 1:
                return new Cashier(dni);
            case 2:
                return new Clerk(dni);

            case 3:
                return new BackOfTheHouse(dni);

            case 4:
                return new Clerk(dni);
            case 5:

                return new Engineer(dni);
            case 6:
                return new FAssintance(dni);
        }
        return null;
    }

}
