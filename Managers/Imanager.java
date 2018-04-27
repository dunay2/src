package Managers;

import Utils.Node;
import java.util.HashMap;

/**
 *
 * @author ashh412
 * @param <T>
 * @param <N>
 */

/*
 Propósito:Interfaz de Gestores de objetos
 */
//Cosas que puede hacer un gestor 
public interface Imanager<T, N> {

    //Para devolver el nombre de las instancias
    default String getClassName() {
        return this.getClass().getSimpleName();
    }

    public void print(T e);

    //para realizar una búsqueda
    public Object get(int rollNo);

    public HashMap<String, T> getAll();

    //Para actualizar los datos de una entidad
    public void update(N e);

    //Para borrar una entidad
    public void delete(T e);
//Para agregar una entidad

    public boolean add(T e);
//Para buscar un elemento

    public T search(N e, StringBuilder  outString);

    public void list();

    public T createObject(Node[] node);

    public boolean handleProcess(Node[] node);

}
