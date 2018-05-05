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
    
    /**
     *
     * @return
     */
    public String getPowersuply() {
        return powersuply;
    }

    /**
     *
     * @param powersuply
     */
    public void setPowersuply(String powersuply) {
        this.powersuply = powersuply;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeigth() {
        return heigth;
    }

    /**
     *
     * @param heigth
     */
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    /**
     *
     * @return
     */
    public int getDepth() {
        return depth;
    }

    /**
     *
     * @param depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
 
    /**
     *
     * @param code
     */
    public Electrodomestic(String code) {
        super(code);
    }

    /**
     *
     * @return
     */
    public String getPower() {
        return power;
    }

    /**
     *
     * @param power
     */
    public void setPower(String power) {
        this.power = power;
    }

    /**
     *
     * @return
     */
    public String getRecharTime() {
        return recharTime;
    }

    /**
     *
     * @param recharTime
     */
    public void setRecharTime(String recharTime) {
        this.recharTime = recharTime;
    }

    /**
     *
     * @return
     */
    public String getEnergyCertification() {
        return energyCertification;
    }

    /**
     *
     * @param energyCertification
     */
    public void setEnergyCertification(String energyCertification) {
        this.energyCertification = energyCertification;
    }

}
