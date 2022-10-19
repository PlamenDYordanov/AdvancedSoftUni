package Advanced.Exam_June_2020_14;

import java.util.Scanner;

public class P02_Snake {
    private static int snakeRow;
    private static int snakeCol;
    private static int firstLairRow;
    private static int firstLairCol;
    private static int secondLairRow;
    private static int secondLairCol;
    private static boolean isOut = false;
    private static int totalEaten;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[dimension][dimension];
        boolean isLair = false;
        for (int row = 0; row < dimension; row++) {
            String[] rowData = scanner.nextLine().split("");
            for (int col = 0; col < dimension; col++) {
                field[row][col] = rowData[col].charAt(0);
                if (field[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (field[row][col] == 'B') {
                    if (!isLair) {
                        firstLairRow = row;
                        firstLairCol = col;
                        isLair = true;
                    } else {
                        secondLairRow = row;
                        secondLairCol = col;
                    }
                }
            }
        }
        boolean isEnough = false;
        while (!isOut && totalEaten < 10) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveSnake(field, -1, 0);
                    break;
                case "down":
                    moveSnake(field, 1, 0);
                    break;
                case "left":
                    moveSnake(field, 0, -1);
                    break;
                case "right":
                    moveSnake(field, 0, 1);
                    break;
            }
        }
        if (isOut) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", totalEaten);
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

    private static void moveSnake(char[][] field, int setRow, int setCol) {
        int nextRow = snakeRow + setRow;
        int nextCol = snakeCol + setCol;
        if (isInBound(field, nextRow, nextCol)) {
            field[snakeRow][snakeCol] = '.';
            if (field[nextRow][nextCol] == 'B') {
                if (nextRow == firstLairRow && nextCol == firstLairCol) {
                    field[nextRow][nextCol] = '.';
                    field[secondLairRow][secondLairCol] = 'S';
                    snakeRow = secondLairRow;
                    snakeCol = secondLairCol;
                } else {
                    field[nextRow][nextCol] = '.';
                    field[firstLairRow][firstLairCol] = 'S';
                    snakeRow = firstLairRow;
                    snakeCol = firstLairCol;
                }
                return;
            } else if (field[nextRow][nextCol] == '*') {
                totalEaten++;
            }
            field[nextRow][nextCol] = 'S';
            snakeRow = nextRow;
            snakeCol = nextCol;
        } else {
            field[snakeRow][snakeCol] = '.';
            isOut = true;
        }
    }

    private static boolean isInBound(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
