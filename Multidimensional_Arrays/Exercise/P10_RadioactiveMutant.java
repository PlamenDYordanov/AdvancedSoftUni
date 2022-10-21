package Advanced.Multidimensional_Arrays.Exercise;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class P10_RadioactiveMutant {
    private static int playerRow;
    private static int playerCol;
    private static boolean isFailed = false;
    private static boolean isOutOfBound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(dimension[0]);
        int col = Integer.parseInt(dimension[1]);

        char[][] field = new char[row][col];
        for (int r = 0; r < field.length; r++) {
            String fieldData = scanner.nextLine();
            field[r] = fieldData.toCharArray();
            if (fieldData.contains("P")) {
                playerRow = r;
                playerCol = fieldData.indexOf("P");
            }
        }
        List<String> commands = List.of(scanner.nextLine().split(""));
        ArrayDeque<Integer> rowsOfBunnies = new ArrayDeque<>();
        ArrayDeque<Integer> colsOfBunnies = new ArrayDeque<>();
        for (String currentCommand : commands) {
            switch (currentCommand) {
                case "U":
                    movePlayer(field, -1, 0);
                    break;
                case "D":
                    movePlayer(field, 1, 0);
                    break;
                case "L":
                    movePlayer(field, 0, -1);
                    break;
                case "R":
                    movePlayer(field, 0, 1);
                    break;
            }
            searchBunniesOnField(field, rowsOfBunnies, colsOfBunnies);
            addBunniesToField(field, rowsOfBunnies, colsOfBunnies);
            if (isOutOfBound) {
                printField(field);
                System.out.printf("won: %d %d%n", playerRow, playerCol);
                break;
            } else if (isFailed) {
                printField(field);
                System.out.printf("dead: %d %d%n", playerRow, playerCol);
                break;
            }
        }
    }

    private static void printField(char[][] field) {
        for (char[] chars : field) {

            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void addBunniesToField(char[][] field, ArrayDeque<Integer> rowsOfBunnies, ArrayDeque<Integer> colsOfBunnies) {
        while (!rowsOfBunnies.isEmpty() && !colsOfBunnies.isEmpty()) {
            int currentRow = rowsOfBunnies.pop();
            int currentCol = colsOfBunnies.pop();
            field[currentRow][currentCol] = 'B';
        }
    }

    private static void searchBunniesOnField(char[][] field, ArrayDeque<Integer> rowsOfBunnies, ArrayDeque<Integer> colsOfBunnies) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'B') {
                    addBunniesToStack(field, row, col, rowsOfBunnies, colsOfBunnies);
                }
            }
        }
    }

    private static void addBunniesToStack(char[][] field, int row, int col, ArrayDeque<Integer> bunniesRow, ArrayDeque<Integer> bunniesCol) {
        //up
        if (isInBound(field, row - 1, col) && field[row - 1][col] != 'B') {
            if (field[row - 1][col] == 'P') {
                isFailed = true;
                return;
            }

            bunniesRow.push(row - 1);
            bunniesCol.push(col);
        }
        //down
        if (isInBound(field, row + 1, col) && field[row + 1][col] != 'B') {
            if (field[row + 1][col] == 'P') {
                isFailed = true;
            }
            bunniesRow.push(row + 1);
            bunniesCol.push(col);
        }
        //left
        if (isInBound(field, row, col - 1) && field[row][col - 1] != 'B') {
            if (field[row][col - 1] == 'P') {
                isFailed = true;
            }
            bunniesRow.push(row);
            bunniesCol.push(col - 1);
        }
        //right
        if (isInBound(field, row, col + 1) && field[row][col + 1] != 'B') {
            if (field[row][col + 1] == 'P') {
                isFailed = true;
            }
            bunniesRow.push(row);
            bunniesCol.push(col + 1);
        }
    }

    private static void movePlayer(char[][] field, int setRow, int setCol) {
        int nextRow = playerRow + setRow;
        int nextCol = playerCol + setCol;
        if (isInBound(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'B') {
                field[playerRow][playerCol] = '.';
                isFailed = true;

            } else {
                field[playerRow][playerCol] = '.';
                field[nextRow][nextCol] = 'P';
            }
            playerRow = nextRow;
            playerCol = nextCol;
        } else {
            field[playerRow][playerCol] = '.';
            isOutOfBound = true;
        }
    }

    private static boolean isInBound(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
