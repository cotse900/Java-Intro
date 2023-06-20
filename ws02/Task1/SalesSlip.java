/**********************************************
 Workshop 2 Task 1
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 8 Feb 2023
 **********************************************/
package WS02Task1;
/**
 * SalesSlip        This class contains task 1
 */
public class SalesSlip {
    /**
     * Initializes sales
     */
    public double[][] Sales;

    /**
     *  This 2d array includes product (5) and salesperson (4)
     */
    public SalesSlip() {
        this.Sales = new double[5][4];
    }
    /**
     * GetSales
     * @return      "Sales" already includes Person, Product and Value
     */
    public double[][] GetSales() {
        return Sales;
    }
    /**
     * Random       sets random for the 2d array
     */
    public void Random() {
        //5 products 4 guys
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Sales[i][j] = Math.random() * 1000;
            }
        }
    }
    /**
     * Total
     * @param       Sales       as a 2d array
     */
    public void total(double[][] Sales) {
        double TotalValue;
        double[] Revenue = new double[Sales[0].length];
        //heading
        System.out.print("\nProd/Person      ");
        for (int n = 1; n <= Sales[0].length; n++) System.out.printf("%-8d", n);
        System.out.print("Total  ");
        System.out.println();
        //each sales guy
        for (int a = 0; a < Sales.length; a++) {
            TotalValue = 0.0;
            System.out.printf("%9d       ", a + 1);
            for (int b = 0; b < Sales[0].length; b++) {
                TotalValue += Sales[a][b];
                Revenue[b] += Sales[a][b];
                System.out.printf(" %-7.2f", Sales[a][b]);
            }
            System.out.printf("%8.2f  \n", TotalValue);
        }
        System.out.printf("%13s   ","Total");
        for (double r : Revenue) System.out.printf(" %-7.2f", r);
        System.out.println();

    }
    /**
     * Main runs Random and total for 100 times
     * @param args  Main
     */
    public static void main(String[] args) {

        SalesSlip slip = new SalesSlip();

        for (int repeat = 0; repeat < 100; repeat++){
            slip.Random();
            slip.total(slip.GetSales());
        }
    }
}
