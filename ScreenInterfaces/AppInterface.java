package ScreenInterfaces;

//Autor: DRS
import Utils.MenuMessage;
import Utils.Node;

public abstract class AppInterface implements IInterface {

    private final Node node = new Node(0, null, "Menú principal");
    private final MenuMessage m = new MenuMessage();

//Agregar el menu principal
    private void mnuMain(Node node) {

        String mnuText[] = MenuMessage.getMenu("mnuMain");

        for (int i = 1; i < mnuText.length; i++) {
            node.addChild(new Node(i, node, mnuText[i - 1]));
        }
        node.addChild(new Node(0, node, mnuText[mnuText.length - 1]));
        //Agregamos los elementos de menú hijos

        //Realizar una transaccion
        mnuTransaction(node.getChildNodes().get(0), 10); //venta
        //Gestionar clientes
        mnuHndClient(node.getChildNodes().get(1), 20);
        //Stock
        mnuAddGeneric(node.getChildNodes().get(2), "Item", 30);
        //Empleados
        mnuAddGeneric(node.getChildNodes().get(3), "Employee", 40);

    }

    //Agregar las ramas de menú segun el rol del usuario
    @Override
    public void addInputMenu(Node node, String mnuCode) {

        String text[] = MenuMessage.getMenu(mnuCode);

        for (String textStr : text) {
            //Se pide un dato al usuario
            Node childNode = new Node(-5, node, textStr);
            childNode.isInput(true);
            node.addChild(childNode);
        }

    }

    private void mnuAddItem(Node node) {
        setInputMenu(node, "mnuAddItem");
    }

    private void setInputMenu(Node node, String s) {
    }

    private void mnuAddEmployee(Node node) {
        setInputMenu(node, "mnuAddEmployee");
    }

    private void mnuSearchItem(Node node) {
        setInputMenu(node, "mnuSearchItem");
    }

    private void mnuSearchClient(Node node) {
        setInputMenu(node, "mnuSearchClient");
    }

    private void mnuItemSection(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuItemSection"), mnuIndex);
    }

    private void mnuBuying(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuBuying"), mnuIndex);
    }

    private void mnuHndClient(Node node, int mnuIndex) {
        mnuAddGeneric(node, "Client", 20);
    }

    private void mnuPaymentType(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuPaymentType"), mnuIndex);
    }

    private void mnuTransaction(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuTransaction"), mnuIndex);
        //Hijos de consultar importe
        addMenu(node.getChildNodes().get(0), MenuMessage.getMenu("mnuBuying"), mnuIndex);
        //Agregar un item al carrito 
        addInputMenu(node.getChildNodes().get(1), "mnuAddItemToCart");
        //Cobrar
        mnuPay(node.getChildNodes().get(2),mnuIndex);

        //node.getChildNodes().get(2).getChildNodes().get(1).isTail(true);
        // addMenu(), MenuMessage.getMenu("mnuAddItemToCart"), mnuIndex);
    }

    private void mnuPay(Node node, int mnuIndex) {

        addInputMenu(node, "mnuAddClient");
        addMenu(node, MenuMessage.getMenu("mnuPaymentType"), mnuIndex);
   
    }

    private void mnuAddGeneric(Node node, String textGeneric, int mnuIndex) {

        String mnuText[] = MenuMessage.getMenu("mnuGenericABMS");

        for (int i = 1; i < mnuText.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, mnuText[i - 1]));
        }
        addInputMenu(node.getChildNodes().get(0), "mnuAdd" + textGeneric);//Menu agregar
        addInputMenu(node.getChildNodes().get(1), "mnuEdit" + textGeneric);//Menu Editar
        addInputMenu(node.getChildNodes().get(2), "mnuDelete" + textGeneric);//Menu Eliminar
        addInputMenu(node.getChildNodes().get(5), "mnuSearch" + textGeneric);//Menu Buscar
        //Volver
        Node lnode = new Node(mnuIndex + mnuText.length, node, mnuText[mnuText.length - 1]);
        lnode.isTail(true);
        node.addChild(lnode);

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
       
    }

    @Override
    public void addMenu(Node node, String[] mnuText, int mnuIndex) {
        for (int i = 1; i <= mnuText.length - 1; i++) {
            node.addChild(new Node(mnuIndex + i, node, mnuText[i - 1]));
        }
        Node lnode = new Node(mnuIndex + mnuText.length, node, mnuText[mnuText.length - 1]);
        lnode.isTail(true);
        node.addChild(lnode);
    }
}
