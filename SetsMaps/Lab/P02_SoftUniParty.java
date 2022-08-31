package Advanced.SetsMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();
        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            char symbol = input.charAt(0);
            if (Character.isDigit(symbol) && input.length() == 8) {
                vip.add(input);
            } else if (input.length()==8){
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        String party = scanner.nextLine();


        while (!party.equals("END")){
            char symbol = party.charAt(0);
            if (Character.isDigit(symbol)){
                if (vip.contains(party)){
                    vip.remove(party);
                }
            }else {
                if (regular.contains(party)){
                    regular.remove(party);
                }
            }


            party = scanner.nextLine();
        }
        int totalSize = vip.size()+ regular.size();
        System.out.println(totalSize);
       if (vip.size()>0){

           vip.forEach(System.out::println);
       }
       if (regular.size()>0){

           regular.forEach(System.out::println);
       }
    }

}
