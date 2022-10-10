package Advanced.Exam_AprilRetake_2022_02;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class P02_Armory {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[dimensions][dimensions];

        int myRow = 0;
        int myCol = 0;
        int firstMirrorRow = 0;
        int firstMirrorCol = 0;
        int secondMirrorRow = 0;
        int secondMirrorCol = 0;
        boolean firstM = false;

        for (int row = 0; row < dimensions; row++) {
            String rowData = scanner.nextLine();
            Reader reader = new StringReader(rowData);
            char[] charArr = new char[rowData.length()];
            reader.read(charArr);
            for (int col = 0; col < dimensions; col++) {
                matrix[row][col] = charArr[col];
                if (matrix[row][col] == 'A') {
                    myRow = row;
                    myCol = col;
                } else if (matrix[row][col] == 'M') {
                    if (!firstM) {
                        firstMirrorRow = row;
                        firstMirrorCol = col;
                        firstM =true;
                    } else {
                        secondMirrorRow = row;
                        secondMirrorCol = col;
                    }
                }
            }
        }
        int goldCoins = 0;
        boolean isOutOtField = false;
        while (goldCoins < 65) {
            String command = scanner.nextLine();

            int previousRow = myRow;
            int previousCol = myCol;
            matrix[myRow][myCol] = '-';
            switch (command) {
                case "up":
                    myRow--;
                    if (myRow < 0) {
                        isOutOtField = true;
                        break;
                    }else {
                        char currChar = matrix[myRow][myCol];
                        if (Character.isDigit(currChar)){
                            goldCoins += Integer.parseInt(String.valueOf(matrix[myRow][myCol]));
                            matrix[previousRow][previousCol] = '-';
                            matrix[myRow][myCol] = 'A';
                        }else if (currChar == 'M'){
                            if (firstMirrorRow == myRow && firstMirrorCol == myCol){
                                matrix[secondMirrorRow][secondMirrorCol] = 'A';
                                matrix[firstMirrorRow][firstMirrorCol] = '-';
                                myRow = secondMirrorRow;
                                myCol = secondMirrorCol;
                            }else {
                                matrix[firstMirrorRow][firstMirrorCol] = 'A';
                                matrix[secondMirrorRow][secondMirrorCol] = '-';
                                myRow = firstMirrorRow;
                                myCol = firstMirrorCol;
                            }
                        }else {
                            matrix[myRow][myCol] = 'A';
                        }
                    }
                    break;
                case "down":
                    myRow++;
                    if (myRow > dimensions - 1) {
                        isOutOtField = true;
                        break;
                    }else {
                        char currChar = matrix[myRow][myCol];
                        if (Character.isDigit(currChar)){
                            goldCoins += Integer.parseInt(String.valueOf(matrix[myRow][myCol]));
                            matrix[previousRow][previousCol] = '-';
                            matrix[myRow][myCol] = 'A';
                        }else if (currChar == 'M'){
                            if (firstMirrorRow == myRow && firstMirrorCol == myCol){
                                matrix[secondMirrorRow][secondMirrorCol] = 'A';
                                matrix[firstMirrorRow][firstMirrorCol] = '-';
                                myRow = secondMirrorRow;
                                myCol = secondMirrorCol;
                            }else {
                                matrix[firstMirrorRow][firstMirrorCol] = 'A';
                                matrix[secondMirrorRow][secondMirrorCol] = '-';
                                myRow = firstMirrorRow;
                                myCol = firstMirrorCol;
                            }
                        }else {
                            matrix[myRow][myCol] = 'A';
                        }
                    }
                    break;
                case "left":
                    myCol--;
                    if (myCol < 0) {
                        isOutOtField = true;
                        break;
                    }else {
                        char currChar = matrix[myRow][myCol];
                        if (Character.isDigit(currChar)){
                            goldCoins += Integer.parseInt(String.valueOf(matrix[myRow][myCol]));
                            matrix[previousRow][previousCol] = '-';
                            matrix[myRow][myCol] = 'A';
                        }else if (currChar == 'M'){
                            if (firstMirrorRow == myRow && firstMirrorCol == myCol){
                                matrix[secondMirrorRow][secondMirrorCol] = 'A';
                                matrix[firstMirrorRow][firstMirrorCol] = '-';
                                myRow = secondMirrorRow;
                                myCol = secondMirrorCol;
                            }else {
                                matrix[firstMirrorRow][firstMirrorCol] = 'A';
                                matrix[secondMirrorRow][secondMirrorCol] = '-';
                                myRow = firstMirrorRow;
                                myCol = firstMirrorCol;
                            }
                        }else {
                            matrix[myRow][myCol] = 'A';
                        }
                    }
                    break;
                case "right":
                    myCol++;
                    if (myCol > dimensions - 1) {
                        isOutOtField = true;
                        break;
                    }else {
                        char currChar = matrix[myRow][myCol];
                        if (Character.isDigit(currChar)){
                            goldCoins += Integer.parseInt(String.valueOf(matrix[myRow][myCol]));
                            matrix[previousRow][previousCol] = '-';
                            matrix[myRow][myCol] = 'A';
                        }else if (currChar == 'M'){
                            if (firstMirrorRow == myRow && firstMirrorCol == myCol){
                                matrix[secondMirrorRow][secondMirrorCol] = 'A';
                                matrix[firstMirrorRow][firstMirrorCol] = '-';
                                myRow = secondMirrorRow;
                                myCol = secondMirrorCol;
                            }else {
                                matrix[firstMirrorRow][firstMirrorCol] = 'A';
                                matrix[secondMirrorRow][secondMirrorCol] = '-';
                                myRow = firstMirrorRow;
                                myCol = firstMirrorCol;
                            }
                        }else {
                            matrix[myRow][myCol] = 'A';
                        }
                    }
                    break;
            }
            if (isOutOtField) {
                break;
            }

        }
        if (!isOutOtField){
            System.out.println("Very nice swords, I will come back for more!");
        }else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.%n",goldCoins);

        printMatrix(dimensions, matrix);
    }


    private static void printMatrix(int dimensions, char[][] matrix) {
        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
