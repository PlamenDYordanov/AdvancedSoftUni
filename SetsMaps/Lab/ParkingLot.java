package Advanced.SetsMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){

            String command = input.split(", ")[0];
            String carNumber = input.split(",")[1];

            switch (command){
                case "IN":
                    parkingLot.add(carNumber);
                    break;
                case"OUT":
                    if (parkingLot.contains(carNumber)){
                        parkingLot.remove(carNumber);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        if (parkingLot.size()>0){
            for (String s : parkingLot) {
                System.out.println(s);
            }

        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
