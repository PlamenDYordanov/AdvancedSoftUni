package Advanced.Exam_August_2021_08;

import java.util.Scanner;


public class P02_FormulaOne {
    private static int playerRow;
    private static int playerCol;
    private static int nextRow;
    private static int nextCol;
    private static boolean isFinish = false;
    private static boolean isBonusMove = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] track = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            String rowData = scanner.nextLine();
            track[row] = rowData.toCharArray();
            if (rowData.contains("P")) {
                playerRow = row;
                playerCol = rowData.indexOf("P");
            }
        }
        for (int commands = 0; commands < numberOfCommands; commands++) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveFormula(track, -1, 0, command);
                    break;
                case "down":
                    moveFormula(track, 1, 0, command);
                    break;
                case "left":
                    moveFormula(track, 0, -1, command);
                    break;
                case "right":
                    moveFormula(track, 0, 1, command);
                    break;
            }
            if (isFinish) {
                break;
            }
        }
        if (isFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printTrack(track);
    }
    private static void printTrack(char[][] track) {
        for (int row = 0; row < track.length; row++) {

            for (int col = 0; col < track[row].length; col++) {
                System.out.print(track[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveFormula(char[][] track, int setRow, int setCol, String command) {
        nextRow = playerRow + setRow;
        nextCol = playerCol + setCol;
        if (isInBound(nextRow, nextCol, track)) {
            currentMove(track, setRow, setCol, command);
        } else {
            moveFormulaOutOfBound(track, nextRow, nextCol, command);
            currentMove(track, setRow, setCol, command);
        }
    }

    private static void currentMove(char[][] track, int setRow, int setCol, String command) {
        if (track[nextRow][nextCol] == 'F') {
            isFinish = true;
            track[playerRow][playerCol] = '.';
            track[nextRow][nextCol] = 'P';
            return;
        }
        if (track[nextRow][nextCol] == 'T') {
            return;
        }
        if (track[nextRow][nextCol] == 'B') {
            track[playerRow][playerCol] = '.';
            playerRow = nextRow;
            playerCol = nextCol;
            isBonusMove = true;
            moveFormula(track, setRow, setCol, command);
            return;
        }
        if (!isBonusMove) {
            track[playerRow][playerCol] = '.';
        }
        track[nextRow][nextCol] = 'P';
        playerRow = nextRow;
        playerCol = nextCol;
        isBonusMove = false;
    }

    private static void moveFormulaOutOfBound(char[][] track, int row, int col, String command) {
        if (command.equals("up")) {
            nextRow = track.length - 1;
        } else if (command.equals("down")) {
            nextRow = 0;
        } else if (command.equals("left")) {
            nextCol = track.length - 1;
        } else if (command.equals("right")) {
            nextCol = 0;
        }

    }
    private static boolean isInBound(int nextRow, int nextCol, char[][] track) {
        return nextRow >= 0 && nextRow < track.length && nextCol >= 0 && nextCol < track[nextRow].length;
    }
}
