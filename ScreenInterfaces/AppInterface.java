package ScreenInterfaces;

//Autor: ashh412
import Utils.Menu.MenuMessage;
import Utils.Node;

public abstract class AppInterface implements IInterface {
//Nodo raíz;

    private final Node node = new Node(0, null, "Menú principal");


//Agregar el menu principal
    private void mnuMain(Node node) {

        String mnuText[] = MenuMessage.getMenu("mnuMain");
//Agregamos los elementos del nodo raíz
        for (int i = 1; i < mnuText.length; i++) {
            node.addChild(new Node(i, node, mnuText[i - 1]));
        }
        node.addChild(new Node(0, node, mnuText[mnuText.length - 1]));
        //Agregamos los elementos de menú hijos
        int mnuIndex = 0;
        //Realizar una transaccion
        mnuTransaction(node.getChildNodes().get(0), mnuIndex += 10); //venta
        //Gestionar clientes
        mnuHndClient(node.getChildNodes().get(1), mnuIndex += 10);
        //Stock
        mnuAddGeneric(node.getChildNodes().get(2), "Item", mnuIndex += 10);
        //Empleados
        mnuAddGeneric(node.getChildNodes().get(3), "Employee", mnuIndex += 10);

        addInputMenu(node.getChildNodes().get(5), "mnuCancelTransaction", mnuIndex += 10);//Menu Buscar

    }

    //Agregar las ramas de menú segun el rol del usuario
    @Override
    public void addInputMenu(Node node, String mnuCode, int mnuIndex) {

        String text[] = MenuMessage.getMenu(mnuCode);

        for (String textStr : text) {
            //Se pide un dato al usuario
            Node childNode = new Node(++mnuIndex, node, textStr);
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

    //Creación de los elementos del menú venta: nivel 1
    private void mnuTransaction(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuTransaction"), mnuIndex, true);
        //Agregamos menú a los hijos
        //Hijos de consultar importe actual
        addMenu(node.getChildNodes().get(0), MenuMessage.getMenu("mnuBuying"), (++mnuIndex) * 10, true);
        //Agregar un item al carrito 
        addInputMenu(node.getChildNodes().get(1), "mnuAddItemToCart", (++mnuIndex) * 10);

        //Cobrar
        mnuPay(node.getChildNodes().get(2), (++mnuIndex * 10));
    }

    private void mnuPay(Node node, int mnuIndex) {

        addInputMenu(node, "mnuAddClient", mnuIndex);

        addMenuToTaiNode(node, "mnuPaymentType", mnuIndex, false);

        Node auxNode = getLastChildNode(node);

        addMenuToTaiNode(auxNode, "mnuCreateFinance", auxNode.getValue() * 10, false);

    }

    private Node getLastChildNode(Node node) {

        Node auxNode = node.getChildNodes().get(node.getChildNodes().size() - 1);
        return auxNode;
    }

    //Agrega un menu en el ultimo nodo hijo
//Nodo al que agregar, nombre del menu que agregar, indice de la funcion a ejecutar
    private void addMenuToTaiNode(Node node, String mnuName, int mnuIndex, boolean isTail) {

        int key = node.getChildNodes().size() - 1;

        Node auxNode = node.getChildNodes().get(key);
        addMenu(auxNode, MenuMessage.getMenu(mnuName), ((mnuIndex + key + 1) * 10), isTail);
    }

    private void mnuAddGeneric(Node node, String textGeneric, int mnuIndex) {

        String mnuText[] = MenuMessage.getMenu("mnuGenericABMS");

        for (int i = 1; i < mnuText.length; i++) {
            node.addChild(new Node(i + mnuIndex, node, mnuText[i - 1]));
        }
        addInputMenu(node.getChildNodes().get(0), "mnuAdd" + textGeneric, mnuIndex);//Menu agregar
        addInputMenu(node.getChildNodes().get(1), "mnuEdit" + textGeneric, mnuIndex);//Menu Editar
        addInputMenu(node.getChildNodes().get(2), "mnuDelete" + textGeneric, mnuIndex);//Menu Eliminar
        addInputMenu(node.getChildNodes().get(5), "mnuSearch" + textGeneric, mnuIndex);//Menu Buscar
        //Volver
        Node lnode = new Node(mnuIndex + mnuText.length, node, mnuText[mnuText.length - 1]);
        lnode.isTail(true);
        node.addChild(lnode);
    }

    @Override
    public void addMenu(Node node, String[] mnuText, int mnuIndex, boolean isTail) {
        for (int i = 1; i <= mnuText.length - 1; i++) {
            node.addChild(new Node(mnuIndex + i, node, mnuText[i - 1]));
        }
        Node lnode = new Node(mnuIndex + mnuText.length, node, mnuText[mnuText.length - 1]);
        lnode.isTail(isTail);
        node.addChild(lnode);
    }

    public AppInterface() {
        //loadMenu();
       
    }

    public Node getNode() {
        return node;
    }

    private void loadMenu() {
        mnuMain(node);

    }

    private void mnuItemSection(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuItemSection"), mnuIndex, true);
    }

    private void mnuBuying(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuBuying"), mnuIndex, true);
    }

    private void mnuHndClient(Node node, int mnuIndex) {
        mnuAddGeneric(node, "Client", 20);
    }

    private void mnuPaymentType(Node node, int mnuIndex) {
        addMenu(node, MenuMessage.getMenu("mnuPaymentType"), mnuIndex, false);
    }
}
