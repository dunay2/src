/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DataBase.TextDatabase;
import Person.Client.Client;
import Person.Employee.Cashier;
import Utils.Node;
import ishop.Shoppingcart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ashh412
 */
public class SalesManager extends TextDatabase implements Imanager<Shoppingcart> {

    private Client client;//Lo declaramos como objeto para poder usar sus métodos
    private Cashier cashier;//Lo declaramos como objeto para poder usar sus métodos
    private final Shoppingcart shoppingcart;
    private final HashMap<String, Shoppingcart> history = new HashMap<>();

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

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
    public boolean add(Shoppingcart shoppingcart) {

//        if (history.containsKey(person.())) {
//            System.out.println("No se puede introducir la persona. El código esta repetido.");
//            return false;
//        }
        try {
            //Agregamos el carrito al hasmap
            history.put("random code", shoppingcart);
            return true;

        } catch (Exception e) {
            System.out.println("Ha habido un error.");
            return false;
        }

    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Shoppingcart createObject(Node node) throws IOException {

//Guardamos la compra en la coleccion
        add(shoppingcart);
        //Guardar los datos 
        save(history);

        return shoppingcart;
    }

    @Override
    public boolean handleProcess(Node node) {

        switch (node.getValue()) {

            //Consultar el importe actual
            case 11:
                queryShoppingCart();
                return true;
            //"12. Añadir electrodomestico al carrito"
            case 12:

                addItem(node);
                return true;
            //break;
            //13. Cobrar Compra
            case 13:
                //identificar al cliente o solicitar alta 
                //  addItem();
                //return true;
                break;
            //Crear carrito aleatorio

            //Cancelar venta
            case 14:
                return true;
        }
        return false;//Profundiza
    }
    //intervinient
    //role (clasgetname)

    private double getTotalAmount() {

        return shoppingcart.getTotalAmount();

    }

    private void addItem(Node node) {
        //shoppingcart.addItem((String) "ITEMCODE", (Double) 10.23, (byte) 2);
        ArrayList<String> nodesData = node.convertTreeChildToList();

        int i = 0;
        //shoppingcart.addItem(nodesData.get(i++), Double.parseDouble(nodesData.get(i++)), Byte.parseByte(nodesData.get(i++)));
        shoppingcart.addItem(nodesData.get(i++), (Double) 10.23, Byte.parseByte(nodesData.get(i++)));

    }

    private void queryShoppingCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fecha:" + shoppingcart.getSalesDate());

        System.out.println("LINE           CODE                 PRICE            AMOUNT    TOTAL ");
        if (!shoppingcart.getItems().isEmpty()) {
            if (shoppingcart.getItems().size() > 0) {
                shoppingcart.getItems().forEach((Shoppingcart.Line line) -> {

                    String s = line.getLineNumber() + " ";
                    s = s.concat(line.getItemCode().concat(" "));
                    s = s.concat(String.valueOf(line.getPrice()).concat(" "));
                    s = s.concat(String.valueOf(line.getAmount()).concat(" "));
                    s = s.concat(String.valueOf(line.getPrice() * line.getAmount()));

                    System.out.println(s);

                });
            }
        }

        System.out.println("TOTAL AMOUNT:" + getTotalAmount() + " Pulse una tecla");

        String a = scanner.nextLine();

    }

    @Override
    public void update(Shoppingcart e) {
        Byte i = 1;

        e.addItem("", 0, i);

        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Shoppingcart e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Shoppingcart search(String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
