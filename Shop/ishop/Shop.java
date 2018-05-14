package Shop.ishop;

import Shop.Deparment.Department;
import java.util.ArrayList;


/*Scanner*/

/**
 *
 * @author ashh412
 */

public abstract class Shop implements IBusiness {

    private String name;

    private String fiscalID;
//Mantenemos un ArrayList de departamentos

    /**
     *
     * @return
     */
    public String getFiscalID() {
        return fiscalID;
    }

    /**
     *
     * @param fiscalID
     */
    public void setFiscalID(String fiscalID) {
        this.fiscalID = fiscalID;
    }

    ArrayList<Department> departments = new ArrayList<>();

 
//
//    private Store store;
//
//    private Store commonStore;

    @Override
    public void open() {
    }

    @Override
    public void close() {
    }

    @Override
    public void addClient() {
    }

    /**
     *
     * @param department
     */
    public void addDepartment(Department department) {

        departments.add(department);

        //  System.out.println("La cantidad de departamentos es "+  departments.size());
    }

    /**
     *
     * @param department
     * @return
     */
    public Department removeDepartment(Department department) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateClient() {
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
