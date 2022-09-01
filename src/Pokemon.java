import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private int level;
    private String item;
    private List<String> moves;
    private int AbilityIndex;
    private boolean genderDefined;
    private boolean isFemale;
    //unknown value here
    private boolean isShiny;
    private String nature;
    private int iv;
    private int happiness;
    //2 unknowns here
    private String ball;

    public Pokemon() {
        level = 0;
        item = "";
        AbilityIndex = -1;
        genderDefined = false;
        nature = "";
        iv = -1;
        happiness = -1;
        ball = "";
        moves = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public void addMove(String move){
        this.moves.add(move);
    }

    public int getAbilityIndex() {
        return AbilityIndex;
    }

    public void setAbilityIndex(int abilityIndex) {
        AbilityIndex = abilityIndex;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        genderDefined = true;
        isFemale = female;
    }

    public boolean isShiny() {
        return isShiny;
    }

    public void setShiny(boolean shiny) {
        isShiny = shiny;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getIv() {
        return iv;
    }

    public void setIv(int iv) {
        this.iv = iv;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    public boolean isGenderDefined(){
        return genderDefined;
    }
}
