package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = 0;

        int[][] matrix = new int[rows][];


        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            cols = arr.length;
            matrix[row] = arr;
        }
        int primarySum = 0;
        int secondarySum = 0;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                if (row == col) {
                    primarySum += matrix[row][col];
                }
                if (row + col == cols - 1) {
                    secondarySum += matrix[row][col];
                }
            }
        }
        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
