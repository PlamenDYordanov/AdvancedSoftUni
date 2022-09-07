package Advanced.FileStreams.Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class P05_Vol2 {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\inputLineNumbers.txt");
        Path output = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\output.txt");

        try {
            Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(output)));
            String line = reader.nextLine();
            int index = 1;
            while (reader.hasNext()){

                printWriter.printf("%d."+line+"%n",index);
                index++;
                line = reader.nextLine();
            }
            printWriter.printf("%d."+line+"%n",index);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
