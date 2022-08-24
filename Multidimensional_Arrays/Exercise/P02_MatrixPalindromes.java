package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Scanner;

public class P02_MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = (scanner.nextLine()).split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        char firstChar = 'a';
        char secondChar = 'a';
        char thirdChar = 'a';

        int[][] matrix = new int[rows][cols];
        int index = 0;
        for (int row = 0; row < rows; row++) {
            firstChar = (char) (firstChar + index);
            secondChar = (char) (secondChar + index);
            thirdChar = (char) (thirdChar + index);
            System.out.print(firstChar + "" + secondChar + "" + thirdChar + " ");
            for (int col = 0; col < cols-1; col++) {
                secondChar = (char) (secondChar + 1);

                System.out.print(firstChar + "" + secondChar + "" + thirdChar + " ");
            }
            secondChar = firstChar;
            System.out.println();
            index = 1;
        }
    }
}
