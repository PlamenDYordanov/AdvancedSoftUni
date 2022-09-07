package Advanced.FileStreams.Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class P06_WordCount {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\words.txt");
        Path compare = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\text.txt");
        Path resultOutput = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\result.txt");

        try {

            Map<String, Integer> mapOfWords = new LinkedHashMap<>();
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(resultOutput)));
            String[] words = String.valueOf(Files.readAllLines(path)).replaceAll("[\\[\\]]","").split(" ");

            for (int i = 0; i < words.length; i++) {
                mapOfWords.put(words[i],0);
            }

            Scanner reader = new Scanner( new FileInputStream(String.valueOf(compare)));

            String word = reader.next();
            while (reader.hasNext()){
                if (mapOfWords.containsKey(word)){
                    int currentValue = mapOfWords.get(word);
                    mapOfWords.put(word,currentValue+1);
                }
                word = reader.next();
            }

            mapOfWords.entrySet()
                    .stream()
                    .sorted((left, right)->{
                        int result = right.getValue().compareTo(left.getValue());
                        return result;
                    }).forEach(p -> {
                        printWriter.printf("%s - %d%n",p.getKey(), p.getValue());
                    });
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
