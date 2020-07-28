import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadJson {

    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    String[] potentialPlayers = {"Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11",
            "Player12", "Player13", "Player14", "Player15", "Player16", "Player17", "Player18", "Player19", "Player20", "Player21", "Player22", "Player23",
            "Player24", "Player25", "Player26", "Player27", "Player28", "Player29", "Player30", "Player31", "Player32", "Player33", "Player34", "Player35",
            "Player36", "Player37", "Player38", "Player39", "Player40", "Player41", "Player42", "Player43", "Player44", "Player45", "Player46", "Player47",
            "Player48", "Player49", "Player50", "Player51", "Player52", "Player53", "Player54", "Player55", "Player56", "Player57", "Player58", "Player59",
            "Player60", "Player61", "Player62", "Player63", "Player64", "Player65", "Player66", "Player67", "Player68", "Player69", "Player70", "Player71",
            "Player72", "Player73", "Player74", "Player75", "Player76", "Player77", "Player78", "Player79", "Player80", "Player81", "Player82", "Player83",
            "Player84", "Player85", "Player86", "Player87", "Player88", "Player89", "Player90", "Player91", "Player92", "Player93", "Player94", "Player95",
            "Player96", "Player97", "Player98", "Player99", "Player100", "Player101", "Player102", "Player103", "Player104", "Player105", "Player106",
            "Player107", "Player108", "Player109", "Player110", "Player111", "Player112", "Player113", "Player114", "Player115", "Player116", "Player117",
            "Player118", "Player119", "Player120", "Player121", "Player122", "Player123", "Player124", "Player125", "Player126", "Player127", "Player128"};

    List<String> potentialPlayersList = Arrays.asList(potentialPlayers);


    static void GSONMethod() throws IOException {

        System.out.println("GSON");

        String jsonFile = "players.json";

        Gson gsonimport = new Gson();

        FileReader fileReader = new FileReader(jsonFile);

        JsonReader jsonReader = new JsonReader(fileReader);

        ReadJson[] data = gsonimport.fromJson(jsonReader, ReadJson.class);

        List<String> playersList = new ArrayList();

        for (ReadJson readJson : data) {

            playersList.add(readJson.getPlayerName());
        }

        System.out.println(playersList);


    }

}