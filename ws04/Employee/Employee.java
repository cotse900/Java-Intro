/**********************************************
 Workshop 4
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 22 Feb 2023
 **********************************************/
package WS04.Employee;

import WS04.Payable;

/**
 * Employee
 */
public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    /**
     * customer constructor
     * @param firstName             first name
     * @param lastName              last name
     * @param socialSecurityNumber  SIN
     */
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Employee: " + getFirstName() + getLastName() + getSocialSecurityNumber();
    }
    /**
     * getter
     * @return  first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * setter
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * getter
     * @return  last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter
     * @param lastName  last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter
     * @return  SIN
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * setter
     * @param socialSecurityNumber  SIN
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


}
