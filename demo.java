package Advanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {
    public static void main(String... args) {
            Scanner scanner = new Scanner(System.in);

            int number = Integer.parseInt(scanner.nextLine());
            String carNumber = scanner.nextLine();;
            String[][] matrix = new String[number][number];
            int currentRow = 0;
            int currentCol = 0;
            int tRow1 = 0;
            int tCol1 = 0;
            int tRow2 = 0;
            int tCol2 = 0;
            boolean isTunnel = false;
            int rowF = 0;
            int colF = 0;


            for (int row = 0; row < number; row++) {
                String[] input = scanner.nextLine().split(" ");
                for (int col = 0; col < number; col++) {
                    matrix[row][col] = input[col];

                    if (matrix[row][col].equals("F")) {
                        colF = col;
                        rowF = row;
                    }

                    if (matrix[row][col].equals("T") && !isTunnel) {
                        tCol1 = col;
                        tRow1 = row;
                        isTunnel = true;
                    }

                    if (matrix[row][col].equals("T") && isTunnel) {
                        tCol2 = col;
                        tRow2 = row;
                    }
                }
            }

            int sumKm = 0;

            String command = scanner.nextLine();
        if (currentRow == tRow1 && currentCol == tCol1) {
            currentRow = tRow2;
            currentCol = tCol2;
            matrix[currentRow][currentCol] = ".";
            matrix[tRow1][tCol1] = ".";
            matrix[currentRow][currentCol] = "C";
            sumKm+=30;
        } else if (currentCol == tCol2 && currentRow == tRow2) {
            currentCol = tCol1;
            currentRow = tRow1;
            matrix[currentRow][currentCol] = ".";
            matrix[tRow2][tCol2] = ".";
            matrix[currentRow][currentCol] = "C";
            sumKm+=30;
        } else if (matrix[currentRow][currentCol].equals(".")) {
            matrix[currentRow][currentRow]=".";
            matrix[currentRow][currentCol]="C";

        }else if(currentCol == colF && currentRow == rowF){
            matrix[currentRow][currentCol]=".";
            matrix[currentRow][currentCol]="C";
            System.out.printf("Racing car %s finished the stage!%n",carNumber);
            System.out.printf("Distance covered %d km.%n",sumKm);
            for (int row = 0; row < number; row++) {
                for (int col = 0; col < number; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
            return;
        }
            while(!command.equals("End")){
                int oldRow = currentRow;
                int oldCol = currentCol;
                if (command.equals("up")) {
                    currentRow--;
                } else if (command.equals("down")) {
                    currentRow++;
                } else if (command.equals("left")) {
                    currentCol--;
                } else if (command.equals("right")) {
                    currentCol++;
                }

                if (currentRow == tRow1 && currentCol == tCol1) {
                    currentRow = tRow2;
                    currentCol = tCol2;
                    matrix[oldRow][oldCol] = ".";
                    matrix[tRow1][tCol1] = ".";
                    matrix[currentRow][currentCol] = "C";
                    sumKm+=30;
                } else if (currentCol == tCol2 && currentRow == tRow2) {
                    currentCol = tCol1;
                    currentRow = tRow1;
                    matrix[oldRow][oldCol] = ".";
                    matrix[tRow2][tCol2] = ".";
                    matrix[currentRow][currentCol] = "C";
                    sumKm+=30;
                } else if (matrix[currentRow][currentCol].equals(".")) {
                    matrix[oldRow][oldCol]=".";
                    matrix[currentRow][currentCol]="C";
                    sumKm+=10;

                }else if(currentCol == colF && currentRow == rowF){
                    matrix[oldRow][oldCol]=".";
                    matrix[currentRow][currentCol]="C";
                    sumKm+=10;
                    System.out.printf("Racing car %s finished the stage!%n",carNumber);
                    System.out.printf("Distance covered %d km.%n",sumKm);
                    for (int row = 0; row < number; row++) {
                        for (int col = 0; col < number; col++) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    return;
                }
                command = scanner.nextLine();
            }

            System.out.printf("Racing car %s DNF.%n", carNumber);
            System.out.printf("Distance covered %d km.%n",sumKm);

            for (int row = 0; row < number; row++) {
                for (int col = 0; col < number; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }



