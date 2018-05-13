/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DataBase.TextDatabase;
import Person.Client.Client;
import Person.Employee.Employee;
import Utils.Menu.MenuNode;
import Utils.Record.Record;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ashh412
 */
//Facturas y ordenes de reparacion
public abstract class OperationsManager extends TextDatabase implements Imanager<Record, MenuNode> {

    private HashMap<String, Record> records = new HashMap<>();
    Client client;
    Employee employee;
    final ClientManager clientManager;
    final StockManager stockManager;

    protected OperationsManager(ClientManager clientManager, StockManager stockManager) {
        this.clientManager = clientManager;
        this.stockManager = stockManager;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

    }

    /**
     *
     * @param node
     * @return
     */
    protected MenuNode callMainMenu(MenuNode node) {

        while (node.getParent() != null) {
            node = node.getParent();
        }
        return node;
    }

    //Extension de database
    //Guardamos
//    public void save() {
//        save(records);
//    }

    /**
     *
     * @return
     */
    public int size() {
        return records.size();
    }

    /**
     *
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Record> getAll() {
        return records;
    }

    @Override
    public void update(MenuNode e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Record e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Record record) {

        if (records.containsKey(record.getOperCode())) {
            System.out.println("No se puede introducir el registro. El código esta repetido.");
            return false;
        }
        try {
            //Agregamos  al hasmap
            records.put(record.getOperCode(), record);
            return true;

        } catch (Exception e) {
            System.out.println("No se puede introducir el registro. Ha habido un error.");
            return false;
        }

    }
    //Propósito: Listar 
    private void printHeader() {
        System.out.printf("%-25s%-15s%-15s%-25s%-20s%n", "OPERACION", "CLIENTE", "EMPLEADO", "FECHA", "ESTADO");
 
    }

    @Override
    public void print(Record record) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.printf("%-25s%-15S%-15S%-25s%-20s\n", record.getOperCode(), record.getCliCode(), record.getEmpCode(), dateFormat.format(record.getDate()), record.getStatus());
    }

    /**
     *
     * @return
     */
    public Record generateRandomOperation() {
        return null;

//        Person person;
//
//        person = new Client(PersonGenerator.generateDni());
//
//        person.setFirstName(PersonGenerator.generateName());
//        person.setSalary(1000D);
//        return person;
    }

    //Propósito: 
    //Buscar la clave en el HashMapy devolver el objeto si existe
    /**
     *
     * @param e
     * @return
     */
    public Record searchRecord(String e) {

        if (records.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return records.get(e);
        }
        return null;

    }

    //Carga de ficheros
    /**
     *
     */
    public void load() {
        records = load(getClassName().replace("Manager", ""));//Pasamos el nombre del fichero   
    }

    @Override
    public HashMap<String, Record> load(String filename) {
        records = super.load(filename);
        return records;//Pasamos el nombre del fichero
    }

    //Extension de database
    //Guardamos
    /**
     *
     */
    public void save() {
        save(records);
    }

//
//    @Override
//    public void update(Node node) {
//
////        Record record = search(node);
////
////        if (record != null) {
////            ArrayList<String> nodesData = node.convertTreeChildToListIdx();
////            int i = 0;
////
////            person.setFirstName(nodesData.get(i++));
////            person.setLastName(nodesData.get(i++));
////            person.setSalary(Double.valueOf(nodesData.get(i++)));
////            //Guardar los datos 
////            save();
//
//  
//    @Override
//    public Record createObject(Node node) throws IOException {
//        Record record = null;
//        String operCode = null;
//        String cliCode = null;;
//        String empCode = null;;
//        Date date;
//        ShoppingCart shoppingCart;
//
//        if (node.getLabel().equals("SELL")) {
//
//            operCode = "INVOICE".concat(String.valueOf(getSequence()));
//            List list = node.getList();
//
//            shoppingCart = (ShoppingCart) list.get(0);
//            
//            operCode = node.getChildNodes().get(0).getLabel();
//            empCode = node.getChildNodes().get(1).getLabel();
//            date = getDate();
//            record = new SalesRecord(operCode, cliCode, empCode, date, shoppingCart);
//        }
//
//        if (node.getLabel().equals("REPAIR")) {
//
//            List list = node.getList();
//
//            shoppingCart = (ShoppingCart) list.get(0);
//            cliCode = node.getChildNodes().get(1).getLabel();
//            empCode = node.getChildNodes().get(2).getLabel();
//            date = getDate();
//
//        }
//        add(record);
//        save();
//
//        return record;
//
//    }
    /**
     *
     * @return
     */
    public int getSequence() {
        return records.size();

    }

    @Override
    public void list() {

        Iterator<Map.Entry<String, Record>> it = records.entrySet().iterator();

        printHeader();
        while (it.hasNext()) {
            print(it.next().getValue());
        }
        clearScreen();
    }

    @Override
    public Record search(MenuNode node, StringBuilder outString) {

        outString.append(node.getChildNodes().get(0).getResponse());
        Record record = searchRecord(outString.toString());
        if (record != null) {
            return record;
        }
        return null;

    }
    
     public Record searchThisNode(MenuNode node, StringBuilder outString) {

        outString.append(node.getResponse());
        Record record = searchRecord(outString.toString());
        if (record != null) {
            return record;
        }
        return null;

    }
    
    
}
