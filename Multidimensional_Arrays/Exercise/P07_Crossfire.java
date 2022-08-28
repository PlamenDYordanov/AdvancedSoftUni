package Advanced.Multidimensional_Arrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];


        fillMatrix(rows,cols,matrix);


        String[][] newMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                newMatrix[row][col] = String.valueOf(matrix[row][col]);
            }
        }
        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {

            int targetRow = Integer.parseInt(input.split("\\s+")[0]);
            int targetCol = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);


            newMatrix = getNewMatrix(newMatrix, targetRow, targetCol, radius);


            input = scanner.nextLine();
        }
        int currRows = newMatrix.length;
        printMatrix(newMatrix, currRows);
    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        int approach = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = approach;
                approach++;
            }
        }
    }

    private static void printMatrix(String[][] newMatrix, int rows) {

        for (int row = 0; row < rows; row++) {
            int collectCol = newMatrix[row].length;

            for (int col = 0; col < collectCol; col++) {

                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();

        }
    }

    private static String[][] getNewMatrix(String[][] matrix, int targetRow, int targetCol, int radius) {
        //current Rows
        int rows = matrix.length;
        String[][] newMatrix = new String[rows][];
        int colLeftRight = 0;

        //delete left
        for (int i = 1; i <= radius; i++) {
            if (targetRow >= 0 && targetRow < rows) {
                colLeftRight = matrix[targetRow].length;
                if (targetCol - i >= 0 && targetCol - i < colLeftRight) {
                    matrix[targetRow][targetCol - i] = null;
                }
            }
        }
        //delete right
        for (int i = 0; i < radius+1; i++) {
            if (targetRow >= 0 && targetRow < rows) {
                colLeftRight = matrix[targetRow].length;
                if (targetCol + i >= 0 && targetCol + i < colLeftRight) {
                    matrix[targetRow][targetCol + i] = null;
                }
            }
        }
        //delete up
        for (int i = 1; i <= radius; i++) {
            if (targetRow - i >= 0 && targetRow - i < rows) {
                colLeftRight = matrix[targetRow - i].length;
                if (targetRow - i >= 0 && targetRow - i < rows && targetCol <= colLeftRight - 1 && targetCol >= 0) {
                    matrix[targetRow - i][targetCol] = null;
                }
            }
        }


        //delete down
        for (int i = 1; i <= radius; i++) {
            if (targetRow + i >= 0 && targetRow + i < rows) {
                colLeftRight = matrix[targetRow + i].length;
                if (targetRow + i >= 0 && targetRow + i < rows && targetCol >= 0 && targetCol <= colLeftRight - 1) {
                    matrix[targetRow + i][targetCol] = null;
                }
            }
        }
        //newMatrix
        int currRow = 0;
        int emptyRow = 0;
        for (int row = 0; row < rows; row++) {
            List<String> list = new ArrayList<>();
            colLeftRight = matrix[row].length;
            for (int col = 0; col < colLeftRight; col++) {

                if (matrix[row][col] != null) {
                    list.add(matrix[row][col]);
                }

            }
            if (list.size() > 0) {
                String[] arr = new String[list.size()];
                arr = list.toArray(arr);
                newMatrix[currRow] = arr;
                currRow++;
            } else {
                emptyRow++;
            }
        }
        String[][] workingMatrix = new String[currRow][];
        for (int row = 0; row < currRow; row++) {
            workingMatrix[row] = newMatrix[row];
        }
        return workingMatrix;
    }
}
