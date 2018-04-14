package Deparment;
import Person.Person;
import Person.Employee.Employee;
import java.util.ArrayList;

public abstract class Department {

    private String extension;

    public ArrayList <Employee> personal= new ArrayList <> ();
    
    //Propósito: Agregar el empleado a la plantilla
    public void addStaff(Employee person) {
      
        personal.add(person);
        
    }

    public void removeStaff() {
    }

    public String getExtension() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String setExtension(String extension) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
