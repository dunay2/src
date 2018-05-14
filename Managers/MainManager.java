/*
   //Propósito: Clase gestora de la aplicación
 */
package Managers;

import Person.Employee.Clerk;
import Person.Employee.Employee;
import Person.Employee.SalesMan;
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
    private EmployeeManager employeeManager; //Multipropósito autenticación/gestión
    private final StockManager stockManager;
    private final SaleManager saleManager;
    private final RepairManager repairManager;
    private final FinanceManager financeManager;
    private final OfferManager offerManager;

    private Employee activeEmployee; //Usuario que está gestionando la aplicación
    String role = "";//Rol del usurio

    private int numAccess = 0; //Valor que controla los intentos de login actuales
    private static final int MAXACCESS = 3; //Valor que controla los intentos máximos de login

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
            //  saleManager.setCashier((Cashier) activeEmployee);
            saleManager.setEmployee(activeEmployee);
        }
        this.clientManager.setSaleManager(this.saleManager);

        this.repairManager = RepairManager.getInstance(clientManager, saleManager);

        this.clientManager.setRepairManager(this.repairManager);

        if (role.equals("Engineer")) {
            this.repairManager.setEmployee(activeEmployee);
        }

        this.financeManager = FinanceManager.getInstance(clientManager, saleManager, stockManager);
        if (role.equals("FAssintance")) {
            this.financeManager.setEmployee(activeEmployee);
        }

        this.offerManager = OfferManager.getInstance(clientManager);
        if (role.equals("SalesMan")) {
            this.offerManager.setSalesMan((SalesMan) activeEmployee);
        }

        stockManager.load();
        saleManager.load();
        repairManager.load();
        financeManager.load();
        offerManager.load("Offer");

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
                || fnum == 6 && role.equals("FAssintance")
                //Promciones
                || fnum == 7 && role.equals("SalesMan");

//        return true;
    }
///////////!!!!!!!!!!!!!!!!!!si no hay usuarios se crea un administrador!!!!!!!!!!!!!!!!

    /**
     * Propósito: Hacer de listener y handler de las peticiones
     *
     * @param enode
     */
    private void doBusiness(MenuNode enode) {
        boolean startNewSequence = false;

//Utilizamos esta técnica mediante la que pasamos un array 
//a los gestores para pasar por referencia el objeto nodo y 
//de esta forma poder antender sus peticiones 
        MenuNode[] node = {enode};
        System.out.println("entrada menu" + enode.getValue());
        if (enode.getValue() == 8) {
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

        if (repairManager.handleProcess(node) && !startNewSequence) {
            startNewSequence = true;
        }

        if (checkRole(enode.getValue())) {
            if (financeManager.handleProcess(node) && !startNewSequence) {
                startNewSequence = true;
            }
        }

        if (checkRole(enode.getValue())) {
            if (offerManager.handleProcess(node) && !startNewSequence) {
                startNewSequence = true;
            }
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

    /**
     * Controla accesos de cliente configurados en MAXACCESS
     *
     * @return
     */
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
        System.out.println("Bienvenido ".concat(activeEmployee.getFirstName()));
        System.out.println("Su role es ".concat(role));
        return true;
    }
}
