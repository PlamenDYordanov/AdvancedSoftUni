package Advanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P10_vol2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<String> partyMembers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> newMembers = new ArrayList<>();
        newMembers.addAll(partyMembers);

        String inputLine = scanner.nextLine();


        while (!inputLine.equals("Party!")) {
            String command = inputLine.split("\\s+")[0];
            String action = inputLine.split("\\s+")[1];
            switch (command) {
                case "Remove":
                    if (action.equals("Length")) {
                        int length = Integer.parseInt(inputLine.split("\\s+")[2]);
                        BiPredicate<String, List<String>> checkLength = (name, list) -> {
                            if (name.length() == length) {
                                return false;
                            }
                            return true;
                        };
                        newMembers = partyMembers.stream().filter(person -> checkLength.test(person, partyMembers)).collect(Collectors.toList());
                    } else {
                        String symbols = inputLine.split("\\s+")[2];
                        if (action.equals("StartsWith")) {
                            BiPredicate<String, List<String>> startWith = (name, list) -> {
                                if (name.startsWith(symbols)) {
                                    return false;
                                }
                                return true;
                            };
                            newMembers = partyMembers.stream().filter(person -> startWith.test(person, partyMembers)).collect(Collectors.toList());
                        } else {
                            BiPredicate<String, List<String>> endWith = (name, list) -> {
                                if (name.endsWith(symbols)) {
                                    return false;
                                }
                                return true;
                            };
                            newMembers = partyMembers.stream().filter(person -> endWith.test(person, partyMembers)).collect(Collectors.toList());
                        }
                    }
                    break;
                case "Double":
                    if (action.equals("Length")) {
                        int length = Integer.parseInt(inputLine.split("\\s+")[2]);
                        int size = newMembers.size();
                        for (int i = 0; i < size; i++) {
                            String name = newMembers.get(i);
                            if (newMembers.get(i).length() == length) {
                                newMembers.add(i++, name);
                            }
                        }

                    } else {
                        String symbols = inputLine.split("\\s+")[2];

                        if (action.equals("StartsWith")) {
                            for (int i = 0; i < newMembers.size(); i++) {
                                String name = newMembers.get(i);
                                if (newMembers.get(i).startsWith(symbols)) {
                                   newMembers.add(i++,name);
                                }
                            }
                        } else {
                            for (int i = 0; i < newMembers.size(); i++) {
                                String name = newMembers.get(i);
                                if (newMembers.get(i).endsWith(symbols)) {
                                    newMembers.add(i++,name);
                                }
                            }

                        }
                    }
                    break;
            }
            inputLine = scanner.nextLine();
        }
        if (newMembers.size() > 0) {
            Collections.sort(newMembers);
            System.out.print(String.join(", ", newMembers));
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }
}


