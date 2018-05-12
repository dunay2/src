/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Record;

import Person.Client.ClientHistory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ashh412
 */
//Proposito: Generico que guarda operaciones de la empresa: venta,reparacacion e implementaciones futuras
public abstract class Record implements Serializable {

    private final String operCode;
    private final String cliCode;
    private final String empCode;
    private String status;
    private Date date = null;
    private String recordType;

    private final ArrayList<ClientHistory> history = new ArrayList();

    /**
     *
     * @param operCode
     * @param cliCode
     * @param empCode
     */
    //Estados 
    // Y--> ACTIVO
    // I--> INACTIVO
    // R--> EN REPARACION
    // P--> PENDIENTE
    // S--> PARADO
    // T--> TEST
    // F--> FINISH
    // W--> ESPERANDO POR FINANCIACION
    public Record(String operCode, String cliCode, String empCode, String recordType) {
        this.status = "A";
        this.operCode = operCode;
        this.cliCode = cliCode;
        this.empCode = empCode;
        date = getDate_();
        this.recordType = recordType;

    }

    public String getRecordType() {
        return recordType;
    }

    public void addHistory(String note) {

        ClientHistory clientHistory;
        clientHistory = new ClientHistory(getDate_(), note);
        history.add(clientHistory);

    }

    public ArrayList<ClientHistory> getHistory() {

        return history;

    }

    /**
     *
     * @return
     */
    public Date getDate() {

        return date;

    }

    /**
     *
     * @return
     */
    public String getOperCode() {
        return operCode;
    }

    /**
     *
     * @return
     */
    public String getCliCode() {
        return cliCode;
    }

    /**
     *
     * @return
     */
    public String getEmpCode() {
        return empCode;
    }

    private Date getDate_() {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        // System.out.println(dateFormat.format(date));  
        return date;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
