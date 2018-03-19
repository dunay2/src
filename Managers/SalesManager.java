/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DataBase.TextDatabase;
import Person.Client.Client;
import Person.Employee.Cashier;
import Person.Person;
import ScreenInterfaces.Node;
import ishop.Shoppingcart;
import item.Electrodomestic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412
 */
public class SalesManager extends TextDatabase implements Imanager {

    private final Client client;//Lo declaramos como objeto para poder usar sus métodos
    private final Cashier cashier;//Lo declaramos como objeto para poder usar sus métodos
    private final Shoppingcart shoppingcart;

    public SalesManager(Client client, Cashier cashier) {
        this.cashier = cashier;
        this.client = client;
        shoppingcart = new Shoppingcart(this.cashier.getDni());
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
    public void update(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object search(String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object createObject() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean handleProcess(int e) {

        switch (e) {

            //Gestion de clientes introducción de DNI
            case 1: {
                try {
                    createObject();
                    // Este es el nod raiz    myInterface.getNode();
                } catch (IOException ex) {
                    Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }

            // (11, childNode, "1. Consultar el contenido del carrito y el importe actual"));
            case 11:
                queryShoppingCart();
                return true;
            //"12. Añadir electrodomestico al carrito"
            case 12:
                //elegir entre las secciones
                addItem();

                break;

            //13. Pagar Compra
            case 13:
                //identificar al cliente o solicitar alta 
                break;

            //Crear carrito aleatorio
        }
        return false;
    }
    //intervinient
    //role (clasgetname)

    private double getTotalAmount() {

        return shoppingcart.getTotalAmount();

    }

    private void addItem() {
        shoppingcart.addItem((String) "ITEMCODE", (Double) 10.23, (byte) 2);
    }

    private void queryShoppingCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fecha:" + shoppingcart.getSalesDate());

        System.out.println("LINE           CODE                 PRICE            AMOUNT    TOTAL ");

        shoppingcart.getItems().forEach((Shoppingcart.Line line) -> {
            System.out.println(line.getLineNumber() + line.getItemCode() + line.getPrice() + line.getAmount() + (line.getPrice() * line.getAmount()));

        });

        System.out.println("TOTAL AMOUNT:" + getTotalAmount());

        String a = scanner.nextLine();

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
