package Person.Client;

import Person.Person;

public class Client extends Person {

    private static final long serialVersionUID = -2873344211410398459L;

//    private ClientHistory history;
//    private ShoppingCart shoppingCart;
//
//    private boolean finance;
//
//    private String financeticket;

    public Client(String dni, String firstName, String lastName ,String address, String phone) {
        super(dni, firstName, lastName, address, phone );
    }

    //Contructor básico
    public Client(String dni) {
        super(dni);
    }

}
