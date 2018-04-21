/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Record;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ashh412
 */
//Proposito: Generico que guarda operaciones de la empresa: venta,reparacacion e implementaciones futuras
public class Record {

    private final String operCode;
    private final String cliCode;
    private final String empCode;
    private Date date = null;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Record(String operCode, String cliCode, String empCode) {
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
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return date;
    }

}
