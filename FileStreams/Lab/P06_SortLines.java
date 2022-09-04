package Advanced.FileStreams.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06_SortLines {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path output = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        try {
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(output)));
            List<String> listOfLines = new ArrayList<>();
            String line = reader.nextLine();
            while (reader.hasNextLine()){
                listOfLines.add(line);

                line = reader.nextLine();
            }
            Collections.sort(listOfLines);
            for (int i = 0; i < listOfLines.size(); i++) {
                String currentLine = listOfLines.get(i);
                printWriter.println(currentLine);
            }
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
