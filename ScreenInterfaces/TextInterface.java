package ScreenInterfaces;

import java.util.Scanner;
// Clase TextInterface:
//Propósito: gestionar las entradas y navegación de menú según la opción seleccionada

public class TextInterface extends AppInterface {

    @Override
    public Node printMenu(Node node) {
        Node n;
        //Menú principal
        if (null == node) {
            n = super.getNode();
            return getMenu(n);
        }
        n = getMenu(node);
        return n;
    }

    //propósito: leer los datos introducidos por consola
    private int readConsole() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i == 0) {
            System.out.println("Gracias por usar la aplicación. Pulse una tecla para continuar");
            String a = scanner.nextLine();
            a = (scanner.nextLine());
        }
        return i;
    }

//Propósito: Accesos los menús
//Muestra las opciones disponibles de menú en la selección actual
//mediante la impresión del menú de hijos
//Gestiona la entrada de menú que ha sido seleccionada
//Devuelve el nodo de menú seleccionado
    
    private Node getMenu(Node node) {
        //Imprimimos el menú
        printChildNodes(node);
        int i;
        i = readConsole();
        if (i > 0) {
            //Tomamos el hijo seleccionado
            Node childNode = node.getChildNodes().get(i - 1);

            //Ejecutamos una función en el sistema dependiendo
            //de la entra de teclado
            int k = childNode.getValue();
            switch (k) {
                case 0://Volver al menú principal 
                    return super.getNode();
                //Retrocedemos en el menu
                case -1://Devolver padre 
                    return node.getParent();
                default:
                    return childNode;
            }
        }
        return null;
    }

//proposito: imprimir todos los hijos de un nodo
    private void printChildNodes(Node n) {
        for (int i = 0; i < n.getChildNodes().size(); i++) {
            System.out.println(n.getChildNodes().get(i).getLabel());
        }
    }
//Propósito: limpiar la consola
    public static void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.flush();
    }
}
