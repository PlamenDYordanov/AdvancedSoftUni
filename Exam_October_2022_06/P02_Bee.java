package Advanced.Exam_October_2022_06;

import java.util.Scanner;

public class P02_Bee {
    private static int beeRow;
    private static int beeCol;
    private static int pollinateFlower;
    private static boolean isInBounds = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            String rowData = scanner.nextLine();
            field[row] = rowData.toCharArray();
            if (rowData.contains("B")) {
                beeRow = row;
                beeCol = rowData.indexOf("B");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    moveBee(field, -1, 0);
                    break;
                case "down":
                    moveBee(field, +1, 0);
                    break;
                case "left":
                    moveBee(field, 0, -1);
                    break;
                case "right":
                    moveBee(field, 0, +1);
                    break;
            }
            if (!isInBounds) {
                break;
            }
            command = scanner.nextLine();
        }
        if (!isInBounds) {
            System.out.println("The bee got lost!");
        }
        if (pollinateFlower >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinateFlower);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinateFlower);
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
        int nextRow = beeRow + rowMutator;
        int nextCol = beeCol + colMutator;
        if (isInField(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'f') {
                pollinateFlower++;
            }
            if (field[nextRow][nextCol] == 'O') {
                isBonus = true;
            }
            field[beeRow][beeCol] = '.';
            field[nextRow][nextCol] = 'B';
            beeRow = nextRow;
            beeCol = nextCol;
            if (isBonus) {
                moveBee(field, rowMutator, colMutator);
            }

        } else {
            field[beeRow][beeCol] = '.';
            isInBounds = false;
        }


    }
    private static boolean isInField(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}
