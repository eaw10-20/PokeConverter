import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PokeConverter {
    public static void main(String[] args) {
        String path = "trainers.txt";
        String destination = "trainersNew.txt";
        List<String> transfer = new ArrayList<>();


        //import file
        try {
            File trainers = new File(path);
            Scanner reader = new Scanner(trainers);
            boolean cont = false;
            int lineNum = 0;
            while (reader.hasNextLine()){
                System.out.println("Reading line "+ ++lineNum);
                String line = reader.nextLine();
                String fin;
                char start = line.charAt(0);
                if(start == '[') cont = true;
                else if(start == '#') cont = false;

                if(cont || start == '#'){
                    transfer.add(line);
                    continue;
                }

                //parsing the trainer

                Trainer trainer = new Trainer();
                trainer.setTrainerType(line);

                //line 2
                System.out.println("Reading line "+ ++lineNum);
                String line2 = reader.nextLine();
                if(line2.contains(",")){
                    String[] strArr = line2.split(",");
                    trainer.setTrainerName(strArr[0]);
                    trainer.setDup(Integer.parseInt(strArr[1])+1);
                }
                else trainer.setTrainerName(line2);

                //line 3
                System.out.println("Reading line "+ ++lineNum);
                int pokemonCount = Integer.parseInt(reader.nextLine());
                trainer.setPokemonCount(pokemonCount);

                //pokemon (line 4+)
                List<Pokemon> pokemonList = new ArrayList<>();
                for(int i = 0; i < pokemonCount; i++){
                    Pokemon pokemon = new Pokemon();
                    System.out.println("Reading line "+ ++lineNum);
                    String[] pkmArr = reader.nextLine().split(",");
                    pokemon.setName(pkmArr[0]);
                    pokemon.setLevel(Integer.parseInt(pkmArr[1]));
                    if(pkmArr.length <=2) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[2], "")) pokemon.setItem(pkmArr[2]);
                    if(pkmArr.length <=3) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[3], "")) pokemon.addMove(pkmArr[3]);
                    if(pkmArr.length <=4) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[4], "")) pokemon.addMove(pkmArr[4]);
                    if(pkmArr.length <=5) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[5], "")) pokemon.addMove(pkmArr[5]);
                    if(pkmArr.length <=6) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[6], "")) pokemon.addMove(pkmArr[6]);
                    if(pkmArr.length <=7) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[7], "")) pokemon.setAbilityIndex(Integer.parseInt(pkmArr[7]));
                    if(pkmArr.length <=8) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[8], "")) pokemon.setFemale(!pkmArr[8].contains("0"));
                    if(pkmArr.length <=10) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    pokemon.setShiny(false);
                    if(pkmArr.length <=11) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[11], "")) pokemon.setNature(pkmArr[11]);
                    if(pkmArr.length <=12) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[12], "")) pokemon.setIv(Integer.parseInt(pkmArr[12]));
                    if(pkmArr.length <=13) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[13], "")) pokemon.setHappiness(Integer.parseInt(pkmArr[13]));
                    if(pkmArr.length <=16) {
                        pokemonList.add(pokemon);
                        continue;
                    }
                    if(!Objects.equals(pkmArr[16], "")) pokemon.setBall(pkmArr[16]);
                    pokemonList.add(pokemon);
                }
                trainer.setPokemonList(pokemonList);

                //set up new lines
                String l1;
                if(trainer.getDup() != 0){
                    l1 = "[" + trainer.getTrainerType() + "," + trainer.getTrainerName() +
                            "," + trainer.getDup() +"]";
                }
                else{
                    l1 = "[" + trainer.getTrainerType() + "," + trainer.getTrainerName() + "]";
                }
                transfer.add(l1);

                pokemonList = trainer.getPokemonList();
                for(Pokemon pkm : pokemonList){
                    transfer.add("Pokemon = "+ pkm.getName() + "," + pkm.getLevel());
                    if(!Objects.equals(pkm.getItem(), "")) transfer.add("    Item = "+pkm.getItem());
                    if(pkm.getMoves() != null){
                        l1 = "";
                        for(String move: pkm.getMoves()){
                            l1 += move + ",";
                        }
                        transfer.add("    Moves = " + l1);
                    }
                    if(pkm.getAbilityIndex() != -1) transfer.add("    AbilityIndex = "+pkm.getAbilityIndex());
                    if(!Objects.equals(pkm.getNature(), "")) transfer.add("    Nature = " + pkm.getNature());
                    if(pkm.getIv() != -1){
                        int x = pkm.getIv();
                        transfer.add("    IV = " + x + ","+ x + ","+ x + ","+ x + ","+ x + ","+ x);
                    }
                    if(pkm.getHappiness() != -1) transfer.add("    Happiness = " + pkm.getHappiness());
                    if(!Objects.equals(pkm.getBall(), "")) transfer.add("    Ball = " + pkm.getBall());
                    if(pkm.isGenderDefined()){
                        transfer.add("    Gender = " + (pkm.isFemale() ? "female" : "male"));
                        transfer.add("    Shiny = FALSE");
                    }
                    if(pkm.getHappiness() != -1) transfer.add("    Happiness = " + pkm.getHappiness());
                }
            }
        }  catch (FileNotFoundException e){
            System.out.println("Error reading the file");
            e.printStackTrace();
        }

        //time to write to new file
        try{
            File tr = new File(destination);
            if(tr.createNewFile()){
                System.out.println("New txt created");
            }
            else {
                System.out.println("Txt already exists!");
            }
            PrintWriter writer = new PrintWriter(destination);
            for(String line: transfer){
                writer.println(line);
            }
            writer.close();
            System.out.println("Success! I think :)");
        } catch (IOException e){
            System.out.println("Error writing to new file");
            e.printStackTrace();
        }
    }
}
