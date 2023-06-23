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
 * inherits AdvanceTicket
 */
public class StudentAdvanceTicket extends AdvanceTicket{
    /**
     * constructor
     */
    public StudentAdvanceTicket(){
        this(0,0);
    }

    /**
     * two-arg constructor
     * @param TicketNum ticket number
     * @param day       advance days
     */
    public StudentAdvanceTicket(int TicketNum, int day){
        super(TicketNum, day);
    }
    /**
     * one arg constructor from AdvanceTicket
     * @param TicketNum ticket number
     */
    public StudentAdvanceTicket(int TicketNum) {
        super(TicketNum);
    }

    public int getPrice(){
        if (super.GetDays() > AdvanceTicket.NumDays){
            return AdvanceTicket.TenOrMoreDaysBeforeCost / 2;
        }
        else return AdvanceTicket.TenOrFewerDaysBeforeCost / 2;
    }

    /**
     * print
     * @return  student ticket
     */
    public String toString(){
        return super.toString() + " (ID required)";
    }
}
