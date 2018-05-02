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
public class WashingMachine extends Electrodomestic {

    private String Revolutions;

    public WashingMachine(String code) {
        super(code);
    }

    public String getRevolutions() {
        return Revolutions;
    }

    public void setRevolutions(String Revolutions) {
        this.Revolutions = Revolutions;
    }

}
