/*
//Autor Diego Rios
 */
package DataBase;

import Person.Person;
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

/**
 *
 * @author ashh412 Propósito: agregar persistencia al proyecto mediante acceso a
 * un fichero de texto donde se guardan los objetos serializados
 */
public abstract class TextDatabase implements IDatabase {

//Implementamos el método save para guardar objetos tipo person
//
// @Override
//    public void save(HashMap e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    // public void save(HashMap<String, Person> hm) {
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

            //   File f = new File(filename);
            //  boolean fexist = f.exists();
            fout = new FileOutputStream(filename, true);
//Comprobamos si el archivo de datos existe para escribir su cabecera solo en ese caso

//Escribimos los objetos
//  do {
// if (fexist) {
//      OWriteStream oos = new OWriteStream(fout);
//        oos.writeObject(objectType);
//} else {
            ObjectOutputStream oosh = new ObjectOutputStream(fout);
            oosh.writeObject(objectType);
            fout.close();

// }
//   if (it.hasNext()) {
//     ite = it.next();
//    objectType = ite.getValue();
//}
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//while (it.hasNext());

    @Override
    public HashMap<String, Person> load(String fileName) {
        HashMap<String, Person> e = new HashMap();;
        FileInputStream file = null;
        ObjectInputStream in = null;
        //  Person person = null;

        // Deserialization
        File f = new File(fileName + ".data");
        if (f.exists()) {

            try {
                file = new FileInputStream(fileName + ".data");

                in = new ObjectInputStream(file);

                //    while (true) {
                e = (HashMap<String, Person>) in.readObject();

                //person = (Person) in.readObject();
                //      e.put(person.getDni(), person);
                //  }
                file.close();

                // HashMap<String, Person> result = e;
//
//                    Iterator<Map.Entry<String, Person>> it = result.entrySet().iterator();
//                    while (it.hasNext()) {
//                        Map.Entry<String, Person> me = it.next();
//
//                        Person per = me.getValue();
//                    }
                // HashMap<String, Person> result = e;
//
//                    Iterator<Map.Entry<String, Person>> it = result.entrySet().iterator();
//                    while (it.hasNext()) {
//                        Map.Entry<String, Person> me = it.next();
//
//                        Person per = me.getValue();
//                    }
                //  }catch (EOFException exc)
//{
                // end of stream
//}
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TextDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //

        return e;
    }
}
