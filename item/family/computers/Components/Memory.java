/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.family.computers.Components;

import item.family.computers.Computer;

/**
 *
 * @author ashh412
 */
public class   Memory extends Computer {
    private String capacity;
    public  Memory(String code) {
        super(code);
      }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    
    
    
}
