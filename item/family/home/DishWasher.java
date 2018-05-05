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
public class DishWasher extends  Electrodomestic{
      private static final long serialVersionUID = -2873344211410398459L;
    public DishWasher(String code) {
        super(code);
    }
    
private String waterConsume;

    public String getWaterConsume() {
        return waterConsume;
    }

    public void setWaterConsume(String waterConsume) {
        this.waterConsume = waterConsume;
    }

    
}
