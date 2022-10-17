package Advanced.Exam_October_2021_07;

import java.util.Scanner;

public class P02_MouseAndCheese {
    private static int rowMouse;
    private static int colMouse;
    private static int eatenCheese;
    private static boolean isInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            String rowData = scanner.nextLine();
            field[row] = rowData.toCharArray();
            if (rowData.contains("M")) {
                rowMouse = row;
                colMouse = rowData.indexOf("M");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {

                case "up":
                    moveBee(field, -1, 0);
                    break;
                case "down":
                    moveBee(field, 1, 0);
                    break;
                case "left":
                    moveBee(field, 0, -1);
                    break;
                case "right":
                    moveBee(field, 0, 1);
                    break;
            }
            if (!isInField) {
                break;
            }

            command = scanner.nextLine();
        }
        if (!isInField) {
            System.out.println("Where is the mouse?");
        }
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
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

    private static void moveBee(char[][] field, int rowMutator, int colMutator) {
        boolean isBonus = false;
        int nextRow = rowMouse + rowMutator;
        int nextCol = colMouse + colMutator;
        if (isInBounds(nextRow, nextCol, field)) {
            if (field[nextRow][nextCol] == 'c') {
                eatenCheese++;
            }
            if (field[nextRow][nextCol] == 'B') {
                isBonus = true;
            }
            field[rowMouse][colMouse] = '-';
            field[nextRow][nextCol] = 'M';
            rowMouse = nextRow;
            colMouse = nextCol;
            if (isBonus) {
                moveBee(field, rowMutator, colMutator);
            }
        } else {
            field[rowMouse][colMouse] = '-';
            isInField = false;
        }
    }

    private static boolean isInBounds(int nextRow, int nextCol, char[][] field) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
