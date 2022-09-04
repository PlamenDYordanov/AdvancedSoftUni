package Advanced.FileStreams.Lab;

import java.io.*;
import java.util.Scanner;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        Scanner reader = new Scanner(new FileReader(path));
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(output));
            int counter = 1;
            String line = reader.nextLine();

            while (reader.hasNextLine()) {
                if (counter % 3 == 0) {
                    printWriter.println(line);
                }
                counter++;

                line = reader.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.close();

    }
}
