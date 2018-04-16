package Person;

import java.io.Serializable;

public abstract class Person implements Serializable {
    //  private static final long serialversionUID = 1;
//    public static long getSerialversionUID() {
//        return serialversionUID;
//    }

    private String id;
    private final String dni;
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private String Company;
    private String City;
    private String County;
    private String State_Province;
    private String PostalCode;
    private String Phone;
    private String mobil;
    private String Email;
    private String Web;
    private Double salary;
    private boolean active;

    //Contructor básico
    public Person(String dni) {
        this.dni = dni;
        active=true;
    }
 public Person(String dni, String firstName, String lastName, Double salary) {
        this.dni=dni;
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
   active=true;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param Company the Company to set
     */
    public void setCompany(String Company) {
        this.Company = Company;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @param County the County to set
     */
    public void setCounty(String County) {
        this.County = County;
    }

    /**
     * @param State_Province the State_Province to set
     */
    public void setState_Province(String State_Province) {
        this.State_Province = State_Province;
    }

    /**
     * @param PostalCode the PostalCode to set
     */
    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @param mobil the mobil to set
     */
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @param Web the Web to set
     */
    public void setWeb(String Web) {
        this.Web = Web;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setfirstName(String name) {
        setFirstName(name);
    }

    public String getfirstName() {
        return getFirstName();
    }

    public void askForCredit() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void getContactPoints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public void update(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return Company;
    }

    public String getCity() {
        return City;
    }

    public String getCounty() {
        return County;
    }

    public String getState_Province() {
        return State_Province;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public String getMobil() {
        return mobil;
    }

    public String getEmail() {
        return Email;
    }

    public String getWeb() {
        return Web;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
