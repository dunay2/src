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

    private String power;//220 240 V
    private String powersuply;// electrical network/bateri;
    private String recharTime;
    private String energyCertification;
    private int width;//ancho cm
    private int heigth;//alto cm
    private int depth;// fondo cm 
    
   

    public String getPowersuply() {
        return powersuply;
    }

    public void setPowersuply(String powersuply) {
        this.powersuply = powersuply;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
 
   

    public Electrodomestic(String code) {
        super(code);
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getRecharTime() {
        return recharTime;
    }

    public void setRecharTime(String recharTime) {
        this.recharTime = recharTime;
    }

    public String getEnergyCertification() {
        return energyCertification;
    }

    public void setEnergyCertification(String energyCertification) {
        this.energyCertification = energyCertification;
    }

}
