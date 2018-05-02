/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.family.computers;

import item.Electrodomestic;



/**
 *
 * @author ashh412
 */
public class Computer extends Electrodomestic {

    private String ram;
    private String mhz;
    private String hddSize;

//    public Computer( String code,String familyCode, String name, String description, double boughtPrice, double sellPrice, int quantity,Double ram) {
//
//        super( code,familyCode, name, description, boughtPrice, sellPrice, quantity);
//        this.ram=ram;
//
//    }

    public Computer(String code) {
        super(code);
    }

    
    
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMhz() {
        return mhz;
    }

    public void setMhz(String mhz) {
        this.mhz = mhz;
    }

    public String getHddSize() {
        return hddSize;
    }

    public void setHddSize(String hddSize) {
        this.hddSize = hddSize;
    }

}
