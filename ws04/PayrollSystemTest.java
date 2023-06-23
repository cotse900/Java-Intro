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
package WS04;

import WS04.Employee.BasePlusCommissionEmployee;
import WS04.Employee.CommissionEmployee;
import WS04.Employee.HourlyEmployee;
import WS04.Employee.SalariedEmployee;

/**
 * PayrollSystemTest
 */
public class PayrollSystemTest {
    /**
     * test everything
     */
    public PayrollSystemTest() {
    }

    /**
     * tester
     * @param args  args
     */
    public static void main(String[] args){
        Payable[] objects = {
                new Invoice("Mozzarella", "Dairy", 3, 8.65),
                new Invoice("Deli meat", "Meat", 1, 13.95),
                new SalariedEmployee("Jon", "Snow", "998-283-030",
                        476.6),
                new HourlyEmployee("Jaime", "Lannister", "998-266-020",
                        100.0, 168),
                new CommissionEmployee("Jorah", "Mormont", "998-254-010",
                        560900.41, 0.2),
                new BasePlusCommissionEmployee("Jayne", "Westerling", "998-283-040",
                        100000, 0.1, 10000.0),

                //error cases below

//                new SalariedEmployee("Edric", "Storm", "998-283-030",
//                        -1.0),
//                new HourlyEmployee("Loras", "Tyrell", "998-266-020",
//                        -1.0, 100),
//                new HourlyEmployee("Barristan", "Selmy", "998-266-020",
//                        100.0, 169),
//                new CommissionEmployee("Bronn", "Blackwater", "998-254-010",
//                        -1, 0.2),
//                new CommissionEmployee("Aegon", "Targaryen the N-th", "998-254-010",
//                        10000.0, -0.1),
//                new BasePlusCommissionEmployee("WhyIsGRRM", "WritingSoSlowly", "998-283-040",
//                        10000, 0.1, -1.0)

        };

        for (Payable object : objects) {
            double Reward = 0.1;
            System.out.println(object);
            if (object instanceof BasePlusCommissionEmployee employee) {
                employee.setBaseSalary(employee.getBaseSalary() * (1 + Reward));
            }
            if (object instanceof BasePlusCommissionEmployee) {
                System.out.println("Total payment amount: $" + String.format("%.2f", object.getPaymentAmount()) +
                        "\nReward to base salary: " + Reward * 100 + "%" + "\n");
            }
            else
                System.out.println("Total payment amount: $" + String.format("%.2f", object.getPaymentAmount()) + "\n");
        }
    }
}
