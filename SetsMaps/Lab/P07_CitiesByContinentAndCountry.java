package Advanced.SetsMaps.Lab;

import java.util.*;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfInputs = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> mapContinentCountryCities = new LinkedHashMap<>();
        for (int i = 0; i < countOfInputs; i++) {

            String[] inputLine = scanner.nextLine().split("\\s+");
            String continent = inputLine[0];
            String country = inputLine[1];
            String cities = inputLine[2];


            if (!mapContinentCountryCities.containsKey(continent)) {

                mapContinentCountryCities.put(continent, new LinkedHashMap<>());
                mapContinentCountryCities.get(continent).put(country, new ArrayList<>());
                mapContinentCountryCities.get(continent).get(country).add(cities);
            } else {
                if (!mapContinentCountryCities.get(continent).containsKey(country)) {
                    mapContinentCountryCities.get(continent).put(country, new ArrayList<>());
                    mapContinentCountryCities.get(continent).get(country).add(cities);
                } else {
                    mapContinentCountryCities.get(continent).get(country).add(cities);
                }
            }
        }
        mapContinentCountryCities.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s:%n", entry.getKey());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .forEach(print -> {
                                System.out.printf("%s -> ", print.getKey());
                                for (int i = 0; i < print.getValue().size(); i++) {
                                    if (i == print.getValue().size() - 1) {
                                        System.out.printf("%s", print.getValue().get(i));
                                    } else {
                                        System.out.printf("%s, ", print.getValue().get(i));
                                    }
                                }
                                System.out.println();
                            });

                });
    }
}
