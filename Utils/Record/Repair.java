/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Record;

/**
 *
 * @author ashh412
 */
public class Repair extends Record {

    String invoiceRef;
    String itemRef;

    public Repair(String operCode, String cliCode, String empCode, String invoiceRef, String itemRef) {
        super(operCode, cliCode, empCode, "R");
        this.invoiceRef = invoiceRef;
        this.itemRef = itemRef;
    }

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public String getItemRef() {
        return itemRef;
    }

}
