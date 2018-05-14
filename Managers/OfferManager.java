package Managers;

import DataBase.TextDatabase;
import Person.Client.Client;
import Person.Employee.SalesMan;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.Offer;
import java.util.HashMap;

/**
 *
 * @author ashh412
 */
public class OfferManager extends TextDatabase {

    private HashMap<String, Offer> Offers;

    private static OfferManager instance = null;    //Singleton  Pattern

    private SalesMan salesMan;
    private final ClientManager clientManager;

    //Singleton Singleton Pattern
    /**
     *
     *
     * @param clientManager
     */
    protected OfferManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public static OfferManager getInstance(ClientManager clientManager) {
        if (instance == null) {
            instance = new OfferManager(clientManager);
        }
        return instance;
    }

    public boolean handleProcess(MenuNode[] enode) {
        MenuNode node = enode[0];
        Offer offer;
        StringBuilder outString = new StringBuilder();

        switch (node.getValue()) {
            case 71:    //entries.add(new MenuStruct("mnuCreatePromo", "Crear una promocion  "));
                //Codigo promo
                //desc

                if (createObject(enode) != null) {
                    return true;
                }
                enode[0] = node.getChildNodes().get(0);

                list();

                //  listRepairHistory(curRepair);
                TextInterface.pressKey();

                return true;

            case 72: //        entries.add(new MenuStruct("mnuLisgPromo", "Listar las promociones"));
                list();
            case 73: //        entries.add(new MenuStruct("mnuListPromoCli", "Listar los clientes de una promocion"));
                String promo = "";
                listClient(promo);

            case 74://        entries.add(new MenuStruct("mnuAddPromoCli", "Agregrar cliente a promocion"));
                //Codigo promocion
                //Codigo cliente

                Client client = (Client) clientManager.search(node, outString);

                offer = search(node, outString);
                offer.addClient(client.getDni(), client);
                save(Offers);

            case 75: //     entries.add(new MenuStruct("mnuPromoSend", "Enviar correo a listado"));
                //codigo promo
                //Obtenerla del hm y enviar

                offer = search(node, outString);
                offer.sendMail();

            case 76: //Volver al Menú Principal
                return true;

        }
        return false;//Profundiza
    }

    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void print(Offer e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean add(Offer e) {
        Offers.put(e.getOfferId(), e);
        return true;
    }

    public Offer search(MenuNode e, StringBuilder outString) {

        searchOffer("");
        return null;
    }

    //Crear promoción
    public Offer createObject(MenuNode[] node) {
        return null;

        //Introduzca un identificador para la promocion
        //introduzca el texto de la promocion
    }

    /**
     * Propósito: Buscar la clave en el HashMap y devolver el objeto si existe
     *
     *
     * @param e
     * @return
     */
    public Offer searchOffer(String e) {

        if (Offers.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return Offers.get(e);
        }
        return null;

    }

    public SalesMan getSalesMan() {
        return salesMan;
    }

    public void listClient(String PromoCode) {
        Offer offer = searchOffer(PromoCode);

        offer.printClients();

    }

    public void setSalesMan(SalesMan salesMan) {
        this.salesMan = salesMan;
    }
}
