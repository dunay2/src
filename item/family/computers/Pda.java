/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.family.computers;

/**
 *
 * @author ashh412
 */
public class Pda extends BateryComputer {

    public Pda(String code) {
        super(code);
    }

    private String autonomy; //autonomia
    //Alimentación powersuply electrical network/bateri

    public String getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(String autonomy) {
        this.autonomy = autonomy;
    }

}
