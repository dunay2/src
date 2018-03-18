package Managers;

import ScreenInterfaces.Node;
import java.io.IOException;
import java.util.HashMap;

/*
 Propósito:Interfaz de Gestores de objetos
 */
//Cosas que puede hacer un gestor 
public interface Imanager<T> {

    //para realizar una búsqueda
    public Object get(int rollNo);
    
    public HashMap<String, T> getAll();

    //Para actualizar los datos de una entidad
    public void update(Object e);

    //Para borrar una entidad
    public void delete(Object e);
//Para agregar una entidad

    public boolean add(Object e);
//Para buscar un elemento

    public Object search(String e);

    public void list();

    public Object createObject() throws IOException;

    public boolean handleProcess(int e);
}
