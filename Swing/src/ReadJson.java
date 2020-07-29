import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;


public class ReadJson {

    private String playerName;

    //  public static void GSONMethod() {
    public static List<String> GSONMethod() throws FileNotFoundException {

        String jsonFile = "players.json";

//        Gson gsonimport = new Gson();
//
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(jsonFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        JsonReader jsonReader = new JsonReader(fileReader);
//
//        Object players = new Gson().fromJson(fileReader,
//                new TypeToken<List<String>>(){}.getType());;

        BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
        Gson gson = new Gson();
        Players players = gson.fromJson(reader, Players.class);

        //System.out.println(players.getPlayernames()); // for debugging only

        return players.getPlayernames();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}

class JSONImportToArray {

    private String[] JSONImport;

    public static void setArrayFromJSON() {
        System.out.println("test");
    }

}

/*
 * The class represents the players list extracted from the JSON file.
 */
class Players {

    List<String> playernames;

    Players(List<String> playernames) {
        this.playernames = playernames;
    }

    List<String> getPlayernames() {
        return playernames;
    }
}




