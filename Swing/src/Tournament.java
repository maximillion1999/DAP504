import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;

public class Tournament {

    private int numberOfPlayersTournament;
    private int gamesToWinMatch;

    public SwingTest app;

    /**
     * Creates a tournament object that has access to the GUI
     *
     * @param application The actual GUI application
     */
    public Tournament(SwingTest application) {
        app = application;
    }

    public int getNumberOfPlayersTournament() {
        return numberOfPlayersTournament;
    }

    public void setNumberOfPlayersTournament(int numberOfPlayersTournament) {
        this.numberOfPlayersTournament = numberOfPlayersTournament;
    }

    public int getGamesToWinMatch() {
        return gamesToWinMatch;
    }

    public void setGamesToWinMatch(int gamesToWinMatch) {
        this.gamesToWinMatch = gamesToWinMatch;
    }

    public void runTournament() throws IOException {

        app.getOutputBox().setText(null);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();

        String fileSeparator = System.getProperty("file.separator");

        //absolute file name with path
        String absoluteFilePath = fileSeparator + "Tournament Outputs" + fileSeparator + (numberOfPlayersTournament + "players " + dtf.format(now) + ".txt");
        File file = new File("Tournament Outputs" + fileSeparator + (numberOfPlayersTournament + "players " + dtf.format(now) + ".txt"));
        try {
            if (file.createNewFile()) {
                //System.out.println(absoluteFilePath + " File Created");
            } //else System.out.println("File " + absoluteFilePath + " already exists");
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.setWritable(true);

        FileWriter fw = new FileWriter(file,true);
        //BufferedWriter writer gives better performance
        BufferedWriter bw = new BufferedWriter(fw);


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

//        ReadJson.GSONMethod();
//
//        List<String> potentialPlayersList = Arrays.asList(potentialPlayers);

        List<String> potentialPlayersList = ReadJson.GSONMethod();
        List<String> potentialPlayersListLOCAL = Arrays.asList(potentialPlayers);

        if (potentialPlayersList.size() != 128){
            potentialPlayersList.isEmpty();
            potentialPlayersList = potentialPlayersListLOCAL;
        }

        List<String> listOfPlayers = new ArrayList<>();
        List<String> listOfRoundWinners = new ArrayList<>();

        //System.out.println("The Simulation has begun.");
        app.getOutputBox().setText(null);
        bw.write("The Simulation has begun."); bw.newLine();bw.newLine();
        bw.flush();



        switch (numberOfPlayersTournament) {

            case 2:
                numberOfPlayersTournament = 2;
                List<String> playersList2 = potentialPlayersList.subList(0, 2);
                listOfPlayers.addAll(playersList2);
                break;

            case 4:
                numberOfPlayersTournament = 4;
                List<String> playersList4 = potentialPlayersList.subList(0, 4);
                listOfPlayers.addAll(playersList4);
                break;

            case 8:
                numberOfPlayersTournament = 8;
                List<String> playersList8 = potentialPlayersList.subList(0, 8);
                listOfPlayers.addAll(playersList8);
                break;

            case 16:
                numberOfPlayersTournament = 16;
                List<String> playersList16 = potentialPlayersList.subList(0, 16);
                listOfPlayers.addAll(playersList16);
                break;

            case 32:
                numberOfPlayersTournament = 32;
                List<String> playersList32 = potentialPlayersList.subList(0, 32);
                listOfPlayers.addAll(playersList32);
                break;

            case 64:
                numberOfPlayersTournament = 64;
                List<String> playersList64 = potentialPlayersList.subList(0, 64);
                listOfPlayers.addAll(playersList64);
                break;

            case 128:
                numberOfPlayersTournament = 128;
                List<String> playersList128 = potentialPlayersList.subList(0, 128);
                listOfPlayers.addAll(playersList128);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + numberOfPlayersTournament);

        }

        //System.out.println(numberOfPlayersTournament);
        // System.out.println(listOfPlayers.size());
        List<String> currentMatchPlayers = new ArrayList<>();
        List<String> roundLosers = new ArrayList<>();


        while (listOfPlayers.size() > 2) {

            //System.out.print("The players of this round are:");
            //for (String listOfPlayer : listOfPlayers) System.out.print(" " + listOfPlayer + ",");

            app.getOutputBox().append("\n" + "The players of this round are:");
            for (String listOfPlayer : listOfPlayers) app.getOutputBox().append(" " + listOfPlayer + ",");

            bw.write("The players of this round are:");bw.flush();
            for (String listOfPlayer : listOfPlayers) bw.write(" " + listOfPlayer + ",");bw.flush();bw.newLine();

            //System.out.println();
            app.getOutputBox().append("\n");

            for (int i = 0; i < listOfPlayers.size(); i += 2) {
                //System.out.println(i);
                int matchCounter = 1;

                currentMatchPlayers.add(listOfPlayers.get(i));
                currentMatchPlayers.add(listOfPlayers.get(i + 1));

                Match currentMatch = new Match();

                currentMatch.setMinWinPoints(getGamesToWinMatch());
                currentMatch.setCurrentMatchPlayers(currentMatchPlayers);

                currentMatch.runMatch();

                //System.out.println(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1));
                app.getOutputBox().append(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1) + "\n");
                bw.write(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1) + "\n");bw.flush();

                //System.out.println("Match Winner: " + currentMatch.getMatchWinner());
                app.getOutputBox().append("Match Winner: " + currentMatch.getMatchWinner() + "\n");
                bw.write("Match Winner: " + currentMatch.getMatchWinner() + "\n");bw.flush();


                listOfRoundWinners.add(currentMatch.getMatchWinner());
                currentMatchPlayers.remove(currentMatch.getMatchWinner());

                roundLosers.add(String.valueOf(currentMatchPlayers).replace("[", "").replace("]", "").trim());

                currentMatchPlayers.clear();

            }

           /* System.out.print("The winners of this round are:");
            for (String listOfRoundWinner : listOfRoundWinners) System.out.print(" " + (listOfRoundWinner) + ",");
            System.out.println();*/


            app.getOutputBox().append("The winners of this round are:");
            for (String listOfRoundWinner : listOfRoundWinners) {
                app.getOutputBox().append(" " + (listOfRoundWinner) + ",");
            }
            app.getOutputBox().append("\n");


            bw.write("The winners of this round are:");
            for (String listOfRoundWinner : listOfRoundWinners) {
                bw.write(" " + (listOfRoundWinner) + ",");
            }
            bw.write("\n");




            /*
            System.out.print("The losers of this round are:");
            for (String roundLoser : roundLosers) {
            System.out.print(" " + (roundLoser) + ",");
            }
            System.out.println();
            */


            app.getOutputBox().append("The losers of this round are:");
            for (String roundLoser : roundLosers) {
                app.getOutputBox().append(" " + (roundLoser) + ",");
            }
            app.getOutputBox().append("\n");


            bw.write("The losers of this round are:");
            for (String roundLoser : roundLosers) {
                bw.write(" " + (roundLoser) + ",");
            }
            bw.write("\n");




            listOfPlayers.clear();
            listOfPlayers.addAll(listOfRoundWinners);
            listOfRoundWinners.clear();
            roundLosers.clear();

            currentMatchPlayers.clear();
            bw.flush();
        }

        currentMatchPlayers.add(listOfPlayers.get(0));
        currentMatchPlayers.add(listOfPlayers.get(1));

        //System.out.println("\n***********************FINAL ROUND***********************");
        app.getOutputBox().append("\n***********************FINAL ROUND***********************" + "\n");
        bw.write("\n***********************FINAL ROUND***********************" + "\n");


        //System.out.println(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1));
        app.getOutputBox().append(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1) + "\n");
        bw.write(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1) + "\n");




        Match currentMatch = new Match();

        currentMatch.setMinWinPoints(getGamesToWinMatch());
        currentMatch.setCurrentMatchPlayers(currentMatchPlayers);

        currentMatch.runMatch();

        //System.out.println("CONGRATULATIONS! " + currentMatch.getMatchWinner() + " has won the tournament!");
        app.getOutputBox().append("CONGRATULATIONS! " + currentMatch.getMatchWinner() + " has won the tournament!\n");
        bw.write("CONGRATULATIONS! " + currentMatch.getMatchWinner() + " has won the tournament!");
        bw.flush();
        bw.close();



    }
}
