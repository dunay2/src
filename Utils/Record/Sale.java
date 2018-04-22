/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Record;

import Utils.ShoppingCart;

/**
 *
 * @author ashh412
 */
public class Sale extends Record {

    private ShoppingCart shoppingcart = null;//Lo guardamos para serializar el carrito

    public Sale(String operCode, String cliCode, String empCode, ShoppingCart shoppingcart) {
        super(operCode, cliCode, empCode);
        this.shoppingcart = shoppingcart;
    }

}
