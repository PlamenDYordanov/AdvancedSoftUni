package Advanced.Exam_December_2021_04;

import java.util.Scanner;

public class P02_ThroneConquering {
    private static int myRow = 0;
    private static int myCol = 0;
    private static int helenaRow = 0;
    private static int helenaCol = 0;
    private static int parisEnergy;
    private static boolean isDead = false;
    private static boolean isFindHelena = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        parisEnergy = energy;
        int dimension = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[dimension][dimension];
        fillField(scanner, dimension, field);
        while (true) {
            String commandLine = scanner.nextLine();
            String command = commandLine.split("\\s+")[0];
            int spartanRow = Integer.parseInt(commandLine.split("\\s+")[1]);
            int spartanCol = Integer.parseInt(commandLine.split("\\s+")[2]);
            field[spartanRow][spartanCol] = 'S';
            parisEnergy--;
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
            if (isDead) {
                break;
            }
            if (isFindHelena) {
                break;
            }

        }
        if (isFindHelena) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
        }
        if (isDead) {
            System.out.printf("Paris died at %d;%d.%n", myRow, myCol);
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

    private static void moveMyPosition(char[][] field, int row, int col) {
        int nextRow = myRow + row;
        int nextCol = myCol + col;
        if (isInBound(field, nextRow, nextCol)) {
            field[myRow][myCol] = '-';
            if (field[nextRow][nextCol] == 'S') {//check if there are spartan
                parisEnergy -= 2;
                if (!checkEnergy()) {// check energy
                    field[nextRow][nextCol] = 'X';
                    isDead = true;
                } else {
                    field[nextRow][nextCol] = 'P';
                }
            } else if (field[nextRow][nextCol] == '-') {
                if (!checkEnergy()) {
                    field[nextRow][nextCol] = 'X';
                    isDead = true;
                } else {
                    field[nextRow][nextCol] = 'P';
                }
            } else {
                field[nextRow][nextCol] = '-';
                isFindHelena = true;
            }
            myRow = nextRow;
            myCol = nextCol;
        }
    }


    private static boolean checkEnergy() {
        return parisEnergy > 0;
    }

    private static boolean isInBound(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }

    private static void fillField(Scanner scanner, int dimension, char[][] field) {
        for (int row = 0; row < dimension; row++) {
            String fieldData = scanner.nextLine();
            field[row] = fieldData.toCharArray();
            if (fieldData.contains("H")) {
                helenaRow = row;
                helenaCol = fieldData.indexOf("H");
            }
            if (fieldData.contains("P")) {
                myRow = row;
                myCol = fieldData.indexOf("P");
            }
        }
    }
}
