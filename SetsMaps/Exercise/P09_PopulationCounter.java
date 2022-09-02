package Advanced.SetsMaps.Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Long> totalPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> mapOfCountries = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            int population = Integer.parseInt(input.split("\\|")[2]);
            if (!mapOfCountries.containsKey(country)) {

                mapOfCountries.put(country, new LinkedHashMap<>());
                mapOfCountries.get(country).put(city, population);
                totalPopulation.put(country, (long) population);
            } else {
                long currentPopulation = totalPopulation.get(country);
                totalPopulation.put(country, currentPopulation + (long) population);


                mapOfCountries.get(country).put(city, population);
            }

            input = scanner.nextLine();
        }

        mapOfCountries.entrySet().stream()
                .sorted((c1, c2) -> totalPopulation.get(c2.getKey()).compareTo(totalPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)%n", country.getKey(), totalPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> {
                                System.out.format("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }
}

