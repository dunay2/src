/*
   //Propósito: Clase gestora de la aplicación
 */
package Managers;

import Person.Employee.Cashier;
import Person.Employee.Clerk;
import Person.Employee.Employee;
import Samples.AddTestItems;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;

/**
 *
 * @author ashh412 Propósito: Clase gestora principal de la aplicación .
 */
public class MainManager {

    //   private Shoppingcart shoppingcart;
    private final TextInterface myTextInterface;
    // private Client client;
    private final ClientManager clientManager;
    private EmployeeManager employeeManager;
    private final StockManager stockManager;
    private final SaleManager saleManager;
    private Employee activeEmployee; //Usuario que está gestionando la aplicación
    String role = "";//Rol del usurio

    private int numAccess = 0; //Valor que controla los intentos de login actuales
    private static final int MAXACCESS = 3; //Valor que controla los intentos máximos de login

    // Cashier cashier = new Cashier("CAJERO1_CODE");
    private boolean getUserAuth() {

        if (numAccess++ == MAXACCESS) {
            return false;
        }

        //Se pide un dato al usuario
        MenuNode node = new MenuNode(null, 0, "auth", "Por favor introduzca codigo de usuario para autenticarse. Si es la primera vez que ejecuta la aplicación pulse return", null);
        node.addNode(node);

//agregar un  nodo hijo de respuesta
        node.isInput(true);
        //Cargamos los empleados
        this.employeeManager = EmployeeManager.getInstance();
        employeeManager.load();
        StringBuilder outString = new StringBuilder();

//Se pide un dato al usuario. Buscamos el empleado
        activeEmployee = (Employee) employeeManager.search(node, outString);

        //Es la primera vez. Creamos un usuario admin
        if (employeeManager.getAll().isEmpty()) {
            activeEmployee = new Clerk("admin");
            activeEmployee.setFirstName("admin");

            employeeManager.add(activeEmployee);
            System.out.println("Creado usuario administrador. Acceso a RRHH NIF: admin");
            employeeManager.save();

        } else {//No hemos encontrado el usuario. Volvemos a pedir datos
            if (activeEmployee == null) {
                System.out.println("Usuario no encontrado");
               return getUserAuth();
            }
        }

        if (activeEmployee == null) {
            return false;
        }

        role = activeEmployee.getClass().getSimpleName();
System.out.println("Bienvenido "  .concat(activeEmployee.getFirstName() ) );
System.out.println("Su role es "  .concat(role ) );
        return true;
    }

    /**
     *
     */
    public MainManager() {

    
        
        if (!getUserAuth()) {
            System.out.println("Usuario no autenticado. Saliendo de la aplicación");
            System.exit(0);
        }

        //Creamos un nodo para la autenticación
        System.out.println("Electronic & CO");

        myTextInterface = new TextInterface();

        //Obtenemos una instancia a los gestores
        this.clientManager = ClientManager.getInstance();

        this.stockManager = StockManager.getInstance();
        this.saleManager = SaleManager.getInstance(clientManager, stockManager);

        if (role.equals("Cashier")) {
            saleManager.setCashier((Cashier) activeEmployee);
        }
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

//Propósito: Comprobar que se tiene permiso para acceder a los menús
    private boolean checkRole(int value) {

        System.out.println(role);
        String sNumero = String.valueOf(value);

        int offset = Double.valueOf(Math.pow(10, sNumero.length() - 1)).intValue();
        int fnum = value / offset;

        return fnum == 1 && role.equals("Cashier")//Ventas

                //gestion de clientes
                || fnum == 2 && role.equals("Clerk")
                || fnum == 2 && role.equals("FAssintance")
                || fnum == 2 && role.equals("Engineer")
                //almacen
                || fnum == 3 && role.equals("BackOfTheHouse")
                //gestion empleados
                || fnum == 4 && role.equals("Clerk")
                //reparaciones
                || fnum == 5 && role.equals("Engineer")
                //Gestion de créditos
                || fnum == 6 && role.equals("FAssintance");

//        return true;
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
        if (enode.getValue() == 7) {
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
