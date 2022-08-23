package Advanced.Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06_PrintDiagonalsOfMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsCols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowsCols][];


        for (int row = 0; row < rowsCols; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        StringBuilder primary = new StringBuilder("");
        StringBuilder secondary = new StringBuilder("");

        for (int row = 0; row < rowsCols; row++) {

            for (int col = 0; col < rowsCols; col++) {
                if (row == col) {
                    primary.append(matrix[row][col] + " ");
                }

            }
        }
        for (int row = rowsCols - 1; row >= 0; row--) {

            for (int col = 0; col < rowsCols; col++) {
                if (row + col == rowsCols - 1) {
                    secondary.append(matrix[row][col] + " ");
                }

            }
        }
        System.out.println(primary);
        System.out.println(secondary);

    }
}
