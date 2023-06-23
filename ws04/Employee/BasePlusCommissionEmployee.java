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
 * BasePlusCommissionEmployee
 */
public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double BaseSalary;

    /**
     * Custom constructor
     * @param firstName             first name
     * @param lastName              last name
     * @param socialSecurityNumber  SIN
     * @param grossSales            sales
     * @param commissionRate        commission rate
     * @param baseSalary            base salary
     */
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        setBaseSalary(baseSalary);
    }

    /**
     * getter
     * @return  base salary
     */
    public double getBaseSalary() {
        return BaseSalary;
    }

    /**
     * setter
     * @param baseSalary    base salary
     */
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0.0){
            this.BaseSalary = baseSalary;
        }
        else {
            throw new ArithmeticException("Base salary has to be positive!");
        }
    }

    @Override
    public double getPaymentAmount() {
        return Math.round(super.getPaymentAmount() + getBaseSalary())
                *100/100.0;
    }

    @Override
    public String toString() {
        return "Name: " + super.getFirstName() + " " + super.getLastName()
                + "\nSIN: " + super.getSocialSecurityNumber()
                + "\nCommission: " + super.getCommissionRate() * 100 + "%"
                + "\nSales: " + super.getGrossSales()
                + "\nBasic salary: " + getBaseSalary();
    }
}
