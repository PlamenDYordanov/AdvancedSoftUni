package Advanced.Multidimensional_Arrays.Lab;

import java.util.Scanner;

public class P02_PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeOfMatrix = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int cols = Integer.parseInt(sizeOfMatrix[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(data[col]);
            }
        }

        int searchingNumber = Integer.parseInt(scanner.nextLine());

        searchForNumber(matrix,searchingNumber,rows,cols);

    }

    private static void searchForNumber(int[][] matrix, int searchingNumber, int rows, int cols) {
            boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col ++) {
                if (matrix[row][col]== searchingNumber){
                System.out.println(row +" "+ col);
                isFound =true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
