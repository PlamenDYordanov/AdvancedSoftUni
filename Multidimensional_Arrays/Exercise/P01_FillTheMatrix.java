package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        int rowsCols = Integer.parseInt(input[0]);
        int cols = 0;
        String model = input[1];

        int[][] matrix = new int[rowsCols][rowsCols];


        switch (model) {
            case "A":
                int digit = 1;
                for (int col = 0; col < rowsCols; col++) {
                    for (int row = 0; row < rowsCols; row++) {
                        matrix[row][col] = digit;
                        digit++;
                    }

                }

                break;
            case "B":
                digit = 1;
                for (int col = 0; col < rowsCols; col++) {
                    for (int row = 0; row < rowsCols; row++) {
                        boolean flag = false;
                        if (col % 2 == 0) {
                            matrix[row][col] = digit;
                            digit++;
                        } else {
                            for (int row2 = rowsCols - 1; row2 >= 0; row2--) {
                                matrix[row2][col] = digit;

                                digit++;
                                if (row2 == 0) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag){
                                break;
                            }
                        }
                    }
                }
                break;
        }
        for (int row = 0; row < rowsCols; row++) {
            for (int col = 0; col < rowsCols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
