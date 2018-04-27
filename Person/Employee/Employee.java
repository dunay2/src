package Person.Employee;

import Person.Person;

public class Employee extends Person {

    private String uniformColor;
    private String userName;
    private String userPassword;

    public Employee(String dni) {
        super(dni);
    }
        public Employee(String dni, String firstName, String lastName, String address, String phone ) {
        super(dni, firstName, lastName ,  address,  phone);
    }
    public void pagarNomina() {
    }
}
