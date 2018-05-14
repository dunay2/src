package Person.Comunications;

import Person.Client.Client;
import java.util.HashMap;
/**
 * 
 * @author ashh412
 */
public interface ICommunication {
    
/**
 * 
 */
    public void sendMail();
/**
 * 
 * @return 
 */
    public HashMap getHmClients();
/**
 * 
 * @param clientId
     * @param client 
 */
    public void addClient(String clientId, Client client);

    /**
     *
     * @return
     */
    public String getOfferId();

    public String getOfferDesc();
}
