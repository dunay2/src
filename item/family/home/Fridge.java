/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.family.home;

import item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class Fridge extends Electrodomestic {
  private static final long serialVersionUID = -2873344211410398459L;
    private String maxCapacity;//capacidad bruta del refrigerador litros
    private String freezermaxCapacity;//capacidad bruta del refrigerador litros
    private String drowers; //cajones

    /**
     *
     * @param code
     */
    public Fridge(String code) {
        super(code);
    }

    /**
     *
     * @return
     */
    public String getMaxCapacity() {
        return maxCapacity;
    }

    /**
     *
     * @param maxCapacity
     */
    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     *
     * @return
     */
    public String getFreezermaxCapacity() {
        return freezermaxCapacity;
    }

    /**
     *
     * @param FreezermaxCapacity
     */
    public void setFreezermaxCapacity(String FreezermaxCapacity) {
        this.freezermaxCapacity = FreezermaxCapacity;
    }

    /**
     *
     * @return
     */
    public String getDrowers() {
        return drowers;
    }

    /**
     *
     * @param drowers
     */
    public void setDrowers(String drowers) {
        this.drowers = drowers;
    }


}
