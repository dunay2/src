/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author ashh412
 */


public class Electrodomestic extends Item {
    private String power;
    private String typeOfBatery;
    private String autonomy;
    private String recharTime;

    public Electrodomestic(String familyCode,String code, String name,String description, double boughtPrice, double sellPrice, int quantity) {
        super(familyCode,code, name,description, boughtPrice, sellPrice, quantity);
    }
 

    
}

   
