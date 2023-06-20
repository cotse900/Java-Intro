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

import java.util.Scanner;
/**
 * GroceryList
 */
public class GroceryList {
    /**
     * initialize
     */
    int size;
    static GroceryList groceryList = new GroceryList();
    GroceryItemOrder[] list = new GroceryItemOrder[10];
    /**
     * GroceryList      constructor
     */
    public GroceryList() {
        size = 0;
    }
    /**
     * add()        limit of 10 items to add
     *
     * @param item      each item
     */
    public void add(GroceryItemOrder item) {
        if (this.size < 10) {
            for (int n = 0; n < this.list.length; n++) {
                if (this.list[n] == null) {
                    this.list[n] = item;
                    break;
                }
            }
            size++;
        }
    }
    /**
     * getTotalCost()       returns total cost
     *
     * @return      totalCost as a double
     */
    public double getTotalCost() {
        double PerUnit;
        double TotalCost = 0;
        for (int n = 0; n < size; n++) {
            PerUnit = this.list[n].getCost();
            TotalCost += PerUnit;
        }
        return TotalCost;
    }
    /**
     * toStr()      make strings
     *
     * @return      prints each entry with item name, quantity, per-unit price, subtotals, and total
     */
    public String PrintList() {
        StringBuilder entry = new StringBuilder("Checkout grocery list:\n");
        for (int n = 0; n < 10; n++) {
            if (groceryList.list[n] != null) {
                entry.append(groceryList.list[n].ItemNem).
                        append(" x ").append(groceryList.list[n].ItemQty).
                        append(" pcs  $").append(this.list[n].getCost()).
                        append("\n");
            }
        }
        return entry.toString();
    }
    /**
     * Main     prints grocery list
     * @param args Main
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("My Grocery List");
        System.out.println("Please add any item");
        System.out.println("Example: Mayonnaise [item name] space 2 [quantity/pieces] space 1.39 [per unit price]");
        System.out.println("Hit enter, then add another item");
        System.out.println("Enter \"x\" to exit\n");

        String string;
        int qty;
        double PerUnitPrice;
        while (true) {
            string = in.next();
            if (string.equalsIgnoreCase("x")) {
                break;
            }
            qty = in.nextInt();
            PerUnitPrice = in.nextDouble();
            GroceryItemOrder newItem = new GroceryItemOrder(string, qty, PerUnitPrice);
            groceryList.add(newItem);
        }
        System.out.println(groceryList.PrintList());
        System.out.println("Total grocery cost: $" + Math.round(groceryList.getTotalCost() * 100.00)/100.00);
        System.out.println("Thank you for shopping!");
    }
}