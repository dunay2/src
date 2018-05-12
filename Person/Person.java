package Person;

import Utils.Record.Record;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ashh412
 */
public abstract class Person implements Serializable, IPersonOperation {
    private static final long serialVersionUID = -2873344211410398459L;
    private final String key;
    private final String dni;
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private String company;
    private String city;
    private String county;
    private String stateProvince;
    private String postalCode;
    private String phone;
    private String mobil;
    private String email;
    private String web;
    private Double salary;
    private boolean active;
    private final List<Record> operations = new ArrayList<>();//Valor de código de operacion

    //Contructor básico

    /**
     *
     * @param dni
     */
    public Person(String dni) {
        this.dni = dni;
        active = true;
        key = "0";
    }

    /**
     *
     * @param dni
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     */
    public Person(String dni, String firstName, String lastName, String address, String phone) {

        key = "0";
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
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
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @param stateProvince the stateProvince to set
     */
    public void setstateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    /**
     * @param postalCode the PostalCode to set
     *
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    /**
     * @param mobil the mobil to set
     */
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     *
     */
    public void askForCredit() {

    }

    /**
     *
     * @return
     */
    public String getkey() {
        return key;
    }

    /**
     *
     * @return
     */
    public double getSalary() {
        if (salary == null) {
            salary = 0D;
        }
        return salary;
    }

    /**
     *
     */
    public void getContactPoints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     *
     * @param person
     */
    public void update(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public String getDni() {
        return dni;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public String getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public String getCompany() {
        return company;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return
     */
    public String getCounty() {
        return county;
    }

    /**
     *
     * @return
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return
     */
    public String getMobil() {
        return mobil;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getWeb() {
        return web;
    }

    /**
     *
     * @return
     */
    public boolean isActive() {
        return active;
    }

    /**
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Record> getOperations() {
        return operations;
    }

    @Override
    public void addOperation( Record record) {

        operations.add(record);
    }
}
