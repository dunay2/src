/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.Factory.Phones;


import item.family.phones.Phone;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;
/**
 *
 * @author ashh412
 */
public class IniPhone extends Phone {
  private static final long serialVersionUID = -2873344211410398459L;
    /** Define la inicialización de un objeto de tipo
     *
     * @param key
     * @param response
     */
    public IniPhone(String key, ArrayList<String> response) {

           super(key);
        int i = 0;

        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
        super.setGuaranty(response.get(i++));
        super.setBoughtPrice(Double.valueOf(response.get(i++)));
        super.setSellPrice(Double.valueOf(response.get(i++)));
        super.setQuantity(parseInt(response.get(i++)));
    }
}
