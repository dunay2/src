package Person.Client;

import Person.Person;
import Utils.ShoppingCart;

public class Client extends Person {

    private static final long serialVersionUID = -2873344211410398459L;

    private ClientHistory history;
    private ShoppingCart shoppingCart;

    private boolean finance;

    private String financeticket;

    public Client(String dni, String firstName, String lastName, Double salary) {
        super(dni, firstName, lastName, salary);
    }

    //Contructor básico
    public Client(String dni) {
        super(dni);
    }
//
//    public Client(String dni, String firstName, String lastName, Double salary) {
//        super(dni);
//
//    }
//    private final String dni;
//    private String firstName;
//    private String lastName;
//    private String age;
//    private String address;
//    private String Company;
//    private String City;
//    private String County;
//    private String State_Province;
//    private String PostalCode;
//    private String Phone;
//    private String mobil;
//    private String Email;
//    private String Web;
//    private Double salary;
//    private boolean active;

//    
//         String str = "ID: " + person.getDni();
//        str = str + "Last name: " + person.getLastName();
//        str = str + "Name: " + person.getFirstName();
//        str = str + "Nomina: " + person.getSalary();
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
