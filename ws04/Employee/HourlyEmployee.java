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

/**
 * HourlyEmployee
 */
public class HourlyEmployee extends Employee{
    private double wage;
    private double hours;

    /**
     * Custom constructor
     * @param firstName             first name
     * @param lastName              last name
     * @param socialSecurityNumber  SIN
     * @param wage                  wage
     * @param hours                 hours
     */
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        setHours(hours);
        setWage(wage);
    }

    /**
     * getter
     * @return  wage
     */
    public double getWage() {
        return wage;
    }

    /**
     * setter
     * @param wage  wage
     */
    public void setWage(double wage) {
        if (wage >= 0.0) {
            this.wage = wage;
        }
        else {
            throw new ArithmeticException("Wage has to be positive!");
        }
    }

    /**
     * getter
     * @return  hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * setter
     * @param hours hours
     */
    public void setHours(double hours) {
        if (hours >= 0.0 && hours <= 168.0) {
            this.hours = hours;
        }
        else {
            throw new ArithmeticException("Hours can only be between 0.0 and 168.0 inclusive.");
        }
    }

    @Override
    public double getPaymentAmount() {
        double pay;
        double overtimeHours = 40.0;
        if (getHours() > overtimeHours){
            double overtimeRate = 1.5;
            pay = overtimeHours * getWage() + (getHours() - overtimeHours) * getWage() * overtimeRate;
        }
        else {
            pay = getHours() * getWage();
        }
        return pay * 10.0/10.0;
    }

    @Override
    public String toString() {
        return "Name: " + super.getFirstName() + " " + super.getLastName() +
                "\nSIN: " + super.getSocialSecurityNumber()
                + "\nWage: " + getWage() + "\nHours: " + getHours();
    }
}
