package Advanced.Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][];


        for (int row = 0; row < rows; row++) {
        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

          matrix[row] = arr;
        }
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum+= matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
