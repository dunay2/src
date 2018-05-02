package Person.Employee;

import Person.Person;

public class Employee extends Person {


    private int rol;
  
//Cla
    public Employee(String dni) {
        super(dni);
    }
        public Employee(String dni, String firstName, String lastName, String address, String phone, int rol ) {
        super(dni, firstName, lastName ,  address,  phone);
        this.rol=rol;
        
  
        
    }
    public void pagarNomina() {
    }
}
