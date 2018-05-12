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
    private final String paymentType;
    //E EFECTIVO
    //T TARJETA
    //W FINANCIADO

    /**
     *
     * @param operCode
     * @param cliCode
     * @param empCode
     * @param shoppingCart
     * @param paymentType
     */
    public Sale(String operCode, String cliCode, String empCode, ShoppingCart shoppingCart, String paymentType) {
        super(operCode, cliCode, empCode,"S");
        this.shoppingCart = shoppingCart;
        this.shoppingCart.setInvoiceCode(operCode);
        this.paymentType = paymentType;
        
        if (paymentType.equals("W")) {
            super.setStatus("W");
        }
    }

    public String getPaymentType() {
        return paymentType;
    }

    
    
    /**
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    
    private ShoppingCart shoppingCart = null;//Lo guardamos para serializar el carrito

}
