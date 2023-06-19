/**********************************************
 Workshop 1 Task 2
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
 * Task 2
 * @author Chungon Tse 1 Feb 2023
 * This is Workshop 1 Task 2 on Craps.
 * Die1     first die
 * Die2     second die
 * sum1     sum of dice before established point, i.e. when first throw doesn't determine win/lose
 * sum2     sum of dice after established point, and it can continue until a decisive throw
 */
public class Task2 {
    Task2(){};
    static int Die1, Die2;
    /**
     * Main
     * @param args  main
     */
    public static void main(String[] args) {
        int sum1, sum2;
        Task2 task2 = new Task2();
        System.out.println("Let's play craps!...");
        System.out.println("Press enter to roll two dice...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Die1 = roll();
        Die2 = roll();
        sum1 = Die1 + Die2;
        if (sum1 == 7 || sum1 == 11){
            System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum1);
            System.out.println("Congratulations, You win");
        }
        else if (sum1 == 2 || sum1 == 3 || sum1 == 12){
            System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum1);
            System.out.println("Craps, Better Luck Next Time, You lose");
        }
        else {
            System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum1);
            System.out.print("Point is (established) set to " + sum1);

            scanner.nextLine();

            do {
                Die1 = roll();
                Die2 = roll();
                sum2 = Die1 + Die2;
                if (sum2 == sum1) {
                    System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum2);
                    System.out.println("Congratulations, You win");
                    break;
                }
                else if (sum2 == 7) {
                    System.out.println("You rolled " + Die1 + " + " + Die2 + " = " + sum2);
                    System.out.println("Craps, Better Luck Next Time, You lose");
                    break;
                }
                else {
                    System.out.print("You rolled " + Die1 + " + " + Die2 + " = " + sum2);
                }

                scanner.nextLine();

            } while (true);
        }
    }
    /**
     * Roll
     * @return      random die number 1 to 6
     *
     */
    public static int roll(){
        int Num = (int)((Math.random() * 6) + 1);
        return Num;
    }
}