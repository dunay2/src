package Person.Employee;

import Person.Client.Client;

/**
 *
 * @author ashh412
 */
public class Clerk extends Employee {

    private static final long serialVersionUID = -2873344211410398459L;

    /**
     *
     * @param dni
     */
    public Clerk(String dni) {
        super(dni);
    }

    /**
     *
     * @param client
     * @return
     */
    public Client getHistory(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    public void printHistory() {
    }

}
