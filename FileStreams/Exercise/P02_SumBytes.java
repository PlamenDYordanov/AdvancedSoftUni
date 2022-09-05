package Advanced.FileStreams.Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P02_SumBytes {
    public static void main(String[] args) {

        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\input.txt");


        try {
            //first case
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
            String line  = reader.nextLine();
            int sum = 0;
            while (reader.hasNextLine()){
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                line = reader.nextLine();
            }
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);

            //second case
            int secondSum = 0;
            List<String> allLines = Files.readAllLines(path);
            for (int i = 0; i < allLines.size(); i++) {
                String firstLine = allLines.get(i);
                for (int j = 0; j < firstLine.length(); j++) {
                    secondSum+= firstLine.charAt(j);
                }
            }
            System.out.println(secondSum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
