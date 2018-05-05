package Shop.Deparment;
import Person.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public abstract class Department {

//    private String extension;

    /**
     *
     */

    public ArrayList <Employee> personal= new ArrayList <> ();
    


    /**Propósito: Agregar el empleado a la plantilla
     *
     * @param person
     */
    public void addStaff(Employee person) {
      
        personal.add(person);
        
    }

    /**
     *
     */
    public void removeStaff() {
    }

    /**
     *
     * @return
     */
    public String getExtension() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param extension
     * @return
     */
    public String setExtension(String extension) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
