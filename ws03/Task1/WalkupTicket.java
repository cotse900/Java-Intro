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
 * inherits Ticket
 */
public class WalkupTicket extends Ticket {
    /**
     * constructor
     */
    public WalkupTicket(){
        this(0);
    }

    /**
     * getter
     * @param TicketNum ticket number
     */
    public WalkupTicket(int TicketNum) {
        super(TicketNum);
    }
    //overrides Ticket
    public int getPrice(){
        return 50;
    }

}
