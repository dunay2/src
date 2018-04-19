/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ashh412
 */
public class MenuMessage {

    static Map hashmap = new HashMap<String, String[]>();
//para agregar un menu debemos hacer lo siguiente:
    //1. Agregar un elemento a mnuName con el nombre del menu
    //2. Poblar el menu en el array code 
    //de forma ordenada 

    public MenuMessage() {
        ArrayList<String[]> menuText = new ArrayList();
        String[] mnuName = new String[19];
//Inicializacion de menus definiendo las funciones que va a ejecutar el sistemas
        mnuName[0] = "mnuMain";

        mnuName[1] = "mnuAddClient";
        mnuName[2] = "mnuEditClient";
        mnuName[3] = "mnuDeleteClient";
        mnuName[4] = "mnuSearchClient";

        mnuName[5] = "mnuAddItem";
        mnuName[6] = "mnuEditItem";
        mnuName[7] = "mnuDeleteItem";
        mnuName[8] = "mnuSearchItem";

        mnuName[9] = "mnuAddEmployee";
        mnuName[10] = "mnuEditEmployee";
        mnuName[11] = "mnuDeleteEmployee";
        mnuName[12] = "mnuSearchEmployee";

        mnuName[13] = "mnuGenericABMS";
        mnuName[14] = "mnuPaymentType";
        mnuName[15] = "mnuTransaction";
        mnuName[16] = "mnuAddItemToCart";
        mnuName[17] = "mnuBuying";

        mnuName[18] = "mnuItemSection";

        //0. mnuMain 
        String[] code = new String[5];
        code[0] = "Realizar una Transacción";
        code[1] = "Gestión de Clientes"; //mnuGenericABMS
        code[2] = "Gestión de Stock";
        code[3] = "Gestión de Empleados";
        code[4] = "Salir de la aplicación";
        menuText.add(code);

        /**
         * ************Client*****************
         */
        //1. mnuAddClient
        code = new String[4];
        code[0] = "Introduzca DNI del cliente";
        code[1] = "Introduzca nombre";
        code[2] = "Introduzca apellido";
        code[3] = "Introduzca nómina";
        menuText.add(code);
        //2. mnuEditClient    
        code = new String[4];
        code[0] = "Introduzca DNI del cliente";
        code[1] = "Introduzca nombre";
        code[2] = "Introduzca apellido";
        code[3] = "Introduzca nómina";
        menuText.add(code);
        //3. mnuDeleteClient    
        code = new String[1];
        code[0] = "Introduzca DNI del cliente";
        menuText.add(code);

        //4. mnuSearchClient    
        code = new String[1];
        code[0] = "Introduzca DNI del cliente";
        menuText.add(code);

        /**
         * ************Stock*****************
         */
        //5. mnuAddItem
        code = new String[7];
        code[0] = "Introduzca código de familia: 1.  Ordenadores   2. Hogar   3. Telefonía   4. Imagen   5. Sonido";
        code[1] = "Introduzca código de artículo";
        code[2] = "Introduzca nombre de artículo";
        code[3] = "Introduzca descripción de artículo";
        code[4] = "Introduzca precio de compra";
        code[5] = "Introduzca precio de venta";
        code[6] = "Introduzca cantidad en stock";
        menuText.add(code);
        //6. mnuEditItem    
        code = new String[6];
        code[0] = "Introduzca código de artículo";
        code[1] = "Introduzca nombre de artículo";
        code[2] = "Introduzca descripción de artículo";
        code[3] = "Introduzca precio de compra";
        code[4] = "Introduzca precio de venta";
        code[5] = "Introduzca cantidad en stock";
        menuText.add(code);
        //7. "mnuDeleteItem";
        code = new String[1];
        code[0] = "Introduzca el código de artículo";
        menuText.add(code);
        //8. mnuSearchItem
        code = new String[1];
        code[0] = "Introduzca el código de artículo";
        menuText.add(code);

        /**
         * ************Employee*****************
         */
        //9. mnuAddEmployee
        code = new String[4];
        code[0] = "Introduzca DNI empleado";
        code[1] = "Introduzca nombre";
        code[2] = "Introduzca apellido";
        code[3] = "Introduzca nómina";
        menuText.add(code);
        //10. mnuEditEmployee    
        code = new String[4];
        code[0] = "Introduzca DNI empleado";
        code[1] = "Introduzca nombre Return para no hacer cambios";
        code[2] = "Introduzca apellido";
        code[3] = "Introduzca nómina";
        menuText.add(code);
        //11. "mnuDeleteEmployee";
        code = new String[1];
        code[0] = "Introduzca DNI de Empleado";
        menuText.add(code);
        //12. mnuSearchEmployee
        code = new String[1];
        code[0] = "Introduzca DNI del Empleado";
        menuText.add(code);

        //13. mnuGenericABMS
        code = new String[7];
        code[0] = "Agregar";
        code[1] = "Actualizar";
        code[2] = "Eliminar";
        code[3] = "Listar";
        code[4] = "Agregar " + "aleatorio";
        code[5] = "Buscar";
        code[6] = "Volver al menú principal";
        menuText.add(code);

        //14. mnuPaymentType
        code = new String[4];
        code[0] = "Efectivo";
        code[1] = "Tarjeta";
        code[2] = "Financiado";
        code[3] = "Cancelar venta";
        menuText.add(code);

        //15. mnuTransaction
        code = new String[4];
        code[0] = "Consultar el importe actual";
        code[1] = "Añadir producto al carrito";
        code[2] = "Cobrar Compra";
        code[3] = "Cancelar venta";
        menuText.add(code);

        //16 mnuAddItemToCart
        code = new String[2];
        code[0] = "Introduzca código de artículo";
        code[1] = "Introduzca cantidad";
        menuText.add(code);
        //17. mnuBuying
        code = new String[2];
        code[0] = "Seguir Comprando";
        code[1] = "Cancelar Compra";
        menuText.add(code);

        //18. mnuItemSection
        code = new String[4];
        code[0] = "PDA'S";
        code[1] = "Portatiles";
        code[2] = "Sobremesa";
        code[3] = "NoteBooks";
        menuText.add(code);

        for (int i = 0; i < mnuName.length; i++) {
            hashmap.put(
                    mnuName[i], menuText.get(i));
        }
    }

    public static String[] getMenu(String s) {
        return (String[]) hashmap.get(s);
    }

}
