/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author ashh412
 */
import Person.Client.Client;
import Managers.ClientManager;
import ScreenInterfaces.AppInterface;
import java.io.*;

public class SerializacionApp {

    public static void main(String[] args) {
        AppInterface myInterface = null;

        String Stremp = "G:\\ESTUDIOS\\UNED\\POO\\PEC1\\Ishop\\Ishop\\empleados.ddr";
        //Creamos el objeto
        ClientManager clientManager = new ClientManager();
        Client client;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Stremp))) {

            for (int i = 0; i < 100; i++) {
                client = clientManager.generateRandomClient();
                //Escribimos en un fichero
                oos.writeObject(client);

                System.out.println(client.getDni());
                System.out.println(client.getfirstName());
            }
            oos.close();
        } catch (IOException e) {

        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Stremp))) {
            //Cuando no haya mas objetos saltara la excepcion EOFException
            while (true) {
                client = (Client) ois.readObject();
                System.out.println(client.getDni());
                System.out.println(client.getfirstName());
                //System.out.println(client.getEdad());
                // System.out.println(client.getSalario());
                System.out.println("");
            }
        } catch (ClassNotFoundException e) {
        } catch (EOFException e) {
        } catch (IOException e) {
        }

    }
}
