/*
//Autor Diego Rios
 */
package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import Person.Client.Client;
import item.Electrodomestic;

/**
 *
 * @author ashh412 Propósito: agregar persistencia al proyecto mediante acceso a
 * un fichero de texto donde se guardan los objetos serializados
 */
public class TextDatabase implements IDatabase {

//Implementamos el método save para guardar objetos
    @Override
    public void save(HashMap hm) {

        try {
            FileOutputStream fout = null;

//Capturar el tipo
//Obtenemos el primer objeto para saber su tipo y guardar en su fichero
            Iterator<Entry<String, Object>> it = hm.entrySet().iterator();
//Tomamos el primer valor para conocer la clase hija que vamos a guardar
            Entry<String, Object> ite = it.next();
            Object objectType = ite.getValue();

//Guardamos el nombre de la clase hija
            String filename = objectType.getClass().getSimpleName() + ".data";

            //Convertimos el HashMap en el tipo que vamos a guardar
            HashMap<?, ?> hmfile = null;
            switch (filename) {
                case "Client.data":
                    hmfile = (HashMap<String, Client>) hm;

                    break;
                case "Electrodomestic.data":
                    hmfile = (HashMap<String, Electrodomestic>) hm;
                    break;
                case "Employee.data":
                    break;
                case "Sell.data":
                    break;
                case "Repair.data":
                    break;
            }

            try {
                fout = new FileOutputStream(filename, false);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }

            ObjectOutputStream oosh = new ObjectOutputStream(fout);
            oosh.writeObject(hmfile);

            fout.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap load(String fileName) {
        HashMap<String, ?> e = new HashMap();;
        FileInputStream file = null;
        ObjectInputStream in = null;

        // Deserialization
        File f = new File(fileName + ".data");
        if (f.exists()) {

            try {
                file = new FileInputStream(fileName + ".data");

                in = new ObjectInputStream(file);

                e = (HashMap<String, ?>) in.readObject();

                file.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
}
