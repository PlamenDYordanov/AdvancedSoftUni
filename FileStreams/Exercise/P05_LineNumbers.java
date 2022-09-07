package Advanced.FileStreams.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P05_LineNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\inputLineNumbers.txt");
        Path output = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\output.txt");

        try {
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(output)));
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                printWriter.printf("%d. "+lines.get(i).toString()+"%n",i+1);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
