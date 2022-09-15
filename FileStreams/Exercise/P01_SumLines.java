package Advanced.FileStreams.Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class P01_SumLines {
    public static void main(String[] args) {

        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        try {
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
            String line = reader.nextLine();
            int sum = 0;
            while (reader.hasNextLine()) {
                sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);


                line = reader.nextLine();
            }
            sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
