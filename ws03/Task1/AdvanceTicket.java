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
public class AdvanceTicket extends Ticket {
    private int AdvanceDays;
    /**
     * constant NumDays for comparison
     */
    public static final int NumDays = 10;
    /**
     * advance price: in 10 or more days
     */
    public static final int TenOrMoreDaysBeforeCost = 30;
    /**
     * advance price: in under 10 days
     */
    public static final int TenOrFewerDaysBeforeCost = 40;
    /**
     * constructor
     */
    public AdvanceTicket(){
        this(0, 0);
    }

    /**
     * two arg constructor
     * @param TicketNum a random ticket number
     * @param day       setting advance days
     */
    public AdvanceTicket(int TicketNum, int day) {
        super(TicketNum);
        AdvanceDays = day;
    }

    /**
     * Inherit one arg constructor from Ticket
     * @param TicketNum a random ticket number
     */
    public AdvanceTicket(int TicketNum) {
        super(TicketNum);
    }
    /**
     * getter
     * @return  how many advance days
     */
    public int GetDays(){
        return AdvanceDays;
    }
    /**
     * getter
     * @return  ticket price
     */
    public int getPrice(){
        if (AdvanceDays > NumDays){
            return TenOrMoreDaysBeforeCost;
        }
        else return TenOrFewerDaysBeforeCost;
    }

}
