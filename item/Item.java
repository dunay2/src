/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.io.Serializable;

/**
 *
 * @author ashh412
 */
public abstract class Item implements Serializable {

    private static final long serialVersionUID = -2873344211410398459L;
    private String familyCode;
    private String code;
    private String name;
    private String description;

    private double boughtPrice;
    private double sellPrice;
    private int quantity;
    private String color;
    private String weith;
    private String guaranty;
    private String brand;

    /**
     *
     * @param code
     * @param familyCode
     * @param name
     * @param description
     * @param boughtPrice
     * @param sellPrice
     * @param quantity
     */
    public Item(String code, String familyCode, String name, String description, double boughtPrice, double sellPrice, int quantity) {
        this.familyCode = familyCode;
        this.code = code;
        this.name = name;
        this.description = description;
        this.boughtPrice = boughtPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;

    }

    /**
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return
     */
    public String getFamilyCode() {
        return familyCode;
    }

    /**
     *
     * @param familyCode
     */
    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    /**
     *
     * @return
     */
    public String getGuaranty() {
        return guaranty;
    }

    /**
     *
     * @param guaranty
     */
    public void setGuaranty(String guaranty) {
        this.guaranty = guaranty;
    }

    /**
     *
     * @param code
     */
    public Item(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public String getWeith() {
        return weith;
    }

    /**
     *
     * @param weith
     */
    public void setWeith(String weith) {
        this.weith = weith;
    }

    /**
     *
     * @return
     */
    public String getFamily() {
        return familyCode;
    }

    /**
     *
     * @param familyCode
     */
    public void setFamily(String familyCode) {
        this.familyCode = familyCode;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public double getBoughtPrice() {
        return boughtPrice;
    }

    /**
     *
     * @param boughtPrice
     */
    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    /**
     *
     * @return
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     *
     * @param sellPrice
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
