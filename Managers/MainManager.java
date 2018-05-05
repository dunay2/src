/*
   //Propósito: Clase gestora de la aplicación
 */
package Managers;

import Person.Employee.Cashier;
import Person.Employee.Clerk;
import Person.Employee.Employee;
import Person.Employee.Engineer;
import Person.Employee.FAssintance;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import java.io.IOException;

/**
 *
 * @author ashh412 Propósito: Clase gestora principal de la aplicación .
 */
public class MainManager {

    //   private Shoppingcart shoppingcart;
    private final TextInterface myTextInterface;
    // private Client client;
    private ClientManager clientManager;
    private EmployeeManager employeeManager;
    private StockManager stockManager;
    private SaleManager saleManager = null;
    private Employee activeEmployee; //Usuario que está gestionando la aplicación

    Cashier cashier = new Cashier("CAJERO1_CODE");

    public MainManager() {

        myTextInterface = new TextInterface();

    }

    //Propósito: main method
    public void start() throws IOException {

        //Creamos un nodo para la autenticación
        System.out.println("Electronic & CO");//Se pide un dato al usuario
        MenuNode node = new MenuNode(null, 0, "auth", "Por favor introduzca codigo de usuario para autenticarse", null);

        node.addNode(node);

//agregar un  nodo hijo de respuesta
        node.isInput(true);
        //Cargamos los empleados
        this.employeeManager = EmployeeManager.getInstance();
        employeeManager.load();
        StringBuilder outString = new StringBuilder();

//Se pide un dato al usuario
        activeEmployee = (Employee) employeeManager.search(node, outString);

        if (employeeManager.getAll().isEmpty()) {
            Clerk clerk = new Clerk("1");
            employeeManager.add(clerk);
            System.out.println("Creado usuario administrador. Acceso a RRHH NIF:1");
        }
//comprobamos qué gestor cargamos
        //Obtenemos una instancia a los gestores
        {
            this.clientManager = ClientManager.getInstance();
        }

        this.stockManager = StockManager.getInstance();

        this.saleManager = SaleManager.getInstance(cashier, clientManager, stockManager);
        clientManager.setSaleManager(this.saleManager);

//   cashier.setFirstName("Juan el cajero 1");
        //inicializar gestores
        //Instanciamos para crear un par de cajeros
        //Creamos unos cajeros
        //Cramos una nueva tienda
        //  Shop myShop = new ElectronicShop();
        // myShop.setName("Empresa1");
//        //Creamos departamentos
//        Department support = new Support();
//        Department cajeros = new FrontDesk();
//        Department finance = new Finance();
//
//        //Agregamos un departamento a la tienda
//        myShop.addDepartment(cajeros);
//        myShop.addDepartment(support);
//        myShop.addDepartment(finance);
//        //Agregamos al cajero 
//        cajeros.addStaff(cashier);
        //Cargamos los datos en memoria dependiendo del usuario
        clientManager.load();
        stockManager.load();
        saleManager.load();

        //  this.saleManager = new SaleManager(cashier, clientManager, stockManager);
        doBusiness(myTextInterface.printMenu(null));

    }
//
//    private static Employee userAuth() throws IOException {
//
////Creamos un lector
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Employee emp = new Employee(br.readLine());
//
//        System.out.println("Electronic & CO");//Se pide un dato al usuario
//
//        System.out.println("Por favor introduzca codigo de usuario para autenticarse");//Se pide un dato al usuario
//
//        System.out.println();
//  System.exit(0);
//  return emp;
//    }
//Propósito: Comprobar que se tiene permiso para acceder a los menús

    private boolean checkRole(int value) {
        String role = activeEmployee.getClass().getSimpleName();
        System.out.println(role);
        String sNumero = String.valueOf(value);

        int offset = Double.valueOf(Math.pow(10, sNumero.length() - 1)).intValue();
        int fnum = value / offset;

//        return fnum == 1 && role.equals("Cashier")//Ventas
//                || fnum == 1 && role.equals("Clerk")
//                //gestion de clientes
//                || fnum == 2 && role.equals("Clerk")
//                || fnum == 2 && role.equals("Clerk")
//                || fnum == 2 && role.equals("FAssintance")
//                || fnum == 2 && role.equals("Engineer")
//                || fnum == 3 && role.equals("BackOfTheHouse")
//                || fnum == 4 && role.equals("Clerk")
//                || fnum == 5 && role.equals("Engineer")
//                || fnum == 4 && role.equals("Engineer");
        return true;
    }
///////////!!!!!!!!!!!!!!!!!!si no hay usuarios crear administrador!!!!!!!!!!!!!!!!1

    //Propósito: Hacer de listener y handler de las peticiones
    private void doBusiness(MenuNode enode) {
        boolean startNewSequence = false;

//Utilizamos esta técnica mediante la que pasamos un array 
//a los gestores para pasar por referencia el objeto nodo y 
//de esta forma poder antender sus peticiones 
        MenuNode[] node = {enode};
        System.out.println("entrada menu" + enode.getValue());
        if (enode.getValue() == 6) {
            System.out.println("Gracias por usar la aplicación");
            System.exit(0);

        }

        if (saleManager.handleProcess(node)) {
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

        TextInterface.clearScreen();
        //Imprimimos el menú del nodo seleccionado y mandamos a consola,
        //la cual nos devolverá el valor del nuevo nodo seleccionado
        //cargamos nuevo menú o menú principal
        MenuNode newNode;

        if (!startNewSequence
                == true && checkRole(enode.getValue())) {//Imprime los hijos de nodo
            newNode = myTextInterface.printMenu(node[0]);
        } else {//Imprime los hijos del padre
            newNode = myTextInterface.printMenu(node[0].getParent());
        }

        doBusiness(newNode);
    }
}
