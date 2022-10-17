package Advanced.ExamPreparation_2022_05;

import java.util.Scanner;

public class P02_ReVolt {
    private static int nextRow;
    private static int nextCol;
    private static int myRow;
    private static int myCol;
    private static boolean isItBonus = false;
    private static boolean isWin = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());
        int checkPositions = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[dimensions][dimensions];
        fillField(scanner, dimensions, field);
        for (int i = 0; i < checkPositions; i++) {
            if (isWin) {
                break;
            }
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    movePlayer(field, -1, 0, command);
                    break;
                case "down":
                    movePlayer(field, +1, 0, command);
                    break;
                case "left":
                    movePlayer(field, 0, -1, command);
                    break;
                case "right":
                    movePlayer(field, 0, +1, command);
                    break;
            }
        }
        if (isWin) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        print2dArray(field);
    }

    private static void movePlayer(char[][] field, int row, int col, String command) {
        nextRow = myRow + row;
        nextCol = myCol + col;

        if (!IsBoundOfFiled(nextRow, nextCol, field)) {
            moveToOppositeWay(field, command, nextRow, nextCol);

        }
        if (field[nextRow][nextCol] == 'F') {
            isWin = true;
        } else if (field[nextRow][nextCol] == 'T') {
            return;
        } else if (field[nextRow][nextCol] == 'B') {
            isItBonus = true;
            field[myRow][myCol] = '-';
            myRow = nextRow;
            myCol = nextCol;
            movePlayer(field, row, col, command);
            return;
        }
        if (!isItBonus) {
            field[myRow][myCol] = '-';
        }
        field[nextRow][nextCol] = 'f';
        myRow = nextRow;
        myCol = nextCol;
        isItBonus = false;


    }


    private static void moveToOppositeWay(char[][] field, String command, int row, int col) {
        if (command.equals("up")) {
            nextRow = field.length - 1;
        } else if (command.equals("down")) {
            nextRow = 0;
        } else if (command.equals("left")) {
            nextCol = field[nextRow].length - 1;
        } else if (command.equals("right")) {
            nextCol = 0;
        }
    }


    private static boolean IsBoundOfFiled(int nextRow, int nextCol, char[][] field) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }

    private static void fillField(Scanner scanner, int dimensions, char[][] field) {
        for (int row = 0; row < dimensions; row++) {
            String rowData = scanner.nextLine();
            field[row] = rowData.toCharArray();
            if (rowData.contains("f")) {
                myRow = row;
                myCol = rowData.indexOf("f");
            }
        }
    }

    public static void print2dArray(char[][] field) {
        for (char[] array : field) {
            for (char symbol : array) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
