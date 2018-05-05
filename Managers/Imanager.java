package Managers;

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

    /**
     *
     * @return
     */
    default String getClassName() {
        return this.getClass().getSimpleName();
    }

    /**
     *
     * @param e
     */
    public void print(T e);

    //para realizar una búsqueda

    /**
     *
     * @param rollNo
     * @return
     */
    public Object get(int rollNo);

    /**
     *
     * @return
     */
    public HashMap<String, T> getAll();

    //Para actualizar los datos de una entidad

    /**
     *
     * @param e
     */
    public void update(N e);

    //Para borrar una entidad

    /**
     *
     * @param e
     */
    public void delete(T e);
//Para agregar una entidad

    /**
     *
     * @param e
     * @return
     */
    public boolean add(T e);
//Para buscar un elemento

    /**
     *
     * @param e
     * @param outString
     * @return
     */
    public T search(N e, StringBuilder  outString);

    /**
     *
     */
    public void list();

    /**
     *
     * @param node
     * @return
     */
    public T createObject(N[] node);

    /**
     *
     * @param node
     * @return
     */
    public boolean handleProcess(N[] node);

}
