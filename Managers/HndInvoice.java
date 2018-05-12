/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Utils.Record.Sale;
import Utils.ShoppingCart;

/**
 *
 * @author ashh412
 */
public class HndInvoice {

    public HndInvoice() {
    }

    public static Sale printInvoiceRef(Sale sale) {

        //Obtenemos el carrito
        ShoppingCart shoppingCart = sale.getShoppingCart();
        
        System.out.println("Mostrando referencias de productos en la factura");
        
        //Recorremos las líneas
        shoppingCart.getItems().forEach((ShoppingCart.Line line) -> {

            line.getReferences().forEach((k, v) -> System.out.println("Referencia: " + k + " Estado:" + v));

        });

        return null;

    }

}
