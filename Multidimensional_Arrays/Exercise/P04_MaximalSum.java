package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        if (rows < 3 || cols < 3) {
            return;
        }
        int[][] matrix = new int[rows][cols];


        //Fill
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        int totalSum = 0;
        int[][] matrix3x3 = new int[3][3];

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                if (col + 3 > cols) {
                    break;
                } else {
                    int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                            matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                            matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                    if (totalSum < sum) {
                        totalSum = sum;
                        matrix3x3[0][0] = matrix[row][col];
                        matrix3x3[0][1] = matrix[row][col + 1];
                        matrix3x3[0][2] = matrix[row][col + 2];
                        matrix3x3[1][0] = matrix[row + 1][col];
                        matrix3x3[1][1] = matrix[row + 1][col + 1];
                        matrix3x3[1][2] = matrix[row + 1][col + 2];
                        matrix3x3[2][0] = matrix[row + 2][col];
                        matrix3x3[2][1] = matrix[row + 2][col + 1];
                        matrix3x3[2][2] = matrix[row + 2][col + 2];
                    }
                }

            }
            if (row + 3 == rows) {
                break;
            }
        }

        System.out.printf("Sum = %d%n", totalSum);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(matrix3x3[row][col] + " ");
            }
            System.out.println();
        }
    }
}
