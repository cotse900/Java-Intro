/**********************************************
 Workshop 3 Task 1
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 15 Feb 2023
 **********************************************/
package WS03Task1;

/**
 * Introduces constructors and vars of base class
 */
public class Ticket {
    private int TicketNum;
    private int price;
    /**
     * one arg constructor
     * @param TicketNum ticket number
     */
    public Ticket(int TicketNum){
        this.TicketNum = TicketNum;
    }
    /**
     * getter
     * @return  ticket price of base class
     */
    public int getPrice(){
        return price;
    }

    /**
     * print
     * @return  a string of ticket number and price
     */
    public String toString(){
        return "Number: " + TicketNum + ", Price: " + getPrice();
    }
}
