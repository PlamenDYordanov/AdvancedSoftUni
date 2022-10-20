package Advanced.Exam_December_2019_15;

import java.util.Scanner;

public class P02_PresentDelivery {
    private static int santaRow;
    private static int santaCol;
    private static int currentPresent;
    private static boolean isOutOfPresent = false;
    private static int niceKid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPresents = Integer.parseInt(scanner.nextLine());
        currentPresent = countOfPresents;
        int dimensions = Integer.parseInt(scanner.nextLine());
        int totalNiceKid = 0;
        char[][] field = new char[dimensions][dimensions];
        for (int row = 0; row < dimensions; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < dimensions; col++) {
                field[row][col] = rowData[col].charAt(0);
                if (field[row][col] == 'S') {
                    santaRow = row;
                    santaCol = col;
                } else if (field[row][col] == 'V') {
                    niceKid++;
                    totalNiceKid++;
                }
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("Christmas morning") && countOfPresents > 0 ) {
            switch (command) {
                case "up":
                    moveSanta(field, -1, 0);
                    break;
                case "down":
                    moveSanta(field, 1, 0);
                    break;
                case "left":
                    moveSanta(field, 0, -1);
                    break;
                case "right":
                    moveSanta(field, 0, 1);
                    break;
            }

            if (isOutOfPresent){
                break;
            }
            command = scanner.nextLine();
        }
        if (isOutOfPresent) {
            System.out.println("Santa ran out of presents!");
        }
        printField(field);
        if (niceKid == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", totalNiceKid);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKid);
        }
    }

    private static void printField(char[][] field) {
        for (int row = 0; row < field.length; row++) {

            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void moveSanta(char[][] field, int setRow, int setCol) {
        int nextRow = santaRow + setRow;
        int nextCol = santaCol + setCol;
        if (isInNeighborhood(nextRow, nextCol, field)) {
            field[santaRow][santaCol] = '-';
            if (field[nextRow][nextCol] == 'V') {
                currentPresent--;
                niceKid--;
                if (currentPresent == 0) {
                    isOutOfPresent = true;
                    field[nextRow][nextCol] = 'S';
                    santaRow = nextRow;
                    santaCol = nextCol;
                    return;
                }
            } else if (field[nextRow][nextCol] == 'C') {
                CookieTime(field, nextRow, nextCol);
                if (currentPresent == 0) {
                    isOutOfPresent = true;
                }
            }
            field[nextRow][nextCol] = 'S';
            santaRow = nextRow;
            santaCol = nextCol;
        }
    }

    private static void CookieTime(char[][] field, int nextRow, int nextCol) {
        //up
        if (isInNeighborhood(nextRow - 1, nextCol, field) && field[nextRow - 1][nextCol] == 'V' || field[nextRow - 1][nextCol] == 'X') {
            currentPresent--;
            if (field[nextRow - 1][nextCol] == 'V') {
                niceKid--;
            }
            field[nextRow - 1][nextCol] = '-';
            //down
        } if (isInNeighborhood(nextRow + 1, nextCol, field) && field[nextRow + 1][nextCol] == 'V' || field[nextRow + 1][nextCol] == 'X') {
            currentPresent--;
            if (field[nextRow + 1][nextCol] == 'V') {
                niceKid--;
            }
            field[nextRow - 1][nextCol] = '-';
            //left
        } if (isInNeighborhood(nextRow, nextCol - 1, field) && field[nextRow][nextCol - 1] == 'V' || field[nextRow][nextCol - 1] == 'X') {
            currentPresent--;
            if (field[nextRow][nextCol - 1] == 'V') {
                niceKid--;
            }
            field[nextRow][nextCol - 1] = '-';
            //right
        }if (isInNeighborhood(nextRow, nextCol + 1, field) && field[nextRow][nextCol + 1] == 'V' || field[nextRow][nextCol + 1] == 'X') {
            currentPresent--;
            if (field[nextRow][nextCol + 1] == 'V') {
                niceKid--;
            }
            field[nextRow][nextCol + 1] = '-';

        }
    }

    private static boolean isInNeighborhood(int nextRow, int nextCol, char[][] field) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
