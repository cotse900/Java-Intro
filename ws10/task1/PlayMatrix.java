/**********************************************
 Workshop 10
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 17 Apr 2023
 **********************************************/
package task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Play matrix
 */
public class PlayMatrix {
    private static final int NumThreads = 4;
    private static final int size = 2000;

    /**
     * constructor
     */
    public PlayMatrix(){}
    /**
     * main
     * @param args  args
     */
    public static void main(String[] args) {
        double[][]a = startMatrix(size, size);
        double[][]b = startMatrix(size, size);

        long start = System.nanoTime();
        parallelMultiplyMatrix(a, b);
        long end = System.nanoTime();
        System.out.println("Parallel matrix multiplication time using " + NumThreads +
                " threads: " + (end - start) / 1e6 + " ms");
        System.out.println("Parallel multiplication done!...");

        long start2 = System.nanoTime();
        sequentialMultiplyMatrix(a, b);
        long end2 = System.nanoTime();
        System.out.println("Sequential matrix addition time: " + (end2 - start2) / 1e6 + " ms");
        System.out.println("Sequential multiplication done!...");


    }

    /**
     * start matrix
     * @param numRows       rows
     * @param numColumns    columns
     * @return              generate matrix
     */
    public static double[][] startMatrix (int numRows, int numColumns){
        double[][] matrix = new double[numRows][numColumns];
        for (int row = 0; row < numRows; row++){
            for (int column = 0; column < numColumns; column++){
                matrix[row][column] = (int)(Math.random() * 10.0);
            }
        }
        return matrix;
    }

    /**
     * parallel multiply
     * @param a matrix a
     * @param b matrix b
     * @return  result of matrices
     */
    public static double[][] parallelMultiplyMatrix(double[][]a, double[][]b){
        double[][] res = new double[a.length][b[0].length];
        ExecutorService executor = Executors.newFixedThreadPool(NumThreads);
        for (int td = 0; td < NumThreads; td++){
            int startRow = (int) ((td * 1.0 / NumThreads) * a.length);
            int endRow = (int) (((td * 1.0 + 1) / NumThreads) * a.length);
            executor.execute(new ParallelMultiply(a, b, res, startRow, endRow));
        }
        executor.shutdown();
        return res;
    }

    /**
     * parallel multiply
     */
    public static class ParallelMultiply implements Runnable{
        private final double[][] x;
        private final double[][] y;
        private final double[][] localRes;
        private final int localRow;
        private final int localRow2;

        /**
         * parallel multiply
         * @param x     matrix 1
         * @param y     matrix 2
         * @param res   result
         * @param row1  row1
         * @param row2  row2
         */
        public ParallelMultiply(double[][] x, double[][] y, double[][] res, int row1, int row2) {
            this.x = x;
            this.y = y;
            this.localRes = res;
            this.localRow = row1;
            this.localRow2 = row2;
        }

        @Override
        public void run() {
            for (int i = 0; i < localRes.length; i++) {
                for (int j = 0; j < localRes[0].length; j++) {
                    localRes[i][j] = 0;
                }
            }
        }
    }

    /**
     * sequential multiply
     * @param a matrix a
     * @param b matrix b
     * @return  result of matrices
     */
    public static double[][] sequentialMultiplyMatrix(double[][]a, double[][]b){
        double[][] res = new double[a.length][b[0].length];
        for (int aRow = 0; aRow < a.length; aRow++){
            for (int bColumn = 0; bColumn < b[0].length; bColumn++){
                for (int c = 0; c < b.length; c++){
                    res[aRow][bColumn] += a[aRow][c] * b[c][bColumn];
                }
            }
        }
        return res;
    }
}
