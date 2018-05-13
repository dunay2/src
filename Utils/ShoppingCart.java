/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ashh412
 */
public class ShoppingCart implements Serializable {

    private String invoiceCode;
    private LocalDateTime salesDate;//Fecha de compra
    private double totalAmount = 0; // Precio de la compra
    private byte lineNumber;//Control de entradas en el carrito

    private ArrayList<Line> items;

    /**
     *
     */
    public ShoppingCart() {

        items = new ArrayList();

        //establecer la fecha por defecto 
        this.salesDate = LocalDateTime.now();
    }

    /**
     * En el shopping cart los items son líneas(con un código), no
     * electrodomesticos // Es una lista poco extensa a la que podemos acceder
     * por indice //No hay que realizar búsquedas y el acceso a elementos es
     * directo
     *
     */
    public class Line implements Serializable {//Estructura privada que contiene el pedido

        private String invoiceCode;
        private byte lineNumber;
        private String itemCode;
        private int amount; //cantidad de items
        private double price;
        private final HashMap<String, String> references = new HashMap<>();

        /**
         * @param invoiceCode*******************************/
        
        public void Line(String invoiceCode) {

            this.invoiceCode = invoiceCode;
        }

        
        
        public String getInvoiceCode() {
            return invoiceCode;
        }

        public void setInvoiceCode(String invoiceCode) {
            this.invoiceCode = invoiceCode;
        }

        //Creamos una referencia única para cada elemento en el carrito
        public void addReference() {

            String RefInvoice=invoiceCode.concat("-");
            
            references.put( RefInvoice.concat( String.valueOf(lineNumber).concat(itemCode).concat(String.valueOf(references.size()))), "A");

        }

        public HashMap<String, String> getReferences() {
            return references;
        }

        /**
         *
         * @return
         */
        public byte getLineNumber() {
            return lineNumber;
        }

        /**
         *
         * @param lineNumber
         */
        public void setLineNumber(byte lineNumber) {
            this.lineNumber = lineNumber;
        }

        /**
         * Devuelve el código de producto
         *
         * @return
         */
        public String getItemCode() {
            return itemCode;
        }

        /**
         *
         * @param itemCode
         */
        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        /**
         *
         * @return
         */
        public int getAmount() {
            return amount;
        }

        /**
         *
         * @param amount
         */
        public void setAmount(int amount) {
            this.amount = amount;
        }

        /**
         *
         * @return
         */
        public double getPrice() {
            return price;
        }

        /**
         *
         * @param price
         */
        public void setPrice(double price) {
            this.price = price;
        }
    }
////fin de Line
//////////////    

    /**
     *
     * @return
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     *
     * @param invoiceCode
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getSalesDate() {
        return salesDate;
    }

    /**
     *
     * @param salesDate
     */
    public void setSalesDate(LocalDateTime salesDate) {
        this.salesDate = salesDate;
    }

    /**
     *
     * @return
     */
    public ArrayList<Line> getItems() {
        return items;
    }

    /**
     *
     * @param lines
     */
    public void setItems(ArrayList<Line> lines) {
        this.items = lines;
    }

    /**
     *
     * @return
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     *
     * @param totalAmount
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     *
     * @param invoiceCode
     * @param itemCode
     * @param itemPrice
     * @param amount
     */
    public void addItem(String invoiceCode,String itemCode, double itemPrice, int amount) {
        Line line = new Line();

        line.setLineNumber(this.lineNumber++);
        line.setItemCode(itemCode);
        line.setPrice(itemPrice);
        line.setAmount(amount);
        line.setInvoiceCode(invoiceCode);
        
        for (int i = 0; i < amount; i++) {
            line.addReference();
        }

        items.add(line);

        totalAmount = totalAmount + line.price * line.amount;
    }

    /**
     *
     * @param lineNumber
     */
    public void removeItem(int lineNumber) {

        Line line = items.get(lineNumber);

        items.remove(line);
        totalAmount = totalAmount - line.price * line.amount;

    }

}
