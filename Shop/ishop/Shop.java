package Shop.ishop;

import Shop.Deparment.Department;
import java.util.ArrayList;


/*Scanner*/
public abstract class Shop implements IBusiness {

    private String name;

    private String fiscalID;
//Mantenemos un ArrayList de departamentos

    ArrayList<Department> departments = new ArrayList<>();

//
//    private Employee Employee;
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

    public void addDepartment(Department department) {

        departments.add(department);

        //  System.out.println("La cantidad de departamentos es "+  departments.size());
    }

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
