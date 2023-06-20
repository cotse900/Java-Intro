/**********************************************
 Workshop 2 Task 2
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 8 Feb 2023
 **********************************************/
package WS02Task2;

/**
 * GroceryItemOrder
 */
public class GroceryItemOrder {
    //initialize
    String ItemNem;
    int ItemQty;
    double PricePerUnit;

    /**
     * setQuantity
     * @param quantity      set quantity, but not really used
     */
    public void setQuantity(int quantity) {
        ItemQty = quantity;
    }

    /**
     * Initalize
     * @param name      item's name
     * @param quantity  item's quantity
     * @param pricePerUnit  per price unit
     */
    public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
        ItemNem = name;
        ItemQty = quantity;
        PricePerUnit = pricePerUnit;
    }

    /**
     * Getter of cost
     * @return      total
     */
    public double getCost() {
        return ItemQty * PricePerUnit;
    }
}
