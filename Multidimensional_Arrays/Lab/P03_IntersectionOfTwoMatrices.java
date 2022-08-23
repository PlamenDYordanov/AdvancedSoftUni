package Advanced.Multidimensional_Arrays.Lab;

import java.util.Scanner;

public class P03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix1[row][col] = data[col].charAt(0);
            }
        }
        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix2[row][col] = data[col].charAt(0);
            }
        }
        for (int row = 0; row < matrix1.length; row++) {

            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(matrix1[row][col] + " ");
                }
            }
            System.out.print("".trim());
            System.out.println();
        }

    }
}
