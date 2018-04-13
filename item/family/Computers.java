/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.family;

import item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class Computers extends Electrodomestic{
   private double ram;
   private double mhz;
   private double hddSize;

    public Computers(double ram, double mhz, double hddSize, String code, String name, double boughtPrice, double sellPrice, int quantity) {
        super(code, name, boughtPrice, sellPrice, quantity);
        this.ram = ram;
        this.mhz = mhz;
        this.hddSize = hddSize;
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