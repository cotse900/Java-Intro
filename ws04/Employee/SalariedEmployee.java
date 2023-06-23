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
 * SalariedEmployee
 */
public class SalariedEmployee extends Employee{
    private double weeklySalary;

    /**
     * Custom constructor
     * @param firstName             first name
     * @param lastName              last name
     * @param socialSecurityNumber  SIN
     * @param weeklySalary          weekly salary
     */
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        setWeeklySalary(weeklySalary);
    }

    /**
     * getter
     * @return  weekly salary
     */
    public double getWeeklySalary() {
        return weeklySalary;
    }

    /**
     * setter
     * @param weeklySalary  weekly salary
     */
    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0){
            throw new ArithmeticException("Weekly salary has to be positive!");
        }
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return "Name: " + super.getFirstName() + " " + super.getLastName() +
                "\nSIN: " + super.getSocialSecurityNumber()
                + "\nWeekly Salary: " + getWeeklySalary();
    }
}
