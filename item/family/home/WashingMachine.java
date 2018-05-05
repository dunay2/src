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

    private static final long serialVersionUID = -2873344211410398459L;
    private String revolutions;

    public WashingMachine(String code) {
        super(code);
    }

    public String getRevolutions() {
        return revolutions;
    }

    public void setRevolutions(String Revolutions) {
        this.revolutions = Revolutions;
    }

}
