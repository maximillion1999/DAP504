public class Game {

    private int player1points;
    private int player2points;
    private int differenceInPoints;
    private String gameWinner;





    public int getPlayer1points() {
        return player1points;
    }

    public int getPlayer2points() {
        return player2points;
    }

    public String getGameWinner() { return gameWinner;}

    public void setGameWinner(String gameWinner) {this.gameWinner = gameWinner;
    }



    public void getState() {

        //System.out.println(player1Name + " has " + player1points);
        //System.out.println(player2Name + " has " + player2points);
        //System.out.println("The point difference is " + differenceInPoints);
    }

    private void incrementPlayer1Points(){
        player1points++;
        this.differenceInPoints = Math.abs(player2points-player1points);

    }

    private void incrementPlayer2Points(){
        player2points++;
        this.differenceInPoints = Math.abs(player2points-player1points);

    }

    public void serve() {

        int probabilityPlayer1 = (int)(Math.random() * 100000 + 1);

        //System.out.println("Probability of " +player1Name +" winning serve: " + probabilityPlayer1);

        int probabilityPlayer2 = (int)(Math.random() * 100000 + 1);

        //System.out.println("Probability of " +player2Name +" winning serve: " + probabilityPlayer2);

        if (probabilityPlayer1>probabilityPlayer2)
            incrementPlayer1Points();
        if (probabilityPlayer1<probabilityPlayer2)
            incrementPlayer2Points();



    }

    public String checkGameWinner() {

        if (player1points > 10) {
            if ((player1points - player2points) > 1) {
                getGameWinner();
                setGameWinner("Player 1");
                return "Player1";

            }
        }

        if (player2points > 10) {
            if ((player2points - player1points) > 1) {
                getGameWinner();
                setGameWinner("Player 2");
                return "Player2";


            }
        }

        return "";

    }

}
