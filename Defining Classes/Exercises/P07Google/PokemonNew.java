package P14DefiningClasses_Exercise.P07Google;

public class PokemonNew {
    private String pokemonName;
    private String pokemonType;

    public PokemonNew(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }
}
