package ScreenInterfaces;

import Utils.Menu.MenuMain;
import Utils.Menu.MenuNode;
import java.io.IOException;
import java.util.Scanner;

//Implementar la lectura de los nodos is imput
// Clase TextInterface:
//Propósito: gestionar las entradas y navegación de menú según la opción seleccionada

/**
 *
 * @author ashh412
 */
public class TextInterface {

    /**
     *
     * @param node Nodo sobre el que vamos a trabajar
     * @return Devuelve el nodo seleccionado
     */
    public MenuNode printMenu(MenuNode node) {

        //Menú principal
        if (node == null) {

            return getMenu(MenuMain.getRootNode());
        }

        return getMenu(node);

    }

    /**Propósito: limpiar la consola
     *
     */
    public static void clearScreen() {

        clearConsole();
    }
    ////proposito: imprimir todos los hijos de un nodo

    private void printChildNodes(MenuNode n) {

        for (int i = 0; i < n.getChildNodes().size(); i++) {
            MenuNode node = n.getChildNodes().get(i);

            String mnEntry = String.valueOf(node.getValue());
            mnEntry = mnEntry.substring(mnEntry.length() - 1, mnEntry.length());

            mnEntry = (node.isInput()) ? node.getLabel() : mnEntry.concat(". ").concat(node.getLabel());

            System.out.println(mnEntry);
        }
    }

//Motor de la clase
    private int readConsole() {
        Scanner scanner = new Scanner(System.in);

        try {
            int i = scanner.nextInt();

            if (i == 0) {
                System.out.println("Gracias por usar la aplicación. Pulse una tecla para continuar");
                String a = scanner.nextLine();
                a = (scanner.nextLine());
                // return 0;
            }
            if (i >= 0 && i <= 9) {
                return i;
            }
        } catch (Exception e) {

        }
        //return i;
        return -1;
    }

//Propósito: Accesos los menús
//Muestra las opciones disponibles de menú en la selección actual
//mediante la impresión del menú de hijos
//Gestiona la entrada de menú que ha sido seleccionada
//Devuelve el nodo de menú seleccionado
    private MenuNode getMenu(MenuNode node) {
        //Imprimimos el menú
        printChildNodes(node);
        int i;
        i = readConsole();
        if (i > 0) {
            //Tomamos el hijo seleccionado
            MenuNode childNode = node.getChildNodes().get(i - 1);

            //Ejecutamos una función en el sistema dependiendo
            //de la entra de teclado
            // if (childNode.isTail()) {
            if (childNode.isInput()) {

                return node.getParent();
            } else {
                int k = childNode.getValue();
                switch (k) {
                    case 0://Volver al menú principal 
                        //return super.getNode();
                        return null;
                    //Retrocedemos en el menu
                    case -1://Devolver padre 
                        return node.getParent();
                    default:
                        return childNode;
                }
            }

        } else if (i == -1) {
            return node;
        }
        return null;
    }

    /**
     *
     */
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final IOException e) {
            //  Handle any exceptions.
        }
    }

    /**
     *
     */
    public static void pressKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulsa una tecla para continuar ...");
        String a = scanner.nextLine();
    }
}
