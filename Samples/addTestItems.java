/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samples;

import Item.Family.Computers.Components.Keyboard;
import Item.Family.Computers.Components.Memory;
import Item.Family.Computers.Components.Mouse;
import Item.Family.Computers.Components.Printer;
import Item.Family.Computers.Components.Procesor;
import Managers.StockManager;
import item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class addTestItems {
    
    private static StockManager stockManager;
    
    public void addTestItems() {
        //Obtenemos una instancia a los gestores

    }

    /**
     *
     */
    public static void addComponents() {
        
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
        pr.setGuaranty("2 año"); //Garantía
        pr.setBoughtPrice(41.23); // precio de compra
        pr.setSellPrice(99.90); // precio de venta

        pr.setQuantity(5); // stock
        stockManager.add(pr);
        
        Memory me = new Memory("N71VN");//Código artículoº
        me.setName("Memoria"); //Nombre
        me.setBrand("ASUS"); //Marca
        me.setDescription("N71VN DDR3 2GB"); //descripción
        me.setGuaranty("2 año"); //Garantía
        me.setBoughtPrice(9.07); // precio de compra
        me.setSellPrice(17.51); // precio de venta
        me.setCapacity("2GB");
        me.setQuantity(5); // stock
        stockManager.add(me);
        
        stockManager.save(stockManager.getAll());
        
    }
    
}
