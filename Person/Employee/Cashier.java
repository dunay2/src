package Person.Employee;


import Invoice.Invoice;
import Person.Client.Client;

/**
 *
 * @author ashh412
 */
public class Cashier extends Employee {
    private static final long serialVersionUID = -2873344211410398459L;
    /**
     *
     * @param dni
     */
    public Cashier(String dni) {
        
        super(dni);
    }

    /**
     *
     * @param client
     * @param paymentMethod
     * @return
     */
    public String sell(Client client, String paymentMethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     *
     * @return
     */
    public Invoice createInvoice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    public void generateFinanceTicket() {
    }
}
