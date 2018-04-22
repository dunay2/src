package ishop;

import Managers.MainManager;
import Person.Client.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElectronicShop extends Shop {

    public static void main(String[] args) {

        try {
            MainManager scene = new MainManager();

            userAuth();

            scene.start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void userAuth() throws IOException {
        Client client;
//Creamos un lector
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//Creamos un cliente
        System.out.println("Electronic & CO");//Se pide un dato al usuario

        System.out.println("Por favor introduzca codigo de usuario para autenticarse");//Se pide un dato al usuario

       // client = new Client(br.readLine());

    }
}
