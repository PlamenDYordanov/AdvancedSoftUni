package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = data[col];
            }
        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("END")) {
            String[] input = inputLine.split("\\s+");
            if (input.length <= 5 && input[0].contains("swap")) {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                if (row1 >= 0 && row1 <= rows && col1 >= 0 && col1 <= cols && row2 >= 0 && row2 <= rows && col2 >= 0 && col2 <= cols) {
                    String digit2 = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = digit2;
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }


            } else {
                System.out.println("Invalid input!");
            }

            inputLine = scanner.nextLine();
        }
        /*for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }*/
    }
}
