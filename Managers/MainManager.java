/*
   //Propósito: Clase gestora de la aplicación
 */
package Managers;

import Deparment.Department;
import Deparment.Finance;
import Deparment.FrontDesk;
import Deparment.Support;
import Person.Employee.Cashier;
import Person.Employee.Employee;
import ScreenInterfaces.Node;
import ScreenInterfaces.TextInterface;
import ishop.ElectronicShop;
import ishop.Shop;

/**
 *
 * @author ashh412 Propósito: Clase gestora principal de la aplicación .
 */
public class MainManager {

    //   private Shoppingcart shoppingcart;
    private final TextInterface myTextInterface;
    // private Client client;
    private final ClientManager clientManager;
    private final EmployeeManager employeeManager;
    private final StockManager stockManager;
    private SalesManager salesManager = null;
    private Employee activeEmployee; //Usuario que está gestionando la aplicación

    //Constructor
    public MainManager() {
        //Obtenemos una instancia a los gestores
        this.clientManager = new ClientManager();
        this.stockManager = new StockManager();
        this.employeeManager = new EmployeeManager();

        myTextInterface = new TextInterface();

        //inicializar gestores
    }

    //Propósito: main method
    public void start() {

        //Instanciamos para crear un par de cajeros
        Cashier cashier = new Cashier("CAJERO1_CODE");

        //Creamos unos cajeros
        cashier.setfirstName("Juan el cajero 1");

        //Cramos una nueva tienda
        Shop myShop = new ElectronicShop();
        myShop.setName("Empresa1");

        //Creamos departamentos
        Department support = new Support();
        Department cajeros = new FrontDesk();
        Department finance = new Finance();

        //Agregamos un departamento a la tienda
        myShop.addDepartment(cajeros);
        myShop.addDepartment(support);
        myShop.addDepartment(finance);

        //Agregamos al cajero 
        cajeros.addStaff(cashier);

        clientManager.load();
        stockManager.load();

        this.salesManager = new SalesManager(null, cashier);
   
        doBusiness(myTextInterface.printMenu(null));

    }

    //Propósito: Hacer de listener y handler de las peticiones
    private void doBusiness(Node node) {
        boolean startNewSequence = false;

        if (salesManager.handleProcess(node)) {
            startNewSequence = true;
        }
        if (clientManager.handleProcess(node)) {
            startNewSequence = true;
        }
        if (stockManager.handleProcess(node)) {
            startNewSequence = true;
        }
        if (employeeManager.handleProcess(node)) {
            startNewSequence = true;
        }

        myTextInterface.clearScreen();
        //Imprimimos el menú del nodo seleccionado y mandamos a consola,
        //la cual nos devolverá el valor del nuevo nodo seleccionado
        //cargamos nuevo menú o menú principal
        Node newNode = null;
        if (!startNewSequence
                == true) {
            newNode = myTextInterface.printMenu(node);
        } else {
            newNode = myTextInterface.printMenu(node.getParent());
        }

        doBusiness(newNode);
    }
}
