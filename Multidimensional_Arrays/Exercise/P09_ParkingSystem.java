package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Scanner;

public class P09_ParkingSystem {
    private static int counter;
    private static boolean hasItSpace = true;
    private static int requireRow;
    private static int requireCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int rowDimen = Integer.parseInt(dimension[0]);
        int colDimen = Integer.parseInt(dimension[1]);

        boolean[][] parking = new boolean[rowDimen][colDimen];
        fillParking(rowDimen, colDimen, parking);

        String requireSpot = scanner.nextLine();

        while (!requireSpot.equals("stop")) {
            String[] positions = requireSpot.split("\\s+");
            int startingPositionRow = Integer.parseInt(positions[0]);
            int row = Integer.parseInt(positions[1]);
            int col = Integer.parseInt(positions[2]);
            requireRow = row;
            requireCol = col;
            moveToParkingSlot(parking, startingPositionRow, requireRow, requireCol);
            if (!hasItSpace) {
                System.out.printf("Row %d full%n", requireRow);
                hasItSpace = true;
            } else {
                System.out.println(counter);
                counter = 0;
            }

            requireSpot = scanner.nextLine();
        }
    }

    private static void moveToParkingSlot(boolean[][] parking, int startingPositionRow, int curRequireRow, int curRequireCol) {

        if (!IsThereCar(parking, curRequireRow, curRequireCol)) {
            if (startingPositionRow != curRequireRow) {
                counter += Math.abs(startingPositionRow - curRequireRow) + curRequireCol + 1;
            }else {
                counter += curRequireCol + 1;
            }

            parking[curRequireRow][curRequireCol] = true;
        } else {
            if (hasItEmptySpace(parking, curRequireRow)) {
                findClosestFreeSpot(parking, curRequireRow, curRequireCol);
                moveToParkingSlot(parking, startingPositionRow, requireRow, requireCol);
            } else {
                hasItSpace = false;
            }
        }
        // }

    }


    private static boolean hasItEmptySpace(boolean[][] parking, int requireRow) {

        for (int col = 1; col <= parking[requireRow].length - 1; col++) {
            if (!parking[requireRow][col]) {
                return true;
            }
        }
        return false;
    }

    private static void findClosestFreeSpot(boolean[][] parking, int curRow, int curCol) {
        //first iterate left side;
        int moveToLeft = 0;
        int currentLeftCol = 0;
        boolean itHasFreeSpaceLeft = false;
        if (curCol > 1) {
            for (int col = curCol - 1; col >= 0; col--) {
                moveToLeft++;
                if (!parking[curRow][col]) {
                    itHasFreeSpaceLeft = true;
                    currentLeftCol = col;
                    break;
                }
            }
        } else {
            moveToLeft = Integer.MAX_VALUE;
        }
        //iterate right side;
        int moveToRight = 0;
        int currentRightCol = 0;
        boolean itHasFreeSpaceRight = false;
        if (curCol < parking[curRow].length - 1) {
            for (int col = curCol + 1; col <= parking[curRow].length - 1; col++) {
                moveToRight++;
                if (!parking[curRow][col]) {
                    itHasFreeSpaceRight = true;
                    currentRightCol = col;
                    break;
                }
            }
        } else {
            moveToRight = Integer.MAX_VALUE;
        }
        //priority left side cuz is near to entrance.
        if (itHasFreeSpaceLeft && moveToLeft < moveToRight) {
            requireCol = currentLeftCol;
        } else if (itHasFreeSpaceRight && moveToRight < moveToLeft) {
            requireCol = currentRightCol;
        } else {
            requireCol = currentLeftCol;
        }
    }

    private static boolean IsThereCar(boolean[][] parking, int currentRow, int currentCol) {
        return parking[currentRow][currentCol];
    }

    private static void fillParking(int rowDimen, int colDimen, boolean[][] parking) {
        for (int row = 0; row < rowDimen; row++) {
            for (int col = 0; col < colDimen; col++) {
                if (col == 0) {
                    parking[row][col] = true;
                }
            }
        }
    }
}
