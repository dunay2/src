/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Person.Person;
import java.util.HashMap;

/**
 *
 * @author ashh412
 * Interfaz genérica de acceso a datos
 * Crea los métodos save y load
 */
public interface IDatabase<T> {

  
    //void save (HashMap<String, Person> e);
void save (HashMap<String, T> e);

   // ArrayList<Person> Load(String id);
    HashMap<String, Person> load(String id);//persons = new HashMap<>();

}
