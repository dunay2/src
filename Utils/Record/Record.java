/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Record;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private  String active;
    private Date date = null;
 
    
    
    public Record(String operCode, String cliCode, String empCode) {
        this.active = "Y";
        this.operCode = operCode;
        this.cliCode = cliCode;
        this.empCode = empCode;
        date = getDate_();

    }

    public Date getDate() {
        return date;
    }

    public String getOperCode() {
        return operCode;
    }

    public String getCliCode() {
        return cliCode;
    }

    public String getEmpCode() {
        return empCode;
    }

    private Date getDate_() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
       // System.out.println(dateFormat.format(date));  
        return date;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }



}
