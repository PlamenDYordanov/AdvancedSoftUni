package Advanced.SetsMaps.Lab;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Map<String, Map<String, Double>> mapOfProduct = new TreeMap<>();

        while (!inputLine.equals("Revision")){
            String market = inputLine.split(", ")[0];
            String product = inputLine.split(", ")[1];
            double price = Double.parseDouble(inputLine.split(", ")[2]);

            if (!mapOfProduct.containsKey(market)){
                mapOfProduct.put(market,new LinkedHashMap<>());
                mapOfProduct.get(market).put(product,price);
            }else {
                mapOfProduct.get(market).put(product,price);
            }

            inputLine = scanner.nextLine();
        }
        mapOfProduct.entrySet()
                .stream()
                .forEach(entry ->  {
                    System.out.printf("%s->%n",entry.getKey());
                    entry.getValue().entrySet()
                            .stream()
                            .forEach(print -> {
                                System.out.printf("Product: %s, Price: %.1f%n",print.getKey(),print.getValue());
                            });
                });
    }
}
