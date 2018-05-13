/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.ShoppingCart;
import java.util.ArrayList;
import java.util.Scanner;
import Utils.Record.Record;
import Utils.Record.Sale;
import Utils.ShoppingCart.Line;
import item.Electrodomestic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412
 */
public class SaleManager extends OperationsManager {

    private ShoppingCart shoppingCart;

    private String invoiceCounter = "INVOICE ".concat(String.valueOf(size()));
    private static SaleManager instance = null;    //Singleton  Pattern

    //Singleton Singleton Pattern
    /**
     *
     * @param clientManager
     * @param stockManager
     */
    protected SaleManager(ClientManager clientManager, StockManager stockManager) {
        super(clientManager, stockManager);
        shoppingCart = new ShoppingCart();

    }
    //Singleton Singleton Pattern

    /**
     *
     * @param clientManager
     * @param stockManager
     * @return
     */
    public static SaleManager getInstance(ClientManager clientManager, StockManager stockManager) {
        if (instance == null) {
            instance = new SaleManager(clientManager, stockManager);
        }
        return instance;
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
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

        MenuNode node = enode[0];

        //1. buscar cliente y si no existe crearlo
        StringBuilder outString = new StringBuilder();

        //Devolvemos el código introducido por teclado en el StringBuilder de salida
        client = (Client) clientManager.search(node, outString);

        //Si el cliente no existe lo creamos
        if (client == null) {
            client = (Client) clientManager.createObject(enode);

        }
        if (!client.isActive()) {
            System.out.println("El cliente no está activo.");
            TextInterface.pressKey();
            return null;
        }

//Pasamos al menu siguiente
        setInvoiceNumber();

        return new Sale(getInvoiceNumber(), client.getDni(), employee.getDni(), shoppingCart, "A");

    }

    private void setInvoiceNumber() {
        invoiceCounter = "INV0000".concat(String.valueOf(size()));
    }

    private String getInvoiceNumber() {
        return invoiceCounter;
    }

    @Override
    public boolean handleProcess(MenuNode[] enode) {
        MenuNode node = enode[0];
        StringBuilder outString;
        Sale sale;

        switch (node.getValue()) {

            //Devolución
            case 12:

                outString = new StringBuilder();
                sale = (Sale) search(node, outString);
                if (sale == null) {
                    System.out.println("La factura no existe");
                    TextInterface.pressKey();
                    return true;
                }
                if (sale.getStatus().equals("A")) {

                    cancelTransaction(sale);

                    System.out.println("La factura ".concat(sale.getOperCode().concat(" ha sido cancelada")));
                    TextInterface.pressKey();
                } else {
                    System.out.println("La factura ".concat(sale.getOperCode().concat(" no se ha podido cancelar")));
                    TextInterface.pressKey();
                }

                return true;

            case 13:
                list();
                TextInterface.pressKey();
                return true;

            case 14: // Buscar una Factura"
                outString = new StringBuilder();
                sale = (Sale) search(node, outString);

                printRecord(sale);
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
//Métodos de pago
            case 11311://pago en efectivo
                finishTransaction("E");
                enode[0] = callMainMenu(node);
                return true;

            case 11312://Tarjeta
                finishTransaction("T");
                enode[0] = callMainMenu(node);
                return true;

            case 11313://Financiado
                finishTransaction("W");
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

    private void cancelTransaction(Sale sale) {
        //continuar aqui, sacar el resto de nodos hijos con la forma de pago
        //Si financia pasar a financiacion
//Guardamos la compra

        sale.setStatus("I");//realizar la devolucion
        save();

        //Restar del stock los items
        //Recorrer todos los items del carro
        sale.getShoppingCart().getItems().forEach(line -> {
            Electrodomestic e = stockManager.searchElectrodomestic(line.getItemCode());
            e.setQuantity(e.getQuantity() + line.getAmount());
        });

        //Guardamos el nuevo estado de la venta
        save();

        stockManager.refresh();
    }

    private void finishTransaction(String paymentType) {
        //continuar aqui, sacar el resto de nodos hijos con la forma de pago
        //Si financia pasar a financiacion
//Guardamos la compra

        //Restar los items del stock
        //Recorrer todos los items del carro
        shoppingCart.getItems().forEach(line -> {
            Electrodomestic e = stockManager.searchElectrodomestic(line.getItemCode());
            e.setQuantity(e.getQuantity() - line.getAmount());
        });

        shoppingCart.setInvoiceCode(invoiceCounter);

        //Agregamos y guardamos todos los datos de la venta
        //Creamos una copia del carrito
        ShoppingCart sShoppingCart = new ShoppingCart();

        sShoppingCart.setInvoiceCode(invoiceCounter);
        sShoppingCart.setTotalAmount(shoppingCart.getTotalAmount());
        sShoppingCart.setSalesDate(shoppingCart.getSalesDate());

        //Recorrer todos los items del carro
        shoppingCart.getItems().forEach(line -> {

            sShoppingCart.addItem(sShoppingCart.getInvoiceCode(), line.getItemCode(), line.getPrice(), line.getAmount());
        });

        Sale sale = new Sale(invoiceCounter, client.getDni(), employee.getDni(), sShoppingCart, paymentType);
        sale.setTotal(shoppingCart.getTotalAmount());

        add(sale);

        save();
        //agregamos en la ficha de cliente el código de operacion
        client.addOperation(sale);
        clientManager.save();

        System.out.println("Total: ".concat(String.valueOf(shoppingCart.getTotalAmount())));
        System.out.println(">>>> Su código de factura es: ".concat(invoiceCounter));
        if (paymentType.equals("W")) {
            System.out.println("Sus productos han sido apartados. Pase por el departamento financiero para finalizar la compra");
        }
        System.out.println("Gracias por usar nuestros productos");

        TextInterface.pressKey();

        stockManager.refresh();
        clearShoppingCart();
    }

    /**
     *
     * @param operCod
     * @return
     */
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

        int i = 0; //variable de control de nodos de lectura

        StringBuilder outString = new StringBuilder();
        Electrodomestic item = stockManager.search(node, outString);

        if (item == null) {
            System.out.println("El electrodoméstico no existe");
            TextInterface.pressKey();
            return;
        }

        ArrayList<String> nodesData = node.convertTreeChildToListIdx();

        String itemCode = item.getCode();

        //Comprobamos la cantidad en stock
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
                //indicamos el nuevo numero de elementos
                auxLine.setAmount(auxLine.getAmount() + amount);

                for (int k = 0; k < amount; k++) {
                    auxLine.addReference();
                }

//Recalculamos el precio del carro
                shoppingCart.setTotalAmount(shoppingCart.getTotalAmount() + (auxLine.getPrice() * amount));

            } else {
                shoppingCart.addItem("", itemCode, cost, amount);
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
                    System.out.printf("%-10s%-10s%-30s%-20s\n", line.getLineNumber() + 1, line.getItemCode(), line.getPrice(), line.getAmount());

                });
            }
        }

        System.out.println("TOTAL AMOUNT:" + getTotalAmount());
        TextInterface.pressKey();
    }

    private void printHeader() {

        System.out.printf("%-10s%-10s%-30s%-20s%n", "LINE", "CODE", "PRICE", "AMOUNT");

    }

    private void printRecord(Sale sale) {
        if (sale == null) {
            System.out.println("la factura no existe");
            TextInterface.pressKey();
            return;
        }
        System.out.printf("%-10s%-15s%-15s%-20s%-20s%n", "Factura", "Cliente", "Empleado", "Fecha", "Activa");
        print(sale);

        Iterator<Line> it = sale.getShoppingCart().getItems().iterator();
        System.out.println("Lineas de factura");

        while (it.hasNext()) {
            Line line = (Line) it.next();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
// Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String strDate = formatter.format(sale.getDate());
            System.out.printf("%-10s%-20s%-20s%-20s%n", "Línea", "Artículo", "precio", "cantidad");
            System.out.printf("%-10s%-20s%-20s%-20s%n", line.getLineNumber() + 1, line.getItemCode(), line.getPrice(), line.getAmount());

        }

        System.out.printf("================= TOTAL: ".concat(String.valueOf(sale.getTotal())).concat("%n"));

        TextInterface.pressKey();
    }

    /**
     *
     * Propósito: Realizar la devolución de un item
     *
     *
     * @param enode
     * @return
     *
     */
    public Sale returnItem(MenuNode[] enode) {
        client = null;

        MenuNode node = enode[0];

        //1. buscar cliente 
        StringBuilder outString = new StringBuilder();

        //Devolvemos el código introducido por teclado en el StringBuilder de salida
        client = (Client) clientManager.search(node, outString);
        if (client == null) {
            System.out.println("El cliente no existe");
            return null;
        }

        if (!client.isActive()) {
            System.out.println("El cliente no está activo.");
            TextInterface.pressKey();
            return null;
        }

        //tomamos el resto de valores output
        ArrayList<String> nodesData = node.convertTreeChildToListIdx();

        node.getChildNodes().get(0).clearResponse();

//llamar a obtencion de nodos index
        int i = 0;

        //introduzca referencia de producto
        String ref = nodesData.get(i++);

        String invRef = getInvoiceRef(ref);

        if (!checkReturnConditions(invRef)) {
            return null;
        }

        //Creamos una nota de abono identificando la referencia del objeto
        Sale sale = createCreditNote(ref, client.getDni(), employee.getDni());

        if (sale == null) {
            System.out.println("Datos incorrectos.");
            return null;
        }

        add(sale);

        save();

        //Modificar la operación antigua
        Iterator<Record> it = client.getOperations().iterator();

        while (it.hasNext()) {

            Sale saleOper = (Sale) it.next();
            if (saleOper.getOperCode().equals(invRef)) {
                saleOper.setStatus("D");
            }
        }

        //Agregar la nueva operación
        client.addOperation(sale);

        clientManager.save();
        System.out.println("Nota de abono creada");
        System.out.println("Su nueva referencia es ".concat(sale.getOperCode()));

        return sale;
    }

    /**
     *
     * Propósito: Cancelar la factura y crear una nota de abono
     *
     *
     *
     */
    private Sale createCreditNote(String itemKeyCode, String clientCode, String empCode) {

        String invoiceRef = getInvoiceRef(itemKeyCode);

        //Buscamos la venta para obtener el producto
        Sale saleCancel = (Sale) searchRecord(invoiceRef);
        if (saleCancel == null || !(saleCancel.getStatus().equals("A"))) {
            System.out.println("La factura indicada no está activa ");
            return null;
        }
        if (!clientCode.equals(saleCancel.getCliCode())) {
            System.out.println("La factura indicada no hace referencia al identificador del cliente ");
            return null;
        }
//Tomamos el carrito de la venta
        shoppingCart = saleCancel.getShoppingCart();

        Boolean changed = false;
//Buscamos la referencia del artículo en las líneas
        for (Line line : shoppingCart.getItems()) {

            if (line.getReferences().get(itemKeyCode).equals("A")) {
//Marcamos la operación en la factura
                line.getReferences().put(itemKeyCode, "D");
//Realizamos la devolución del producto al stock
                Electrodomestic e = stockManager.searchElectrodomestic(line.getItemCode());
                e.setQuantity(e.getQuantity() + 1);

                changed = true;
                break;

            }
        }

        if (!changed) {
            System.out.println("No se ha podido realizar la cancelación de la factura ");
            return null;
        }

        //Bloqueamos la factura e indicamos que es una devolución
        saleCancel.setStatus("D");

        //Creamos una nueva factura identificando la referencia del objeto
        setInvoiceNumber();

        Sale sale = new Sale(getInvoiceNumber(), clientCode, empCode, saleCancel.getShoppingCart(), saleCancel.getPaymentType());
//Guardamos y devolvemos el objeto creado

        return sale;
    }

    private static String getInvoiceRef(String code) {

        String[] parts = code.split("-");
        return parts[0];

    }

    private static String getItemRef(String code) {

        String[] parts = code.split("-");
        return parts[1];

    }

    /**
     *
     * Propósito: Comprobar las condiciones de devolución de una factura
     *
     * @param invRef String código de factura
     * @return boolean: Verdadero si se puede realizar la operación Rules: la
     * diferencia entre la fecha de compra y la devolución no puede ser superior
     * a 90 días
     */
    public boolean checkReturnConditions(String invRef) {

        Sale sale = (Sale) searchRecord(invRef);

        //supera los 3 meses
        Calendar rightNow = Calendar.getInstance();

        rightNow.getTime();

        Date fechaInicial;
        Date fechaFinal;
        int dias;

        fechaInicial = sale.getDate();

        fechaFinal = rightNow.getTime();

        dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
        System.out.println("Hay " + dias + " dias de diferencia");

        return false;

    }

}
