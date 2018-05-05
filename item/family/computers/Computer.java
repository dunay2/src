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
  private static final long serialVersionUID = -2873344211410398459L;
    private String ram;
    private String mhz;
    private String hddSize;

    /**
     *
     * @param code
     */
    public Computer(String code) {
        super(code);
    }

    /**
     *
     * @return
     */
    public String getRam() {
        return ram;
    }

    /**
     *
     * @param ram
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     *
     * @return
     */
    public String getMhz() {
        return mhz;
    }

    /**
     *
     * @param mhz
     */
    public void setMhz(String mhz) {
        this.mhz = mhz;
    }

    /**
     *
     * @return
     */
    public String getHddSize() {
        return hddSize;
    }

    /**
     *
     * @param hddSize
     */
    public void setHddSize(String hddSize) {
        this.hddSize = hddSize;
    }

}
