package Advanced.Multidimensional_Arrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] degreeInput = scanner.nextLine().split("\\(");
        int degree = Integer.parseInt(degreeInput[1].replaceAll("\\)", ""));


        String input = scanner.nextLine();
        List<String> inputs = new ArrayList<>();
        int cols = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            int length = input.length();
            if (length > cols) {
                cols = length;
            }
            inputs.add(input);


            input = scanner.nextLine();
        }
        String[] itemArr = new String[inputs.size()];
        itemArr = inputs.toArray(itemArr);

        int rows = inputs.size();

//0-5
        if (degree == 0) {
            String[][] matrix = new String[rows][cols];
            for (int row = 0; row < rows; row++) {

                String item = itemArr[row];
                for (int col = 0; col < item.length(); col++) {
                    matrix[row][col] = String.valueOf(item.charAt(col));
                }

            }
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == null) {
                        System.out.print(" ");
                        continue;
                    } else {
                        System.out.print(matrix[row][col] + "");
                    }
                }
                System.out.println();
            }
            return;
        }
        if (degree%90!=0){
            return;
        }
        int turns = degree / 90;
        int cases = -1;
        if (turns <= 299) {
            for (int i = 0; i <= turns; i++) {
                cases++;
                if (cases > 4) {
                    cases = 1;
                }
            }
        } else if (turns <= 699) {
            for (int i = 300; i <= turns; i++) {
                cases++;
                if (cases > 4) {
                    cases = 1;
                }
            }
        } else {
            for (int i = 700; i <= turns; i++) {
                cases++;
                if (cases > 4) {
                    cases = 1;
                }
            }
        }
        //1 case
        String[][] matrix = new String[cols][rows];
        if (cases == 1) {
            for (int col = 0; col < rows; col++) {
                String item = itemArr[itemArr.length - 1 - col];
                for (int row = 0; row < item.length(); row++) {
                    matrix[row][col] = String.valueOf(item.charAt(row));
                }
            }
        }
        //2 case

        else if (cases == 2) {
            matrix = new String[rows][cols];
            for (int row = 0; row < rows; row++) {
                int position = 0;
                String item = itemArr[itemArr.length - 1 - row];
                for (int col = cols - item.length(); col < cols; col++) {
                    matrix[row][col] = String.valueOf(item.charAt(item.length() - 1 - position));
                    position++;


                }
            }

        }
        // 3 case

        else if (cases == 3) {
            for (int col = 0; col < rows; col++) {
                int position = 0;
                String item = itemArr[col];
                for (int row = cols - 1; row > cols - 1 - item.length(); row--) {
                    matrix[row][col] = String.valueOf(item.charAt(position));
                    position++;
                }
            }
        } else if (cases == 4) {
            matrix = matrix = new String[rows][cols];
            for (int row = 0; row < rows; row++) {

                String item = itemArr[row];
                for (int col = 0; col < item.length(); col++) {
                    matrix[row][col] = String.valueOf(item.charAt(col));
                }

            }

        }
        if (cases == 2 || cases == 4) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == null) {
                        System.out.print(" ");
                        continue;
                    } else {
                        System.out.print(matrix[row][col] + "");
                    }
                }
                System.out.println();
            }
        } else if (cases==1|| cases ==3){
            for (int row = 0; row < cols; row++) {
                for (int col = 0; col < rows; col++) {
                    if (matrix[row][col] == null) {
                        System.out.print(" ");
                        continue;
                    } else {
                        System.out.print(matrix[row][col] + "");
                    }
                }
                System.out.println();
            }

        }
    }
}
