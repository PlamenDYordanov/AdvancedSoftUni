package Advanced.FileStreams.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt";
        List<Character> punctuation = new ArrayList<>();
        punctuation.add(',');
        punctuation.add('!');
        punctuation.add('?');
        punctuation.add('.');

        try {
            FileInputStream fileInputStream = new FileInputStream(inputPath);
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
            int oneChar = fileInputStream.read();

            while (oneChar >= 0) {
            if (!punctuation.contains((char) oneChar)){
                fileOutputStream.write(oneChar);
                }
                oneChar = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file didn't find");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
