/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Deparment.Department;
import Deparment.Finance;
import Deparment.FrontDesk;
import Deparment.Support;
import Person.Employee.Cashier;
import ScreenInterfaces.Node;
import ScreenInterfaces.TextInterface;
import ishop.ElectronicShop;
import ishop.Shop;

/**
 *
 * @author ashh412 Propósito: gestor principal.
 */
public class MainScene {

    //   private Shoppingcart shoppingcart;
    private final TextInterface myTextInterface;
    // private Client client;
    private final ClientManager cm;
    private final StockManager sm;

    public MainScene() {
        this.cm = new ClientManager();
        this.sm = new StockManager();
        myTextInterface = new TextInterface();
        //inicializar gestores
    }

    //Propósito: Clase gestora de la aplicación
    public void start() {

        //Instanciamos para crear un par de cajeros
        Cashier cashier = new Cashier("12");
        Cashier cashier1 = new Cashier("12");

        //Creamos unos cajeros
        cashier.setfirstName("Juan");
        cashier1.setfirstName("Pedro");

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

        //Agregamos el cajero tipo Person y tipo Cashier
        cajeros.addStaff(cashier);
        cajeros.addStaff(cashier1);

        cm.load();

        doBusiness(myTextInterface.printMenu(null));

    }
//Procesamos las ordenes que nos van llegando de los menus desde de la entrada de teclado
//debe tener un return
    //Listar los procesos implementados
    //2. Clientes
    //21. Gestion de clientes introducción de DNI
    //25.Crear cliente aleatorio
    //3. Stock . 
    //31. Agregar Item a Stock
    //32. Modificar Item Stock
    //33. Eliminar Item Stock
    //34. Listar eletrodomésticos
    //35. Volver al menú principal

    private void doBusiness(Node node) {
        boolean startNewSequence = false;

        startNewSequence = cm.handleProcess(node.getValue());
        if (!startNewSequence) {
            startNewSequence = sm.handleProcess(node.getValue());
        }

        myTextInterface.clearScreen();
        //Imprimimos el menú del nodo seleccionado y mandamos a consola,
        //la cual nos devolverá el valor del nuevo nodo seleccionado
        //cargamos nuevo menú o menú principal
        Node newNode = null;
        if (!startNewSequence == true) {
            newNode = myTextInterface.printMenu(node);
        } else {
            newNode = myTextInterface.printMenu(node.getParent());
        }

        doBusiness(newNode);
    }
}
