/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.components;

import item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class Computer extends Electrodomestic {

    private double ram;
    private double mhz;
    private double hddSize;

    public Computer( String code,String familyCode, String name, String description, double boughtPrice, double sellPrice, int quantity,Double ram) {

        super( code,familyCode, name, description, boughtPrice, sellPrice, quantity);
        this.ram=ram;

    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getMhz() {
        return mhz;
    }

    public void setMhz(double mhz) {
        this.mhz = mhz;
    }

    public double getHddSize() {
        return hddSize;
    }

    public void setHddSize(double hddSize) {
        this.hddSize = hddSize;
    }

}
