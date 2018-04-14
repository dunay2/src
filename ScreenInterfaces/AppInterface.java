package ScreenInterfaces;

//Autor: DRS
//Propósito: guardar los menús de aplicación
public abstract class AppInterface implements IInterface {

    private final Node node = new Node(0, null, "Menú principal");

    @Override
    public void addmenu(Node node) {

    }

    private void mnuMain(Node node) {
        // <editor-fold defaultstate="collapsed" desc=" ${Consultar Importe} ">  

        String text[] = {". Realizar una Transacción", ". Gestión de Clientes", ". Gestión de Stock", ". Salir de la aplicación"};

        for (int i = 0; i <= text.length; i++) {
            node.addChild(new Node(i + 1, node, i + 1 + text[i]));
        }

        mnuTransaction(node.getChildNodes().get(0), 10);

        //Agregamos los elementos de menú hijos
        mnuAddGeneric(node.getChildNodes().get(1), "Cliente", 10);

        mnuAddGeneric(node.getChildNodes().get(2), "Electrodoméstico", 30);

        node.addChild(new Node(text.length + 1, node, "0. Salir de la aplicación"));
    }

    private Node mnuAddGeneric(Node node, String text, int mnuIndex) {

        String string2[] = {". Agregar " + text, ". Actualizar " + text, ". Eliminar " + text, ". Listar " + text + "s", ". Agregar " + text + " aleatorio"};

        for (int i = 1; i <= string2.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + string2[i]));
        }
        node.addChild(new Node(0, node, mnuIndex + ". Volver al menú principal"));
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

    private void mnuTransaction(Node node, int mnuIndex) {

        String text[] = {". Consultar el importe actual", ". Añadir electrodomestico al carrito", ". Pagar Compra"};

        for (int i = 1; i <= text.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + text[i - 1]));
        }
        //Hijos de consultar importe
        mnuBuying(node.getChildNodes().get(0), mnuIndex * 10);

    }

    private Node mnuItemSection(Node node, int mnuIndex) {
        node.addChild(new Node(mnuIndex, node, "Seleccione seccion"));
        String text[] = {". PDA'S", ". Portatiles", ". Sobremesa", ". NoteBooks"};

        for (int i = 1; i <= text.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, i + text[i - 1]));
        }
        return node;

    }

    private Node mnuPaymentType(Node node, int mnuIndex) {

        String text[] = {". Efectivo", ". Tarjeta", " Financiado", " Cancelar venta"};

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
        // <editor-fold defaultstate="collapsed" desc=" ${Creacion Menu} ">  
        mnuMain(node);

        // </editor-fold> 
    }
}
