/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.Factory.Computer.Computers;

import item.family.computers.BateryComputer;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class IniPda extends BateryComputer {

    public IniPda(String code) {
        super(code);
    }

    /**
     *
     * @param key
     * @param response
     */
    public IniPda(String key, ArrayList<String> response) {

        super(key);
        int i = 0;

        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
        super.setMhz(Double.valueOf(response.get(i++)));
        super.setRam(Double.valueOf(response.get(i++)));
        super.setHddSize(Double.valueOf(response.get(i++)));
        super.setAutonomy(response.get(i++));
        super.setGuaranty(response.get(i++));
        super.setBoughtPrice(Double.valueOf(response.get(i++)));
        super.setSellPrice(Double.valueOf(response.get(i++)));
        super.setQuantity(Integer.valueOf(response.get(i++)));

    }

}