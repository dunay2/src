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

    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    private ShoppingCart shoppingCart = null;//Lo guardamos para serializar el carrito

    public Sale(String operCode, String cliCode, String empCode, ShoppingCart shoppingCart) {
        super(operCode, cliCode, empCode);
        this.shoppingCart = shoppingCart;
    }

}
