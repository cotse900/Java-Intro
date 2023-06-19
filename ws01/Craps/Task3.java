/**********************************************
 Workshop 1 Task 3
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 1 Feb 2023
 **********************************************/
package Craps;
import java.util.Scanner;
/**
 * Task 3
 * @author Chungon Tse
 * Modifying Craps
 * Die1     first die
 * Die2     second die
 * BankBalance  starting/current balance
 * wager    the money to bet on each turn
 * quit     exit the program
 * repeat   continue the game
 */
public class Task3 {
    Task3(){};
    static int Die1, Die2;
    //add
    static double BankBalance = 1000.00;
    static double wager;
    static boolean quit, repeat = true;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Main
     * @param args  Main
     */
    public static void main(String[] args) {
        System.out.println("Let's play craps!...");
        while (!quit) {
            Play();
            while (repeat && !quit){
                repeat = Repeat();
                if (repeat) Play();
            }
        }
    }
    /**
     * This method is the main game modified from {@link Task2}
     * {@link Craps.Chatter} Chatter supports this module adding messages
     */
    public static void Play() {
        int sum1, sum2;
        Task3 task3 = new Task3();
        Chatter chat = new Chatter();
        //
        System.out.println("Your starting balance: " + BankBalance);
        System.out.print("Enter your wager: ");
        scanner.reset();
        wager = scanner.nextDouble();

        while (wager > BankBalance || wager < 0)
        {
            if (wager > BankBalance) {
                System.out.print("Insufficient funds, enter again: ");
                wager = scanner.nextDouble();
            }
            if (wager < 0)
            {
                System.out.print("The wager must be positive, enter again: ");
                wager = scanner.nextDouble();
            }
        }
        chat.RandomString();

        System.out.println("Press enter to roll two dice...");

        scanner.nextLine();

        Die1 = roll();
        Die2 = roll();
        sum1 = Die1 + Die2;
        if (sum1 == 7 || sum1 == 11){
            System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum1);
            System.out.println("Congratulations, You win");
            //
            BankBalance += wager;
            wager = 0;
            System.out.println("Your current balance: " + BankBalance);
        }
        else if (sum1 == 2 || sum1 == 3 || sum1 == 12){
            System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum1);
            System.out.println("Craps, Better Luck Next Time, You lose");

            BankBalance -= wager;
            wager = 0;
            System.out.println("Your current balance: " + BankBalance);
            if (BankBalance <= 0) {
                System.out.println("Sorry. You busted!");
                quit = true;
            }

        }
        else {
            System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum1);
            System.out.print("Point is (established) set to " + sum1);

            chat.RandomString();
            scanner.nextLine();

            do {
                Die1 = roll();
                Die2 = roll();
                sum2 = Die1 + Die2;
                if (sum2 == sum1) {
                    System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum2);
                    System.out.println("Congratulations, You win");
                    //
                    BankBalance += wager;
                    wager = 0;
                    System.out.println("Your current balance: " + BankBalance);
                    break;
                }
                else if (sum2 == 7) {
                    System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum2);
                    System.out.println("Craps, Better Luck Next Time, You lose");

                    BankBalance -= wager;
                    wager = 0;
                    System.out.println("Your current balance: " + BankBalance);
                    if (BankBalance <= 0) {
                        System.out.println("Sorry. You busted!");
                        quit = true;
                    }
                    break;
                }
                else {
                    System.out.print("You rolled " + Die1 + " + " + Die2 + " = " + sum2);
                }

                scanner.nextLine();

            } while (!quit);
        }

        //

    }
    /**
     * Roll
     * @return      random die number 1 to 6
     */
    public static int roll() {
        int Num = (int)((Math.random() * 6) + 1);
        return Num;
    }
    /**
     * Repeat
     * @return      a true means continue, and a false means quitting the game
     */
    public static boolean Repeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Continue? (Type 1 or 2)");
        System.out.print("1. Yes\n2. No\nOption: ");

        int option = scanner.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("No such option");
            option = scanner.nextInt();
        }
        if (option == 1) {
            System.out.println("Continue...");
        }
        else {
            System.out.println("Bye. Come back when you have money.");
            repeat = false;
            quit = true;
        }

        return repeat;
    }
}