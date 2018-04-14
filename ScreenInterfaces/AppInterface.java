package ScreenInterfaces;

//Autor: DRS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Propósito: guardar los menús de aplicación
public abstract class AppInterface implements IInterface {

    private final Node node = new Node(0, null, "Menú principal");

    @Override
    public void addmenu(Node node) {

    }

    private Node mnuAddItem(Node node) throws IOException {

        String text[] = {"Introduzca código de familia", "Introduzca código de artículo", "Introduzca nombre de artículo", "Introduzca descripción de artículo", "Introduzca precio de compra", "Introduzca precio de venta", "Introduzca cantidad en stock"};

        // public Electrodomestic(String code, String name,String description, double boughtPrice, double sellPrice, int quantity, String familyCode) {
//        String code;
//        String name;
//        String description;
//        double price;
//        int quantity;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (String textStr : text) {
            System.out.println(textStr); //Se pide un dato al usuario
            node.addChild(new Node(-5, node, textStr));

        }
        //node.addChild(new Node(0, node, 0 + text[text.length - 1]));
//
//        System.out.println("Por favor introduzca código");//Se pide un dato al usuario

        //llamada a new item 
//        code = br.readLine();
//        System.out.println("Introduzca nombre");//Se pide un dato al usuario
//        name = br.readLine();
//        System.out.println("Introduzca Descripción");//Se pide un dato al usuario
//        description = br.readLine();
//        System.out.println("Introduzca precio de compra");//Se pide un dato al usuario
//        price = Double.parseDouble(br.readLine());
//        System.out.println("Introduzca cantidad en stock");//Se pide un dato al usuario
//        quantity = Integer.parseInt(br.readLine())
        return node;
    }

    private void mnuMain(Node node) {
        // <editor-fold defaultstate="collapsed" desc=" ${Consultar Importe} ">  

        String text[] = {". Realizar una Transacción", ". Gestión de Clientes", ". Gestión de Stock", ". Gestión de Empleados", ". Salir de la aplicación"};

        for (int i = 1; i < text.length; i++) {
            node.addChild(new Node(i, node, i + text[i - 1]));
        }
        node.addChild(new Node(0, node, 0 + text[text.length - 1]));

        //Realizar una transaccion
        mnuTransaction(node.getChildNodes().get(0), 10); //venta

        //Agregamos los elementos de menú hijos
        mnuAddGeneric(node.getChildNodes().get(1), "Cliente", 20);

        mnuAddGeneric(node.getChildNodes().get(2), "Electrodoméstico", 30);

        mnuAddGeneric(node.getChildNodes().get(3), "Empleado", 40);

    }

    private void mnuTransaction(Node node, int mnuIndex) {

        String mnuText[] = {". Consultar el importe actual", ". Añadir electrodomestico al carrito", ". Pagar Compra", ". Cancelar venta"};

        for (int i = 1; i < mnuText.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + mnuText[i - 1]));
        }
        node.addChild(new Node(-1, node, mnuText.length + mnuText[mnuText.length - 1]));

        //Hijos de consultar importe
        mnuBuying(node.getChildNodes().get(0), mnuIndex * 10);

    }

    private Node mnuPaymentType(Node node, int mnuIndex) {

        String text[] = {". Efectivo", ". Tarjeta", ". Financiado", ". Cancelar venta"};

        for (int i = 1; i < text.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + text[i - 1]));
        }
        node.addChild(new Node(-1, node, text.length + text[text.length - 1]));
        return node;

    }

    private Node mnuAddGeneric(Node node, String textGeneric, int mnuIndex) {

        String mnuText[] = {". Agregar " + textGeneric, ". Actualizar " + textGeneric, ". Eliminar " + textGeneric, ". Listar " + textGeneric + "s", ". Agregar " + textGeneric + " aleatorio", ". Volver al menú principal"};

        for (int i = 1; i < mnuText.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + mnuText[i - 1]));
        }
        node.addChild(new Node(-1, node, mnuText.length + mnuText[mnuText.length - 1]));
        return node;
//si cliente...
        //<editor-fold defaultstate="collapsed" desc=" ${Agregar Cliente} ">
//            {//Tomamos una referencia al 1 elemento hijo del nodo padre 
//                childNode = childNode.getChildNodes().get(0);
//                //Agregamos los elementos de menú hijos
//                childNode.addChild(new Node(211, childNode, "1. Introducir DNI "));
//                childNode.addChild(new Node(212, childNode, "2. Introducir nombre"));
//                childNode.addChild(new Node(213, childNode, "3. Introducir apellido"));
//                childNode.addChild(new Node(214, childNode, "4. Introducir email"));
//                childNode.addChild(new Node(215, childNode, "5. Guardar"));
//                childNode.addChild(new Node(0, childNode, "6. Volver al menú principal"));
//            }
        // childNode = childNode.getParent();
        // </editor-fold> 
    }

    private Node mnuBuying(Node node, int mnuIndex) {

        String text[] = {" Seguir Comprando", ". Cancelar Compra"};

        for (int i = 0; i <= 1; i++) {
            node.addChild(new Node(i - 1, node, i + 1 + text[i]));
        }
        return node;

    }

    private Node mnuItemSection(Node node, int mnuIndex) {
        node.addChild(new Node(mnuIndex, node, "Seleccione seccion"));
        String text[] = {". PDA'S", ". Portatiles", ". Sobremesa", ". NoteBooks"};

        for (int i = 1; i <= text.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + text[i - 1]));
        }
        return node;

    }

    public AppInterface() {
        loadMenu();
    }

    public Node getNode() {
        return node;
    }

    private void loadMenu() {

        /**
         * **********************Menu principal****************************
         */
        mnuMain(node);
        // <editor-fold defaultstate="collapsed" desc=" ${Creacion Menu} ">  

        // </editor-fold> 
    }
}
