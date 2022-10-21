package Advanced.Multidimensional_Arrays.Exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P12_TheMatrixVol2 {
    private static int startRow;
    private static int startCol;
    private static List<String> indexes;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split("\\s+");
        int rowDimen = Integer.parseInt(dimension[0]);
        int colDimen = Integer.parseInt(dimension[1]);

        char[][] field = new char[rowDimen][colDimen];

        fillField(scanner, rowDimen, colDimen, field);

        char symbol = scanner.nextLine().charAt(0);
        String[] startRowAndCol = scanner.nextLine().split("\\s+");
        startRow = Integer.parseInt(startRowAndCol[0]);
        startCol = Integer.parseInt(startRowAndCol[1]);

        char requireSymbol = field[startRow][startCol];
        ArrayDeque<Integer> rowsStackMutator = new ArrayDeque<>();
        ArrayDeque<Integer> colsStackMutator = new ArrayDeque<>();
        indexes = new ArrayList<>();
        rowsStackMutator.push(startRow);
        colsStackMutator.push(startCol);
        indexes.add(startRow + " " + startCol);
        field[startRow][startCol] = symbol;

        while (!rowsStackMutator.isEmpty() && !colsStackMutator.isEmpty()){
            int currentRow = rowsStackMutator.pop();
            int currentCol = colsStackMutator.pop();
            startRow = currentRow;
            startCol = currentCol;
            checkSides(field, 0 , -1,rowsStackMutator, colsStackMutator, requireSymbol, symbol);
            checkSides(field, -1 , 0,rowsStackMutator, colsStackMutator, requireSymbol, symbol);
            checkSides(field, 0 , 1,rowsStackMutator, colsStackMutator, requireSymbol, symbol);
            checkSides(field, 1 , 0,rowsStackMutator, colsStackMutator, requireSymbol, symbol);

        }
        printField(field);
    }
    private static void printField(char[][] field) {
        for (int row = 0; row < field.length; row++) {

            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
    private static void checkSides(char[][] field, int rowMutator, int colMutator, ArrayDeque<Integer> rowsStackMutator, ArrayDeque<Integer> colsStackMutator, char requireSymbol, char symbol) {
        int nextRow = rowMutator + startRow;
        int nextCol = colMutator + startCol;
        if (isInBound(field, nextRow, nextCol)){
            if (field[nextRow][nextCol] == requireSymbol){
                rowsStackMutator.push(nextRow);
                colsStackMutator.push(nextCol);
                indexes.add(nextRow + " " + nextCol);
                field[nextRow][nextCol] = symbol;
            }
        }
    }

    private static boolean isInBound(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }

    private static void fillField(Scanner scanner, int rowDimen, int colDimen, char[][] field) {
        for (int row = 0; row < rowDimen; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < colDimen; col++) {
                field[row][col] = rowData[col].charAt(0);
            }
        }
    }
}
