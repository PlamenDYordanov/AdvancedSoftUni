package Advanced.DefiningClasses.Exercise.P06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String information = scanner.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!information.equals("Tournament")) {
            String trainerName = information.split("\\s+")[0];
            String pokemonName = information.split("\\s+")[1];
            String pokemonElement = information.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(information.split("\\s+")[3]);

            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon =  new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainerMap.putIfAbsent(trainerName,trainer);
            trainerMap.get(trainerName).addPokemon(pokemon,pokemonElement);


            information = scanner.nextLine();
        }
        information = scanner.nextLine();

        while (!information.equals("End")) {
            String currentElement = information;
            for (Trainer trainer : trainerMap.values()) {
               if (trainer.HasElement(currentElement)){
                   trainer.addBadges(1);

               }else {
                   trainer.damagePokemon(10);

               }
            }


            information = scanner.nextLine();
        }
        trainerMap.values()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getBadges(), o1.getBadges()))
                .forEach(print -> System.out.printf("%s %d %d%n",print.getName(), print.getBadges(), print.getCountPokemons()));

    }




}


