package Advanced.RegularExam;

import java.util.Scanner;

public class P02_Racing {
    private static int myRow = 0;
    private static int myCol = 0;
    private static int firstTunnelRow;
    private static int firstTunnelCol;
    private static int secondTunnelRow;
    private static int secondTunnelCol;
    private static boolean isFinish = false;
    private static int distanceCovered;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        boolean isFirstTunnel = false;
        char[][] track = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < dimension; col++) {
                track[row][col] = rowData[col].charAt(0);
                if (track[row][col] == 'T') {
                    if (!isFirstTunnel) {
                        firstTunnelRow = row;
                        firstTunnelCol = col;
                        isFirstTunnel = true;
                    } else {
                        secondTunnelRow = row;
                        secondTunnelCol = col;
                    }
                }
            }
        }
        checkFirstPosition(track);
        String command = scanner.nextLine();
        while (!command.equals("End") && !isFinish) {

            switch (command) {
                case "up":
                    movePlayer(track, -1, 0);
                    break;
                case "down":
                    movePlayer(track, +1, 0);
                    break;
                case "left":
                    movePlayer(track, 0, -1);
                    break;
                case "right":
                    movePlayer(track, 0, +1);
                    break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        if (isFinish) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", distanceCovered);

        printTrack(track);
    }

    private static void printTrack(char[][] field) {
        for (int row = 0; row < field.length; row++) {

            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static void checkFirstPosition(char[][] track) {

        int nextRow = myRow;
        int nextCol = myCol;
        if (track[nextRow][nextCol] == 'F') {
            isFinish = true;
        } else if (track[nextRow][nextCol] == 'T') {
            if (nextRow == firstTunnelRow && nextCol == firstTunnelCol) {
                track[myRow][myCol] = '.';
                track[nextRow][nextCol] = '.';
                track[secondTunnelRow][secondTunnelCol] = 'C';
                myRow = secondTunnelRow;
                myCol = secondTunnelCol;
            } else {
                track[myRow][myCol] = '.';
                track[nextRow][nextCol] = '.';
                track[firstTunnelRow][firstTunnelCol] = 'C';
                myRow = firstTunnelRow;
                myCol = firstTunnelCol;
            }
            return;
        }
        track[nextRow][nextCol] = 'C';
        myRow = nextRow;
        myCol = nextCol;
    }

    private static void movePlayer(char[][] track, int setRow, int setCol) {
        int nextRow = setRow + myRow;
        int nextCol = setCol + myCol;

        distanceCovered += 10;
        if (track[nextRow][nextCol] == 'F') {
            isFinish = true;
        } else if (track[nextRow][nextCol] == 'T') {
            distanceCovered -= 10;
            distanceCovered += 30;
            if (nextRow == firstTunnelRow && nextCol == firstTunnelCol) {
                track[myRow][myCol] = '.';
                track[nextRow][nextCol] = '.';
                track[secondTunnelRow][secondTunnelCol] = 'C';
                myRow = secondTunnelRow;
                myCol = secondTunnelCol;
            } else {
                track[myRow][myCol] = '.';
                track[nextRow][nextCol] = '.';
                track[firstTunnelRow][firstTunnelCol] = 'C';
                myRow = firstTunnelRow;
                myCol = firstTunnelCol;
            }
            return;
        }
        track[myRow][myCol] = '.';
        track[nextRow][nextCol] = 'C';
        myRow = nextRow;
        myCol = nextCol;

    }
}
