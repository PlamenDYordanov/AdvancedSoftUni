package Generics.Exercise.P07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!commandLine.equals("END")) {
            String[] tokens = commandLine.split("\\s+");
            switch (commandLine.split("\\s+")[0]) {
                case "Add": {
                    String element = tokens[1];
                    customList.add(element);
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                }
                case "Contains": {
                    String element = tokens[1];
                    System.out.println(customList.contains(element));
                    break;
                }
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swapIndex(firstIndex,secondIndex);
                    break;
                case "Greater":
                    String element = tokens[1];
                    System.out.println(customList.compareTo(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
            }
            commandLine = scanner.nextLine();
        }
    }}
