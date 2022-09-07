package Advanced.FileStreams.Exercise;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P08_FolderSize {
    public static void main(String[] args) {

        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        File folder = new File(String.valueOf(path));
        File[] allFiles = folder.listFiles();

        int folderSize = 0;
        for (File file : allFiles) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);


    }
}
