/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;
import Person.Employee.Cashier;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.ShoppingCart;
import java.util.ArrayList;
import java.util.Scanner;
import Utils.Record.Record;
import Utils.Record.Sale;
import Utils.ShoppingCart.Line;
import item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class SaleManager extends OperationsManager {

    private Client client;
    private Cashier cashier;//Lo declaramos como objeto para poder usar sus métodos
    private final ShoppingCart shoppingCart;
    private final ClientManager clientManager;
    private final StockManager stockManager;
    private String operCode = "INVOICE ".concat(String.valueOf(size()));
    private static SaleManager instance = null;    //Singleton  Pattern

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //Singleton Singleton Pattern
    protected SaleManager(Cashier cashier, ClientManager clientManager, StockManager stockManager) {
        this.cashier = cashier;
        shoppingCart = new ShoppingCart(this.cashier.getDni());
        this.clientManager = clientManager;
        this.stockManager = stockManager;

    }
    //Singleton Singleton Pattern

    public static SaleManager getInstance(Cashier cashier, ClientManager clientManager, StockManager stockManager) {
        if (instance == null) {
            instance = new SaleManager(cashier, clientManager, stockManager);
        }
        return instance;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    private MenuNode callTailMenu(MenuNode node) {
        return node.getChildNodes().get(node.getChildNodes().size() - 1);
    }

    private MenuNode callNextMenu(MenuNode node) {
        return node.getChildNodes().get(0);
    }

    @Override
    public Record createObject(MenuNode[] enode) {
        client = null;
        if (shoppingCart.getItems().isEmpty()) {
            System.out.println("El carrito está vacío.");
            TextInterface.pressKey();
            return null;
        }
// hacer cosas 
        MenuNode node = enode[0];

        //1. buscar cliente y si no existe crearlo
        StringBuilder outString = new StringBuilder();

        //Devolvemos el código introducido por teclado en el StringBuilder de salida
        client = (Client) clientManager.search(node, outString);

        //Si el cliente no existe lo creamos
        if (client == null) {
            client = (Client) clientManager.createObject(enode);
            //tomamos el resto de valores output

            //ArrayList<String> nodesData = node.convertTreeChildToListIdx();
        }
        if (!client.isActive()) {
            System.out.println("El cliente no está activo.");
            TextInterface.pressKey();
            return null;
        }

//Pasamos al menu siguiente
        setInvoiceNumber();
        return new Sale("", "", "", null);
    }

    private void setInvoiceNumber() {
        operCode = "INV0000".concat(String.valueOf(size()));
    }

    @Override
    public boolean handleProcess(MenuNode[] enode) {
        MenuNode node = enode[0];

        switch (node.getValue()) {

//            case 5:
//                list();
//                TextInterface.pressKey();
//                return true;
            //Devolución
            case 12:

                StringBuilder outString = new StringBuilder();
                Sale sale = (Sale) search(node, outString);
                if (sale == null) {
                    System.out.println("La factura no existe");
                    TextInterface.pressKey();
                    return true;
                }
                sale.setActive("I");
                save();
                return true;

            case 13:
                list();
                TextInterface.pressKey();
                return true;
            //Consultar el importe actual
            case 111:
                itemList();
                return true;
            //"12. Añadir electrodomestico al carrito"
            case 112:
                addItem(node);
                return true;

            //13. Cobrar Compra
            case 113:
                //identificar al cliente o solicitar alta 
                //Si el carrito está vacío cancelar el cobro
                //Si no, seguimos navegando por los hijos
                if (createObject(enode) == null) {
                    return true;
                }
                enode[0] = callNextMenu(node);
                break;
            //Crear carrito aleatorio
            //Cancelar venta
            case 114:
                clearShoppingCart();
                return false;

            case 11311://pago en efectivo
                finishTransaction();
                enode[0] = callMainMenu(node);
                return true;

            case 11312://Tarjeta
                finishTransaction();
                enode[0] = callMainMenu(node);
                return true;

            case 11313://Financiado
                finishTransaction();
                enode[0] = callMainMenu(node);
                return true;

            case 11314://cancel
                clearShoppingCart();
                enode[0] = callMainMenu(node);
                return true;

            case 113131://Mensaje final financiado
                enode[0] = callMainMenu(node);

        }
        return false;//Profundiza
    }

    private void finishTransaction() {
        //continuar aqui, sacar el resto de nodos hijos con la forma de pago
        //Si financia pasar a financiacion
//Guardamos la compra

//agregamos en la ficha de cliente el código de operacion
        client.addOperation(operCode);
        clientManager.save();

        //Restar del stock los items
        //Recorrer todos los items del carro
        shoppingCart.getItems().forEach((line) -> {
            Electrodomestic e = stockManager.searchElectrodomestic(line.getItemCode());
            e.setQuantity(e.getQuantity() - line.getAmount());
        });

        //Agregamos y guardamos todos los datos de la venta
        add(new Sale(operCode, client.getDni(), cashier.getDni(), shoppingCart));
        save();

        System.out.println("Total: ".concat(String.valueOf(shoppingCart.getTotalAmount())));
        System.out.println(">>>> Su código de factura es: ".concat(operCode));
        System.out.println("Gracias por usar nuestros productos");

        TextInterface.pressKey();

        clearShoppingCart();

        stockManager.refresh();
    }

    public Sale getSale(String operCod) {

        Sale sale = (Sale) searchRecord(operCod);

        return sale;

    }

    private void openCreditLine() {

        //crear credito para el cliente
    }

    private void clearShoppingCart() {
        for (byte i = 0; i < shoppingCart.getItems().size(); i++) {
            shoppingCart.removeItem(i);
        }
    }

    private double getTotalAmount() {

        return shoppingCart.getTotalAmount();
    }

    private void addItem(MenuNode node) {

        int i = 0;

        StringBuilder outString = new StringBuilder();
        Electrodomestic item = stockManager.search(node, outString);

        if (item == null) {
            System.out.println("El electrodoméstico no existe");
            TextInterface.pressKey();
            return;
        }

        ArrayList<String> nodesData = node.convertTreeChildToListIdx();

        String itemCode = item.getCode();

        //Comprobamos la cantidad en estock
        int stockUnits = item.getQuantity();
        //Obtenemos la cantidad de unidades que vamos a comprar
        int amount = Byte.parseByte(nodesData.get(i++));
        Double cost = amount * item.getSellPrice();

        Line auxLine = null;
        //Comprobamos si tenemos unidades en el carrito        
        int auxAmount = 0;
        for (Line line : shoppingCart.getItems()) {
            if (line.getItemCode().equals(itemCode)) {
                auxLine = line;
                break;
            }
        }
//Hemos encontrado el artículo, guardamos la cantidad de unidades 
        if (auxLine != null) {
            auxAmount = auxLine.getAmount();
        }
//Comprobamos que la cantidad de unidades en el carrito más las que vamos a agregar no sea mayor que las unidades en stock
        if (amount + auxAmount > stockUnits) {
            System.out.println("No queda Stock suficiente. Unidades en Stock:".concat(String.valueOf(stockUnits)));
        } else {
//Comprobamos si Existe la línea de pedidos. En caso afirmativo la modificamos. Si no, creamos una nueva línea en el carro
            if (auxAmount > 0) {
                auxLine.setAmount(auxLine.getAmount() + amount);
            } else {
                shoppingCart.addItem(itemCode, cost, amount);
            }
        }

    }
//Proposito: Listar elementos del carrito. Dar formato

    private void itemList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fecha:" + shoppingCart.getSalesDate());
        printHeader();

        if (!shoppingCart.getItems().isEmpty()) {
            if (shoppingCart.getItems().size() > 0) {
                shoppingCart.getItems().forEach((ShoppingCart.Line line) -> {
                    System.out.printf("%-10s%-10s%-30s%-20s\n", line.getLineNumber(), line.getItemCode(), line.getPrice(), line.getAmount());

                });
            }
        }

        System.out.println("TOTAL AMOUNT:" + getTotalAmount());
        TextInterface.pressKey();
    }

    private void listFormat(Electrodomestic item) {

        System.out.printf("%-20s%-20s%-40s%-20s%-20s%-20s\n", item.getCode(), item.getName(), item.getDescription(), item.getBoughtPrice(), item.getSellPrice(), item.getQuantity());

    }

    private void printHeader() {

        System.out.printf("%-10s%-10s%-30s%-20s\n", "LINE", "CODE", "PRICE", "AMOUNT");

    }

    @Override
    public void update(MenuNode e) {
        Byte i = 1;

        //  e.addItem("", 0, i);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Record search(Node node, StringBuilder outString) {
//        outString.append(node.getChildNodes().get(0).getResponse());
//        Sale sale = (Sale) searchRecord(outString.toString());
//        if (sale != null) {
//            return sale;
//        }
//        return null;
//
//    }
}

/*

 
//ventas de productos e inventarios
public class Ventasproductos {
    static void inventarioyventa(String x){
    String resultado="venta";
    resultado="inventario";
    int opcion=3;
   while (opcion != 0){
     opcion=Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para la venta o 2 para el inventario")); 
        switch(opcion){
           
            case 1:
       
                int a=0;
                int codigo=1; 
            
                while(codigo != -1){
               
                codigo=VentanaProductos.seleccionProducto();
             
           
               
               
              JOptionPane.showMessageDialog(null, "El Valor Total a pagar es:"+ a);
                break;
               
            
              
                JOptionPane.showMessageDialog(null,"hay tomate!"  );
        
break;
    }
       }
   }

    /**
     * @param args the command line arguments
 */
 /*



    public static void main(String[] args) {
        // TODO code application logic here
        String resultado="0";
Ventasproductos.inventarioyventa(resultado);
    }

//    //intervinient
//    //role (clasgetname)
////deprecated
//    private void saveTransaction() { ////         
/////ESTRUCTURA DEL NODO: 0 (REPAIR || SELL)
//// cliCode  empCode  List --> (0)ShoppingCart
/////llamada
//////              List l = null;
//////          ShoppingCart shoppingCart;
//////          l.add(shoppingCart);
//////
//////          node.setList(l);
//////            }
//        ////         
/////ESTRUCTURA DEL NODO: 0 (REPAIR || SELL)
//// cliCode  empCode  List --> (0)ShoppingCart
//
//        Node node = new Node(0, null, "SALES");
//        Node childNode = new Node(0, node, client.getDni());
//        node.addChild(node);
//        childNode = new Node(1, node, client.getDni());
//        node.addChild(node);
//        childNode = new Node(2, node, cashier.getDni());
//        node.addChild(node);
/////llamada
//        List<ShoppingCart> list = new ArrayList<>();
//
//        list.add(shoppingCart);
//
//        //   node.setList(list);
//    }

 */
