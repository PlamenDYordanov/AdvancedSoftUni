package Advanced.FileStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class P03_CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream(output);
            int character = fileInputStream.read();
            while (character >= 0) {
                String digit = String.valueOf(character);
                if (digit.equals("32")||digit.equals("10")) {
                    fileOutputStream.write(character);
                } else {
                    for (int i = 0; i < digit.length(); i++) {
                        fileOutputStream.write(digit.charAt(i));
                    }
                }

                character = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry i didn't find the file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
