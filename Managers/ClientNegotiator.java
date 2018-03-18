package Managers;

import Person.Person;

public class ClientNegotiator {

    private Person person;

    private Person person2;

    public void stablishNegotiator() {
    }

    public void stopNegotiation() {
    }

    public Person ClientNegotiator(Person person, Person person2, String negotiationType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void generateTicket() {
    }

    public void checkCompraMultiple() {
    }
}


/*
public class Tienda {
 
    String nombrePr;
    int stock;
    int precio;
 
 /*   public Tienda() {
        solicitarNombrePro();
        solicitarStockPro();
        solicitarPrecioPro();
    }
 
  /*  public static int solicitarProductos() {
      
        int numeroPro;
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("Â¿Cuantos productos desea dar de Alta?");
 
        numeroPro = teclado.nextInt();
        return numeroPro;
    }
 /*  public void solicitarNombrePro(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("------Producto--------");
        System.out.println("Introduce el nombre del producto: ");
        nombrePr = teclado.nextLine();
    }
 
 /*   public void solicitarStockPro(){
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("Introduce el stock de: " + devolverNombre() + " : ");
        stock = teclado.nextInt();
    }
 
  /*  public void solicitarPrecioPro(){
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("Introduce el precio de: " + devolverNombre() + " : ");
        precio = teclado.nextInt();
    }
 
    public String devolverNombre(){
        return nombrePr;
    }
    public int devolverPrecio(){
        return precio;
    }
    public int devolverStok(){
        return stock;
    }
/*    public void modificarStock(int sto){
        stock = stock -sto;
        System.out.println("Venta realizada.");
    }
  /*  public boolean quedaStock(int sto){
 
        if (stock >= sto) {
 
            return true;
 
        } else {
 
            System.err.println("Error. Quedan " + stock + " unidades");
 
            return false;
        }
    }
    /*
    public static void menuEntrada (ArrayList <Tienda> productos) {
        int opcion;
 
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("+++ Supermecado \" Don Botellon \" +++++");
            System.out.println("");
            System.out.println("Pulse 1 para acceso al Menu de Altas de productos");
            System.out.println("Pulse 2 para acceder al Menu de Ventas");
            System.out.println("Pulse 3 para salir ");
            opcion = teclado.nextInt();
 
            switch (opcion) {
                case 1: {
                    menuProductos(productos);
                    break;
                }
                case 2: {
                    menuVentas(productos);
                    break;
                }
                case 3: {
                    System.out.println("Gracias!!! por usar el programa");
                    break;
                }
                default: {
                    System.out.println("Error");
                    break;
                }
            }
 
        } while (opcion != 3);
 
 
    }
 /*
    public static void menuProductos(ArrayList<Tienda> productos) {
        String respuesta = "no";
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("- Menu de altas de Productos -");
 
            productos.add(new Tienda());
 
            System.out.println("Â¿Desea dar de alta Otro Producto?");
            respuesta = teclado.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));
 
    }
 
 /*   public static void menuVentas(ArrayList<Tienda> productos) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int unidades=0;
        String respuesta;
        double factura = 0;
        do {
            System.out.println("--Menu de venta de productos--");
            System.out.println("");
 
            for (int i = 0; i < productos.size(); i++) {
                System.out.println("Puse " + i + " Para comprar " + productos.get(i).devolverNombre() + " cuyo precio es de " + productos.get(i).devolverPrecio() + " y el stock es de " + productos.get(i).devolverStok() + " unidades");
            }
 
            opcion = teclado.nextInt();
 
            System.out.println("Ha elegido comprar " + productos.get(opcion).devolverNombre());
 
            for (int i = opcion; i < productos.size(); i++) {
 
                unidades = unidades(productos);
 
                if (productos.get(i).quedaStock(unidades) == true) {
                    productos.get(i).modificarStock(unidades);
                     unidades = unidades * productos.get(i).devolverPrecio();
                }
                break;
            }
 
            factura = factura + unidades;
 
            System.out.println("Â¿Desea comprar otro producto?(si/no)");
            respuesta = teclado.next();
 
        } while (respuesta.equalsIgnoreCase("si"));
 
        System.out.println("El total de su compra es: " + factura + "â‚¬");
 
    }
 
  /*  public static int unidades(ArrayList<Tienda> productos) {
        Scanner teclado = new Scanner(System.in);
        int unidades;
 
        System.out.println("Â¿Cuantas unidades quieres?");
        unidades = teclado.nextInt();
 
        return unidades;
    }
 */
 /*
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
 
        ArrayList<Tienda> productos = new ArrayList<>();
 
        menuEntrada(productos);
 
    }
 
}
 */
/**
 * Esta es una pequeña aplicación para realizar ventas de productos de una
 * tiendita de computadoras
 *
 * @author Humberto
 * @version 25 / 11 / 11
 */
/*public class ArregloBidimensional
{
    /* El lector de caracteres */
 /*   static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        

        /* Arreglo de cadenas que contiene nombres de los productos */
 /*   String nombres [] = {"Laptop   ", "Mouse   ", "Teclado ", "Pantalla"};
        
        /* Arreglo bidimensional con los precios y las existencias de los productos, en el mismo orden que los nombres */
 /*     int productos [][] = {{15000,5},
                              {500,5},
                              {300,5},
                              {3000,5}};

        /* Opcion elegida del menu */
 /*    int opcion;        
        
        /* Total de ventas */
  /*      int ventas = 0;
                                         
        do {
            opcion = lee_opcion_menu();        
        
            switch (opcion) {
                case 1:
                    listar_productos(nombres, productos);
                    break;                
                case 2:
                    ventas = vender_productos(nombres, productos) + ventas;
                    break;                
                case 3:
                    mostrar_total_de_ventas(ventas);
                    break;                

                }
        } while (opcion != 0);
        
        System.out.println("Gracias por sus compras!");
        
    }
  */
