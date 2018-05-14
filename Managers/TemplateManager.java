/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DataBase.TextDatabase;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import item.Electrodomestic;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ashh412
 */
public class TemplateManager extends TextDatabase implements Imanager<Electrodomestic, MenuNode> {

    @Override
    public Electrodomestic createObject(MenuNode[] enode) {
        String key;
        MenuNode node = enode[0];
        ArrayList<String> nodesData;
        MenuNode nodeAux = node.getChildNodes().get(0);//comprobacion de respuesta
        int i = 0;
//creacion estandar
//No hay datos en los nodos hijos
        if (nodeAux.getResponseValue() == null) {
            StringBuilder outString = new StringBuilder();
            Electrodomestic electrodomestic = (Electrodomestic) search(node, outString);
            if (electrodomestic == null) {
                key = outString.toString();
            } else {
                node.getChildNodes().get(0).clearResponse();
                System.out.println("El registro ya existe");
                TextInterface.pressKey();
                return null;
            }

        } else {//Creación por búsqueda 

            key = nodeAux.getResponseValue();
        }
        nodesData = node.convertTreeChildToListIdx();
        node.getChildNodes().get(0).clearResponse();
        //  Client client = new Client(key, nodesData.get(i++), nodesData.get(i++), nodesData.get(i++), nodesData.get(i++));

//Guardamos el cliente en la coleccion
        //add(client);
        //Guardar los datos 
        //  save();
        //return client;
        return null;
    }

    @Override
    public void print(Electrodomestic e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Electrodomestic> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MenuNode e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Electrodomestic e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Electrodomestic e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Electrodomestic search(MenuNode e, StringBuilder outString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean handleProcess(MenuNode[] node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
