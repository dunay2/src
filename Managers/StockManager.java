/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DataBase.TextDatabase;
import ScreenInterfaces.Node;
import item.Electrodomestic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412 Propósito: hacer de gestor clase Items Extiende la clase
 * TextDatabase lo que le da persistencia
 *
 */
public class StockManager extends TextDatabase implements Imanager {

    private  HashMap<String, Electrodomestic> electrodomestics = new HashMap<>();

    public void buyItems(String itemCode, int amount) {

    }

    public void save() {

        /*        public static void guardarProducto(String codigo, float precio, HashMap<String, Float> listaProductos) {
        if (listaProductos.containsKey(codigo)) {
   //         System.out.println("No se puede introducir el producto. El código esta repetido.");
     //   } else {
       //     listaProductos.put(codigo, precio);
       // }
    }*/
        save(electrodomestics);
    }



//Devuelve todo el listado de Electrodomestic
    @Override
    public HashMap<String, Electrodomestic> getAll() {

        return electrodomestics;
    }

    @Override //necesitamos el codigo del elemento, 
    //por tanto esto será string
    public void delete(Object electrodomestic) {
        Electrodomestic lelectrodomestic;
        lelectrodomestic = (Electrodomestic) electrodomestic;
        // electrodomestics.remove(lelectrodomestic);
        //  System.out.println("Student: Roll No " + lperson.getfirstName() + ", deleted from database");

    }

    @Override
    public boolean add(Object item) {
        Electrodomestic electrodomestic = (Electrodomestic) item;

        if (electrodomestics.containsKey(electrodomestic.getCode())) {
            System.out.println("No se puede introducir el electrodomestico. El código esta repetido.");
            return false;
        }

        try {
            //Agregamos una electrodoméstico al hasmap
            electrodomestics.put(electrodomestic.getCode(), electrodomestic);
            return true;

        } catch (Exception e) {
            System.out.println("No se puede introducir el electrodoméstico. Ha habido un error.");
            return false;
        }

    }

    //Propósito: 
    //Buscar la clave en el HashMapy devolver el objeto person si existe
    @Override
    public Object search(String e) {
        if (electrodomestics.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return electrodomestics.get(e);
        }
        return null;
    }

//   
    public Electrodomestic generateRandomItem() {

        Electrodomestic item = null;

        // client = new Client(PersonGenerator.generateDni());
        // client.setFirstName(PersonGenerator.generateName());
        return item;
    }

    //Propósito: Cargar el HM con el stock
    public void load() {

        System.out.println("===============Carga de Electrodomesticos");

       electrodomestics = load("Electrodomestic");
        

        Iterator<Map.Entry<String, Electrodomestic>> it = electrodomestics.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Electrodomestic> e = it.next();
            Electrodomestic item = e.getValue();

            System.out.println("nombre item " + item.getName());
        }
    }

    
    
    @Override
    public boolean handleProcess(int e) {

        try {
            Scanner scanner = new Scanner(System.in);
            String a = "";

            switch (e) {
                //31. Agregar Item a Stock
                case 31:

                    createObject();
                    return true;
                //32. Modificar Item Stock
                case 32:
                    updateStock();

                    break;
                //33. Eliminar Item Stock
                case 33:
                    break;
                //34. Listar eletrodomésticos
                case 34:
                    list();
                    a = scanner.nextLine();
                    return true;
                //Crear electrodoméstico aleatorio
                //case 25:
                // createRandomClient();
                //  a = scanner.nextLine();
                //return true;
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void updateStock() throws IOException {
        //introducir el código del producto a actualizar
        Electrodomestic electrodomestic;
        String code;

//Creamos un lector
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//Buscamos un item
        System.out.println("Por favor introduzca código");//Se pide un dato al usuario
        code = br.readLine();
//Control de errores
        electrodomestic = (Electrodomestic) search(code);

        System.out.println("Codigo==================descripción==========Cantidad======Precio Unidad");
        System.out.println(electrodomestic.getCode() + "    " + electrodomestic.getName() + "  " + electrodomestic.getQuantity() + "  " + electrodomestic.getSellPrice());
        //Modificar el stock
        System.out.println("1. Modificar el stock");
        //Modificar la descripción
        System.out.println("2. Modificar el Nombre");
        System.out.println("3. Modificar el precio de venta");

        int i = readConsole();

//        if (electrodomestics.containsKey(code)) {
    }
    //tomar

//Propósito: Listar los Electrodomestic por consola
    @Override
    public void list() {

        HashMap<String, Electrodomestic> items = new HashMap<>();
        Electrodomestic item;

        items = getAll();
        Iterator<Map.Entry<String, Electrodomestic>> it = items.entrySet().iterator();

        System.out.println("============Listado de electrodomésticos============");

        while (it.hasNext()) {
            Map.Entry<String, Electrodomestic> e = it.next();

            item = e.getValue();

            System.out.println("Name: " + item.getName());
            System.out.println("Price: " + item.getSellPrice());

        }
        System.out.println("Pulsa una tecla para continuar ...");
    }

    //Propósito: crear un nuevo electrodoméstico con los datos de entrada de consola
    @Override
    public Object createObject() throws IOException {
//ya comprobaremos el tipo
        String code;
        String name;
        String description;
        double price;
        int quantity;

//Creamos un lector
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//Creamos un item
   Node printMenu;
   
        System.out.println("Por favor introduzca código");//Se pide un dato al usuario

        //llamada a new item 
        code = br.readLine();
        System.out.println("Introduzca nombre");//Se pide un dato al usuario
        name = br.readLine();
        System.out.println("Introduzca Descripción");//Se pide un dato al usuario
        description = br.readLine();
        System.out.println("Introduzca precio de compra");//Se pide un dato al usuario
        price = Double.parseDouble(br.readLine());
        System.out.println("Introduzca cantidad en stock");//Se pide un dato al usuario
        quantity = Integer.parseInt(br.readLine());
//   
        Electrodomestic item = new Electrodomestic(code, description, price, price, quantity,"");

        //Guardamos el item en la coleccion
        add(item);
        //Guardar los datos 
        save();

        return item;
    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
    }

    //propósito: leer los datos introducidos por consola
    private int readConsole() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        return i;
    }

}
