package Advanced.DefiningClasses.Exercise.P06_PokemonTrainer;

import java.util.*;

public class Trainer {
    private static final int INITIAL_BADGES = 0;


    private int badges = INITIAL_BADGES;
    private String name;
    private Map<String, List<Pokemon>> pokemons;


    public Trainer(String name) {
        this.name = name;
        this.pokemons = new LinkedHashMap<>();
    }

    public void addPokemon(Pokemon pokemon, String pokemonElement) {
        this.pokemons.putIfAbsent(pokemonElement, new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }


    public int getBadges() {
        return badges;
    }


    public void setBadges(int badges) {
        this.badges = badges;
    }


    public void damagePokemon(int damage) {
        for (List<Pokemon> currPokemon : pokemons.values()) {
            for (Pokemon pokemon : currPokemon) {
                pokemon.takeDamage(damage);
            }
            this.checkPokemonHealth();
        }
    }

    private void checkPokemonHealth() {
        for (List<Pokemon> pokemon : pokemons.values()) {
            pokemon.removeIf(pok -> pok.getHealth() <= 0);

        }
    }

    public void addBadges(int increment) {
        this.badges += increment;
    }


    public boolean HasElement(String currentElement) {
        for (Map.Entry<String, List<Pokemon>> entry : pokemons.entrySet()) {
            for (Pokemon pokemon : entry.getValue()) {
                if (pokemon.getElement().equals(currentElement)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Pokemon>> getPokemons() {
        return pokemons;
    }
    public int getCountPokemons(){
        int size = 0;
        for (List<Pokemon> value : pokemons.values()) {
            size+=value.size();
        }
        return size;
    }
    @Override
    public String toString(){
        return String.format("%s %d %d",this.name, this.badges, getCountPokemons());
    }

}
