import java.util.List;

public class Trainer {

    private String trainerType;
    private String trainerName;
    private int dup;
    private int pokemonCount;
    private List<Pokemon> pokemonList;

    public Trainer(){
        int dup = 0;
    }

    public String getTrainerType() {
        return trainerType;
    }

    public void setTrainerType(String trainerType) {
        this.trainerType = trainerType;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getDup() {
        return dup;
    }

    public void setDup(int dup) {
        this.dup = dup;
    }

    public int getPokemonCount() {
        return pokemonCount;
    }

    public void setPokemonCount(int pokemonCount) {
        this.pokemonCount = pokemonCount;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemonList.add(pokemon);
    }
}
