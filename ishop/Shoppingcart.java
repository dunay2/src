/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ishop;

import Person.Client.Client;
import Person.Employee.Cashier;
import item.Electrodomestic;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ashh412
 */
public class Shoppingcart {

    private Cashier cashier;
    private Client client;

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public ArrayList<Object> getItems() {
        return items;
    }

    public void setItems(ArrayList<Object> items) {
        this.items = items;
    }
    private Date salesDate;

    private double totalAmount = 0;
    private ArrayList<Object> items;

    public Shoppingcart(Cashier cashier) {
        this.cashier = cashier;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(Electrodomestic item) {
        items.add(item);
        totalAmount = totalAmount + item.getSellPrice();
    }

    public void removeItem(Electrodomestic item) {
        items.remove(item);
        totalAmount = totalAmount - item.getSellPrice();
    }

}
