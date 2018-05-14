package Utils;

import Person.Client.Client;
import Person.Comunications.ICommunication;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ashh412
 */
public class Offer implements ICommunication {

    private String offerId;
    private String offerDesc;
    private final HashMap hmClients;
    private Date sendDate;

    /**
     * Clase privada que controla cuándo se ha enviado el dato del cliente
     */
    private class ClientRecord extends Client {//Estructura privada que contiene el envío a los clientes

        private Date sendDate;

        public ClientRecord(String dni) {
            super(dni);
        }

        public Date getSendDate() {
            return this.sendDate;
        }

        public void setSendDate(Date sendDate) {
            this.sendDate = sendDate;
        }

    }

    public Offer(int offerId, String offerDesc) {
        this.hmClients = new HashMap();
    }

    /**
     *
     * @param clientId
     * @param client
     */
    @Override
    public void addClient(String clientId, Client client) {

        hmClients.put(clientId, (ClientRecord) client);
    }

    /**
     *
     * @return
     */
    @Override
    public String getOfferId() {
        return offerId;
    }

    /**
     *
     * @return
     */
    @Override
    public String getOfferDesc() {
        return offerDesc;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap getHmClients() {
        return hmClients;
    }

    /**
     *
     */
    @Override
    public void sendMail() {

        Iterator it = hmClients.entrySet().iterator();
        while (it.hasNext()) {
            ClientRecord clientRecord = (ClientRecord) it.next();

            sendMail(clientRecord);

        }

        Calendar rightNow = Calendar.getInstance();

        sendDate = rightNow.getTime();
    }

    /**
     *
     * @param clientRecord
     */
    private void sendMail(ClientRecord clientRecord) {

        //Comprobamos las condiciones de envío
        if (checkSendMailConditions(clientRecord.getSendDate())) {
            System.out.println("Correo enviado a " + clientRecord.getEmail());

            System.out.println("Estimado/a Señor/a " + clientRecord.getLastName() + offerDesc);

            //Guardamos la fecha de envío
            Calendar rightNow = Calendar.getInstance();
            clientRecord.setSendDate(rightNow.getTime());
        }

    }

    /**
     *
     * Propósito: Comprobar las condiciones de envío de un correo
     *
     * @param cr ClientRecord
     * @return boolean: Verdadero si se puede realizar la operación Rules: la
     * diferencia entre la fecha del primer envio y el nuevo debe ser superior a
     * 1 año
     */
    private boolean checkSendMailConditions(Date date) {

        Calendar rightNow = Calendar.getInstance();

        Date fechaFinal = rightNow.getTime();

        Date fechaInicial = date;

        //supera 1 año
        return (((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000) > 365);

    }

    public Date getSendDate() {
        return sendDate;
    }

    public void printClients() {

        Iterator it = hmClients.entrySet().iterator();
        while (it.hasNext()) {
            ClientRecord clientRecord = (ClientRecord) it.next();

            String OutputString = clientRecord.getDni() + "  ";
            OutputString += clientRecord.getFirstName() + "  ";
            OutputString += clientRecord.getEmail() + "  ";
            OutputString += clientRecord.getSendDate() + "  ";

            System.out.println(OutputString);

        }
    }
}
