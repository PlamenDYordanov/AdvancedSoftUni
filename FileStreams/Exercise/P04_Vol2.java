package Advanced.FileStreams.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class P04_Vol2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\input.txt");
        Path outPut = Paths.get("E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\ExR\\Exercises Resources\\output.txt");
        Set<Character> vowelsSet = getVowels();
        Set<Character> punctuationSet = getPunctuation();
        Scanner reader;

        {
            try {
                reader = new Scanner(new FileInputStream(String.valueOf(path)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        List<String> line;

        {

            try {
                line = Files.readAllLines(path);
                for (String s : line) {
                    for (int i = 0; i < s.length(); i++) {
                        char currentChar = s.charAt(i);
                        if (currentChar == 32) {
                            continue;
                        }
                        if (vowelsSet.contains(currentChar)) {
                            vowels++;
                        } else if (punctuationSet.contains(currentChar)) {
                            punctuation++;
                        } else {
                            consonants++;
                        }


                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintWriter printWriter;

        {
            try {
                printWriter = new PrintWriter(new FileOutputStream(String.valueOf(outPut)));
                printWriter.printf("Vowels: %d%n", vowels);
                printWriter.printf("Consonants: %d%n", consonants);
                printWriter.printf("Punctuation: %d%n", punctuation);
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    private static Set<Character> getVowels () {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
    private static Set<Character> getPunctuation () {
        Set<Character> punctuation = new HashSet<>();
        punctuation.add('!');
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('?');
        return punctuation;
    }
}