package Advanced.FileStreams.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P08_NestedFolders {
    public static void main(String[] args) {
        File file = new File("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        ArrayDeque queue = new ArrayDeque<>();

        int counter = 0;

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                counter++;
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        counter++;
                        queue.offer(f.getPath());
                        System.out.println(f.getName());
                    }
                }

            }
            while (!queue.isEmpty()) {
                String currentPath = String.valueOf(queue.poll());
                file = new File(currentPath);
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    for (File f : files) {
                        if (f.isDirectory()){
                            counter++;
                            queue.offer(f.getPath());
                            System.out.println(f.getName());
                        }

                    }
                }
            }
        }
        System.out.printf("%d folders",counter);

    }
}
