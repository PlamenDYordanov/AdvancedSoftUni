package Advanced.FileStreams.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class P03_Vol2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\input.txt");
        Path outPut = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\output.txt");
        try {
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(outPut)));
            List<String> lines = Files.readAllLines(path);
            System.out.println();
            for (String line : lines) {
                printWriter.println(line.toUpperCase());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
