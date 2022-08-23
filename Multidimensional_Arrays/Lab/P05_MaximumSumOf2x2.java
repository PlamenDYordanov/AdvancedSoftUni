package Advanced.Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MaximumSumOf2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }

        int sum = 0;
        int total = 0;
        int[][] subMatrix = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {


            for (int col = 0; col < cols - 1; col ++) {
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (total < sum) {
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                    total = sum;
                }

            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(total);
    }
}
