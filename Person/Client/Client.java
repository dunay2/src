package Person.Client;

import Person.Person;
import ishop.Shoppingcart;

public class Client extends Person {
    private static final long serialVersionUID = -2873344211410398459L;
    
    private ClientHistory history;
    private Shoppingcart shoppingCart;
    
    private boolean finance;

    private String financeticket;

    public Client(String dni) {
        super(dni);
    }

 

    public ClientHistory getHistory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buy() {
    }

    public void devolution() {
    }

    public void hasFinance() {
    }

    public String getFinanceTicket(String tiket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void dropfinanceTicket() {
    }

    public boolean hasFinanceTicket() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
