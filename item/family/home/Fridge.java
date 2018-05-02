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

    private String maxCapacity;//capacidad bruta del refrigerador litros
    private String FreezermaxCapacity;//capacidad bruta del refrigerador litros
    private String drowers; //cajones

    public Fridge(String code) {
        super(code);
    }

    public String getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getFreezermaxCapacity() {
        return FreezermaxCapacity;
    }

    public void setFreezermaxCapacity(String FreezermaxCapacity) {
        this.FreezermaxCapacity = FreezermaxCapacity;
    }

    public String getDrowers() {
        return drowers;
    }

    public void setDrowers(String drowers) {
        this.drowers = drowers;
    }


}
