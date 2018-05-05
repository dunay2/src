/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.util.HashMap;

/**
 *
 * @author ashh412 Interfaz genérica de acceso a datos Crea los métodos save y
 * load
 * @param <T>
 */
public interface IDatabase<T> {

    /**
     *
     * @param e
     */
    void save(HashMap<String, T> e);

    /**
     *
     * @param id
     * @return
     */
    HashMap<String, T> load(String id);

}
