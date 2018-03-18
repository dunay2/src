package Person.Employee;


import Person.Client.Client;

public class Clerk extends Personal {

    public Clerk(String dni) {
        super(dni);
    }

    public Client getHistory(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void printHistory() {
    }

    public void printInvoice() {
    }

    public String getFinanceTicket(String ticket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean aprove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
