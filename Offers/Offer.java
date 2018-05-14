package Offers;

import java.util.HashMap;

public class Offer {

    private int offerId;

    private String offerDesc;

    private HashMap hmClients;

    public Offer(int offerId, String offerDesc) {
    }

    public String addClient(String clientId, String offerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String sendMail(String offerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
