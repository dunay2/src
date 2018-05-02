/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.family.computers;


import item.IRechargable;

/**
 *
 * @author ashh412
 */
public class BateryComputer extends Computer  implements IRechargable{


    private String autonomy; //autonomia

//    }

    public BateryComputer(String code) {
        super(code);
    }

   


    @Override
   public String getAutonomy() {
        return autonomy;
    }
    
  

    @Override
    public void setAutonomy(String autonomy) {
        this.autonomy = autonomy;
    }
    
    

}
