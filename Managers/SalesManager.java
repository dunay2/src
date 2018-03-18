/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import Person.Client.Client;
import Person.Person;

/**
 *
 * @author ashh412
 */
public class SalesManager {
 
    private final Client actor1;
    private final Person actor2;

    public SalesManager(Client actor1, Person actor2) {
        this.actor1 = actor1;
        this.actor2 = actor2;
    }
    
    
    
    
}


/*

}

//ventas de productos e inventarios
public class Ventasproductos {
    static void inventarioyventa(String x){
    String resultado="venta";
    resultado="inventario";
    int opcion=3;
   while (opcion != 0){
     opcion=Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para la venta o 2 para el inventario")); 
        switch(opcion){
           
            case 1:
       
                int a=0;
                int codigo=1; 
            
                while(codigo != -1){
               
                codigo=VentanaProductos.seleccionProducto();
             
                if (codigo==100){JOptionPane.showMessageDialog(null, "el Valor del tomate es:500");
                a=a+500;}
                if (codigo==200){JOptionPane.showMessageDialog(null, "el Valor de la cebolla es:700");
                a=a+700;}
                if (codigo==300){JOptionPane.showMessageDialog(null, "el Valor de la zanahoria es:800");
                a=a+800;}     
                if (codigo==400){JOptionPane.showMessageDialog(null, "el Valor del perenjil es:900");
                a=a+900;}
                if (codigo==500){JOptionPane.showMessageDialog(null, "el Valor de la remolacha es:1000");
                a=a+1000;}
                if (codigo==600){JOptionPane.showMessageDialog(null, "el Valor del frijol es :80");
                a=a+80;}
                
                a=a;
                 }
               
               
              JOptionPane.showMessageDialog(null, "El Valor Total a pagar es:"+ a);
                break;
               
            case 2:
               
                int tomate=1;
                int cebolla=1;
                int zanahoria=1;
                int remolacha=1;
                int perenjil=1;
                int frijol=1;
              
                int cod=1; 
            
                while(cod != 0){
               
                cod=Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del producto"));
               
                if (cod==100){tomate++;}
                if (cod==200){cebolla++;}
                if (cod==300){zanahoria++;}     
                if (cod==400){remolacha++;}
                if (cod==500){perenjil++;}
                if (cod==600){frijol++;}
                }
              
                JOptionPane.showMessageDialog(null,"hay "+tomate+" libras de tomate");
                JOptionPane.showMessageDialog(null,"hay "+cebolla+" libras de cebolla");
                JOptionPane.showMessageDialog(null,"hay "+zanahoria+" libras de zanahoria");
                JOptionPane.showMessageDialog(null,"hay "+perenjil+" libras de perejil");
                JOptionPane.showMessageDialog(null,"hay "+remolacha+" libras de remolacha");
                JOptionPane.showMessageDialog(null,"hay "+frijol+" libras de frijol");
break;
    }
       }
   }

    /**
     * @param args the command line arguments
     */
/*
    public static void main(String[] args) {
        // TODO code application logic here
        String resultado="0";
Ventasproductos.inventarioyventa(resultado);
    }

*/