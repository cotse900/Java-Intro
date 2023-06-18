/**********************************************
 Workshop 1 Task 1
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 1 Feb 2023
 **********************************************/
package Task1;
import java.util.Scanner;
/**
 * Task 1
 * @author Chungon Tse
 * Cryptography
 */
public class Task1 {
    Task1(){}
    /**
     * Encoding
     * @param input     ask user to input a number for encoding
     * @return          the encoded number
     */
    public int encoding (int input){
        int[] digit = new int[4];
        for (int n = 3; n >= 0; n--){
            digit[n] = input % 10;
            input /= 10;
        }
        //Replace each digit with the result of adding 7 to the digit and getting the remainder after
        //dividing the new value by 10.
        for (int n = 0; n < digit.length; n++){
            digit[n] = (digit[n] + 7) % 10;
        }
        //Then swap the first digit with the third and swap the second digit with the fourth.
        int temp = digit[0];
        digit[0] = digit[2];
        digit[2] = temp;
        temp = digit[1];
        digit[1] = digit[3];
        digit[3] = temp;

        for (int n : digit){
            input = input * 10 + n;
        }

        return input;
    }

    /**
     * Decoding
     * @param output    decode the number from encoding
     * @return          the decoded number which is the input
     */
    public int decoding (int output){
        int[] digit = new int[4];
        for (int n = 3; n >= 0; n--){
            digit[n] = output % 10;
            output /= 10;
        }
        for (int n = 0; n < digit.length; n++){
            digit[n] = (digit[n] + 3) % 10;
        }
        int temp = digit[0];
        digit[0] = digit[2];
        digit[2] = temp;
        temp = digit[1];
        digit[1] = digit[3];
        digit[3] = temp;

        for (int n : digit){
            output = output * 10 + n;
        }

        return output;
    }

    /**
     * main
     * @param args      main
     */
    public static void main(String[] args) {
        int input;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a 4-digit number: ");
        input = scan.nextInt();
        while (input < 1000 || input > 9999){
            System.out.print("Enter a 4-digit number!: ");
            input = scan.nextInt();
        }
        scan.close();

        Task1 ThisTask = new Task1();
        int encoded = ThisTask.encoding(input);
        int decoded = ThisTask.decoding(encoded);

        System.out.print("Input is " + input + "\n");
        System.out.print("Encoded is " + encoded + "\n");
        System.out.print("Decoded is " + decoded + "\n");
    }
}
