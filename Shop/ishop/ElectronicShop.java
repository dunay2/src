package Shop.ishop;

import Managers.MainManager;
import Samples.addTestItems;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElectronicShop extends Shop {

    public static void main(String[] args) {


            MainManager scene = new MainManager();

          //  addTestItems.addComponents();

        try {
            scene.start();
        } catch (IOException ex) {
            Logger.getLogger(ElectronicShop.class.getName()).log(Level.SEVERE, null, ex);
        }

     
    }

  
}
