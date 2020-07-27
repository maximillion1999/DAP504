import java.util.List;

public class Match {


    private int player1MatchPoints;
    private int player2MatchPoints;
    private int differenceInMatchPoints;
    private int minWinPoints;
    private String MatchWinner;

    private List<String> currentMatchPlayers;

    public List<String> getCurrentMatchPlayers() {
        return currentMatchPlayers;
    }

    public void setCurrentMatchPlayers(List<String> currentMatchPlayers) {
        this.currentMatchPlayers = currentMatchPlayers;
    }

    public String getMatchWinner() {
        return MatchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        MatchWinner = matchWinner;
    }

    private void incrementPlayer1MatchPoints(){
        player1MatchPoints++;

    }

    private void incrementPlayer2MatchPoints(){
        player2MatchPoints++;

    }

    public int getMinWinPoints() {
        return minWinPoints;
    }

    public void setMinWinPoints(int minWinPoints) {
        this.minWinPoints = minWinPoints;
    }

    public String runMatch() {

        while (player1MatchPoints < getMinWinPoints() && player2MatchPoints < getMinWinPoints()){

            Game myGame = new Game();

            while (myGame.checkGameWinner() == "") {

                myGame.serve();
            }

            //System.out.println("The winner of the game is " + myGame.getGameWinner());

            if (myGame.getGameWinner() == "Player 1") {
                incrementPlayer1MatchPoints();


            }

            if (myGame.getGameWinner() == "Player 2") {
                incrementPlayer2MatchPoints();

            }


        }

        if (player1MatchPoints >= getMinWinPoints()) {
            if ((player1MatchPoints - player2MatchPoints) >= 1) {
                getMatchWinner();
                setMatchWinner(currentMatchPlayers.get(0));
                //System.out.println( currentMatchPlayers.get(0) + "Wins the Match!");
                return currentMatchPlayers.get(0);

            }
        }

        if (player2MatchPoints >= getMinWinPoints()) {
            if ((player2MatchPoints - player1MatchPoints) >= 1) {
                getMatchWinner();
                setMatchWinner(currentMatchPlayers.get(1));
                //System.out.println( currentMatchPlayers.get(1) + "Wins the Match!");
                return currentMatchPlayers.get(1);

            }
        }

        return null;
    }


    /*public String checkMatchWinner() {


        if (player1MatchPoints >= getMinWinPoints()) {
            if ((player1MatchPoints - player2MatchPoints) >= 1) {
                getMatchWinner();
                setMatchWinner("Player 1");
                System.out.println("Player1WinstheMatch!");
                return "Player1";

            }
        }

        if (player2MatchPoints >= getMinWinPoints()) {
            if ((player2MatchPoints - player1MatchPoints) >= 1) {
                getMatchWinner();
                setMatchWinner("Player 2");
                System.out.println("Player2WinstheMatch!");
                return "Player2";

            }
        }

        return null;
    }*/

}