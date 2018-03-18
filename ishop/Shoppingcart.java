/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ishop;

import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class Shoppingcart {
    private double totalAmount=0;
    private ArrayList<Object> items; 

    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void addItem (Object item)
    {
    items.add(item);
    totalAmount= totalAmount +1;
    }
    
    public void removeItem (Object item)
    {
    items.remove(item);
     totalAmount= totalAmount -1;
    }
    
}
