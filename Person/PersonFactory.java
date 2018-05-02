/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Person.Employee.Cashier;
import Person.Employee.Engineer;
import Person.Employee.FAssintance;

/**
 *
 * @author ashh412
 */
public class PersonFactory {
//1. Vendedor 2. Tecnico 3. Financiero"));

    public static Person getPerson(int tipo, String dni) {

        switch (tipo) {
            case 1:

                return new Cashier  (dni);
            case 2:
                return new Engineer(dni);
            case 3:
                return new FAssintance(dni);

        }
        return null;
    }

}
