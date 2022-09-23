package Advanced.DefiningClasses.Exercise.P09_CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<Cymric> cymricList = new ArrayList<>();
        List<Siamese> siameseList = new ArrayList<>();
        List<StreetExtraordinary> extraordinaryList = new ArrayList<>();
        while (!inputLine.equals("End")) {
            String type = inputLine.split("\\s+")[0];
            String name = inputLine.split("\\s+")[1];
            double values = Double.parseDouble(inputLine.split("\\s+")[2]);

            if (type.equals("Siamese")) {
                Siamese siamese = new Siamese(name, values);
                siameseList.add(siamese);
            } else if (type.equals("Cymric")) {
                Cymric cymric = new Cymric(name, values);
                cymricList.add(cymric);
            } else if (type.equals("StreetExtraordinaire")) {
                StreetExtraordinary streetExtraordinary = new StreetExtraordinary(name, values);
                extraordinaryList.add(streetExtraordinary);
            }

            inputLine = scanner.nextLine();
        }
        inputLine = scanner.nextLine();
        String requireCatName = inputLine;
        boolean isFind = false;
        if (!cymricList.isEmpty()) {
            for (Cymric currentCatName : cymricList) {
                if (currentCatName.getName().equals(requireCatName)) {
                    System.out.println(currentCatName.toString());
                    isFind = true;
                }
            }
        }
        if (!siameseList.isEmpty()&&!isFind){
            for (Siamese currentCatName : siameseList) {
                if (currentCatName.getName().equals(requireCatName)) {
                    System.out.println(currentCatName.toString());
                    isFind = true;
                }
            }
        }
        if (!extraordinaryList.isEmpty() && !isFind){
            for (StreetExtraordinary currentCatName : extraordinaryList) {
                if (currentCatName.getName().equals(requireCatName)) {
                    System.out.println(currentCatName.toString());
                    isFind = true;
                }
            }
        }

    }
}
