package Person.Employee;

/**
 *
 * @author ashh412
 */
public class Salesman extends Employee {
   private static final long serialVersionUID = -2873344211410398459L;

    /**
     *
     * @param dni
     */
    public Salesman(String dni) {
        super(dni);
    }

    /**
     *
     */
    public void sale() {
    }

    /**
     *
     * @return
     */
    public boolean doReturn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
