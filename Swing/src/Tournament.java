import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.lang.Object;

public class Tournament {

    private int numberOfPlayersTournament;
    private int gamesToWinMatch;


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

    public void runTournament(){
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        File file;
        file = new File ("\\Matches\\" + df + ".txt" );




        String[] potentialPlayers = {"Player1","Player2","Player3","Player4","Player5","Player6","Player7","Player8","Player9","Player10","Player11","Player12","Player13","Player14","Player15","Player16","Player17","Player18","Player19","Player20","Player21","Player22","Player23","Player24","Player25","Player26","Player27","Player28","Player29","Player30","Player31","Player32","Player33","Player34","Player35","Player36","Player37","Player38","Player39","Player40","Player41","Player42","Player43","Player44","Player45","Player46","Player47","Player48","Player49","Player50","Player51","Player52","Player53","Player54","Player55","Player56","Player57","Player58","Player59","Player60","Player61","Player62","Player63","Player64","Player65","Player66","Player67","Player68","Player69","Player70","Player71","Player72","Player73","Player74","Player75","Player76","Player77","Player78","Player79","Player80","Player81","Player82","Player83","Player84","Player85","Player86","Player87","Player88","Player89","Player90","Player91","Player92","Player93","Player94","Player95","Player96","Player97","Player98","Player99","Player100","Player101","Player102","Player103","Player104","Player105","Player106","Player107","Player108","Player109","Player110","Player111","Player112","Player113","Player114","Player115","Player116","Player117","Player118","Player119","Player120","Player121","Player122","Player123","Player124","Player125","Player126","Player127","Player128"};
        String[] tournamentRoundPlayers;
        String[] tournamentRoundWinners = {};

        List<String> potentialPlayersList = Arrays.asList(potentialPlayers);

        List<String> listOfPlayers = new ArrayList<>();
        List<String> listOfRoundWinners = new ArrayList<>();



        switch (numberOfPlayersTournament){

            case 2:
                numberOfPlayersTournament = 2;
                List<String> playersList2 = potentialPlayersList.subList(0,2) ;
                listOfPlayers.addAll(playersList2);
                break;

            case 4:
                numberOfPlayersTournament = 4;
                List<String> playersList4 = potentialPlayersList.subList(0,4) ;
                listOfPlayers.addAll(playersList4);
                break;

            case 8:
                numberOfPlayersTournament = 8;
                List<String> playersList8 = potentialPlayersList.subList(0,8) ;
                listOfPlayers.addAll(playersList8);
                break;

            case 16:
                numberOfPlayersTournament = 16;
                List<String> playersList16 = potentialPlayersList.subList(0,16) ;
                listOfPlayers.addAll(playersList16);
                break;

            case 32:
                numberOfPlayersTournament = 32;
                List<String> playersList32 = potentialPlayersList.subList(0,32) ;
                listOfPlayers.addAll(playersList32);
                break;

            case 64:
                numberOfPlayersTournament = 64;
                List<String> playersList64 = potentialPlayersList.subList(0,64) ;
                listOfPlayers.addAll(playersList64);
                break;

            case 128:
                numberOfPlayersTournament = 128;
                List<String> playersList128 = potentialPlayersList.subList(0,128) ;
                listOfPlayers.addAll(playersList128);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + numberOfPlayersTournament);
        }


        //System.out.println(numberOfPlayersTournament);
       // System.out.println(listOfPlayers.size());
        List <String> currentMatchPlayers = new ArrayList<>();
        List <String> roundLosers = new ArrayList<>();
        

        while (listOfPlayers.size() > 2){

            System.out.print("The players of this round are:");

            for (String listOfPlayer : listOfPlayers) System.out.print(" " + listOfPlayer);

            System.out.println();

            for (int i = 0; i < listOfPlayers.size(); i+=2) {
                //System.out.println(i);
                int matchCounter = 1;

                currentMatchPlayers.add(listOfPlayers.get(i));
                currentMatchPlayers.add(listOfPlayers.get(i+1));

                Match currentMatch = new Match();

                currentMatch.setMinWinPoints(getGamesToWinMatch());
                currentMatch.setCurrentMatchPlayers(currentMatchPlayers);

                currentMatch.runMatch();

                System.out.println(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1) );

                System.out.println("Match Winner: " + currentMatch.getMatchWinner());

                listOfRoundWinners.add(currentMatch.getMatchWinner());

                currentMatchPlayers.remove(currentMatch.getMatchWinner());

                //roundLosers.add(currentMatchPlayers);

                currentMatchPlayers.clear();

            }

            System.out.print("The winners of this round are:");

            for (String listOfRoundWinner : listOfRoundWinners) {
                System.out.print(" " + (listOfRoundWinner));
            }

            System.out.println();

            System.out.println("The losers of this round are:");

            for (String roundLoser : roundLosers) {
                System.out.print(" " + (roundLoser));
            }

            System.out.println();

            listOfPlayers.clear();
            listOfPlayers.addAll(listOfRoundWinners);
            listOfRoundWinners.clear();

            currentMatchPlayers.clear();
        }

        currentMatchPlayers.add(listOfPlayers.get(0));
        currentMatchPlayers.add(listOfPlayers.get(1));

        System.out.println("FINAL ROUND");

        System.out.println(currentMatchPlayers.get(0) + " VS " + currentMatchPlayers.get(1) );

        Match currentMatch = new Match();

        currentMatch.setMinWinPoints(getGamesToWinMatch());
        currentMatch.setCurrentMatchPlayers(currentMatchPlayers);

        currentMatch.runMatch();

        System.out.println("CONGRATULATIONS! " + currentMatch.getMatchWinner() + " has won the tournament!");
        
        /*for (int i = 0; i < listOfPlayers.size(); i+=2) {
            System.out.println(i);

            List <String> currentMatchPlayers = new ArrayList<>();

            currentMatchPlayers.add(listOfPlayers.get(i));
            currentMatchPlayers.add(listOfPlayers.get(i+1));

            System.out.println(currentMatchPlayers);

            Match currentMatch = new Match();

            currentMatch.setMinWinPoints(getGamesToWinMatch());
            currentMatch.setCurrentMatchPlayers(currentMatchPlayers);

            currentMatch.runMatch();

            System.out.println(currentMatch.getMatchWinner());



        }*/



        }



        /*System.out.println("Hello  World!");

        Game myGame = new Game();

        while(myGame.checkGameWinner() == "") {

            myGame.serve();
        }

        System.out.println("The winner is " + myGame.getGameWinner());

        if (myGame.getGameWinner() == "Player 1"){

            System.out.println("Player1Passthrough");

        }

        if (myGame.getGameWinner() == "Player 2") {

            System.out.println("Player2Passthrough");

        }*/


    }
