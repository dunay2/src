package Person.Employee;

import Person.Person;

/**
 *
 * @author ashh412
 */
public class Employee extends Person {

    private static final long serialVersionUID = -2873344211410398459L;
    private int rol;

//Cla

    /**
     *
     * @param dni
     */
    public Employee(String dni) {
        super(dni);
    }

    /**
     *
     * @param dni
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param rol
     */
    public Employee(String dni, String firstName, String lastName, String address, String phone, int rol) {
        super(dni, firstName, lastName, address, phone);
        this.rol = rol;

    }

    /**
     *
     */
    public void pagarNomina() {
    }
}
