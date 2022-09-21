package Advanced.DefiningClasses.Exercise.P07_Google;

public class Pokemon {
    private String name;
    private String pokemonType;

    public Pokemon(String name, String pokemonType) {
        this.name = name;
        this.pokemonType = pokemonType;
    }

    public String getName() {
        return name;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    @Override
    public String toString() {
        return name + " " + pokemonType;

    }
}
