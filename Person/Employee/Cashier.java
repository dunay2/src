package Person.Employee;


import Invoice.Invoice;
import Person.Client.Client;

public class Cashier extends Employee {

    public Cashier(String dni) {
        super(dni);
    }

    public String sell(Client client, String paymentMethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stablishNegotiator() {
    }

    public Invoice createInvoice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void generateFinanceTicket() {
    }
}
