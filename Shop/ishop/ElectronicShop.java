package Shop.ishop;

import Managers.MainManager;
import Samples.AddTest;

/**
 *
 * @author ashh412
 */
public class ElectronicShop extends Shop {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        AddTest.addTestEmployees();
        AddTest.addTestComponents();
        AddTest.addTestSale();
      
        
       // AddTest.testRepair();

      //  AddTest.testChangeOrderStatus();

       // AddTest.printOrders("");

        MainManager scene = new MainManager();

        //  scene.start();
    }

}
