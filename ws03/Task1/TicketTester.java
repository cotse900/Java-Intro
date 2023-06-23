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

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

class TicketTester {
    private static Scanner scanner;
    private Random random;

    public TicketTester() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void buyWalkupTicket() {
        int ticketNumber = random.nextInt(1000) + 1;
        Ticket t1 = new WalkupTicket(ticketNumber);
        System.out.println("Walk-up Ticket");
        System.out.println(t1 + "\n");
    }

    public void buyAdvanceTicket() {
        int ticketNumber = random.nextInt(1000) + 1;
        System.out.println("Advance Ticket");
        System.out.println("Price:");
        System.out.println("If the event is in 10 or more days from now: $" + AdvanceTicket.TenOrMoreDaysBeforeCost);
        System.out.println("If the event is in 1 to 9 days from now: $" + AdvanceTicket.TenOrFewerDaysBeforeCost);
        System.out.print("Please enter how many days from now: ");
        int HowManyDays = scanner.nextInt();
        Ticket t2 = new AdvanceTicket(ticketNumber, HowManyDays);
        System.out.println(t2 + "\n");
    }

    public void buyStudentAdvanceTicket() {
        int ticketNumber = random.nextInt(1000) + 1;
        System.out.println("Student Advance Ticket");
        System.out.println("Price:");
        System.out.println("If the event is in 10 or more days from now: $" + AdvanceTicket.TenOrMoreDaysBeforeCost / 2);
        System.out.println("If the event is in 1 to 9 days from now: $" + AdvanceTicket.TenOrFewerDaysBeforeCost / 2);
        System.out.print("Please enter how many days from now: ");
        int HowManyDays = scanner.nextInt();
        Ticket t3 = new StudentAdvanceTicket(ticketNumber, HowManyDays);
        System.out.println(t3 + "\n");
    }

    public void showMenu() {
        System.out.println("Campus Event Ticket Menu");
        System.out.println("1. Buy Walk-up Ticket");
        System.out.println("2. Buy Advance Ticket");
        System.out.println("3. Buy Student Advance Ticket");
        System.out.println("4. Quit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> buyWalkupTicket();
            case 2 -> buyAdvanceTicket();
            case 3 -> buyStudentAdvanceTicket();
            case 4 -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    public static void main(String[] args) {
        TicketTester t = new TicketTester();
        while (true) {
            try {
                t.showMenu();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // clear the scanner buffer
            } catch (Exception e) {
                System.out.println("An error has occurred: " + e.getMessage());
            }
        }
    }
}
