package Advanced.Exam_June_2021_09;

import java.util.Scanner;

public class P02_Python {
    private static int rowSnake;
    private static int colSnake;
    private static int nextRow;
    private static int nextCol;
    private static int length = 1;
    private static boolean isEnemySpot = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        char[][] filed = new char[dimension][dimension];
        String[] commands = scanner.nextLine().split(", ");

        int counterFood = 1;
        boolean isAllEaten = false;
        for (int row = 0; row < dimension; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < dimension; col++) {
                filed[row][col] = rowData[col].charAt(0);
                if (filed[row][col] == 's') {
                    rowSnake = row;
                    colSnake = col;
                } else if (filed[row][col] == 'f') {
                    counterFood++;
                }
            }

        }
        for (String command : commands) {
            switch (command) {
                case "up":
                    moveSnake(filed, -1, 0, command);
                    break;
                case "down":
                    moveSnake(filed, 1, 0, command);
                    break;
                case "left":
                    moveSnake(filed, 0, -1, command);
                    break;
                case "right":
                    moveSnake(filed, 0, 1, command);
                    break;

            }
            if (isEnemySpot) {
                break;
            }
            if (counterFood == length){
                isAllEaten = true;
                break;
            }
        }
        if (isEnemySpot) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            if (isAllEaten) {
                System.out.printf("You win! Final python length is %d%n", length);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.%n", counterFood - length);
            }
        }
    }

    private static void moveSnake(char[][] filed, int setRow, int setCol, String command) {
        nextRow = rowSnake + setRow;
        nextCol = colSnake + setCol;
        if (isOnEdge(filed, nextRow, nextCol, command)) {
            currentMove(filed);
        } else {
            currentMove(filed);
        }
    }

    private static void currentMove(char[][] filed) {
        if (filed[nextRow][nextCol] == 'e') {
            isEnemySpot = true;
            return;
        } else if (filed[nextRow][nextCol] == 'f') {
            length++;
        }
        filed[rowSnake][colSnake] = '*';
        filed[nextRow][nextCol] = 's';
        rowSnake = nextRow;
        colSnake = nextCol;
    }

    private static boolean isOnEdge(char[][] filed, int row, int col, String command) {
        if (row == -1 && command.equals("up")) {
            nextRow = filed.length - 1;
            return true;
        } else if (row == filed.length && command.equals("down")) {
            nextRow = 0;
            return true;
        } else if (nextCol == -1 && command.equals("left")) {
            nextCol = filed.length - 1;
            return true;
        } else if (nextCol == filed.length && command.equals("right")) {
            nextCol = 0;
            return true;
        }
        return false;
    }
}
