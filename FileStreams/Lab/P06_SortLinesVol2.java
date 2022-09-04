package Advanced.FileStreams.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06_SortLinesVol2 {
    public static void main(String[] args) {

        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path output = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");
        //We may have a problem if files is big.
        try {
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            Files.write(output,lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
