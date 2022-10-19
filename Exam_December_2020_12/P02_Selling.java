package Advanced.Exam_December_2020_12;

import java.util.Scanner;

public class P02_Selling {
    private static int myRow;
    private static int myCol;
    private static int firstPillarRow;
    private static int firstPillarCol;
    private static int secondPillarRow;
    private static int secondPillarCol;
    private static int money;
    private static boolean isOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[dimension][dimension];
        boolean isPillar = false;
        for (int row = 0; row < dimension; row++) {
            String[] rowData = scanner.nextLine().split("");
            for (int col = 0; col < dimension; col++) {
                field[row][col] = rowData[col].charAt(0);
                if (field[row][col] == 'S') {
                    myRow = row;
                    myCol = col;
                } else if (field[row][col] == 'O') {
                    if (!isPillar) {
                        firstPillarRow = row;
                        firstPillarCol = col;
                        isPillar = true;
                    } else {
                        secondPillarRow = row;
                        secondPillarCol = col;
                    }
                }
            }
        }
        while (money < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveMyPosition(field, -1, 0);
                    break;
                case "down":
                    moveMyPosition(field, 1, 0);
                    break;
                case "left":
                    moveMyPosition(field, 0, -1);
                    break;
                case "right":
                    moveMyPosition(field, 0, 1);
                    break;
            }
            if (isOut) {
                break;
            }
        }
        if (isOut){
            System.out.println("Bad news, you are out of the bakery.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);

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

    private static void moveMyPosition(char[][] field, int setRow, int setCol) {
        int nextRow = myRow + setRow;
        int nextCol = myCol + setCol;
        if (isInBound(field, nextRow, nextCol)) {
            field[myRow][myCol] = '-';
            char currentChar = field[nextRow][nextCol];
            if (Character.isDigit(currentChar)) {
                money += Integer.parseInt(String.valueOf(currentChar));
            } else if (field[nextRow][nextCol] == 'O') {
                if (firstPillarCol == nextCol && firstPillarRow == nextRow) {
                    field[nextRow][nextCol] = '-';
                    field[secondPillarRow][secondPillarCol] = 'S';
                    myRow = secondPillarRow;
                    myCol = secondPillarCol;
                } else {
                    field[nextRow][nextCol] = '-';
                    field[firstPillarRow][firstPillarCol] = 'S';
                    myRow = firstPillarRow;
                    myCol = firstPillarCol;
                }

                return;
            }
            field[nextRow][nextCol] = 'S';
            myRow = nextRow;
            myCol = nextCol;

        } else {
            field[myRow][myCol] = '-';
            isOut = true;
        }
    }

    private static boolean isInBound(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
