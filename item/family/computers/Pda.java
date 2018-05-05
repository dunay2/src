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
  private static final long serialVersionUID = -2873344211410398459L;
    public Pda(String code) {
        super(code);
    }

    private String inches; //autonomia
    //Alimentación powersuply electrical network/bateri

    public String getInches() {
        return inches;
    }

    public void setInches(String inches) {
        this.inches = inches;
    }

 

}
