package Advanced.FileStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(output));
        try {
            Scanner reader = new Scanner(new FileInputStream(path));

            while (reader.hasNext()){
                if (reader.hasNextInt()){
                    int myNumber = reader.nextInt();
                    printWriter.println(myNumber);
                }
                reader.next();
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
