/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DataBase.TextDatabase;
import ScreenInterfaces.TextInterface;
import Utils.Node;
import item.Electrodomestic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ashh412 Propósito: hacer de gestor clase Items Extiende la clase
 * TextDatabase lo que le da persistencia
 *
 */
public class StockManager extends TextDatabase implements Imanager<Electrodomestic, Node> {

    private HashMap<String, Electrodomestic> electrodomestics = new HashMap<>();

    private static StockManager instance = null;    //Singleton Singleton Pattern

    //Singleton Singleton Pattern
    protected StockManager() {
        // Exists only to defeat instantiation.
    }
    //Singleton Singleton Pattern

    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    public void buyItems(String itemCode, int amount) {

    }

    public void save() {

        super.save(electrodomestics);
    }

//Devuelve todo el listado de Electrodomestic
    @Override
    public HashMap<String, Electrodomestic> getAll() {

        return electrodomestics;
    }

    //Propósito: Cargar el HM con el stock
    public void load() {

        electrodomestics = super.load("Electrodomestic");
    }

    @Override
    public boolean handleProcess(Node[] enode) {
        Node node = enode[0];

        switch (node.getValue()) {
            //31. Agregar Item a Stock
            case 31: {
                createObject(enode);
            }
            return true;
            //32. Modificar Item Stock
            case 32:
                update(node);
                return true;
            //33. Eliminar Item Stock
            case 33:
                break;
            //34. Listar eletrodomésticos
            case 34:
                list();
                return true;
            //Crear electrodoméstico aleatorio
            //case 25:
            // createRandomClient();
            //  a = scanner.nextLine();
            //return true;
            }
        return false;

    }

    ///////////////////////////////////////////////////
    //Propósito: crear un nuevo electrodoméstico con los datos de entrada de consola
    @Override
    public Electrodomestic createObject(Node[] enode) {
        Node node = enode[0];
        int i = 0;
        //Convertimos los nodos en parametros
        ArrayList<String> nodesData = node.convertTreeChildToList();

        Electrodomestic item = new Electrodomestic(nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), Double.parseDouble(nodesData.get(i++)), Double.parseDouble(nodesData.get(i++)), Integer.parseInt(nodesData.get(i++)));

        add(item);
        //Guardar los datos 

        save();

        return item;
    }

    //Propósito: 
    //Buscar la clave en el HashMapy devolver el objeto si existe
    @Override
    public Electrodomestic search(Node node, StringBuilder outString) {

        Electrodomestic electrodomestic = searchElectrodomestic(node.getChildNodes().get(0).getResponse());
        if (electrodomestic != null) {

            return electrodomestic;

        }
        return null;

    }

    public void print(Electrodomestic e) {
        printHeader();
        listFormat(e);
    }

    private void printHeader() {
        System.out.printf("%-20s%-20s%-40s%-20s%-20s%-20s\n", "CODIGO", "NOMBRE", "DESCRIPCION", "PRECIO COMPRA", "PRECIO VENTA", "UNIDADES");
    }

    private Electrodomestic searchElectrodomestic(String e) {
        if (electrodomestics.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return electrodomestics.get(e);
        }
        return null;
    }

    @Override
    public void delete(Electrodomestic e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Electrodomestic item) {

        if (electrodomestics.containsKey(item.getCode())) {
            System.out.println("No se puede introducir el electrodomestico. El código esta repetido.");
            return false;
        }

        try {
            //Agregamos una electrodoméstico al hasmap
            electrodomestics.put(item.getCode(), item);
            return true;

        } catch (Exception e) {
            System.out.println("No se puede introducir el electrodoméstico. Ha habido un error.");
            return false;
        }

    }

//    public class Test {
//
//        public String var1;
//        public Integer var2;
//    }
//
//    public class Test2 {
//
//        Test2(String[] args) throws Exception {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("var1", "test");
//            map.put("var2", 1);
//
//            Test t = new Test();
//
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                Field f = Test.class.getField(entry.getKey());
//
//                f.set(t, f.getType().cast(entry.getValue()));
//            }
//
//            System.out.println(t.var1);
//            System.out.println(t.var2);
//        }
//    }
    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* Display content using Iterator*/
//        Set set = hmap.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry) iterator.next();
//            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
//            System.out.println(mentry.getValue());
//        }
//
//        /* Get values based on key*/
//        String var = hmap.get(2);
//        System.out.println("Value at index 2 is: " + var);
//
//        /* Remove values based on key*/
//        hmap.remove(3);
//        System.out.println("Map key and values after removal:");
//        Set set2 = hmap.entrySet();
//        Iterator iterator2 = set2.iterator();
//        while (iterator2.hasNext()) {
//            Map.Entry mentry2 = (Map.Entry) iterator2.next();
//            System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
//            System.out.println(mentry2.getValue());
//        }
    // }
    //propósito: leer los datos introducidos por consola
    @Override
    public void update(Node node) {
        StringBuilder outString = null;
        Electrodomestic electrodomestic = search(node, outString);

        if (electrodomestic != null) {
            ArrayList<String> nodesData = node.convertTreeChildToListIdx();
            int i = 0;
//electrodomestic
            electrodomestic.setName(nodesData.get(i++));
            electrodomestic.setDescription(nodesData.get(i++));
            electrodomestic.setBoughtPrice(Double.valueOf(nodesData.get(i++)));
            electrodomestic.setSellPrice(Double.valueOf(nodesData.get(i++)));
            electrodomestic.setQuantity(Integer.valueOf(nodesData.get(i++)));
            //Guardar los datos 

            save();
        }
    }

    //Propósito: Listar los Electrodomestic por consola
    @Override
    public void list() {

        HashMap<String, Electrodomestic> items = getAll();
        Electrodomestic item;

        Iterator<Map.Entry<String, Electrodomestic>> it = items.entrySet().iterator();
        printHeader();

        while (it.hasNext()) {
            Map.Entry<String, Electrodomestic> e = it.next();

            item = e.getValue();
            listFormat(item);
        }
        TextInterface.pressKey();
    }

    private void listFormat(Electrodomestic item) {

        System.out.printf("%-20s%-20s%-40s%-20s%-20s%-20s\n", item.getCode(), item.getName(), item.getDescription(), item.getBoughtPrice(), item.getSellPrice(), item.getQuantity());

    }
    // public void delete(Node electrodomestic) {
    //   Electrodomestic lelectrodomestic = (Electrodomestic) electrodomestic;
    // electrodomestics.remove(lelectrodomestic);
    //  System.out.println("Student: Roll No " + lperson.getfirstName() + ", deleted from database");
    //}
//   
//    public Electrodomestic generateRandomItem() {
//
//        Electrodomestic item = null;
//
//        // client = new Client(PersonGenerator.generateDni());
//        // client.setFirstName(PersonGenerator.generateName());
//        return item;
//    } private void updateStock() throws IOException {
//        //introducir el código del producto a actualizar
//        Electrodomestic electrodomestic;
//        String code;
////Control de errores
//        //  electrodomestic = (Electrodomestic) search(code);
//
//        System.out.println("Codigo==================descripción==========Cantidad======Precio Unidad");
//        //    System.out.println(electrodomestic.getCode() + "    " + electrodomestic.getName() + "  " + electrodomestic.getQuantity() + "  " + electrodomestic.getSellPrice());
//        //Modificar el stock
//        System.out.println("1. Modificar el stock");
//        //Modificar la descripción
//        System.out.println("2. Modificar el Nombre");
//        System.out.println("3. Modificar el precio de venta");
//
//        int i = readConsole();
//
////        if (electrodomestics.containsKey(code)) {
//    }
//
//   
}
