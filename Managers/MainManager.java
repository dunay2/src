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
import Utils.Node;
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
    private SaleManager salesManager = null;
    private Employee activeEmployee; //Usuario que está gestionando la aplicación

    //Constructor
    public MainManager() {
        //Obtenemos una instancia a los gestores
        this.clientManager = ClientManager.getInstance();

        this.stockManager = StockManager.getInstance();
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

        this.salesManager = new SaleManager(cashier, clientManager,stockManager);

        doBusiness(myTextInterface.printMenu(null));

    }

    //Propósito: Hacer de listener y handler de las peticiones
    private void doBusiness(Node enode) {
        boolean startNewSequence = false;
//Utilizamos esta técnica mediante la que pasamos un array 
//a los gestores para pasar por referencia el objeto nodo y 
//de esta forma poder antender sus peticiones 

        Node[]node={enode};
  

        if (salesManager.handleProcess(node)) {
            startNewSequence = true;
        }
        if (clientManager.handleProcess(node) && !startNewSequence) {
            startNewSequence = true;
        }
        if (stockManager.handleProcess(node) && !startNewSequence) {
            startNewSequence = true;
        }
        if (employeeManager.handleProcess(node) && !startNewSequence) {
            startNewSequence = true;
        }

        myTextInterface.clearScreen();
        //Imprimimos el menú del nodo seleccionado y mandamos a consola,
        //la cual nos devolverá el valor del nuevo nodo seleccionado
        //cargamos nuevo menú o menú principal
        Node newNode ;
        if (!startNewSequence
                == true) {//Imprime los hijos de nodo
            newNode = myTextInterface.printMenu(node[0]);
        } else {//Imprime los hijos del padre
            newNode = myTextInterface.printMenu(node[0].getParent());
        }

        doBusiness(newNode);
    }
}
