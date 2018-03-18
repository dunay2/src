package ScreenInterfaces;

//Autor: DRS
//Propósito: guardar los menús de aplicación
public abstract class AppInterface implements IInterface {

    private final Node node = new Node(0, null, "Menú principal");

    @Override
    public void addmenu(Node node) {

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
        Node childNode = new Node(1, node, "1. Realizar una Transacción");
        // <editor-fold defaultstate="collapsed" desc=" ${Hijos Transacción Compra} ">  
        node.addChild(childNode);

        {  // * **************10. Realizar una Transacción**********
            childNode.addChild(new Node(11, childNode, "1. Consultar el importe actual"));
            {// <editor-fold defaultstate="collapsed" desc=" ${Consultar Importe} ">  
                childNode = childNode.getChildNodes().get(0);
                {
                    childNode.addChild(new Node(-1, childNode, "1. Seguir Comprando"));
                    childNode.addChild(new Node(0, childNode, "2. Cancelar Compra"));

                }
                childNode = childNode.getParent();
            } // </editor-fold>
            childNode.addChild(new Node(12, childNode, "2. Añadir electrodomestico al carrito"));
            childNode.addChild(new Node(13, childNode, "3. Pagar Compra"));
            // <editor-fold defaultstate="collapsed" desc=" ${Introducir forma de pago} ">  
            {
                childNode = childNode.getChildNodes().get(2);

                childNode.addChild(new Node(131, childNode, "1. Efectivo"));
                childNode.addChild(new Node(132, childNode, "2. Tarjeta"));
                childNode.addChild(new Node(133, childNode, "3. Financiado"));
                childNode.addChild(new Node(0, childNode, "4. Cancelar venta"));

                childNode = childNode.getParent();
            }
            // </editor-fold> 
            childNode.addChild(new Node(0, childNode, "4. Volver al menú principal"));
        }
        // </editor-fold> 
        node.addChild(new Node(2, node, "2. Gestión de Clientes"));
        // <editor-fold defaultstate="collapsed" desc=" ${Hijos Gestión Clientes} ">
        {   //Tomamos una referencia al segundo elemento hijo del nodo raíz 

            childNode = node.getChildNodes().get(1);
            //Agregamos los elementos de menú hijos
            childNode.addChild(new Node(21, childNode, "1. Agregar Cliente "));
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
            childNode.addChild(new Node(22, childNode, "2. Actualizar Cliente"));
            childNode.addChild(new Node(23, childNode, "3. Eliminar Cliente"));
            childNode.addChild(new Node(24, childNode, "4. Listar Clientes"));
            childNode.addChild(new Node(25, childNode, "5. Agregar cliente aleatorio"));
            childNode.addChild(new Node(0, childNode, "6. Volver al menú principal"));
        }
        // </editor-fold>
        node.addChild(new Node(3, node, "3. Gestión de Stock"));
        // <editor-fold defaultstate="collapsed" desc=" ${Hijos Gestión Stock} ">

        childNode = node.getChildNodes().get(2);

        childNode.addChild(new Node(31, childNode, "1. Agregar Item a Stock"));
        childNode.addChild(new Node(32, childNode, "2. Modificar Item Stock"));
        childNode.addChild(new Node(33, childNode, "3. Eliminar Item Stock"));
        childNode.addChild(new Node(34, childNode, "4. Listar eletrodomésticos"));
        childNode.addChild(new Node(0, childNode, "5. Volver al menú principal"));
        // </editor-fold>
        node.addChild(new Node(4, node, "0. Salir de la aplicación"));
    }
}
