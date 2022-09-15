package Advanced.FileStreams.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        Path outPut = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt");

        Scanner reader = new Scanner(new FileInputStream(String.valueOf(path)));
        List<String> line = Files.readAllLines(path);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(outPut)));
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        for (String s : line) {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (currentChar == 32){
                    continue;
                }
                    if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                        vowels++;
                    }else if (currentChar == '!' || currentChar == ',' || currentChar == '.' || currentChar == '?') {
                        punctuation++;
                    } else {
                        consonants++;
                    }


            }

        }
        printWriter.printf("Vowels: %d%n", vowels);
        printWriter.printf("Consonants: %d%n", consonants);
        printWriter.printf("Punctuation: %d%n", punctuation);
        printWriter.close();
    }}
