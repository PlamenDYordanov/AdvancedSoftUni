package Advanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> partyMembers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());


        String inputLine = scanner.nextLine();


        while (!inputLine.equals("Party!")) {

            String[] commandTokens = inputLine.split("\\s+");

            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String predicateArgument = commandTokens[2];

            if (command.equals("Remove")) {
                partyMembers.removeIf(getPredicate(predicateType, predicateArgument));
            }
            else if (command.equals("Double")) {

                for (int i = 0; i < partyMembers.size(); i++) {
                    String guest = partyMembers.get(i);
                    if (getPredicate(predicateType, predicateArgument).test(guest)) {
                        partyMembers.add(i++, guest);
                    }
                }
            }
            inputLine = scanner.nextLine();
        }
        if (partyMembers.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(partyMembers);
            System.out.println(String.format("%s are going to the party!", String.join(", ", partyMembers)));
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text -> false;
        }
    }
}