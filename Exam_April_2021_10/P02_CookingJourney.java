package Advanced.Exam_April_2021_10;

import java.util.Scanner;

public class P02_CookingJourney {
    private static int myRow;
    private static int myCol;
    private static int firstPillarRow;
    private static int firstPillarCol;
    private static int secondPillarRow;
    private static int secondPillarCol;
    private static int money;
    private static boolean outOfBounds = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[dimension][dimension];
        boolean firstPillar = false;
        for (int row = 0; row < dimension; row++) {
            String[] rowData = scanner.nextLine().split("");
            for (int col = 0; col < dimension; col++) {
                field[row][col] = rowData[col].charAt(0);
                if (field[row][col] == 'S') {
                    myRow = row;
                    myCol = col;
                } else if (field[row][col] == 'P') {
                    if (!firstPillar) {
                        firstPillarRow = row;
                        firstPillarCol = col;
                        firstPillar = true;
                    } else {
                        secondPillarRow = row;
                        secondPillarCol = col;
                    }
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveCooker(field, -1, 0);
                    break;
                case "down":
                    moveCooker(field, 1, 0);
                    break;
                case "left":
                    moveCooker(field, 0, -1);
                    break;
                case "right":
                    moveCooker(field, 0, 1);
                    break;
            }
            if (!outOfBounds) {
                break;
            }
            if (money >= 50){
                break;
            }
        }
        if (!outOfBounds){
            System.out.println("Bad news! You are out of the pastry shop.");
        }else {
            System.out.printf("Good news! You succeeded in collecting enough money!%n");
        }
        System.out.printf("Money: %d%n",money);
        printField(field);
    }
    private static void printField(char[][] track) {
        for (int row = 0; row < track.length; row++) {

            for (int col = 0; col < track[row].length; col++) {
                System.out.print(track[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveCooker(char[][] field, int rowMutator, int colMutator) {
        int nextRow = myRow + rowMutator;
        int nextCol = myCol + colMutator;
        if (isInBounds(field, nextRow, nextCol)) {
            char currentChar = field[nextRow][nextCol];
            if (field[nextRow][nextCol] == 'P') {
                if (nextRow == firstPillarRow && nextCol == firstPillarCol) {
                    field[myRow][myCol] = '-';
                    field[nextRow][nextCol] = '-';
                    field[secondPillarRow][secondPillarCol] = 'S';
                    myRow = secondPillarRow;
                    myCol = secondPillarCol;
                } else {
                    field[myRow][myCol] = '-';
                    field[nextRow][nextCol] = '-';
                    field[firstPillarRow][firstPillarCol] = 'S';
                    myRow = firstPillarRow;
                    myCol = firstPillarCol;
                }
                return;
            } else if (Character.isDigit(currentChar)) {
                int currentMoney = Integer.parseInt(String.valueOf(currentChar));
                money += currentMoney;
            }
            field[myRow][myCol] = '-';
            field[nextRow][nextCol] = 'S';
            myRow = nextRow;
            myCol = nextCol;
        } else {
            field[myRow][myCol] = '-';
            outOfBounds = false;
        }
    }

    private static boolean isInBounds(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
