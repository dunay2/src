package Deparment;
import Person.Person;
import Person.Employee.Personal;
import java.util.ArrayList;

public abstract class Department {

    private String extension;

    public ArrayList <Personal> personal= new ArrayList <> ();
    
    
    public void addStaff(Personal person) {
      
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
