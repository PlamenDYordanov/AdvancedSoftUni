package Advanced.FileStreams.Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class P07_MergeTwoFiles {
    public static void main(String[] args) {
        Path firstFile = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\inputOne.txt");
        Path secondFile = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\inputTwo.txt");
        Path output = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\output.txt");

        try {
            Scanner reader1 = new Scanner(new FileInputStream(String.valueOf(firstFile)));
            Scanner reader2 = new Scanner(new FileInputStream(String.valueOf(secondFile)));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(output)));
            String word = reader1.nextLine();
            StringBuilder file = new StringBuilder();
            while (reader1.hasNextLine()){
                file.append(word);

                word = reader1.nextLine();
            }
                file.append(word);
            word = reader2.nextLine();
            while (reader2.hasNextLine()){
                file.append(word);

                word =  reader2.nextLine();
            }
            file.append(word);
            for (int i = 0; i < file.length(); i++) {
                char currChar = file.charAt(i);
                printWriter.printf("%c%n",currChar);
            }
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
