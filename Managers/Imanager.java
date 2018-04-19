package Managers;

import Utils.Node;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ashh412
 * @param <T>
 */

/*
 Propósito:Interfaz de Gestores de objetos
 */
//Cosas que puede hacer un gestor 

public interface Imanager<T> {



    default String getClassName() {
        return this.getClass().getSimpleName();
    }

    //para realizar una búsqueda
    public Object get(int rollNo);

    public HashMap<String, T> getAll();

    //Para actualizar los datos de una entidad
    public void update(T e);

    //Para borrar una entidad
    public void delete(T e);
//Para agregar una entidad

    public boolean add(T e);
//Para buscar un elemento

    public T search(String e);

    public void list();

    public T createObject(Node node) throws IOException;

    public boolean handleProcess(Node node);

}
