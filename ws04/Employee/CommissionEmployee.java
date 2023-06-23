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
 * CommissionEmployee
 */
public class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;

    /**
     * custom constructor
     * @param firstName             first name
     * @param lastName              last name
     * @param socialSecurityNumber  SIN
     * @param grossSales            sales
     * @param commissionRate        commission rate
     */
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    /**
     * getter
     * @return  sales
     */
    public double getGrossSales() {
        return grossSales;
    }

    /**
     * setter
     * @param grossSales sales
     */
    public void setGrossSales(double grossSales) {
        if (grossSales > 0.0){
            this.grossSales = grossSales;
        }
        else {
            throw new ArithmeticException("Gross sales has to be positive!");
        }
    }

    /**
     * getter
     * @return commission rate
     */
    public double getCommissionRate() {
        return commissionRate;
    }

    /**
     * setter
     * @param commissionRate    commission rate
     */
    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0.0 && commissionRate <= 1.0){
            this.commissionRate = commissionRate;
        }
        else {
            throw new ArithmeticException("Commission rate can only be between 0.0 and 1.0 inclusive.");
        }
    }

    @Override
    public double getPaymentAmount() {
        return Math.round(getCommissionRate() * getGrossSales() * 100)/100.0;
    }

    @Override
    public String toString() {
        return "Name: " + super.getFirstName() + " " + super.getLastName() +
                "\nSIN: " + super.getSocialSecurityNumber()
                + "\nSales: " + getGrossSales() + "\nCommission: " + getCommissionRate() * 100 + "%";
    }
}
