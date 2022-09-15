package Advanced.DefiningClasses.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];


            Car car = null;
            if (input.length==1){
                car = new Car(brand);
            }else {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                car = new Car(brand, model ,horsePower);

            }



            System.out.printf("The car is: %s %s - %d HP.%n",car.getBrand(),car.getModel(),car.getHorsePower());
        }
    }
}
