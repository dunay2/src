package Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Serializable, IPersonOperation {

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
    private final List<String> operations = new ArrayList<>();//Valor de código de operacion

    //Contructor básico
    public Person(String dni) {
        this.dni = dni;
        active = true;
        key = "0";
    }

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

    public void askForCredit() {

    }

    public String getkey() {
        return key;
    }

    public double getSalary() {
        if (salary == null) {
            salary = 0D;
        }
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
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobil() {
        return mobil;
    }

    public String getEmail() {
        return email;
    }

    public String getWeb() {
        return web;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public List<String> getOperations() {
        return operations;
    }

    @Override
    public void addOperation(String e) {

        operations.add(e);
    }
}
