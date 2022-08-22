package Advanced.Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrix1 = scanner.nextLine().split("\\s+");

        int rows1 = Integer.parseInt(matrix1[0]);
        int cols1 = Integer.parseInt(matrix1[1]);

        int[][] firstMatrix = new int[rows1][cols1];

        for (int row = 0; row < rows1; row++) {
            String[] rawData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols1 ; col++) {
                firstMatrix[row][col] = Integer.parseInt(rawData[col]);
            }
        }
        String[] matrix2 = scanner.nextLine().split("\\s+");
        int rows2 = Integer.parseInt(matrix2[0]);
        int cols2 = Integer.parseInt(matrix2[1]);
        if (rows1!=rows2 || cols1!=cols2){
            System.out.println("not equal");
            return;
        }
        int[][] secondMatrix = new int[rows2][cols2];

        for (int row = 0; row < rows2; row++) {
            String[] rawData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols2; col++) {
                secondMatrix[row][col] = Integer.parseInt(rawData[col]);
            }
        }

        for (int row = 0; row < rows2; row++) {
            for (int col = 0; col < cols2; col++) {
                if (firstMatrix[row][col]!=secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");

    }



}
