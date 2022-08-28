package Advanced.Multidimensional_Arrays.Exercise;

import java.util.Scanner;

public class P08_HeiganDance {

    //You have to use boolean[][] !!!!! And you have to implement 3x3 hit zone with true
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damageDone = Double.parseDouble(scanner.nextLine());
        double heiganHeal = 3000000;
        double playerHeal = 18500;

        String[][] chamber = new String[15][15];
        boolean flag = false;
        String lastSpell = "";
        int lastRow = 0;
        int lastCol = 0;

        fillMatrix(chamber);
        while (heiganHeal > 0 && playerHeal > 0) {
            if (flag) {
                playerHeal -= 3500;
                flag = false;
            }
            heiganHeal -= damageDone;
            if (playerHeal < 0) {
                break;
            }
            if (heiganHeal < 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int rowSpell = Integer.parseInt(input[1]);
            int colSpell = Integer.parseInt(input[2]);
            boolean isFindPlayer = false;

            //firstRow
            for (int row = rowSpell - 1; row <= rowSpell - 1; row++) {
                for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                    if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                        if (chamber[row][col].equals("p")) {
                            isFindPlayer = true;
                            if (row - 1 >= 0) {
                                chamber[row][col] = "a";
                                chamber[row - 1][col] = "p";
                            }
                            break;
                        }
                    }
                }
            }
            //secondRow
            if (!isFindPlayer) {
                for (int row = rowSpell; row <= rowSpell; row++) {
                    for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                        if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                            if (chamber[row][col].equals("p")) {
                                isFindPlayer = true;
                                if (row - 1 >= 0) {
                                    chamber[row][col] = "a";
                                    chamber[row - 1][col] = "p";
                                }
                                break;
                            }
                        }
                    }
                }
            }
            //thirdRow
            if (!isFindPlayer) {
                for (int row = rowSpell + 1; row <= rowSpell + 1; row++) {
                    for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                        if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                            if (chamber[row][col].equals("p")) {
                                isFindPlayer = true;
                                if (row - 1 >= 0) {
                                    chamber[row][col] = "a";
                                    chamber[row - 1][col] = "p";
                                }
                                break;
                            }
                        }
                    }
                }
            }
            //try to escape
            if (isFindPlayer) {

                tryToEscapeUp(chamber, rowSpell, colSpell, lastRow, lastCol);
                    tryToEscapeRight(chamber, rowSpell, colSpell, lastRow, lastCol);
                        tryToEscapeDown(chamber, rowSpell, colSpell, lastRow, lastCol);
                            if (!tryToEscapeLeft(chamber, rowSpell, colSpell, lastRow, lastCol)) {

                                if (spell.equals("Cloud")) {
                                    lastSpell = "Plague Cloud";
                                    playerHeal -= 3500;
                                    flag = true;
                                } else if (spell.equals("Eruption")) {
                                    lastSpell = spell;
                                    playerHeal -= 6000;
                                }
                            }
                        }


                    }



        if (flag) {
            playerHeal -= 3500;
        }
        if (heiganHeal <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHeal);
        }
        if (playerHeal > 0) {
            System.out.printf("Player: %.0f%n", playerHeal);
        } else {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }
        boolean isFind = false;
        for (int row = 0; row < chamber.length; row++) {
            for (int col = 0; col < chamber.length; col++) {
                if (chamber[row][col].equals("p")) {
                    System.out.printf("Final position: %d, %d%n", row, col);
                    isFind = true;
                    break;

                }
            }
            if (isFind) {
                break;
            }
        }

    }


    private static boolean tryToEscapeLeft(String[][] chamber, int rowSpell, int colSpell, int lastRow, int lastCol) {
        //firstRow
        for (int row = rowSpell - 1; row <= rowSpell - 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        chamber[row][col] = "a";
                        if (col + 1 <= 14) {
                            chamber[row][col + 1] = "p";
                        }
                        return false;
                    }
                }
            }
        }
        //secondRow
        for (int row = rowSpell; row <= rowSpell; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        chamber[row][col] = "a";
                        if (col + 1 <= 14) {
                            chamber[row][col + 1] = "p";
                        }
                        return false;
                    }
                }
            }
        }
        //thirdRow
        for (int row = rowSpell + 1; row <= rowSpell + 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        chamber[row][col] = "a";
                        if (col + 1 <= 14) {
                            chamber[row][col + 1] = "p";
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void  tryToEscapeDown(String[][] chamber, int rowSpell, int colSpell, int lastRow, int lastCol) {
        //firstRow
        for (int row = rowSpell - 1; row <= rowSpell - 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (lastRow + 1 <= 14 && lastCol - 1 >= 0) {
                        if (chamber[row][col].equals("p")) {
                            chamber[row][col] = "a";
                            chamber[row - 1][col - 1] = "p";
                        }

                    }
                }
            }
        }
        //secondRow
        for (int row = rowSpell; row <= rowSpell; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        chamber[row][col] = "a";
                        chamber[row - 1][col - 1] = "p";

                    }
                }
            }
        }
        //thirdRow
        for (int row = rowSpell + 1; row <= rowSpell + 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        chamber[row][col] = "a";
                        chamber[row - 1][col - 1] = "p";

                    }
                }
            }
        }

    }

    private static void tryToEscapeRight(String[][] chamber, int rowSpell, int colSpell, int lastRow, int lastCol) {
        //firstRow
        for (int row = rowSpell - 1; row <= rowSpell - 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        if (lastRow <= 14 && lastCol <= 14) {
                            chamber[row][col] = "a";
                            chamber[lastRow + 1][lastCol - 1] = "p";
                            lastRow = lastRow + 1;
                            lastCol = lastCol - 1;
                        }

                    }
                }
            }
        }
        //secondRow
        for (int row = rowSpell; row <= rowSpell; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {

                        if (lastRow <= 14 && lastCol <= 14) {
                            chamber[row][col] = "a";
                            chamber[lastRow + 1][lastCol - 1] = "p";
                            lastRow = lastRow + 1;
                            lastCol = lastCol - 1;
                        }

                    }
                }
            }
        }
        //thirdRow
        for (int row = rowSpell + 1; row <= rowSpell + 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {

                        if (lastRow <= 14 && lastCol <= 14) {
                            chamber[row][col] = "a";
                            chamber[lastRow + 1][lastCol - 1] = "p";
                            lastRow = lastRow + 1;
                            lastCol = lastCol - 1;
                        }

                    }
                }
            }
        }

    }

    private static void tryToEscapeUp(String[][] chamber, int rowSpell, int colSpell, int lastRow, int lastCol) {
        //firstRow
        for (int row = rowSpell - 1; row <= rowSpell - 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        lastCol = col;
                        lastRow = row;
                        if (row + 1 <= 14 && col + 1 <= 14) {
                            chamber[row][col] = "a";
                            chamber[row + 1][col + 1] = "p";
                            lastCol = col + 1;
                            lastRow = row + 1;
                        }

                    }
                }
            }
        }
        //secondRow
        for (int row = rowSpell; row <= rowSpell; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        lastCol = col;
                        lastRow = row;
                        if (row + 1 <= 14 && col + 1 <= 14) {
                            chamber[row][col] = "a";
                            chamber[row + 1][col + 1] = "p";
                            lastCol = col + 1;
                            lastRow = row + 1;
                        }

                    }
                }
            }
        }
        //thirdRow
        for (int row = rowSpell + 1; row <= rowSpell + 1; row++) {
            for (int col = colSpell - 1; col <= colSpell + 1; col++) {
                if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                    if (chamber[row][col].equals("p")) {
                        lastCol = col;
                        lastRow = row;
                        if (row + 1 <= 14 && col + 1 <= 14) {
                            chamber[row][col] = "a";
                            chamber[row + 1][col + 1] = "p";
                            lastCol = col + 1;
                            lastRow = row + 1;
                        }

                    }
                }
            }
        }

    }

    private static void fillMatrix(String[][] chamber) {
        String symbol = "a";
        for (int row = 0; row < chamber.length; row++) {
            for (int col = 0; col < chamber.length; col++) {
                if (row == 7 & col == 7) {
                    chamber[row][col] = "p";
                } else {
                    chamber[row][col] = symbol;
                }
            }
        }
    }
}