/**********************************************
 Workshop 8
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 28 Mar 2023
 **********************************************/
package ws08_task1;

import java.util.Scanner;
/**
 * main
 */
public class Main {
    /**
     * constructor
     */
    public Main(){}
    /**
     * maxval
     */
    public static final DoubleArrayFunctions MaxVal = array -> {
        double max = Double.NEGATIVE_INFINITY;
        for (double d : array) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    };
    /**
     * minimal value
     */
    public static final DoubleArrayFunctions MinVal = array -> {
        double min = Double.POSITIVE_INFINITY;
        for (double d : array) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    };
    /**
     * sum
     */
    public static final DoubleArrayFunctions Sum = array -> {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum;
    };
    /**
     * average
     */
    public static final DoubleArrayFunctions Average = array -> {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum / array.length;
    };

    /**
     * counter function
     * @param value     double value
     * @return          count
     */
    public static DoubleArrayFunctions counter(double value) {
        return array -> {
            int count = 0;
            for (double d : array) {
                if (d == value) {
                    count++;
                }
            }
            return count;
        };
    }

    /**
     * Main
     * @param args  args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scan.nextInt();
        double[] array = new double[size];

        for (int i = 0; i < size; i++){
            System.out.print("Enter the value for index " +  (i+1) +": ");
            array[i] = scan.nextDouble();
        }

        System.out.print("Maximum value in the array: ");
        System.out.println(MaxVal.applyDouble(array));
        System.out.print("Minimal value in the array: ");
        System.out.println(MinVal.applyDouble(array));
        System.out.print("Sum of all array elements: ");
        System.out.println(Sum.applyDouble(array));
        System.out.print("Average of all array elements: ");
        System.out.println(Average.applyDouble(array));

        System.out.print("Enter a number to check how many times it appears in this array: ");
        double TargetNum = scan.nextDouble();
        DoubleArrayFunctions counter2 = counter(TargetNum);
        int count = (int) counter2.applyDouble(array);
        System.out.println(TargetNum + " appears " + count + " " + (count == 1 ? "time" : "times"));
    }
}

