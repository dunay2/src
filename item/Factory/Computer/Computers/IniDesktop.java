/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.Factory.Computer.Computers;

import item.family.computers.Desktop;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class IniDesktop extends Desktop {

    /**
     *
     * @param code
     */
    public IniDesktop(String code) {
        super(code);
    }

     /** Define la inicialización de un objeto de tipo
     *
     * @param key
     * @param response
     */
    public IniDesktop(String key, ArrayList<String> response) {

        super(key);
        int i = 0;

        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
        super.setMhz(response.get(i++));
        super.setRam(response.get(i++));
        super.setHddSize(response.get(i++));
        super.setGuaranty(response.get(i++));
        super.setBoughtPrice(Double.valueOf(response.get(i++)));
        super.setSellPrice(Double.valueOf(response.get(i++)));
        super.setQuantity(parseInt(response.get(i++)));

    }

}
