package Person.Employee;

public class Salesman extends Personal {

    public Salesman(String dni) {
        super(dni);
    }

    public void sale() {
    }

    public boolean doReturn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
