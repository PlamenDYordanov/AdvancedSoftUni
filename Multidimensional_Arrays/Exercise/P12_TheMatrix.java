package Advanced.Multidimensional_Arrays.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P12_TheMatrix {
    private static boolean isUpwardHaveSymbol = false;
    private static boolean isDownwardHaveSymbol = false;
    private static int startRowUpward;
    private static int startColUpward;
    private static int startRowDownward;
    private static int startColDownward;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split("\\s+");
        int rowDimen = Integer.parseInt(dimension[0]);
        int colDimen = Integer.parseInt(dimension[1]);

        char[][] field = new char[rowDimen][colDimen];

        for (int row = 0; row < rowDimen; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < colDimen; col++) {
                field[row][col] = rowData[col].charAt(0);
            }
        }
        char symbol = scanner.nextLine().charAt(0);
        String[] startRowAndCol = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startRowAndCol[0]);
        int startCol = Integer.parseInt(startRowAndCol[1]);

        char requireSymbol = field[startRow][startCol];
        ArrayDeque<Integer> rowsStack = new ArrayDeque<>();
        ArrayDeque<Integer> colsStack = new ArrayDeque<>();
        field[startRow][startCol] = symbol;
        checkLeft(field, startRow, startCol, requireSymbol, rowsStack, colsStack);
        checkRight(field, startRow, startCol, requireSymbol, rowsStack, colsStack);
        int upWardRow = startRow;
        int downWardRow = startRow;
        while (isUpwardHaveSymbol) {
            isUpwardHaveSymbol = false;
            upWardRow--;
            checkLeft(field, upWardRow, startCol, requireSymbol, rowsStack, colsStack);
            checkRight(field, upWardRow, startCol, requireSymbol, rowsStack, colsStack);

        }
        while (isDownwardHaveSymbol){
            isDownwardHaveSymbol =false;
            downWardRow++;
            checkLeft(field, downWardRow, startCol, requireSymbol, rowsStack, colsStack);
            checkRight(field, downWardRow, startCol, requireSymbol, rowsStack, colsStack);
        }

    }

    private static void checkRight(char[][] field, int startRow, int startCol, char symbol, ArrayDeque<Integer> rowsStack, ArrayDeque<Integer> colStack) {
        int rightCol = startCol + 1;
        if (isInBound(field, startRow, rightCol)) {

                checkDownWards(field, startRow, startCol, symbol, rowsStack, colStack);
                checkUpWards(field, startRow, startCol, symbol, rowsStack, colStack);

            if (field[startRow][rightCol] == symbol) {
                startCol = rightCol;
                rowsStack.push(startRow);
                colStack.push(startCol);
                checkRight(field, startRow, startCol, symbol, rowsStack, colStack);
            }
        } else {
                checkDownWards(field, startRow, startCol, symbol, rowsStack, colStack);
                checkUpWards(field, startRow, startCol, symbol, rowsStack, colStack);
        }
    }

    private static void checkLeft(char[][] field, int startRow, int startCol, char symbol, ArrayDeque<Integer> rowsStack, ArrayDeque<Integer> colStack) {
        int leftCol = startCol - 1;
        if (isInBound(field, startRow, leftCol)) {

                checkDownWards(field, startRow, startCol, symbol,rowsStack,colStack);
                checkUpWards(field, startRow, startCol, symbol, rowsStack, colStack);

            if (field[startRow][leftCol] == symbol) {
                startCol = leftCol;
                rowsStack.push(startRow);
                colStack.push(startCol);
                checkLeft(field, startRow, startCol, symbol, rowsStack, colStack);
            }
        } else {
                checkDownWards(field, startRow, startCol, symbol, rowsStack, colStack);
                checkUpWards(field, startRow, startCol, symbol, rowsStack, colStack);
        }


    }

    private static void checkDownWards(char[][] field, int startRow, int startCol, char symbol, ArrayDeque<Integer> rowsStack, ArrayDeque<Integer> colStack) {
        int downRow = startRow + 1;
        if (isInBound(field, downRow, startCol)) {
            if (field[downRow][startCol] == symbol) {
                startRowDownward = downRow;
                startColDownward = startCol;
                rowsStack.push(downRow);
                rowsStack.push(startCol);
                isDownwardHaveSymbol = true;
            }
        }
    }

    private static void checkUpWards(char[][] field, int startRow, int startCol, char symbol, ArrayDeque<Integer> rowsStack, ArrayDeque<Integer> colStack) {
        int upRow = startRow - 1;
        if (isInBound(field, upRow, startCol)) {
            if (field[upRow][startCol] == symbol) {
                startRowUpward = upRow;
                startColUpward = startCol;
                rowsStack.push(upRow);
                rowsStack.push(startCol);
                isUpwardHaveSymbol = true;
            }
        }
    }

    private static boolean isInBound(char[][] field, int startRow, int startCol) {
        return startRow >= 0 && startRow < field.length && startCol >= 0 && startCol < field[startRow].length;
    }
}
