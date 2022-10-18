package Advanced.Exam_February_2021_11;

import java.util.Scanner;

public class P02_Bomb {
    private static int sapperRow;
    private static int sapperCol;
    private static int bombOnField;
    private static boolean isFindEnd = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] field = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < dimension; col++) {
                field[row][col] = rowData[col].charAt(0);
                if (field[row][col] == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (field[row][col] == 'B') {
                    bombOnField++;
                }
            }
        }
        for (String command : commands) {
            switch (command) {
                case "up":
                    sapperMove(field, -1, 0);
                    break;
                case "down":
                    sapperMove(field, 1, 0);
                    break;
                case "left":
                    sapperMove(field, 0, -1);
                    break;
                case "right":
                    sapperMove(field, 0, 1);
                    break;
            }
            if (isFindEnd) {
                break;
            }
            if (bombOnField == 0){
                break;
            }
        }
        if (isFindEnd) {
            System.out.printf("END! %d bombs left on the field", bombOnField);
        } else if (bombOnField == 0){
            System.out.println("Congratulations! You found all bombs!");
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombOnField, sapperRow , sapperCol);
        }
    }

    private static void sapperMove(char[][] field, int setRow, int setCol) {
        int nextRow = sapperRow + setRow;
        int nextCol = sapperCol + setCol;
        if (isInField(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'B') {
                System.out.println("You found a bomb!");
                bombOnField--;
            } else if (field[nextRow][nextCol] == 'e') {
                isFindEnd = true;
            }
            field[sapperRow][sapperCol] = '+';
            field[nextRow][nextCol] = 's';
            sapperRow = nextRow;
            sapperCol = nextCol;
        }
    }

    private static boolean isInField(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length;
    }
}

