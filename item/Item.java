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
    private  String brand; 

    public Item(String code, String familyCode, String name, String description, double boughtPrice, double sellPrice, int quantity) {
        this.familyCode = familyCode;
        this.code = code;
        this.name = name;
        this.description = description;
        this.boughtPrice = boughtPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    
    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(String guaranty) {
        this.guaranty = guaranty;
    }

    public Item(String code) {
        this.code = code;
    }

    
    
    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeith() {
        return weith;
    }

    public void setWeith(String weith) {
        this.weith = weith;
    }

    public String getFamily() {
        return familyCode;
    }

    public void setFamily(String familyCode) {
        this.familyCode = familyCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBoughtPrice() {
        return boughtPrice;
    }

    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
