package Advanced.FileStreams.Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class P03_AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\input.txt");
        Path output = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\output.txt");
        PrintWriter printWriter = new PrintWriter(new PrintWriter(new FileOutputStream(String.valueOf(output))));

        try {
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));

            String line = reader.nextLine();

            StringBuilder newLine = new StringBuilder();
            while (reader.hasNext()) {
                newLine = new StringBuilder("");
                for (char letter : line.toCharArray()) {
                    if (Character.isLetter(letter) && Character.isLowerCase(letter)) {
                        char currentChar = (char) ((char) letter - 32);
                        newLine.append(currentChar);
                    }else {
                        newLine.append(letter);
                    }
                }
                    printWriter.println(newLine);

                line = reader.nextLine();
            }

            newLine = new StringBuilder("");
            for (char letter : line.toCharArray()) {
                if (Character.isLetter(letter) && Character.isLowerCase(letter)) {
                    char currentChar = (char) ((char) letter - 32);
                    newLine.append(currentChar);
                }else {
                    newLine.append(letter);
                }
            }
            printWriter.println(newLine);


printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
