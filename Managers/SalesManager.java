/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;
import Person.Employee.Cashier;
import Person.PersonOperation;
import ScreenInterfaces.TextInterface;
import Utils.Node;
import Utils.ShoppingCart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import Utils.Record.Record;
import Utils.Record.SalesRecord;
import item.Electrodomestic;
import java.util.logging.Level;
import java.util.logging.Logger;
//Crear un numero de factura

/**
 *
 * @author ashh412
 */
public class SalesManager extends OperationsManager implements Imanager<Record, Node> {

    private PersonOperation client;//Lo declaramos como objeto para poder usar sus métodos
    private Cashier cashier;//Lo declaramos como objeto para poder usar sus métodos
    private final ShoppingCart shoppingCart;
    private final HashMap<String, Record> history = new HashMap<>();
    private final ClientManager clientManager;
    private final StockManager stockManager;

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public SalesManager(Cashier cashier, ClientManager clientManager, StockManager stockManager) {
        this.cashier = cashier;
        shoppingCart = new ShoppingCart(this.cashier.getDni());
        this.clientManager = clientManager;
        this.stockManager = stockManager;

    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Record createObject(Node node) throws IOException {
        //1. buscar cliente
        //Si no existe crearlo

        StringBuilder outString = new StringBuilder();

        //Devolvemos el código introducido por teclado en el StringBuilder de salida
        client = (PersonOperation) clientManager.search(node, outString);
        if (client == null) {
            //crear cliente

            client = new PersonOperation(outString.toString());
            //Obtener el menu para añadir clientes
//Paramos la operacion y creamos cliente
            clientManager.add(client);
            clientManager.save();
        }
//Guardamos la compra
        String operCode = "INVOICE".concat(String.valueOf(getSequence()));
//guardar la operacion de la tienda
        Record record = new SalesRecord(operCode, client.getDni(), cashier.getDni(), shoppingCart);
//guardar la ficha de cliente
        history.put(operCode, record);
        save(history);
        return record;
    }

    @Override
    public boolean handleProcess(Node node) {

        switch (node.getValue()) {

            //Consultar el importe actual
            case 11:
                list();
                return true;
            //"12. Añadir electrodomestico al carrito"
            case 12:
                addItem(node);
                return true;

            //13. Cobrar Compra
            case 13:
                //identificar al cliente o solicitar alta 
                try {
                    createObject(node);
                } catch (IOException ex) {
                    Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;

            //Crear carrito aleatorio
            //Cancelar venta
            case 14:
                clearShoppingCart();
                return true;
        }
        return false;//Profundiza
    }

    private void clearShoppingCart() {
        for (byte i = 0; i < shoppingCart.getItems().size(); i++) {
            shoppingCart.removeItem(i);
        }

    }

    //intervinient
    //role (clasgetname)
//deprecated
    private void saveTransaction() { ////         
///ESTRUCTURA DEL NODO: 0 (REPAIR || SELL)
// cliCode  empCode  List --> (0)ShoppingCart
///llamada
////              List l = null;
////          ShoppingCart shoppingCart;
////          l.add(shoppingCart);
////
////          node.setList(l);
////            }
        ////         
///ESTRUCTURA DEL NODO: 0 (REPAIR || SELL)
// cliCode  empCode  List --> (0)ShoppingCart

        Node node = new Node(0, null, "SALES");
        Node childNode = new Node(0, node, client.getDni());
        node.addChild(node);
        childNode = new Node(1, node, client.getDni());
        node.addChild(node);
        childNode = new Node(2, node, cashier.getDni());
        node.addChild(node);
///llamada
        List<ShoppingCart> list = new ArrayList<>();

        list.add(shoppingCart);

     //   node.setList(list);

    }

    private double getTotalAmount() {

        return shoppingCart.getTotalAmount();
    }

    private void addItem(Node node) {

        int i = 0;

        StringBuilder outString = new StringBuilder();
        Electrodomestic item = stockManager.search(node, outString);
        if (item == null) {
            return;
        }

        ArrayList<String> nodesData = node.convertTreeChildToListIdx();

        String itemCode = item.getCode();
        Byte amount = Byte.parseByte(nodesData.get(i++));
        Double cost = amount * item.getSellPrice();

        shoppingCart.addItem(itemCode, cost, amount);
    }
//Proposito: Listar elementos del carrito. Dar formato

    @Override
    public void list() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fecha:" + shoppingCart.getSalesDate());
        printHeader();

        if (!shoppingCart.getItems().isEmpty()) {
            if (shoppingCart.getItems().size() > 0) {
                shoppingCart.getItems().forEach((ShoppingCart.Line line) -> {

                    String s = line.getLineNumber() + " ";
                    s = s.concat(line.getItemCode().concat(" "));
                    s = s.concat(String.valueOf(line.getPrice()).concat(" "));
                    s = s.concat(String.valueOf(line.getAmount()).concat(" "));
                    s = s.concat(String.valueOf(line.getPrice() * line.getAmount()));

                    System.out.println(s);

                });
            }
        }

        System.out.println("TOTAL AMOUNT:" + getTotalAmount());
        TextInterface.pressKey();

    }

    private void printHeader() {

        System.out.printf("%-2s%-10s%-40s%-20s\n", "LINE", "CODE", "DESCRIPTION", "PRICE");

    }

    @Override
    public void update(Node e) {
        Byte i = 1;

        //  e.addItem("", 0, i);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


/*

}

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
             
                if (codigo==100){JOptionPane.showMessageDialog(null, "el Valor del tomate es:500");
                a=a+500;}
                if (codigo==200){JOptionPane.showMessageDialog(null, "el Valor de la cebolla es:700");
                a=a+700;}
                if (codigo==300){JOptionPane.showMessageDialog(null, "el Valor de la zanahoria es:800");
                a=a+800;}     
                if (codigo==400){JOptionPane.showMessageDialog(null, "el Valor del perenjil es:900");
                a=a+900;}
                if (codigo==500){JOptionPane.showMessageDialog(null, "el Valor de la remolacha es:1000");
                a=a+1000;}
                if (codigo==600){JOptionPane.showMessageDialog(null, "el Valor del frijol es :80");
                a=a+80;}
                
                a=a;
                 }
               
               
              JOptionPane.showMessageDialog(null, "El Valor Total a pagar es:"+ a);
                break;
               
            case 2:
               
                int tomate=1;
                int cebolla=1;
                int zanahoria=1;
                int remolacha=1;
                int perenjil=1;
                int frijol=1;
              
                int cod=1; 
            
                while(cod != 0){
               
                cod=Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del producto"));
               
                if (cod==100){tomate++;}
                if (cod==200){cebolla++;}
                if (cod==300){zanahoria++;}     
                if (cod==400){remolacha++;}
                if (cod==500){perenjil++;}
                if (cod==600){frijol++;}
                }
              
                JOptionPane.showMessageDialog(null,"hay "+tomate+" libras de tomate");
                JOptionPane.showMessageDialog(null,"hay "+cebolla+" libras de cebolla");
                JOptionPane.showMessageDialog(null,"hay "+zanahoria+" libras de zanahoria");
                JOptionPane.showMessageDialog(null,"hay "+perenjil+" libras de perejil");
                JOptionPane.showMessageDialog(null,"hay "+remolacha+" libras de remolacha");
                JOptionPane.showMessageDialog(null,"hay "+frijol+" libras de frijol");
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

 */
