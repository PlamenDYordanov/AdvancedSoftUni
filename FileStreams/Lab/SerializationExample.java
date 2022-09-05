package Advanced.FileStreams.Lab;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3d,12.4d,3d);

        String path = "E:\\Advanced_SoftUni\\src\\Advanced\\FileStreams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\MyCube.ser";
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(cube);
            objectOutputStream.close();

            ObjectInput objectInput = new ObjectInputStream(new FileInputStream(path));

            Cube cubeFromFile = (Cube)objectInput.readObject();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
