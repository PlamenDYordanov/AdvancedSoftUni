package Advanced.Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08_WrongMeasurements {
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

        String[] indexes = scanner.nextLine().split("\\s+");
        int indexRow = Integer.parseInt(indexes[0]);
        int indexCol = Integer.parseInt(indexes[1]);

        boolean flag = false;
        int value = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == indexRow && col == indexCol) {
                    value = matrix[row][col];
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        int[][] printMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                boolean isFind = false;
                int sum = 0;
                if (matrix[row][col] == value) {
                    isFind = true;
                    if (row - 1 >= 0) {
                        if (matrix[row - 1][col] != value) {
                            sum += matrix[row - 1][col];
                        }
                    }
                    if (row + 1 <= rows - 1) {
                        if (matrix[row + 1][col] != value) {
                            sum += matrix[row + 1][col];
                        }
                    }
                    if (col + 1 <= cols - 1) {
                        if (matrix[row][col + 1] != value) {
                            sum += matrix[row][col + 1];
                        }
                    }
                    if (col - 1 >= 0) {
                        if (matrix[row][col - 1] != value) {
                            sum += matrix[row][col - 1];
                        }

                    }
                    printMatrix[row][col] = sum;
                    continue;
                }

                printMatrix[row][col] = matrix[row][col];
            }
        }
        for (
                int row = 0;
                row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(printMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}


