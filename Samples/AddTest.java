/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samples;

import Managers.EmployeeManager;
import Managers.SaleManager;
import item.family.computers.Components.*;
import Managers.StockManager;
import Managers.ClientManager;
import Managers.HndInvoice;
import Managers.RepairManager;
import Person.Client.Client;
import Person.Employee.Employee;
import Person.Employee.Engineer;
import Person.PersonFactory;
import Utils.Record.Record;
import Utils.Record.Repair;
import Utils.Record.Sale;
import Utils.ShoppingCart;
import item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class AddTest {

    private static StockManager stockManager;
    private static EmployeeManager employeeManager;
    private static SaleManager saleManager;
    private static ClientManager clientManager;
    private static RepairManager repairManager;

    /**
     *
     */
    public static void addTestEmployees() {
        Employee employee;
        int i = 1;
        if (i == 1) {
            employeeManager = EmployeeManager.getInstance();
            employeeManager.load();

            employee = (Employee) PersonFactory.getPerson(1, "1");
            employee.setFirstName("Cashier");
            employeeManager.add(employee);

            employeeManager.add(employee);
            employee = (Employee) PersonFactory.getPerson(2, "2");
            employee.setFirstName("Clerk");
            employeeManager.add(employee);

            employee = (Employee) PersonFactory.getPerson(3, "3");
            employee.setFirstName("BackOfTheHouse");
            employeeManager.add(employee);

            employee = (Employee) PersonFactory.getPerson(4, "4");
            employee.setFirstName("Clerk");
            employeeManager.add(employee);

            employee = (Employee) PersonFactory.getPerson(5, "5");
            employee.setFirstName("Engineer");
            employeeManager.add(employee);

            employee = (Employee) PersonFactory.getPerson(6, "6");
            employee.setFirstName("FAssintance");
            employeeManager.add(employee);

            employee = (Employee) PersonFactory.getPerson(5, "Engineer 1");
            employee.setFirstName("Engineer");
            employeeManager.add(employee);
            employee = (Employee) PersonFactory.getPerson(5, "Engineer 2");
            employee.setFirstName("Engineer");
            employeeManager.add(employee);

            employeeManager.save();
        }
    }

    public static void addTestComponents() {

        stockManager = StockManager.getInstance();
        stockManager.load();

        Electrodomestic e = new Keyboard("LOGIK480");//Código artículo
        e.setName("Teclado"); //Nombre
        e.setBrand("LOGITECH"); //Marca
        e.setDescription("BLUETOOTH MULTI-DEVICE KEYBOARD K480"); //descripción
        e.setGuaranty("6 meses"); //Garantía
        e.setBoughtPrice(10.12); // precio de compra
        e.setSellPrice(56.99); // precio de venta
        e.setQuantity(10); // stock
        stockManager.add(e);

        e = new Keyboard("LOGIK490");//Código artículo
        e.setName("Teclado"); //Nombre
        e.setBrand("LOGITECH"); //Marca
        e.setDescription("BLUETOOTH MULTI-DEVICE KEYBOARD K490"); //descripción
        e.setGuaranty("6 meses"); //Garantía
        e.setBoughtPrice(12.12); // precio de compra
        e.setSellPrice(57.99); // precio de venta
        e.setQuantity(12); // stock
        stockManager.add(e);

        e = new Mouse("M330");//Código artículo
        e.setName("Ratón"); //Nombre
        e.setBrand("LOGITECH"); //Marca
        e.setDescription("M330 SILENT PLUS"); //descripción
        e.setGuaranty("6 meses"); //Garantía
        e.setBoughtPrice(11.99); // precio de compra
        e.setSellPrice(41.50); // precio de venta
        e.setQuantity(7); // stock
        stockManager.add(e);

        Procesor p = new Procesor("BX80684I78700K");//Código artículo
        p.setName("Procesador"); //Nombre
        p.setBrand("Intel"); //Marca
        p.setDescription("Intel Core i7-8700K 3.7Ghz BOX"); //descripción
        p.setGuaranty("1 año"); //Garantía
        p.setBoughtPrice(121.50); // precio de compra
        p.setSellPrice(311.99); // precio de venta
        p.setMhz("3.4MHz");
        p.setQuantity(2); // stock
        stockManager.add(p);

        Printer pr = new Printer("HP6230");//Código artículo
        pr.setName("Impresora"); //Nombre
        pr.setBrand("HP"); //Marca
        pr.setDescription("HP ENVY Photo 6230 Multifunción"); //descripción
        pr.setGuaranty("2 años"); //Garantía
        pr.setBoughtPrice(41.23); // precio de compra
        pr.setSellPrice(99.90); // precio de venta

        pr.setQuantity(5); // stock
        stockManager.add(pr);

        pr = new Printer("EP550");//Código artículo
        pr.setName("Impresora"); //Nombre
        pr.setBrand("EPSON"); //Marca
        pr.setDescription("EPSON 550 Multifunción"); //descripción
        pr.setGuaranty("2 años"); //Garantía
        pr.setBoughtPrice(41.23); // precio de compra
        pr.setSellPrice(99.90); // precio de venta

        pr.setQuantity(5); // stock
        stockManager.add(pr);

        Memory me = new Memory("N71VN");//Código artículoº
        me.setName("Memoria"); //Nombre
        me.setBrand("ASUS"); //Marca
        me.setDescription("N71VN DDR3 2GB"); //descripción
        me.setGuaranty("2 años"); //Garantía
        me.setBoughtPrice(9.07); // precio de compra
        me.setSellPrice(17.51); // precio de venta
        me.setCapacity("2GB");
        me.setQuantity(5); // stock
        stockManager.add(me);

        stockManager.save(stockManager.getAll());

        System.out.println("Añadidos electrodomésticos de prueba");

    }

    public static void addTestSale() {
        System.out.println("Agregando venta de prueba");

        stockManager = StockManager.getInstance();
        clientManager = ClientManager.getInstance();

        saleManager = SaleManager.getInstance(clientManager, stockManager);

        employeeManager = EmployeeManager.getInstance();
        employeeManager.load();

        clientManager = ClientManager.getInstance();
        clientManager.load();
        Client person = new Client("1");

        clientManager.add(person);

        saleManager = SaleManager.getInstance(clientManager, stockManager);

        clientManager.setSaleManager(saleManager);
        saleManager.load();

        //  Sale(String operCode, String cliCode, String empCode, ShoppingCart shoppingCart)
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();

        saleManager.setClient(person);

        Sale sale = new Sale("INV1", "1", "1", shoppingCart, "W");
        person.addOperation(sale);

//Agregamos un elemento al carrito
        shoppingCart.addItem(shoppingCart.getInvoiceCode(), "LOGIK480", 100, 300);

        sale.setTotal(shoppingCart.getTotalAmount());
        saleManager.add(sale);

        saleManager.save();
        clientManager.save();
        
       
        
        saleManager.checkReturnConditions("INV1");
        

    }

    //Imprimir todas las referencias de productos vendidos
    private static void printAllReferences() {
        saleManager.getAll().forEach((String s, Record fsale) -> {
            searchReferences(fsale.getOperCode());
        });

    }

    //Imprimir todas las referencias de PARTES
    //Código de empleado si queremos solo dar sus partes
    //Poner estados de reparacion en la orden
    //Asociar cada parte a una referencia de producto
    public static void printOrders(String employeeCode) {
        System.out.println("Imprimiendo todos los partes: ".concat(String.valueOf(repairManager.getAll().size())));

        repairManager.getAll().forEach((String s, Record fOper) -> {
            //  searchReferences(fOper.getOperCode());
            System.out.println("Código de reparación: ".concat(fOper.getOperCode()));
            System.out.println("Notas de reparación");
            fOper.getHistory().forEach(history -> {
                System.out.println(history.getNote().concat(" ".concat(String.valueOf(history.getDate()))));

            });

        });

    }
//Buscar el estado de una reparacion

    public static void testRepairStatus(String code) {

    }

    public static void testVerMisReparaciones() {

//• Producir diferentes listados del funcionamiento de la tienda:
//las piezas que hace falta pedir para las //imprimir notas de pendiente de piezas, la ultima 
//reparaciones, 
//las fichas procesadas por cada técnico, 
//las confirmaciones que hay que solicitar a los
//clientes, las fichas en proceso
//un historial de cada técnico y cada electrodoméstico.
    }

    //public static void testChangeOrderStatus(Repair repair, String newStatus) {
    public static void testChangeOrderStatus() {
        Repair repair = new Repair("testo1", "cli", "emp");
        //Estados 
        // A--> FACTURA ACTIVA
        // I--> FACTURA INACTIVA
        // R--> EN REPARACION
        // P--> PENDIENTE
        // S--> PARADO
        // T--> TEST
        // F--> FINISH

        repair.setStatus("A");
        repair.addHistory("registro creado");

        repair.setStatus("I");
        repair.addHistory("registro inactivo");

        //R APERTURA DE PARTE
        repair.setStatus("R");
        repair.addHistory("APERTURA DE PARTE");

        repair.setStatus("P");
        repair.addHistory("pendiente de piezas");
        repair.setStatus("S");
        repair.addHistory("esperando confirmacion de cliente");
        repair.setStatus("T");
        repair.addHistory("Probando el articulo");
        repair.setStatus("F");
        repair.addHistory("producto entregado al cliente");

        repairManager.add(repair);
    }

    public static void testRepair() {

        System.out.println("****Agregando Reparacion de prueba");

        //necesitamos acceso a las ventas
        clientManager = ClientManager.getInstance();

        saleManager = SaleManager.getInstance(clientManager, stockManager);

        repairManager = RepairManager.getInstance(clientManager, saleManager);

        repairManager.load();

        //abrir un parte
        //introduzca codigo de cliente
        Client client =(Client) clientManager.searchPerson("1");
        
        Engineer engineer = new Engineer("5");

        //introduzca referencia de producto
        String ref = "INV1-0LOGIK4800";
        String invoiceRef = getInvoiceRef(ref);

        //Buscamos la venta
        Sale sale = (Sale) saleManager.searchRecord(invoiceRef);
        ShoppingCart shoppingCart = sale.getShoppingCart();

        //records
        shoppingCart.getItems().forEach(line -> {

            if (line.getReferences().containsKey(ref)) {
                line.getReferences().put(ref, "R");

            }
        }
        );

        //public Record(String operCode, String cliCode, String empCode) {
        //Creamos un nuevo parte identificando la referencia del objeto
        //
        //damos seguimiento al objeto
        Repair repair = new Repair("INV1-0LOGIK4800", client.getDni(), engineer.getDni());

        //Intruduzca descripción del problema
        String note = "Apertura de parte problema con teclado";

        repair.addHistory(note);

        //repair.getOperCode();
        repairManager.add(repair);
        client.addOperation(repair);
        repairManager.save();
        clientManager.save();

        //  entries.add(new MenuStruct("mnuOpenPart", "Abrir un parte de reparaciones"));
//        entries.add(new MenuStruct("mnuRepairSearch", "Gestionar una reparacion"));
////        entries.add(new MenuStruct("mnuRepairInsertItem", "Dar entrada producto"));
//        entries.add(new MenuStruct("mnuChekcInvoiceItem", "Buscar referencias por factura"));
//        entries.add(new MenuStruct("", "Listar reparaciones")); //indicando quién las tiene
    }

//Menu listar referencias de factura
    public static void searchReferences(String operCode) {
        Sale sale = (Sale) saleManager.searchRecord(operCode);

        HndInvoice.printInvoiceRef(sale);

    }

    //Menu listar referencias de factura
    public static void searchParteReferences(String operCode) {
        Repair repair = (Repair) repairManager.searchRecord(operCode);

        // HndInvoice.printInvoiceRef(repair);
    }

    private static String getInvoiceRef(String code) {

        String[] parts = code.split("-");
        return parts[0];

    }

}
