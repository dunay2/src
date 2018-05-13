/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;
 
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.Record.Finance;
import Utils.Record.Record;
import Utils.Record.Sale;
import Utils.ShoppingCart;
import item.Electrodomestic;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ashh412
 */
public class FinanceManager extends OperationsManager {

    final SaleManager saleManager;

    private String operCode = "finance ".concat(String.valueOf(size()));

    private static FinanceManager instance = null;    //Singleton  Pattern

    /**
     *
     * @param rollNo
     * @return
     */
    //Singleton Singleton Pattern
    /**
     *
     * @param clientManager
     * @param saleManager
     * @param stockManager
     */
    protected FinanceManager(ClientManager clientManager, SaleManager saleManager, StockManager stockManager) {
        super(clientManager, stockManager);

        this.saleManager = saleManager;

    }

//Singleton Singleton Pattern
    /**
     *
     * @param clientManager
     * @param saleManager
     * @param stockManager
     * @return
     */
    public static FinanceManager getInstance(ClientManager clientManager, SaleManager saleManager, StockManager stockManager) {
        if (instance == null) {
            instance = new FinanceManager(clientManager, saleManager, stockManager);
        }
        return instance;
    }

    @Override
    public Record createObject(MenuNode[] node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Sale startFinanceProcess(MenuNode[] enode) {

        Sale sale;
        StringBuilder outString;
        outString = new StringBuilder();
        MenuNode node = enode[0];
        byte fperiod;
        int i = 2;
        client = (Client) clientManager.search(node, outString);

        if (client == null) {
            System.out.println("El cliente no existe");
            TextInterface.pressKey();
            return null;
        }

        outString.setLength(0);

        sale = (Sale) saleManager.searchThisNode(node.getChildNodes().get(1), outString);
        if (sale == null || (!sale.getStatus().equals("W"))) {
            System.out.println("No se encuentra la factura a financiar");
            TextInterface.pressKey();
            return null;
        }

        ArrayList<String> nodesData = node.convertTreeChildToListIdxFrom(i);
        i = 0;
        client.setSalary(Double.valueOf(nodesData.get(i++)));

        fperiod = Byte.valueOf(nodesData.get(i++));
        Finance finance;
        if (finance(client.getSalary(), sale.getTotalAmount(), fperiod)) {
            sale.setStatus("A");
            finance = new Finance(sale.getOperCode() , client.getDni(), employee.getDni(), true);

        } else {
            finance = new Finance(sale.getOperCode(), client.getDni(), employee.getDni(), false);
            sale.setStatus("I");
        }
        changeOperStatus(sale.getOperCode(), sale.getStatus());

        client.addOperation(finance);

        add(finance);
        save();

        return sale;

    }

    private void changeOperStatus(String operCode, String newStatus) {

        Iterator<Record> it = client.getOperations().iterator();

        while (it.hasNext()) {

            Record record = (Record) it.next();
            if (record.getOperCode().equals(operCode)) {
                record.setStatus(newStatus);
            }
        }
    }

    /**
     *
     * @param enode
     *
     * @return
     */
    @Override
    public boolean handleProcess(MenuNode[] enode
    ) {
        MenuNode node = enode[0];

        switch (node.getValue()) {

            //Financiar
            case 6:
                Sale sale;
                sale = startFinanceProcess(enode);
                if (sale != null) {
                    if (sale.getStatus().equals("A")) {
                        System.out.println("La factura ha sido financiada");
                    }

                    if (sale.getStatus().equals("I")) {
                        System.out.println("No se ha podido aprobar la financiación");
                        transactionCancel(sale);

                    }
                }
                saleManager.save();
                stockManager.refresh();
                clientManager.save();
                save();
                  TextInterface.pressKey();
                return true;

        }
        return false;//Profundiza
    }
    //            • Financiación (financiación): El empleado de la oficina
    //            de financiación recibirá clientes que previamente hayan pasado por la 
    //            línea de cajas para comprar productos y analizará la ficha de financiación. 
    //            Solicitará la última nómina al cliente, dejando constancia de la cantidad
    //            en la ficha del cliente y en caso de que el cargo
    //            mensual no supere el 15% de la nómina en un máximo de financiación de 60 meses, la financiación se aprobará.

    private boolean finance(double salCli, double financedAmount, byte financedPeriod) {

        if (financedPeriod > 60) {
            return false;
        }

        return (salCli * 15 / 100) >= (financedAmount / financedPeriod);
    }

    private void transactionCancel(Sale sale) {
        ShoppingCart shoppingCart;

        shoppingCart = sale.getShoppingCart();

        returnItems(shoppingCart);

    }

    private void returnItems(ShoppingCart shoppingCart) {
//Buscamos la referencia del artículo en las líneas
        shoppingCart.getItems().forEach(line -> {
            //
            Electrodomestic electrodomestic = stockManager.searchElectrodomestic(line.getItemCode());

            electrodomestic.setQuantity(electrodomestic.getQuantity() + line.getAmount());

            line.getReferences().forEach((k, v) -> line.getReferences().put(k, "I"));

        });

    }

    private void setInvoiceNumber() {
        operCode = "FIN0000".concat(String.valueOf(size()));
    }

    private String getInvoiceNumber() {
     
     
        
        return operCode;
    }

}
